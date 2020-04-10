package GUI;


import Models.Product;
import Models.Region;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ClientService;
import service.IncidentService;
import java.time.LocalDate;
import java.util.List;

public class ControllerWindowProduct {

    @FXML
    TableView table;

    @FXML
    TableColumn tableId;

    @FXML
    TableColumn tableProductName;

    @FXML
    TableColumn tableProductBuildDate;

    @FXML
    TableColumn tableProductPartNumber;

    @FXML
    DatePicker datePickerProductBuildDate;

    @FXML
    TextField textFieldProductPartNumber;

    @FXML
    TextField textFieldAddProductName;

    @FXML
    CheckBox checkBoxAddProduct;

    @FXML
    Button buttonAddProduct;


    public void showAllProduct(MouseEvent mouseEvent) {
        table.getItems().clear();
        IncidentService incidentService = new IncidentService();
        tableId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        tableProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        tableProductBuildDate.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productBuildDate"));
        tableProductPartNumber.setCellValueFactory(new PropertyValueFactory<Product, Integer>("partNumber"));
        List<Product> listProduct = incidentService.showAllProduct();
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(listProduct.get(i));
            table.getItems().add(listProduct.get(i));
        }
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void deleteSelectedProduct(MouseEvent mouseEvent) {
        int id = Integer.valueOf(tableId.getCellObservableValue(table.getSelectionModel().getSelectedIndex()).getValue().toString());  //получание значения с ячейки id
        String productName = String.valueOf(table.getSelectionModel().getSelectedItem());
        System.out.println(id);
        Product productToDelete = new Product();
        productToDelete.setProductId(id);
        productToDelete.setProductName(productName);
        IncidentService incidentService = new IncidentService();
        incidentService.deleteProduct(productToDelete);

    }

    public LocalDate datePickerSelectProductBuildDate() {
        LocalDate today = LocalDate.now();
        LocalDate productBuildDate = datePickerProductBuildDate.getValue();
        if(productBuildDate==null || productBuildDate.isAfter(today)){
           datePickerProductBuildDate.getEditor().clear();
            System.out.println("Select Valid Date");
        }
        return productBuildDate;
    }

    public void checkBoxAddProductClicked(ActionEvent actionEvent) {
        buttonAddProduct.setVisible(true);
        checkBoxAddProduct.setSelected(false);
    }

    public void buttonAddProductSelect(ActionEvent actionEvent) {
        buttonAddProduct.setVisible(false);
        String productNameString = textFieldAddProductName.getText();
        Integer productPartnumberString = Integer.valueOf(textFieldProductPartNumber.getText());
        LocalDate datePickerProductBuildDate = datePickerSelectProductBuildDate();
        Product product = new Product();
        product.setProductName(productNameString);
        product.setPartNumber(productPartnumberString);
        product.setProductBuildDate(datePickerProductBuildDate);
       // System.out.println(product.getPartNumber()+" "+ product.getProductName()+ " "+ product.getProductBuildDate());
        IncidentService incidentService = new IncidentService();
        incidentService.addProduct(product);
    }
}

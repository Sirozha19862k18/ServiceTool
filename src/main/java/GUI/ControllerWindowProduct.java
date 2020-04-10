package GUI;

import Models.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.IncidentService;

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


    public void buttonAddProduct(ActionEvent actionEvent) {
    }

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

    }
}

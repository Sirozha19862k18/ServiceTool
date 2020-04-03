package GUI;

import Models.Position;
import Models.Region;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ClientService;
import service.EmployerService;


import java.util.List;

public class ControllerWindowRegion {

    @FXML
    private TableView table;
    @FXML
    private TableColumn tableId;

    @FXML
    private TableColumn tableRegion;

    @FXML private TextField textFieldAddRegion;


    public void buttonAddRegion(ActionEvent actionEvent) {
        String s = textFieldAddRegion.getText();
        Region region = new Region();
        region.setRegionName(s);
        ClientService service = new ClientService();
        service.addNewRegion(region);
    }

    public void showAllRegion(MouseEvent mouseEvent) {
        table.getItems().clear();
        ClientService clientService = new ClientService();
        tableId.setCellValueFactory(new PropertyValueFactory<Region, Integer>("regionId"));
        tableRegion.setCellValueFactory(new PropertyValueFactory<Region, String>("regionName"));
        List<Region> reg = clientService.showAllRegions();
        for (int i = 0; i < reg.size(); i++) {
            System.out.println(reg.get(i));
            table.getItems().add(reg.get(i));
        }
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void deleteSelectedRegion(MouseEvent mouseEvent) {
        int id = Integer.valueOf(tableId.getCellObservableValue(table.getSelectionModel().getSelectedIndex()).getValue().toString());  //получание значения с ячейки id
        String regionName = String.valueOf(table.getSelectionModel().getSelectedItem());
        System.out.println(id);
        Region regionToDelete = new Region();
        regionToDelete.setRegionId(id);
        regionToDelete.setRegionName(regionName);
       ClientService service = new ClientService();
       service.deleteRegion(regionToDelete);
    }
}

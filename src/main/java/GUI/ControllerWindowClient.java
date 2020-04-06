package GUI;

import Models.Client;
import Models.Region;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ClientService;
import java.util.ArrayList;
import java.util.List;


public class ControllerWindowClient {

    @FXML
    Button buttonAddClient;

    @FXML
    TextField textFieldClientNameUserInput;

    @FXML
    CheckBox checkBoxAddClient;

    @FXML
    ListView listViewRegionOfClient;

    @FXML
    TextArea TextAreaClientAdress;

    @FXML
    private TableView table;
    @FXML
    private TableColumn tableId;
    @FXML
    private TableColumn tableClientName;
    @FXML
    private TableColumn tableRegion;
    @FXML
    private TableColumn tableClientAdress;

    //действия на чекбоксе Добавить клиента
    public void checkBoxAddClientAction(MouseEvent mouseEvent) {
        buttonAddClient.setVisible(true);
        listViewRegionOfClient.getItems().clear();
        ClientService clientService = new ClientService();
        List<Region> listOfRegionToSelect = clientService.showAllRegions();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <listOfRegionToSelect.size() ; i++) {
            list.add(i, listOfRegionToSelect.get(i).getRegionName());
        }
        listViewRegionOfClient.setItems(FXCollections.observableList(list));
        checkBoxAddClient.setSelected(false);
    }

    //действия на кнопке Добавить клиента
    public void buttonAddClientMouseClicked(MouseEvent mouseEvent) {
    }

    //Показать всех клиентов
    public void showAllClient(MouseEvent mouseEvent) {
        table.getItems().clear();
        ClientService clientService = new ClientService();
        tableId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("client_id"));
        tableClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("clientName"));
        tableRegion.setCellValueFactory(new PropertyValueFactory<Client, String>("region"));
        tableClientAdress.setCellValueFactory(new PropertyValueFactory<Client, String>("adress"));
        List<Client> clientList = clientService.showAllClients();
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i));
            table.getItems().add(clientList.get(i));
        }
    }

    public void deleteSelectedClient(MouseEvent mouseEvent) {
    }
}

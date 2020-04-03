package GUI;

import Models.Client;
import Models.Employer;
import Models.Position;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ClientService;
import service.EmployerService;

import java.util.List;


public class ControllerWindowClient {

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

    public void checkBoxAddClientAction(MouseEvent mouseEvent) {
    }

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

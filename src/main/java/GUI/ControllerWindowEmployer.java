package GUI;

import Models.Employer;
import Models.Position;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.EmployerService;

import java.util.ArrayList;
import java.util.List;

public class ControllerWindowEmployer {
    @FXML
    private TableView table;
    @FXML
    private TableColumn tableId;
    @FXML
    private TableColumn tableEmployerName;
    @FXML
    private TableColumn tablePosition;
    @FXML
    private CheckBox checkBoxAddEmployer;
    @FXML
    private ListView listViewPositionEmployers;
    @FXML
    private Button buttonAddEmployer;
    @FXML
    private TextField textFieldEmployersNameUserInput;

//Кнопка показать всех сотрудников
    public void showAllEmployer(MouseEvent mouseEvent) {
        table.getItems().clear();
        EmployerService employerService = new EmployerService();
        tableId.setCellValueFactory(new PropertyValueFactory<Position, Integer>("employer_id"));
        tableEmployerName.setCellValueFactory(new PropertyValueFactory<Position, String>("employer_name"));
        tablePosition.setCellValueFactory(new PropertyValueFactory<Position, String>("position"));
        List<Employer> pos = employerService.showAllEmployers();
        for (int i = 0; i < pos.size(); i++) {
            System.out.println(pos.get(i));
            table.getItems().add(pos.get(i));
        }

    }
//действия на чекбоксе Добавить сотрудника
    public void checkBoxAddEmloyerAction(MouseEvent mouseEvent) {
        buttonAddEmployer.setVisible(true);
        listViewPositionEmployers.getItems().clear();
        List<String> list = new ArrayList<String>();
        EmployerService employerService = new EmployerService();
        List<Position> pos = employerService.showAllPosition();
        for (int i = 0; i < pos.size(); i++) {
            list.add(i, pos.get(i).getPosition());
        }
        ObservableList<String> observableListPositionEmployers= FXCollections.observableList(list);
        listViewPositionEmployers.setItems(observableListPositionEmployers);
        checkBoxAddEmployer.setSelected(false);
        }

        //Кнопка добавления нового сотрудника с должностью
    public void buttonAddMployerMouseClicked(MouseEvent mouseEvent) {
        EmployerService employerService = new EmployerService();
        Position position = new Position();
        List<Position> listPosition= employerService.searchPositionByName((String) listViewPositionEmployers.getSelectionModel().getSelectedItem());
        position.setId(listPosition.get(0).getId());
        position.setPosition(listPosition.get(0).getPosition());
        Employer employer = new Employer();
        employer.setEmployer_name(textFieldEmployersNameUserInput.getText());
        employer.setPosition(position);
        employerService.addNewEployer(employer);
        showAllEmployer(mouseEvent);
    }

    //Кнопка удалить выбранного сотрудника
    public void deleteSelectedEmployer(MouseEvent mouseEvent) {
        int id = Integer.valueOf(tableId.getCellObservableValue(table.getSelectionModel().getSelectedIndex()).getValue().toString());
        String employerName = String.valueOf(table.getSelectionModel().getSelectedItem());
        Employer employerToDelete = new Employer();
        employerToDelete.setEmployer_id(id);
        employerToDelete.setEmployer_name(employerName);
      //  System.out.println(employerToDelete.getEmployer_id()+ " /  "+ employerToDelete.getEmployer_name());
        EmployerService service = new EmployerService();
        service.deleteEmployer(employerToDelete);
        showAllEmployer(mouseEvent);
    }
}





package GUI;


import Models.Position;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.EmployerService;

import java.util.List;

public class ControllerWindowPosition {
    @FXML
    private TableView<Position> table;
    @FXML
    private TableColumn tableId;

    @FXML
    private TableColumn tablePosition;
    @FXML private TextField textFieldAddPosition;

    public void showAllPosition(MouseEvent mouseEvent) {
        table.getItems().clear();
        EmployerService employerService = new EmployerService();
        tableId.setCellValueFactory(new PropertyValueFactory<Position, Integer>("id"));
        tablePosition.setCellValueFactory(new PropertyValueFactory<Position, String>("position"));
        List<Position> pos = employerService.showAllPosition();
        for (int i = 0; i < pos.size(); i++) {
            System.out.println(pos.get(i));
            table.getItems().add(pos.get(i));
        }
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       // table.getSelectionModel().setCellSelectionEnabled(true);
    }

    public void buttonAddPosition(ActionEvent actionEvent) {
        String s = textFieldAddPosition.getText();
        Position position = new Position();
        position.setPosition(s);
        EmployerService service = new EmployerService();
        service.addPosition(position);

    }

    //кнопка удалить выбранную профессию
    public void deleteSelectedPosition(MouseEvent mouseEvent) {

        int id = Integer.valueOf(tableId.getCellObservableValue(table.getSelectionModel().getSelectedIndex()).getValue().toString());  //получание значения с ячейки id
        String positionName = String.valueOf(table.getSelectionModel().getSelectedItem());
        System.out.println(id);
        Position positionToDelete = new Position();
        positionToDelete.setId(id);
        positionToDelete.setPosition(positionName);
        EmployerService servise = new EmployerService();
        servise.deletePosition(positionToDelete);
    }
}

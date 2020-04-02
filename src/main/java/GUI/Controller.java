package GUI;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class Controller {


    public void MenuShowAllEmployers(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/employerWindow.fxml"));
        Parent root = loader.load();
        Stage stage=new Stage();
        stage.setTitle("Список сотрудников с должностями");
        stage.setScene(new Scene(root, 768, 600));
        stage.show();

    }

    public void MenuShowAllPosition(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/positionWindow.fxml"));
        Parent root = loader.load();
        Stage stage=new Stage();
        stage.setTitle("Список должностей");
        stage.setScene(new Scene(root, 768, 600));
        stage.show();
    }
}

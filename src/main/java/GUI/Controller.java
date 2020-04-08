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

    public void MenuShowAllRegion(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/regionWindow.fxml"));
        Parent root = loader.load();
        Stage stage=new Stage();
        stage.setTitle("Список регионов");
        stage.setScene(new Scene(root, 768, 600));
        stage.show();
    }

    public void MenuShowAllClient(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/clientWindow.fxml"));
        Parent root = loader.load();
        Stage stage=new Stage();
        stage.setTitle("Список клиентов");
        stage.setScene(new Scene(root, 768, 600));
        stage.show();
    }

    public void MenuShowAllProduct(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/productWindow.fxml"));
        Parent root = loader.load();
        Stage stage=new Stage();
        stage.setTitle("Список отгруженных изделий");
        stage.setScene(new Scene(root));
        stage.show();
    }
}

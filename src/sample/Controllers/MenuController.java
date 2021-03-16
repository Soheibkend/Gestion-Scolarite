package sample.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {

    @FXML
    private Button etudiantButton;
    @FXML
    private Button moduleButton;
    @FXML
    private Button listeEtudiantButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button examenButton;

   @FXML
   public void etudiantButtonClicked (ActionEvent event) throws IOException {
       Stage stage = (Stage) etudiantButton.getScene().getWindow();
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/sample/Views/etudiant.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       stage.setScene(scene);
   }

    @FXML
    public void certificatButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) etudiantButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/certificatScolarite.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void moduleButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) etudiantButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/module.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void exitButtonClicked (ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void listEtudiantButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) etudiantButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/listeEtudiant.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void examenButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) etudiantButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/examen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}

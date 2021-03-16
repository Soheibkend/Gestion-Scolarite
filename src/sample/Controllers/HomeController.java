package sample.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private TextField nomUtilisateurField;
    @FXML
    private TextField motPasseField;
    @FXML
    private Button loginButton;
    int count =0;

    public void loginButtonClicked (ActionEvent event) throws IOException {

        if (count == 3){
            Platform.exit();
            System.exit(0);
        }
        if ((nomUtilisateurField.getText().equals("admindep") && motPasseField.getText().equals("admin")) || (nomUtilisateurField.getText().equals("adminscol") && motPasseField.getText().equals("admin"))) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Views/menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } else {
            count ++;
            if (count == 3){
                Platform.exit();
                System.exit(0);
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText(null);
            alert.setContentText("mot de passe ou nom utilisateur incorrect ");
            alert.showAndWait();
        }

    }




}

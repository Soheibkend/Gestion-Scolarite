package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DB_CONNECTION;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModuleController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField coefficientField;
    @FXML
    private TextField enseignantField;

    @FXML
    public void retourButtonClicked (ActionEvent event) throws IOException{

        Stage stage = (Stage) nomField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void rechercheButtonClicked (ActionEvent event) {
        if (!DB_CONNECTION.moduleExiste(codeField.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("module inexistant veuillez inserer le module");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("module existe");
            alert.showAndWait();
            ResultSet rs1 = DB_CONNECTION.getModule(codeField.getText());
            try {
                if (rs1.next()) {
                    nomField.setText(rs1.getString("LIBELLEM"));
                    codeField.setText(rs1.getString("CODEM"));
                    coefficientField.setText(rs1.getString("COEF"));
                    enseignantField.setText(rs1.getString("CODEENS"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void ajouterButtonClicked (ActionEvent event) {
        if (DB_CONNECTION.moduleExiste(codeField.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("impossible d'ajouter module existe deja");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("voulez vous ajouter le module ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                if (codeField.getText().equals("") || enseignantField.getText().equals("")) {
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert2.setTitle("ERREUR");
                    alert2.setHeaderText(null);
                    alert2.setContentText("remplire les champs vide");
                    alert2.showAndWait();
                } else {
                    DB_CONNECTION.addModule(codeField.getText(), nomField.getText(), enseignantField.getText(), Integer.valueOf(coefficientField.getText()));
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Felecitation!");
                    alert1.setHeaderText(null);
                    alert1.setContentText("ajout fait avec succes");
                    alert1.showAndWait();
                }
            }
        }
    }


    public void supprimerButtonClicked (ActionEvent event) {
        if (!DB_CONNECTION.moduleExiste(codeField.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("module inexistant ");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("voulez vous supprimer le module ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                DB_CONNECTION.supprimerModule(codeField.getText());
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Felecitation!");
                alert1.setHeaderText(null);
                alert1.setContentText("suppresion faite avec succes");
                alert1.showAndWait();

            }

        }
    }

    public void modifierButtonClicked (ActionEvent event) {
        if (DB_CONNECTION.moduleExiste(codeField.getText())){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("voulez vous modifier le module ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                DB_CONNECTION.modifierModule(codeField.getText(),nomField.getText(),enseignantField.getText(),Integer.valueOf(coefficientField.getText()));
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Felecitation!");
                alert1.setHeaderText(null);
                alert1.setContentText("modification faite avec succes");
                alert1.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("module inexistant");
            alert.showAndWait();
        }
    }


}

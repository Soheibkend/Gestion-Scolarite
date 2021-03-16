package sample.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DB_CONNECTION;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EtudiantController {

    @FXML
    TextField matriculeField;
    @FXML
    TextField nomField;
    @FXML
    TextField prenomField;
    @FXML
    TextField groupeField;
    @FXML
    TextField sectionField;
    @FXML
    Button ajouterButton;
    @FXML
    Button chercherButton;
    @FXML
    Button modifierButton;
    @FXML
    Button supprimerButton;
    @FXML
    Button retourButton;

    @FXML
    public void ajouterButtonClicked (ActionEvent event)throws SQLException{
        if (DB_CONNECTION.etudiantExiste(matriculeField.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("impossible d'ajouter etudiant existe deja");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("voulez vous ajouter l'etudiant ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                if (matriculeField.getText().equals("") || sectionField.getText().equals("")) {
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert2.setTitle("ERREUR");
                    alert2.setHeaderText(null);
                    alert2.setContentText("remplire les champs vide");
                    alert2.showAndWait();
                } else {

                    DB_CONNECTION.addEtudiant(matriculeField.getText(), nomField.getText(), prenomField.getText(), sectionField.getText(), Integer.valueOf(groupeField.getText()));
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Felecitation!");
                    alert1.setHeaderText(null);
                    alert1.setContentText("ajout fait avec succes");
                    alert1.showAndWait();
                }
            }
        }
    }

    @FXML
    public void chercherButtonClicked (ActionEvent event) {

          if (!DB_CONNECTION.etudiantExiste(matriculeField.getText())){
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Information");
              alert.setHeaderText(null);
              alert.setContentText("etudiant inexistant veuillez saisir le reste des donnees");
              alert.showAndWait();
          } else {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Information");
              alert.setHeaderText(null);
              alert.setContentText("etudiant existe");
              alert.showAndWait();
              ResultSet rs1 = DB_CONNECTION.getEtudiant(matriculeField.getText());
              try {
                  if (rs1.next()) {
                      nomField.setText(rs1.getString("nom"));
                      prenomField.setText(rs1.getString("prenom"));
                      sectionField.setText(rs1.getString("codes"));
                      groupeField.setText(rs1.getString("groupe"));
                  }
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
    }

    @FXML
    public void modifierButtonClicked (ActionEvent event) {
         if (DB_CONNECTION.etudiantExiste(matriculeField.getText())){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Confirmation");
             alert.setHeaderText(null);
             alert.setContentText("voulez vous modifier l'etudiant ?");
             alert.showAndWait();
             if (alert.getResult() == ButtonType.OK) {
                 DB_CONNECTION.modifierEtudiant(matriculeField.getText(),nomField.getText(),prenomField.getText(),sectionField.getText(),Integer.valueOf(groupeField.getText()));
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
             alert.setContentText("etudiant inexistant veuillez saisir le reste des donnees");
             alert.showAndWait();
         }
    }

    @FXML
    public void supprimerButtonClicked (ActionEvent event) {
         if (!DB_CONNECTION.etudiantExiste(matriculeField.getText())){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Information");
             alert.setHeaderText(null);
             alert.setContentText("etudiant inexistant veuillez saisir le reste des donnees");
             alert.showAndWait();
         } else {
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Confirmation");
             alert.setHeaderText(null);
             alert.setContentText("voulez vous supprimer l'etudiant ?");
             alert.showAndWait();
             if (alert.getResult() == ButtonType.OK) {
                 DB_CONNECTION.supprimerEtudiant(matriculeField.getText());
                 Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                 alert1.setTitle("Felecitation!");
                 alert1.setHeaderText(null);
                 alert1.setContentText("suppresion faite avec succes");
                 alert1.showAndWait();

             }

         }
    }

    @FXML
    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}

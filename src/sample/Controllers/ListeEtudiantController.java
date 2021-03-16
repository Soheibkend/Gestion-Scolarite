package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.DB.DB_CONNECTION;
import sample.Models.Etudiant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListeEtudiantController implements Initializable {

    @FXML
    private TextField codeField;

    @FXML
    private TableView<Etudiant> tableEtudiant;

    @FXML
    private TableColumn<Etudiant,String> matricule;

    @FXML
    private TableColumn<Etudiant,String> nom;

    @FXML
    private TableColumn<Etudiant,String> prenom;

    @FXML
    private TableColumn<Etudiant,String> codeSection;

    @FXML
    private TableColumn<Etudiant,Integer> groupe;

    public void rechercheButtonClicked (ActionEvent event) {
        tableEtudiant.setItems(DB_CONNECTION.getListeEtudiant(codeField.getText()));
    }

    public void RetourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) codeField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        matricule.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("matricule"));
        nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenom"));
        codeSection.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("section"));
        groupe.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("groupe"));

        tableEtudiant.setEditable(false);

    }


}

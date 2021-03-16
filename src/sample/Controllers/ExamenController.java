package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.DB.DB_CONNECTION;

public class ExamenController {
    @FXML
    TextField matriculeField;

    @FXML
    TextField noteField;

    @FXML
    TextField codeField;

    public void ajouterButtonClicked (ActionEvent event) {

    }

    public void modifierButtonClicked (ActionEvent event) {

    }

    public void supprimerButtonClicked (ActionEvent event) {

    }

    public void rechercheButtonClicked (ActionEvent event) {
        if (DB_CONNECTION.noteExiste(matriculeField.getText(),noteField.getText())) {

        }
    }

}

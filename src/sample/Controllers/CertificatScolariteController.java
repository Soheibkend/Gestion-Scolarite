package sample.Controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DB_CONNECTION;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.TimeZone;

public class CertificatScolariteController {

    @FXML
    private TextField matriculeField;

    @FXML
    private TextField dateNaissanceField;

    @FXML
    private TextField lieuField;

    @FXML
    private TextField dateField;

    public void retourButtonClicked (ActionEvent event) throws IOException {
        Stage stage = (Stage) matriculeField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Views/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void genererButtonClicked (ActionEvent event) {
        if (!DB_CONNECTION.etudiantExiste(matriculeField.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("etudiant inexistant");
            alert.showAndWait();
        } else {
            Document document = new Document();
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
            ResultSet rs = DB_CONNECTION.getEtudiant(matriculeField.getText());
            ResultSet rs1 = DB_CONNECTION.getSection(matriculeField.getText());
            try
            {
                String path = "C:\\CertificatTPSI\\document.pdf";
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
                document.open();
                document.add(new Paragraph("                     REPUBLIQUE ALGERIENNE DEMOCRATIQUE ET POPULAIRE"));
                document.add(new Paragraph("    MINISTERE DE L'ENSEIGNEMENT SUPERIEUR ET DE LA RECHERCHE SCIENTIFIQUE"));
                document.add(new Paragraph("          UNIVERISTE DES SCIENCES ET DE LA TECHNOLOGIE HOUARI BOUMEDIENE"));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("                      Certificat de scolarite",font));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("Le Vice Recteur charge de la formation superieure de la graduation, de la formation continue et des diplomes "));
                document.add(new Paragraph("         "));
                if (rs.next()){

                }
                document.add(new Paragraph("Certifie que l'etudiant : "+ rs.getString("nom")+" "+ rs.getString("prenom")));
                document.add(new Paragraph("Nè le : " + dateNaissanceField.getText()+"                                                                  à : "+lieuField.getText()));
                document.add(new Paragraph("Matricule : "+matriculeField.getText()));
                document.add(new Paragraph("         "));
                document.add(new Paragraph("est inscrit pour l'année universitaire : 2019/2020"+ "           En : Deuxieme année"));
                if (rs1.next()){

                }
                rs = DB_CONNECTION.getSection(matriculeField.getText());
                String sp = rs.getString(3);
                document.add(new Paragraph("Specialite : "+sp+"                                           Bab-Ezzouar, le : "+ dateField.getText()));


                document.close();
                writer.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

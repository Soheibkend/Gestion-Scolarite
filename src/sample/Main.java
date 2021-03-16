package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DB.DB_CONNECTION;

import java.io.IOException;
import java.sql.Connection;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage)throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("Views/home.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("style.css");
            primaryStage.setTitle("Gestion de Scolarite");
            primaryStage.setScene(scene);
            primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
        Connection con = DB_CONNECTION.getConnection();
        if (con == null) {
            System.out.println("connection failed");
        } else {
            System.out.println("succes");
        }
    }
}

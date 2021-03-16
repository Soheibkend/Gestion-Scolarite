package sample.DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import sample.Models.Etudiant;

import java.sql.*;
//"DESKTOP-HHPM41M"
public class DB_CONNECTION {
    private static final String HOST = "";
    private static final int PORT = 1521;
    private static final String DB_NAME = "SOHEIB";
    private static final String USERNAME= "TPSI";
    private static final String PASSWORD = "soheib";
    public static ResultSet rs=null;
    public static Statement statement;
    private static Connection connection;


    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@localhost:1521:SOHEIB";
            connection = DriverManager.getConnection(dbURL, "TPSI", "soheib");
            statement = connection.createStatement();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static ResultSet getEtudiant(String matricule) {
        try{
            Connection con = getConnection();
            rs = statement.executeQuery("select * FROM Etudiant WHERE MATRICULE = '"+matricule+"'");
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean etudiantExiste(String matricule){

        try {
            Connection con = getConnection();
            rs = statement.executeQuery("select * FROM Etudiant WHERE MATRICULE = '"+matricule+"'");
            if (rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addEtudiant(String matricule, String nom, String prenom, String section, int groupe) {

        try {
            statement.executeQuery("INSERT INTO ETUDIANT"+"  VALUES ('" +matricule + "','"+nom+"','"+ prenom+ "',"+ groupe+",'"+section+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getSection (String matricule) {
        try{
            Connection con = getConnection();
            rs = statement.executeQuery("SELECT * FROM SECTION WHERE CODES IN (SELECT CODES FROM ETUDIANT WHERE MATRICULE = '"+matricule+"')");
            if (rs.next()){
                return rs;
            }
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void supprimerEtudiant (String matricule) {
         try {
             statement.executeUpdate("DELETE FROM ETUDIANT WHERE MATRICULE = '"+ matricule+"'");
         } catch (SQLException e){
             e.printStackTrace();
         }
    }

    public static void modifierEtudiant (String matricule,String nom, String prenom, String section, int groupe) {
        try{
            statement.executeUpdate("UPDATE ETUDIANT SET NOM ='"+nom+"', PRENOM = '"+prenom+"', CODES= '"+section+"', GROUPE = "+groupe + " WHERE MATRICULE ='"+matricule+"'");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean moduleExiste (String codeModule) {

        try {
            Connection con = getConnection();
            rs = statement.executeQuery("select * FROM MODULE WHERE CODEM = '"+codeModule+"'");
            if (rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet getModule(String codeModule) {
        try{
            Connection con = getConnection();
            rs = statement.executeQuery("select * FROM MODULE WHERE CODEM = '"+codeModule+"'");
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void addModule (String codem, String nom, String codeN, int coef){
        try {
            statement.executeQuery("INSERT INTO MODULE"+"  VALUES ('" +codem + "','"+nom+"',"+ coef+ ",'"+ codeN+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void supprimerModule (String codem) {
        try {
            statement.executeUpdate("DELETE FROM MODULE WHERE CODEM = '"+ codem+"'");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void modifierModule (String codem,String nom, String codeN, int coef) {
        try{
            statement.executeUpdate("UPDATE MODULE SET LIBELLEM ='"+nom+"', CODEENS = '"+codeN+"', COEF= "+coef+" WHERE CODEM ='"+codem+"'");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ObservableList<Etudiant> getListeEtudiant (String codes) {
        try {
            Connection con = getConnection();
            ObservableList<Etudiant> Liste = FXCollections.observableArrayList();
            rs = statement.executeQuery("Select * FROM ETUDIANT WHERE CODES = '" + codes + "'");
            while (rs.next()) {
                Liste.add(new Etudiant(rs.getString("MATRICULE"), rs.getString("NOM"), rs.getString("prenom"), rs.getString("CODES"), rs.getInt("groupe")));
            }
            return Liste;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean noteExiste (String matricule , String codem) {
        try {
            Connection con = getConnection();
            rs = statement.executeQuery("select * FROM EXAMEN WHERE MATRICULE = '"+matricule+"'"+" and CODEM = '" + codem + "'");
            if (rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

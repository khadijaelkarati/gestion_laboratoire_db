package java.patien.dao;
import java.sql.Connection;  
import java.sql.DriverManager;

public class DBConnection {
    public DBConnection() {
    }
    
    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Paramètres de connexion Oracle
            String host = "localhost";
            String port = "1521";
            String service = "FREEPDB1"; // ou "XE"
            String user = "system";
            String password = "OraclePass123"; // votre mot de passe
            String url = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + service;
            return DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver Oracle non trouvé !");
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Erreur de connexion à Oracle : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connexion réussie à Oracle !");
        } else {
            System.out.println("Échec de la connexion");
        }
    }
}
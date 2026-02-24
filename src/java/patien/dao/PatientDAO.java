package java.patien.dao;
import java.sql.*;
import java.util.*;
import java.patient.bean.*;
public class PatientDAO {
	public PatientDAO() {
	}
// Supprimer
	  public static void deletePatient(String cin) throws Exception { 
	        Connection con = DBConnection.getConnection();
	        String query = "DELETE FROM patient WHERE CIN=?";
	        PreparedStatement ps = con.prepareStatement(query);
	     // setString SÉCURISÉ !
	        ps.setString(1, cin); // Remplace le ? par la valeur de cin 
	        ps.executeUpdate();
	        con.close();
	    }

    // Modifier
    public static void updatePatient(Patient p) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(  "UPDATE patient SET NOM=?, PRENOM=?, DATE_NAIS=?, GENRE=?,PHONE=?,"
        		+ "EMAIL=?,ADRESS=?, MEDECIN_TRAITANT=?, DATE_CREATION=?, DATE_MODIFICATION=?,CREE_PAR=?,MODIFIE_PAR=?,CIN=? WHERE ID_PATIENT=?" );
        ps.setString(1, p.getNOM()); // 1er ? → NOM
        ps.setString(2, p.getPRENOM());// 2ème ? → PRENOM
        ps.setString(3, p.getDATE_NAIS());
        ps.setString(4, p.getGENRE());
        ps.setString(5, p.getPHONE());
        ps.setString(6, p.getEMAIL());
        ps.setString(7, p.getADRESS());
        ps.setString(8, p.getMEDECIN_TRAITANT());
        ps.setString(9, p.getDATE_CREATION());
        ps.setString(10, p.getDATE_MODIFICATION());
        ps.setString(11, p.getCREE_PAR());
        ps.setString(12, p.getMODIFIE_PAR());
        ps.setString(13, p.getCIN()); 
        ps.executeUpdate();
        con.close();
    }
    // Récupérer tous les patients
    public static List<Patient> getAllPatients() throws Exception {
        List<Patient> patients = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM patient");
        
        while (rs.next()) {
            Patient p = new Patient();
            p.setNOM(rs.getString("NOM"));
            p.setPRENOM(rs.getString("PRENOM"));
            p.setDATE_NAIS(rs.getString("DATE_NAIS"));
            p.setGENRE(rs.getString("GENRE"));
            p.setPHONE(rs.getString("PHONE"));
            p.setEMAIL(rs.getString("EMAIL"));
            p.setADRESS(rs.getString("ADRESS"));
            p.setMEDECIN_TRAITANT(rs.getString("MEDECIN_TRAITANT"));
            p.setDATE_CREATION(rs.getString("DATE_CREATION"));
            p.setDATE_MODIFICATION(rs.getString("DATE_MODIFICATION"));
            p.setCREE_PAR(rs.getString("CREE_PAR"));
            p.setMODIFIE_PAR(rs.getString("MODIFIE_PAR"));
            p.setCIN(rs.getString("CIN"));
            patients.add(p);
        }
        
        con.close();
        return patients;
    }
}

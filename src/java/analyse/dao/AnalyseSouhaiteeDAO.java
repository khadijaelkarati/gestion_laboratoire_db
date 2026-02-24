
package java.analyse.dao;
import java.analyse.bean.AnalyseSouhaitee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.patien.dao.*;
public class AnalyseSouhaiteeDAO {

	public AnalyseSouhaiteeDAO() {
		// TODO Auto-generated constructor stub
	}
  
    private Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }
   
    // ==================== UPDATE ====================
    
    // Mise à jour complète
    public void updateAnalyse(AnalyseSouhaitee analyse) throws SQLException {
        String sql = "UPDATE analyse_souhaitee SET status = ?, resultat = ?, " +
                    "observations = ? WHERE id_analyse_souhaitee = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, analyse.getStatus());
            ps.setString(2, analyse.getResultat());
            ps.setString(3, analyse.getObservations());
            ps.setInt(4, analyse.getId_analyse_souhaitee());
            
            ps.executeUpdate();
        }
    }
    
    // Mise à jour status seulement
    public void updateStatus(int idAnalyse, String status) throws SQLException {
        String sql = "UPDATE analyse_souhaitee SET status = ? WHERE id_analyse_souhaitee = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, status);
            ps.setInt(2, idAnalyse);
            ps.executeUpdate();
        }
    }
    
    // Mise à jour résultat seulement
    public void updateResultat(int idAnalyse, String resultat) throws SQLException {
        String sql = "UPDATE analyse_souhaitee SET resultat = ? WHERE id_analyse_souhaitee = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, resultat);
            ps.setInt(2, idAnalyse);
            ps.executeUpdate();
        }
    }
    
    // ==================== DELETE ====================
    
    // Supprimer une analyse par ID
    public void deleteAnalyse(int idAnalyse) throws SQLException {
        String sql = "DELETE FROM analyse_souhaitee WHERE id_analyse_souhaitee = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idAnalyse);
            ps.executeUpdate();
        }
    }
    
    // Supprimer toutes les analyses d'un patient
    public void deleteAnalysesByPatient(int idPatient) throws SQLException {
        String sql = "DELETE FROM analyse_souhaitee WHERE id_patient = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idPatient);
            ps.executeUpdate();
        }
    }
    
    // Supprimer les analyses terminées
    public void deleteAnalysesTerminees() throws SQLException {
        String sql = "DELETE FROM analyse_souhaitee WHERE status = 'TERMINEE'";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.executeUpdate();
        }
    }
    }
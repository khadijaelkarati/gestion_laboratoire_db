package java.factureanalyse.dao;
import java.patien.dao.*;

import java.factureanalyse.bean.FactureAnalyse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class FactureAnalyseDAO {

	public FactureAnalyseDAO() {
		// TODO Auto-generated constructor stub
	}
	  private Connection getConnection() throws SQLException {
	        return DBConnection.getConnection();
	    }
	   
	    // ==================== DELETE ====================
	    
	    // Supprimer une ligne spécifique
	    public void delete(int idFacture, int idAnalyse) throws SQLException {
	        String sql = "DELETE FROM facture_analyse WHERE id_facture = ? AND id_analyse_souhaitee = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, idFacture);
	            ps.setInt(2, idAnalyse);
	            ps.executeUpdate();
	        }
	    }
	    
	    // Supprimer toutes les analyses d'une facture
	    public void deleteByFacture(int idFacture) throws SQLException {
	        String sql = "DELETE FROM facture_analyse WHERE id_facture = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, idFacture);
	            ps.executeUpdate();
	        }
	    }
	    
	    // Supprimer toutes les factures d'une analyse
	    public void deleteByAnalyse(int idAnalyse) throws SQLException {
	        String sql = "DELETE FROM facture_analyse WHERE id_analyse_souhaitee = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, idAnalyse);
	            ps.executeUpdate();
	        }
	    }
	    
	    // ==================== UPDATE ====================
	    // (Rare pour table de liaison - on delete/insert plutôt)
	    
	    // "Update" = supprimer ancienne et insérer nouvelle
	    public void update(int ancienneFacture, int ancienneAnalyse, 
	                      int nouvelleFacture, int nouvelleAnalyse) throws SQLException {
	        
	        Connection conn = null;
	        try {
	            conn = getConnection();
	            conn.setAutoCommit(false);
	            
	            // Supprimer l'ancienne relation
	            String deleteSql = "DELETE FROM facture_analyse WHERE id_facture = ? AND id_analyse_souhaitee = ?";
	            try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
	                ps.setInt(1, ancienneFacture);
	                ps.setInt(2, ancienneAnalyse);
	                ps.executeUpdate();
	            }
	            
	            // Insérer la nouvelle
	            String insertSql = "INSERT INTO facture_analyse (id_facture, id_analyse_souhaitee) VALUES (?, ?)";
	            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
	                ps.setInt(1, nouvelleFacture);
	                ps.setInt(2, nouvelleAnalyse);
	                ps.executeUpdate();
	            }
	            
	            conn.commit();
	        } catch (SQLException e) {
	            if (conn != null) conn.rollback();
	            throw e;
	        } finally {
	            if (conn != null) conn.close();
	        }
	    }
	    
}

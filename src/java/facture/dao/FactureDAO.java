package java.facture.dao;
import java.facture.bean.Facture;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.patien.dao.*;
public class FactureDAO {

	public FactureDAO() {
		// TODO Auto-generated constructor stub
	}
	   private Connection getConnection() throws SQLException {
	        return DBConnection.getConnection();
	    }
	// ==================== UPDATE ====================
	    
	    // Mise à jour complète
	    public void updateFacture(Facture facture) throws SQLException {
	        String sql = "UPDATE facture SET numero_facture = ?, id_patient = ?, " +
	                    "montant_total = ?, status_paiement = ?, date_paiement = ?, " +
	                    "mode_paiement = ?, observation = ? WHERE id_facture = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setString(1, facture.getNumero_facture());
	            ps.setInt(2, facture.getId_patient());
	            ps.setDouble(3, facture.getMontant_total());
	            ps.setString(4, facture.getStatus_paiement());
	            
	            if (facture.getDate_paiement() != null) {
	                ps.setDate(5, new java.sql.Date(facture.getDate_paiement().getTime()));
	            } else {
	                ps.setNull(5, Types.DATE);
	            }
	            
	            ps.setString(6, facture.getMode_paiement());
	            ps.setString(7, facture.getObservation());
	            ps.setInt(8, facture.getId_facture());
	            
	            ps.executeUpdate();
	        }
	    }
	   // Mise à jour du status de paiement
	    public void updateStatusPaiement(int idFacture, String status, String mode, Date datePaiement) throws SQLException {
	        String sql = "UPDATE facture SET status_paiement = ?, mode_paiement = ?, date_paiement = ? " +
	                    "WHERE id_facture = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setString(1, status);
	            ps.setString(2, mode);
	            
	            if (datePaiement != null) {
	                ps.setDate(3, new java.sql.Date(datePaiement.getTime()));
	            } else {
	                ps.setNull(3, Types.DATE);
	            }
	            
	            ps.setInt(4, idFacture);
	            
	            ps.executeUpdate();
	        }
	    }
	 // Marquer comme payée
	    public void marquerCommePayee(int idFacture, String modePaiement) throws SQLException {
	        String sql = "UPDATE facture SET status_paiement = 'PAYEE', date_paiement = SYSDATE, " +
	                    "mode_paiement = ? WHERE id_facture = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setString(1, modePaiement);
	            ps.setInt(2, idFacture);
	            
	            ps.executeUpdate();
	        }
	    } 
	    // ==================== DELETE ====================
	    
	    // Supprimer une facture par ID
	    public void deleteFacture(int idFacture) throws SQLException {
	        String sql = "DELETE FROM facture WHERE id_facture = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, idFacture);
	            ps.executeUpdate();
	        }
	    }
	    
	    // Supprimer les factures d'un patient
	    public void deleteFacturesByPatient(int idPatient) throws SQLException {
	        String sql = "DELETE FROM facture WHERE id_patient = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, idPatient);
	            ps.executeUpdate();
	        }
	    }
	    
	    // Supprimer les factures annulées
	    public void deleteFacturesAnnulees() throws SQLException {
	        String sql = "DELETE FROM facture WHERE status_paiement = 'ANNULEE'";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.executeUpdate();
	        }
	    }
}

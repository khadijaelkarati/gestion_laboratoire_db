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
	// ==================== CALCUL MONTANT TOTAL ====================

	   public void updateMontantTotal(int idFacture) throws SQLException {

	       String sql = "UPDATE facture f SET montant_total = ( SELECT NVL(SUM(ca.prix), 0)"+"FROM facture_analyse fa "+
	       "JOIN analyse_souhaitee a ON fa.id_analyse_souhaitee = a.id_analyse_souhaitee "+
	    		   "JOIN catalogue_analyse ca ON a.id_catalogue = ca.id_catalogue"
	    		   +" WHERE fa.id_facture = f.id_facture)";

	       try (Connection conn = getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql)) {

	           ps.setInt(1, idFacture);
	           ps.executeUpdate();
	       }
	   }
	   
	   // Mise à jour des info du facture
	    public void updateFacture(Facture facture) throws SQLException {

	        String sql = "UPDATE facture SET id_facture=?,numero_facture=?,id_patient=?,date_emission=?, montant_total=?, status_paiement=?, mode_paiement=? ,observation=? WHERE  numero_facture=?";

	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	        	 ps.setString(1, facture.getNumero_facture());
	             ps.setInt(2, facture.getId_patient());
	             ps.setDate(3, new java.sql.Date(facture.getDate_emission().getTime()));
	             ps.setDouble(4, facture.getMontant_total());
	             ps.setString(5, facture.getStatus_paiement());
	             ps.setString(6, facture.getMode_paiement());
	             ps.setString(7, facture.getObservation());
	             ps.setInt(8, facture.getId_facture());	
	             ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	    // ==================== DELETE ====================
	    
	    // Supprimer une facture par numero_facture
	    public void deleteFacture(int numero_facture) throws SQLException {
	        String sql = "DELETE FROM facture WHERE numero_facture = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1,  numero_facture);
	            ps.executeUpdate();
	        }
	    }
	    
	    // Supprimer les factures d'un patient
	    public void deleteFacturesByPatient(int CIN) throws SQLException {
	        String sql = "DELETE FROM facture WHERE CIN = ?";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, CIN);
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

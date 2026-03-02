package com.labo.patient.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.labo.db.BDContext;
import com.labo.patient.beans.PatientBean;

public class PatientDAO {
	// === Afficher tous les patients ====
		public static List<PatientBean> getAllPatient() throws Exception {
			List<PatientBean> patients = new ArrayList<>();
			String sql = " select * from PATIENT";
			try (Connection con = BDContext.getConnection();
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					PatientBean patient = new PatientBean();
					patient.setId(rs.getInt("ID_PATIENT"));
					patient.setCin(rs.getString("CIN"));
					patient.setNom(rs.getString("NOM"));
					patient.setPrenom(rs.getString("PRENOM"));
					patient.setGenre(rs.getString("GENRE"));
	                patient.setPhone(rs.getString("PHONE"));
	                patient.setDateNaissance(rs.getString("DATE_NAIS"));
	                patient.setEmail(rs.getString("EMAIL"));
	                patient.setAddress(rs.getString("ADRESS"));
	                patient.setMedecinTraitant(rs.getString("MEDECIN_TRAITANT"));
	                patient.setDateCreation(rs.getString("DATE_CREATION"));
	                patient.setDateModification(rs.getString("DATE_MODIFICATION"));
	                patient.setCreePar(rs.getString("CREE_PAR"));
	                patient.setModifiePar(rs.getString("MODIFIE_PAR"));  
	                patients.add(patient);
				}
			}catch (SQLException e) {
	            System.err.println("Erreur SQL dans getAllPatients: " + e.getMessage());
	            throw new Exception("Erreur lors de la récupération des patients: " + e.getMessage(), e);
	        }
	        
	        return patients;		
			
		}
		
		// === Récupérer un patient par cin ===
		public PatientBean getPatientByCin(String cin) {
		    PatientBean patient = null;
		    String sql = "SELECT * FROM PATIENT WHERE CIN = ?"; 
		    
		    try (Connection con = BDContext.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {
		        ps.setString(1, cin);
		        
		        // Ensuite exécuter la requête
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                patient = new PatientBean();
		                patient.setId(rs.getInt("ID_PATIENT"));
		                patient.setCin(rs.getString("CIN"));
		                patient.setNom(rs.getString("NOM"));
		                patient.setPrenom(rs.getString("PRENOM"));
		                patient.setGenre(rs.getString("GENRE"));
		                patient.setPhone(rs.getString("PHONE"));
		                patient.setDateNaissance(rs.getString("DATE_NAIS"));
		                patient.setEmail(rs.getString("EMAIL"));
		                patient.setAddress(rs.getString("ADRESS"));
		                patient.setMedecinTraitant(rs.getString("MEDECIN_TRAITANT"));
		                patient.setDateCreation(rs.getString("DATE_CREATION"));
		                patient.setDateModification(rs.getString("DATE_MODIFICATION"));
		                patient.setCreePar(rs.getString("CREE_PAR"));
		                patient.setModifiePar(rs.getString("MODIFIE_PAR"));
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return patient;
		}
		// === Mettre à jour un patient ===
		public boolean updatePatient(PatientBean patient) {
		    String sql = "UPDATE PATIENT SET " +
		                 "NOM = ?, " +
		                 "PRENOM = ?, " +
		                 "DATE_NAIS = TO_DATE(?, 'YYYY-MM-DD'), " +  // Format date seulement
		                 "GENRE = ?, " +
		                 "PHONE = ?, " +
		                 "EMAIL = ?, " +
		                 "ADRESS = ?, " +
		                 "MEDECIN_TRAITANT = ?, " +
		                 "DATE_MODIFICATION = SYSDATE, " +
		                 "CREE_PAR = ?, " +
		                 "MODIFIE_PAR = ? " +
		                 "WHERE CIN = ?";
		    
		    try (Connection con = BDContext.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {
		        
		        // 1. Nom
		        ps.setString(1, patient.getNom() != null ? patient.getNom() : "");
		        
		        // 2. Prénom
		        ps.setString(2, patient.getPrenom() != null ? patient.getPrenom() : "");
		        
		        // 3. Date de naissance - formater correctement
		        String dateNaiss = patient.getDateNaissance();
		        if (dateNaiss != null && dateNaiss.length() > 10) {
		            dateNaiss = dateNaiss.substring(0, 10); // Garder seulement YYYY-MM-DD
		        }
		        ps.setString(3, dateNaiss);
		        
		        // 4. Genre
		        ps.setString(4, patient.getGenre() != null ? patient.getGenre() : "");
		        
		        // 5. Phone
		        ps.setString(5, patient.getPhone() != null ? patient.getPhone() : "");
		        
		        // 6. Email
		        ps.setString(6, patient.getEmail() != null ? patient.getEmail() : "");
		        
		        // 7. Adresse
		        ps.setString(7, patient.getAddress() != null ? patient.getAddress() : "");
		        
		        // 8. Médecin traitant
		        ps.setString(8, patient.getMedecinTraitant() != null ? patient.getMedecinTraitant() : "");
		
		        
		        // 9. Créé par
		        ps.setString(9, patient.getCreePar() != null ? patient.getCreePar() : "");
		        
		        // 10. Modifié par
		        ps.setString(10, patient.getModifiePar() != null ? patient.getModifiePar() : "system");
		        
		        // 11. CIN (WHERE)
		        ps.setString(11, patient.GetCin());
		        
		        System.out.println("Exécution UPDATE pour CIN: " + patient.GetCin());
		        System.out.println("Date naissance: " + dateNaiss);
		       
		        
		        int rowsUpdated = ps.executeUpdate();
		        System.out.println("Lignes mises à jour: " + rowsUpdated);
		        
		        return rowsUpdated > 0;
		        
		    } catch (SQLException e) {
		        System.err.println("Erreur SQL dans updatePatient:");
		        e.printStackTrace();
		        return false;
		    }
		}
		
		
		// === Delete un patient ===
		public boolean deletePatientByCin(String cin) {
		    String sql = "DELETE FROM patient WHERE CIN = ?";
		    
		    try (Connection con = BDContext.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {
		        
		        ps.setString(1, cin);
		        
		        int rowsDeleted = ps.executeUpdate();
		        System.out.println("Lignes supprimées: " + rowsDeleted);
		        
		        return rowsDeleted > 0;
		        
		    } catch (SQLException e) {
		        System.err.println("Erreur SQL dans deletePatientByCin: " + e.getMessage());
		        e.printStackTrace();
		        return false;
		    }
		}
		// === Ajouter un patient ===
	  public  boolean insertPatient(PatientBean p) throws Exception {
	    String sql =
	      "INSERT INTO PATIENT (ID_PATIENT, NOM, PRENOM, DATE_NAIS, GENRE, PHONE, EMAIL, ADRESS, MEDECIN_TRAITANT, DATE_CREATION, DATE_MODIFICATION,CREE_PAR, MODIFIE_PAR, CIN) " +
	      "VALUES (SEQ_PATIENT.NEXTVAL, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, SYSDATE, SYSDATE, ?, ?, ?)";

	    try (Connection con = BDContext.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	      ps.setString(1, p.getNom());
	      ps.setString(2, p.getPrenom());
	      ps.setString(3, p.getDateNaissance());
	      ps.setString(4, p.getGenre());
	      ps.setString(5, p.getPhone());
	      ps.setString(6, p.getEmail());
	      ps.setString(7, p.getAddress());
	      ps.setString(8, p.getMedecinTraitant());
	      ps.setString(9, p.getCreePar());
	      ps.setString(10, p.getModifiePar());
	      ps.setString(11, p.GetCin());
	      
	      int rowsInserted = ps.executeUpdate();
	      return rowsInserted > 0;
	    }catch (SQLException e) {
			System.out.println(" Erreur SQL dans insertPatient : " + e.getMessage());
			 e.printStackTrace();
			 return false;
		}
	  }


}

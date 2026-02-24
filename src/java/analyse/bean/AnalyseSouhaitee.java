package java.analyse.bean;

import java.util.Date;

public class AnalyseSouhaitee {
 private int id_analyse_souhaitee;
		    private int id_patient;
		    private int id_catalogue;
		    private Date date_demande;
		    private String status;
		    private String resultat;
		    private String observations;
	
	public AnalyseSouhaitee() {
		  this.status = "EN_ATTENTE";
                 }
	 // Getters et Setters
    public int getId_analyse_souhaitee() {
        return  id_analyse_souhaitee;
    }
    
    public void setId_analyse_souhaitee(int id_analyse_souhaitee) {
        this. id_analyse_souhaitee =  id_analyse_souhaitee;
    }
    
    public int getId_patient() {
        return id_patient;
    }
    
    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }
    
    public int getId_catalogue() {
        return id_catalogue;
    }
    
    public void setId_catalogue(int id_catalogue) {
        this.id_catalogue = id_catalogue;
    }
    
    public Date getDate_demande() {
        return date_demande;
    }
    
    public void setDateDemande(Date date_demande) {
        this.date_demande = date_demande;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status= status;
    }
    public String getResultat() {
        return resultat;
    }
    
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
    public String getObservations() {
        return observations;
    }
    
    public void setObservations(String observations) {
        this.observations = observations;
    }
	
}

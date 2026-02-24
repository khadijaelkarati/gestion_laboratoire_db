package java.analyse.beans;

import java.util.Date;

public class AnalyseSouhaitee {

	

	    private int id_analyse;
	    private int id_patient;
	    private int id_catalogue;
	    private Date date_demande;
	    private String status;
	    private String resultat;
	    private String observations;
	    private String validation;
	    private int validee_par;
	    private Date date_validation;
	    private String avis_biologiste;

	    public AnalyseSouhaitee() {}

	    public int getId_analyse() { return id_analyse; }
	    public void setId_analyse(int id_analyse) { this.id_analyse = id_analyse; }

	    public int getId_patient() { return id_patient; }
	    public void setId_patient(int id_patient) { this.id_patient = id_patient; }

	    public int getId_catalogue() { return id_catalogue; }
	    public void setId_catalogue(int id_catalogue) { this.id_catalogue =id_catalogue; }

	    public Date getDate_demande() { return  date_demande; }
	    public void setDate_demande(Date  date_demande) { this. date_demande =  date_demande; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public String getResultat() { return resultat; }
	    public void setResultat(String resultat) { this.resultat = resultat; }

	    public String getObservations() { return observations; }
	    public void setObservations(String observations) { this.observations = observations; }


	    public String getValidation() { return validation; }
	    public void setValidation(String validation) { this.validation = validation; }

	    public int getValidee_par() { return validee_par; }
	    public void setValidee_par(int validee_par) { this.validee_par = validee_par; }

	    public Date getDate_validation() { return date_validation; }
	    public void setDate_validation(Date date_validation) { this.date_validation = date_validation; }

	    public String getAvis_biologiste() { return avis_biologiste; }
	    public void setAvis_biologiste(String avis_biologiste) { this.avis_biologiste = avis_biologiste; }
	}


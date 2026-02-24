package java.patient.bean;

public class Patient {
private String ID_PATIENT;
private String NOM;
private String PRENOM;
private String DATE_NAIS;
private String GENRE ;
private String PHONE;
private String EMAIL;
private String ADRESS;
private String MEDECIN_TRAITANT;
private String DATE_CREATION;
private String DATE_MODIFICATION;
private String CREE_PAR;
private String MODIFIE_PAR ;
private String CIN;
public Patient() {
}
//Getters & Setters
public String getID_PATIENT() {
	return ID_PATIENT;
}
public void setID_PATIENT(String ID_PATIENT) {
	this.ID_PATIENT=ID_PATIENT;
}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String NOM) {
		this.NOM=NOM;
	}
	public String getPRENOM() {
		return PRENOM;
	}
	public void setPRENOM(String PRENOM) {
		this.PRENOM=PRENOM;
	}
	public String getDATE_NAIS() {
		return DATE_NAIS;
	}
	public void setDATE_NAIS(String DATE_NAIS) {
		this.DATE_NAIS=DATE_NAIS;
	}
	public String getGENRE() {
		return GENRE;
	}
	public void setGENRE(String GENRE) {
		this.GENRE=GENRE;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String PHONE) {
		this.PHONE=PHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String EMAIL) {
		this.EMAIL=EMAIL;
	}
	public String getADRESS() {
		return ADRESS;
	}
	public void setADRESS(String ADRESS) {
		this.ADRESS=ADRESS;
	}
	public String getMEDECIN_TRAITANT() {
		return MEDECIN_TRAITANT;
	}
	public void setMEDECIN_TRAITANT(String MEDECIN_TRAITANT) {
		this.MEDECIN_TRAITANT=MEDECIN_TRAITANT;
	}
	public String getDATE_CREATION() {
		return DATE_CREATION;
	}
	public void setDATE_CREATION(String DATE_CREATION) {
		this.DATE_CREATION=DATE_CREATION;
	}public String getDATE_MODIFICATION() {
		return DATE_MODIFICATION;
	}
	public void setDATE_MODIFICATION(String DATE_MODIFICATION) {
		this.DATE_MODIFICATION=DATE_MODIFICATION;
	}public String getCREE_PAR() {
		return CREE_PAR;
	}
	public void setCREE_PAR(String CREE_PAR) {
		this.CREE_PAR=CREE_PAR;
	}
	public String getMODIFIE_PAR() {
		return MODIFIE_PAR;
	}
	public void setMODIFIE_PAR(String MODIFIE_PAR) {
		this.MODIFIE_PAR=MODIFIE_PAR;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String CIN) {
		this.CIN=CIN;
	}
}

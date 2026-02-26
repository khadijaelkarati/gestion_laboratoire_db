package java.patient.beans;

import java.util.Date;

public class Patient {
	private int id;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String adress;
    private String medecin;
    private  Date  date_nais ;
    private String genre ;
    private  Date date_creation ;
    private  Date date_modification ;
    private String  cree_par ;
    private String  modifie_par ;
    public Patient() {}

   
    public int getId() { return id; }
  
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    
    public void setEmail(String email) { this.email =email; }

    public String getAdress() { return adress; }
    public void setAdress(String adress) { this.adress = adress; }

    public Date getDate_nais () { return date_nais ; }
    public void setDate_nais (Date date_nais ) { this.date_nais  = date_nais ; }
    
    public Date getDate_creation () { return date_creation ; }
    public void setDate_creation (Date date_creation ) { this.date_creation  = date_creation ; }
    
    public Date getDate_modification() { return date_modification ; }
    public void setDate_modification (Date date_modification ) { this.date_modification  = date_modification ; }
    
    
    
    public String getMedecin() { return medecin; }
    public void setMedecin(String medecin) { this.medecin = medecin; }

    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre =genre; }

    
    public String getCree_par() { return cree_par; }
    public void setCree_par(String cree_par) { this.cree_par = cree_par; }

    
    public String getModifie_par() { return modifie_par; }
    public void setModifie_par(String modifie_par) { this.modifie_par = modifie_par; }


}

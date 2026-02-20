package java.patient.beans;

public class Patient {
	private int id;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String adress;
    private String medecin;
  
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

    public String getMedecin() { return medecin; }
    public void setMedecin(String medecin) { this.medecin = medecin; }


}

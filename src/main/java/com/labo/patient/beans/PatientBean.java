package com.labo.patient.beans;

public class PatientBean {
	 private int id;
	    private String nom;
	    private String prenom;
	    private String cin;
	    private String dateNaissance;
	    private String genre;
	    private String phone;
	    private String email;
	    private String address;
	    private String medecinTraitant;
	    private String dateCreation;
	    private String dateModification;
	    private String creePar;
	    private String modifiePar;
	    
	    // Getters et Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int idPatient) {
	        this.id = idPatient;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }
	    public void setCin(String cin) {
	    	this.cin = cin;
	    }
	    public String GetCin() {
	    	return this.cin;
	    }

	    public String getDateNaissance() {
	        return dateNaissance;
	    }

	    public void setDateNaissance(String dateNaissance) {
	        this.dateNaissance = dateNaissance;
	    }
	    public String getGenre() {
	        return genre;
	    }

	    public void setGenre(String genre) {
	        this.genre = genre;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	    public String getMedecinTraitant() {
	        return medecinTraitant;
	    }

	    public void setMedecinTraitant(String medecinTraitant) {
	        this.medecinTraitant = medecinTraitant;
	    }

	    public String getDateCreation() {
	        return dateCreation;
	    }

	    public void setDateCreation(String dateCreation) {
	        this.dateCreation = dateCreation;
	    }
	    public String getDateModification() {
	        return dateModification;
	    }
	    public void setDateModification(String dateModification) {
	        this.dateModification = dateModification;
	    }

	    public String getCreePar() {
	        return creePar;
	    }

	    public void setCreePar(String creePar) {
	        this.creePar = creePar;
	    }

	    public String getModifiePar() {
	        return modifiePar;
	    }
	    public void setModifiePar(String modifiePar) {
	        this.modifiePar = modifiePar;
	    }
	    

}

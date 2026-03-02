package com.labo.facture.beans;

import java.sql.Date;

public class FactureBean {

    private int id_facture;
    private String numero_facture;
    private int id_patient;
    private Date date_emission;
    private double montant_total;
    private String status_paiement;
    private Date date_paiement;
    private String mode_paiment;
    private String observation;

    public FactureBean() {}

    public FactureBean(int id_facture, String numero_facture, int id_patient,
                       Date date_emission, double montant_total,
                       String status_paiement, Date date_paiement,
                       String mode_paiment, String observation) {

        this.id_facture = id_facture;
        this.numero_facture = numero_facture;
        this.id_patient = id_patient;
        this.date_emission = date_emission;
        this.montant_total = montant_total;
        this.status_paiement = status_paiement;
        this.date_paiement = date_paiement;
        this.mode_paiment = mode_paiment;
        this.observation = observation;
    }

    // Getters & Setters
    public int getId_facture() { return id_facture; }
    public void setId_facture(int id_facture) { this.id_facture = id_facture; }

    public String getNumero_facture() { return numero_facture; }
    public void setNumero_facture(String numero_facture) { this.numero_facture = numero_facture; }

    public int getId_patient() { return id_patient; }
    public void setId_patient(int id_patient) { this.id_patient = id_patient; }

    public Date getDate_emission() { return date_emission; }
    public void setDate_emission(Date date_emission) { this.date_emission = date_emission; }

    public double getMontant_total() { return montant_total; }
    public void setMontant_total(double montant_total) { this.montant_total = montant_total; }

    public String getStatus_paiement() { return status_paiement; }
    public void setStatus_paiement(String status_paiement) { this.status_paiement = status_paiement; }

    public Date getDate_paiement() { return date_paiement; }
    public void setDate_paiement(Date date_paiement) { this.date_paiement = date_paiement; }

    public String getMode_paiment() { return mode_paiment; }
    public void setMode_paiment(String mode_paiment) { this.mode_paiment = mode_paiment; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }
}
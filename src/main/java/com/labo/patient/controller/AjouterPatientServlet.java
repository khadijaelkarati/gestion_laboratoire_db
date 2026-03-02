package com.labo.patient.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.labo.patient.beans.PatientBean;
import com.labo.patient.doa.PatientDAO;

/**
 * Servlet implementation class AjouterPatientServlet
 */
@WebServlet("/AjouterPatientServlet")
public class AjouterPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
    private PatientDAO patientDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        patientDAO = new PatientDAO();
        System.out.println("✅ AjouterPatientServlet initialisée");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Récupérer les paramètres
            String cin = request.getParameter("cin");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String dateNaissance = request.getParameter("dateNaissance");
            String genre = request.getParameter("genre");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String adresse = request.getParameter("adresse");
            String medecinTraitant = request.getParameter("medecinTraitant");
            
            // Validation simple
            if (cin == null || cin.trim().isEmpty() || nom == null || nom.trim().isEmpty()) {
                request.setAttribute("erreur", "CIN et Nom sont obligatoires");
                request.getRequestDispatcher("AjouterPatient.jsp").forward(request, response);
                return;
            }
            
            // Créer et remplir le bean
            PatientBean patient = new PatientBean();
            patient.setCin(cin);
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setDateNaissance(dateNaissance);
            patient.setGenre(genre);
            patient.setPhone(phone);
            patient.setEmail(email);
            patient.setAddress(adresse);
            patient.setMedecinTraitant(medecinTraitant);
            
            // Informations système
            HttpSession session = request.getSession();
            /*String utilisateur = (String) session.getAttribute("utilisateur");
            patient.setCreePar(utilisateur != null ? utilisateur : "SECRETAIRE");
            patient.setModifiePar(utilisateur != null ? utilisateur : "SECRETAIRE");*/
            
            // Appel au DAO
            boolean success = patientDAO.insertPatient(patient);
            
            if (success) {
                session.setAttribute("message", "Patient ajouté avec succès");
                session.setAttribute("messageType", "success");
                response.sendRedirect("ConfirmAjoutPatient.jsp");
            } else {
                request.setAttribute("erreur", "Erreur lors de l'ajout");
                request.getRequestDispatcher("AjouterPatient.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Erreur: " + e.getMessage());
            request.getRequestDispatcher("AjouterPatient.jsp").forward(request, response);
        }
    }
}

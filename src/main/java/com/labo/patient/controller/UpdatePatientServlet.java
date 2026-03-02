package com.labo.patient.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.patient.beans.PatientBean;
import com.labo.patient.doa.PatientDAO;

/**
 * Servlet implementation class UpdatePatientServlet
 */
@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Récupérer les données du formulaire
            String cin = request.getParameter("cin");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String dateNaissance = request.getParameter("dateNaissance");
            String genre = request.getParameter("genre");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String adresse = request.getParameter("adresse");
            String medecinTraitant = request.getParameter("medecinTraitant");
            String creePar = request.getParameter("creepar");
            String modiferPar = request.getParameter("modifierpar");
            // Créer l'objet Patient avec les nouvelles données
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
            patient.setCreePar(creePar);
            patient.setModifiePar(modiferPar);
            
            // Mettre à jour dans la base de données
            PatientDAO dao = new PatientDAO();
            boolean success = dao.updatePatient(patient);
            
            if (success) {
                // Rediriger vers la page de confirmation avec le CIN
                response.sendRedirect("ConfirmModificationPatient.jsp?cin=" + cin + "&success=true");
            } else {
                // En cas d'échec
                response.sendRedirect("ErrorEditPatient.jsp?cin=" + cin + "&error=update_failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("PatientDashboard.jsp?error=exception");
        }
    }

}

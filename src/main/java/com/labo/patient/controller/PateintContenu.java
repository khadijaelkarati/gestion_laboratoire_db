package com.labo.patient.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.patient.beans.PatientBean;
import com.labo.patient.doa.PatientDAO;

/**
 * Servlet implementation class PateintContenu
 */
@WebServlet("/PateintContenu")
public class PateintContenu extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    // Méthode doGet pour gérer les requêtes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // 1. Appeler le DAO pour récupérer la liste des patients
            List<PatientBean> patients = PatientDAO.getAllPatient();
            // 2. Stocker la liste dans la requête (pour la JSP)
            request.setAttribute("patients", patients);
            
            // 3. Optionnel: Ajouter un message de succès
            request.setAttribute("message", patients.size() + " patient(s) trouvé(s)");
            
            // 4. Rediriger vers la page d'accueil avec le paramètre page=patient
            //    pour que le menu affiche la classe active
            request.getRequestDispatcher("Accuiel.jsp?page=patient").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            
            // En cas d'erreur, stocker le message d'erreur
            request.setAttribute("erreur", "Erreur lors du chargement des patients: " + e.getMessage());
            
            // Rediriger quand même vers la page mais avec l'erreur
            request.getRequestDispatcher("Accuiel.jsp?page=patient").forward(request, response);
        }
    }
    

}

package com.labo.patient.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.patient.doa.PatientDAO;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/DeletePatientServlet")
public class DeletePatientServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Récupérer le CIN du patient à supprimer
            String cin = request.getParameter("cin");
            
            // Vérifier si le CIN est présent
            if (cin == null || cin.trim().isEmpty()) {
                response.sendRedirect("Accuiel.jsp?error=missing_cin");
                return;
            }
            
            System.out.println("Tentative de suppression pour CIN: " + cin);
            
            // Supprimer le patient de la base de données
            PatientDAO dao = new PatientDAO();
            boolean success = dao.deletePatientByCin(cin);
            System.out.println("suppression: " +success);
            
            if (success) {
                // Rediriger vers la page de confirmation
                response.sendRedirect("SuccesDeletePatient.jsp?cin=" + cin + "&success=true");
            } else {
                // En cas d'échec
                response.sendRedirect("ErrorDelete.jsp?cin=" + cin + "&error=delete_failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Accuiel.jsp.jsp?error=exception");
        }
    }
}

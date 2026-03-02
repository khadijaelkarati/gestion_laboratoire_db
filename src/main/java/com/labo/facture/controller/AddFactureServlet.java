package com.labo.facture.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.db.BDContext;

@WebServlet("/AddFactureServlet")
public class AddFactureServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        String numFacture = request.getParameter("numero_facture");
	        int idPatient = Integer.parseInt(request.getParameter("id_patient"));
	        double montant = Double.parseDouble(request.getParameter("montant_total"));
	        String status = request.getParameter("status_paiement");
	        String mode = request.getParameter("mode_paiment");
	        String observation = request.getParameter("observation");

	        try {
	            Connection conn = BDContext.getConnection();
	            
	            String sql = "INSERT INTO FACTURE (NUMERO_FACTURE, ID_PATIENT, MONTANT_TOTAL, STATUS_PAIEMENT, MODE_PAIMENT, OBSERVATION, DATE_EMISSION) VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, numFacture);
	            ps.setInt(2, idPatient);
	            ps.setDouble(3, montant);
	            ps.setString(4, status);
	            ps.setString(5, mode);
	            ps.setString(6, observation);

	            int result = ps.executeUpdate();
	            if (result > 0) {
	                
	                response.sendRedirect("FactureDashboard.jsp");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("ErrorEditFacture.jsp");
	        }
	    }
	}

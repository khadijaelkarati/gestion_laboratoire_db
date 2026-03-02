package com.labo.facture.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.db.BDContext;
import com.labo.facture.beans.FactureBean;

/**
 * Servlet implementation class ModifierFactureServlet
 */
@WebServlet("/ModifierFactureServlet")
public class ModifierFactureServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FactureBean facture = null;

        try {
            Connection conn = BDContext.getConnection();
            String sql = "SELECT * FROM FACTURE WHERE ID_FACTURE = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                facture = new FactureBean();
                facture.setId_facture(rs.getInt("ID_FACTURE"));
                facture.setNumero_facture(rs.getString("NUMERO_FACTURE"));
                facture.setMontant_total(rs.getDouble("MONTANT_TOTAL"));
                facture.setStatus_paiement(rs.getString("STATUS_PAIEMENT"));
                facture. setMode_paiment(rs.getString("MODE_PAIMENT"));
            }
            request.setAttribute("facture", facture);
            request.getRequestDispatcher("ModifierFacture.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ErrorEditFacture.jsp");
        }
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_facture"));
        double montant = Double.parseDouble(request.getParameter("montant_total"));
        String status = request.getParameter("status_paiement");
        String mode = request.getParameter("mode_paiment");

        try {
            Connection conn = BDContext.getConnection();
          
            String sql = "UPDATE FACTURE SET MONTANT_TOTAL = ?, STATUS_PAIEMENT = ?, MODE_PAIMENT = ? WHERE ID_FACTURE = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, montant);
            ps.setString(2, status);
            ps.setString(3, mode);
            ps.setInt(4, id);

            int result = ps.executeUpdate();
            if (result > 0) {
                
                response.sendRedirect("FactureDashboard.jsp");
            } else {
                response.sendRedirect("ErrorEditFacture.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ErrorEditFacture.jsp");
        }
    }
}
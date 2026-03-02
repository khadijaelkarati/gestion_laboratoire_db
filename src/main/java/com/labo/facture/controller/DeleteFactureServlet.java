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

/**
 * Servlet implementation class DeleteFactureServlet
 */
@WebServlet("/DeleteFactureServlet")
public class DeleteFactureServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	        int idFacture = Integer.parseInt(request.getParameter("id"));

	        try {
	            Connection conn = BDContext.getConnection();
	            String sql = "DELETE FROM FACTURE WHERE ID_FACTURE = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, idFacture);

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

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
}
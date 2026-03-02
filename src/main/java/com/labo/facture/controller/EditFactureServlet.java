package com.labo.facture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.facture.dao.FactureDAO;

/**
 * Servlet implementation class EditFactureServlet
 */
@WebServlet("/EditFactureServlet")
public class EditFactureServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            FactureDAO dao = new FactureDAO();
            request.setAttribute("facture", dao.getFactureById(id));
            request.getRequestDispatcher("EditFacture.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
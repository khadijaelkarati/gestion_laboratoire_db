package com.labo.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final Map<String, String> VIEWS = new HashMap<String, String>();
	    static {
	        // Dashboard
	        VIEWS.put("home", "/WEB-INF/views/dashboard/home.jsp");

	        // Patients
	        VIEWS.put("patients_list", "/WEB-INF/views/patients/list.jsp");
	        VIEWS.put("patients_form", "/WEB-INF/views/patients/form.jsp");
	        VIEWS.put("patients_details", "/WEB-INF/views/patients/details.jsp");

	        // Analyses
	        VIEWS.put("analyses_list", "/WEB-INF/views/analyses/list.jsp");
	        VIEWS.put("analyses_form", "/WEB-INF/views/analyses/form.jsp");
	        VIEWS.put("analyses_details", "/WEB-INF/views/analyses/details.jsp");

	        // Résultats
	        VIEWS.put("results_list", "/WEB-INF/views/results/list.jsp");
	        VIEWS.put("results_entry", "/WEB-INF/views/results/entry.jsp");
	        VIEWS.put("results_validate", "/WEB-INF/views/results/validate.jsp");
	        VIEWS.put("results_details", "/WEB-INF/views/results/details.jsp");

	        // Paiement
	        VIEWS.put("payments_receipt", "/WEB-INF/views/payments/receipt.jsp");
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String viewKey = request.getParameter("view");
	        if (viewKey == null || viewKey.trim().isEmpty()) viewKey = "home";

	        String jsp = VIEWS.get(viewKey);
	        if (jsp == null) {
	            // si quelqu’un met un view inconnu, on revient à home
	            viewKey = "home";
	            jsp = VIEWS.get("home");
	        }

	        request.setAttribute("pageTitle", titleFromKey(viewKey));
	        request.setAttribute("contentPage", jsp);

	        request.getRequestDispatcher("/WEB-INF/views/layout.jsp")
	               .forward(request, response);
	    }

	    private String titleFromKey(String key) {
	        if (key.startsWith("patients")) return "Patients";
	        if (key.startsWith("analyses")) return "Analyses";
	        if (key.startsWith("results")) return "Résultats";
	        if (key.startsWith("payments")) return "Paiement";
	        return "Accueil";
	    }}
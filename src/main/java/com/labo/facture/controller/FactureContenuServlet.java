package com.labo.facture.controller;

import java.io.IOException;
import java.util.List; // Zid hadi
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labo.facture.dao.FactureDAO;
import com.labo.facture.beans.FactureBean; // Zid hadi darori

@WebServlet("/FactureContenu")
public class FactureContenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FactureDAO dao = new FactureDAO();
           
            request.setAttribute("listeFactures", dao.getAllFactures());
            
            request.getRequestDispatcher("facture.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
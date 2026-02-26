package java.analyse.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.java.DBContext;

/**
 * Servlet implementation class AddAnalyseServlet
 */
@WebServlet("/AddAnalyseServlet")
public class AddAnalyseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 try {

	            int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
	            int idPatient = Integer.parseInt(request.getParameter("idPatient"));
	            int idCatalogue = Integer.parseInt(request.getParameter("idCatalogue"));
	            String observations = request.getParameter("observations");

	            Connection conn = DBContext.getConnection();

	            String sql = "INSERT INTO analyse_souhaitee "
	                       + "(id_analyse_souhaitee, id_patient, id_catalogue, status, observations , date_demande) "
	                       + "VALUES (?, ?, ?, 'EN_ATTENTE', ? , SYSDATE)";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, idAnalyse);
	            ps.setInt(2, idPatient);
	            ps.setInt(3, idCatalogue);
	            ps.setString(4, observations);;

	            ps.executeUpdate();

	           response.sendRedirect("page fatimaezzahra");

	        } catch (Exception e) {
	            e.printStackTrace();
	           // response.sendRedirect("page fatimaezzahra");
	        }
	    }
}
package java.analyse.controller;

import java.analyse.beans.AnalyseSouhaitee;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.java.DBContext;

/**
 * Servlet implementation class SearchAnalyseServlet
 */
@WebServlet("/SearchAnalyseServlet")
public class SearchAnalyseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id_analyse");
        AnalyseSouhaitee analyse = null;

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                
                try (Connection conn = DBContext.getConnection()) {
                    String sql = "SELECT * FROM AnalyseSouhaitee WHERE id_analyse = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    
                    ResultSet rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        analyse = new AnalyseSouhaitee();
                        analyse.setId_analyse(rs.getInt("id_analyse"));
                        analyse.setId_patient(rs.getInt("id_patient"));
                        analyse.setId_catalogue(rs.getInt("id_catalogue"));
                        analyse.setDate_demande(rs.getDate("date_demande"));
                        analyse.setStatus(rs.getString("status"));
                        analyse.setResultat(rs.getString("resultat"));
                        analyse.setObservations(rs.getString("observations"));
                        analyse.setValidation(rs.getString("validation"));
                        analyse.setValidee_par(rs.getInt("validee_par"));
                        analyse.setDate_validation(rs.getDate("date_validation"));
                        analyse.setAvis_biologiste(rs.getString("avis_biologiste"));
                        
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        
        request.setAttribute("analyse", analyse);
        // Redirection vers la page d'affichage
        request.getRequestDispatcher("page fatimaezzahra ").forward(request, response);
    }

}

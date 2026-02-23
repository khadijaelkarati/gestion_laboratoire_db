package java.patient.controller;

import java.io.IOException;
import java.patient.beans.Patient;
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
 * Servlet implementation class SearchPatientServlet
 */
@WebServlet("/SearchPatientServlet")
public class SearchPatientServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cin = request.getParameter("cin");
        Patient patient = null;

        try (Connection conn = DBContext.getConnection()) {

            String sql = "SELECT id_patient, nom, prenom, phone, email, adress, medecin_traitant FROM patient WHERE cin = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cin);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                patient = new Patient();

                patient.setId(rs.getInt("id_patient"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setPhone(rs.getString("phone"));
                patient.setEmail(rs.getString("email"));
                patient.setAdress(rs.getString("adress"));
                patient.setMedecin(rs.getString("medecin_traitant"));
            }

            request.setAttribute("patient", patient);
            request.getRequestDispatcher("page fatimaezzahra")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
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

@WebServlet("/SearchPatientServlet")
public class SearchPatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cin = request.getParameter("cin");
        Patient patient = null;

        try (Connection conn = DBContext.getConnection()) {

            String sql = "SELECT id_patient, nom, prenom, date_nais, genre, "
                       + "phone, email, adress, medecin_traitant, "
                       + "date_creation, date_modification, cree_par, modifie_par "
                       + "FROM patient WHERE cin = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cin);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                patient = new Patient();

                patient.setId(rs.getInt("id_patient"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));

                patient.setDate_nais (rs.getDate("date_nais"));
                patient.setGenre(rs.getString("genre"));

                patient.setPhone(rs.getString("phone"));
                patient.setEmail(rs.getString("email"));
                patient.setAdress(rs.getString("adress"));
                patient.setMedecin(rs.getString("medecin_traitant"));

                patient.setDate_creation(rs.getDate("date_creation"));
                patient.setDate_modification(rs.getDate("date_modification"));

                patient.setCree_par(rs.getString("cree_par"));
                patient.setModifie_par(rs.getString("modifie_par"));
            }

            request.setAttribute("patient", patient);
            request.getRequestDispatcher("page fatimaezzahra")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
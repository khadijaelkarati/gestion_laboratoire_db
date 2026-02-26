package java.patient.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.java.DBContext;

@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection con = DBContext.getConnection()) {

            String sql = "INSERT INTO patient "
                    + "(id_patient, cin, nom, prenom, date_nais, genre, phone, email, adress, "
                    + "medecin_traitant, date_creation, date_modification, cree_par, modifie_par) "
                    + "VALUES (seq_patient.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, request.getParameter("cin"));
            ps.setString(2, request.getParameter("nom"));
            ps.setString(3, request.getParameter("prenom"));

           
            ps.setDate(4, Date.valueOf(request.getParameter("date_nais")));

            ps.setString(5, request.getParameter("genre"));
            ps.setString(6, request.getParameter("phone"));
            ps.setString(7, request.getParameter("email"));
            ps.setString(8, request.getParameter("adress"));
            ps.setString(9, request.getParameter("medecin"));

            ps.setString(10, request.getParameter("cree_par"));
            ps.setString(11, request.getParameter("modifie_par"));

            ps.executeUpdate();

            response.sendRedirect("page fatimaezzahra");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("page fatimaezzahra");
        }
    }
}
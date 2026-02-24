package java.facture.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.facture.beans.Facture;
import patient.java.DBContext;

@WebServlet("/SearchFactureServlet")
public class SearchFactureServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int idFacture = Integer.parseInt(request.getParameter("id_facture"));

            Connection con = DBContext.getConnection();

            String sql = "SELECT * FROM FACTURE WHERE ID_FACTURE = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idFacture);

            ResultSet rs = ps.executeQuery();

            Facture facture = null;

            if (rs.next()) {
                facture = new Facture();

                facture.setId_facture(rs.getInt("ID_FACTURE"));
                facture.setNumero_facture(rs.getString("NUMERO_FACTURE"));
                facture.setId_patient(rs.getInt("ID_PATIENT"));
                facture.setDate_emission(rs.getDate("DATE_EMISSION"));
                facture.setMontant_total(rs.getDouble("MONTANT_TOTAL"));
                facture.setStatus_paiement(rs.getString("STATUS_PAIEMENT"));
                facture.setDate_paiement(rs.getDate("DATE_PAIEMENT"));
                facture.setMode_paiment(rs.getString("MODE_PAIEMENT"));
                facture.setObservation(rs.getString("OBSERVATION"));
            }

            request.setAttribute("facture", facture);
            request.getRequestDispatcher("page fatimaezzahra").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
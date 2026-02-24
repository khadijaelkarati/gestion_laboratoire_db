package java.facture.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import patient.java.DBContext;

@WebServlet("/AddFactureServlet")
public class AddFactureServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = null;
        PreparedStatement psTotal = null;
        PreparedStatement psInsert = null;
        ResultSet rs = null;

        try {

            int idPatient = Integer.parseInt(request.getParameter("id_patient"));
            String numeroFacture = request.getParameter("numero_facture");
            String statusPaiement = request.getParameter("status_paiement");
            String modePaiement = request.getParameter("mode_paiement");
            String observation = request.getParameter("observation");

            con = DBContext.getConnection();

            //   montant_total
            String sqlTotal = "SELECT SUM(c.PRIX) AS total " +
                    "FROM ANALYSE_SOUHAITEE a " +
                    "JOIN CATALOGUE_ANALYSE c ON a.ID_CATALOGUE = c.ID_CATALOGUE " +
                    "WHERE a.ID_PATIENT = ?";

            psTotal = con.prepareStatement(sqlTotal);
            psTotal.setInt(1, idPatient);
            rs = psTotal.executeQuery();

            double montantTotal = 0;

            if (rs.next()) {
                montantTotal = rs.getDouble("total");
            }

            
            String sqlInsert = "INSERT INTO FACTURE " +
                    "(ID_FACTURE, NUMERO_FACTURE, ID_PATIENT, DATE_EMISSION, " +
                    "MONTANT_TOTAL, STATUS_PAIEMENT, DATE_PAIEMENT, MODE_PAIEMENT, OBSERVATION) " +
                    "VALUES (SEQ_FACTURE.NEXTVAL, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?)";

            psInsert = con.prepareStatement(sqlInsert);

            psInsert.setString(1, numeroFacture);
            psInsert.setInt(2, idPatient);
            psInsert.setDouble(3, montantTotal);
            psInsert.setString(4, statusPaiement);
            psInsert.setString(5, modePaiement);
            psInsert.setString(6, observation);

            psInsert.executeUpdate();

            response.sendRedirect("page fatimaezzahra");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
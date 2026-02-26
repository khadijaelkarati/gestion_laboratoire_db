package java.facture.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import patient.java.DBContext;

@WebServlet("/AddFactureServlet")
public class AddFactureServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int idPatient = Integer.parseInt(request.getParameter("id_patient"));
            String numeroFacture = request.getParameter("numero_facture");
            String statusPaiement = request.getParameter("status_paiement");
            String modePaiement = request.getParameter("mode_paiement");
            String observation = request.getParameter("observation");

            Connection con = DBContext.getConnection();

            //  Calcul montant_total
            String sqlTotal = "SELECT NVL(SUM(c.PRIX),0) AS total " +
                    "FROM ANALYSE_SOUHAITEE a " +
                    "JOIN CATALOGUE_ANALYSE c ON a.ID_CATALOGUE = c.ID_CATALOGUE " +
                    "WHERE a.ID_PATIENT = ?";

            PreparedStatement psTotal = con.prepareStatement(sqlTotal);
            psTotal.setInt(1, idPatient);
            ResultSet rs = psTotal.executeQuery();

            double montantTotal = 0;
            if (rs.next()) {
                montantTotal = rs.getDouble("total");
            }

            //  Insert facture
            String sqlInsert = "INSERT INTO FACTURE " +
                    "(ID_FACTURE, NUMERO_FACTURE, ID_PATIENT, DATE_EMISSION, " +
                    "MONTANT_TOTAL, STATUS_PAIEMENT, DATE_PAIEMENT, MODE_PAIEMENT, OBSERVATION) " +
                    "VALUES (SEQ_FACTURE.NEXTVAL, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?)";

            PreparedStatement psInsert = con.prepareStatement(sqlInsert, new String[] { "ID_FACTURE" });

            psInsert.setString(1, numeroFacture);
            psInsert.setInt(2, idPatient);
            psInsert.setDouble(3, montantTotal);
            psInsert.setString(4, statusPaiement);
            psInsert.setString(5, modePaiement);
            psInsert.setString(6, observation);

            psInsert.executeUpdate();

            //  Get generated ID_FACTURE
            ResultSet generatedKeys = psInsert.getGeneratedKeys();
            int idFacture = 0;

            if (generatedKeys.next()) {
                idFacture = generatedKeys.getInt(1);
            }

            // Get analyses
            String sqlAnalyse = "SELECT ID_ANALYSE_SOUHAITEE FROM ANALYSE_SOUHAITEE WHERE ID_PATIENT = ?";
            PreparedStatement psAnalyse = con.prepareStatement(sqlAnalyse);
            psAnalyse.setInt(1, idPatient);
            ResultSet rsAnalyse = psAnalyse.executeQuery();

            //  Insert into facture_analyse
            String sqlLink = "INSERT INTO FACTURE_ANALYSE (ID_FACTURE, ID_ANALYSE_SOUHAITEE) VALUES (?, ?)";
            PreparedStatement psLink = con.prepareStatement(sqlLink);

            while (rsAnalyse.next()) {
                int idAnalyse = rsAnalyse.getInt("ID_ANALYSE_SOUHAITEE");
                psLink.setInt(1, idFacture);
                psLink.setInt(2, idAnalyse);
                psLink.executeUpdate();
            }

            response.sendRedirect("factureSuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package java.facture.servlet;
import java.facture.dao.FactureDAO;
import java.facture.bean.Facture;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateFactureServlet
 */
@WebServlet("/UpdateFactureServlet")
public class UpdateFactureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FactureDAO factureDAO = new FactureDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFactureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

 

            try {

                int id = Integer.parseInt(request.getParameter("id"));

                Facture facture = factureDAO.getFactureById(id);

                request.setAttribute("facture", facture);

                RequestDispatcher dispatcher =
                        request.getRequestDispatcher("editFacture.jsp");

                dispatcher.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
            }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  

        try {

            int id = Integer.parseInt(request.getParameter("id_facture"));
            String numero = request.getParameter("numero_facture");
            int idPatient = Integer.parseInt(request.getParameter("id_patient"));


            double montant = Double.parseDouble(request.getParameter("montant_total"));
            String status = request.getParameter("status_paiement");
            String mode = request.getParameter("mode_paiement");
            String observation = request.getParameter("observation");

            Facture facture = new Facture();
            facture.setId_facture(id);
            facture.setNumero_facture(numero);
            facture.setId_patient(idPatient);
            facture.setMontant_total(montant);
            facture.setStatus_paiement(status);
            facture.setMode_paiement(mode);
            facture.setObservation(observation);

            factureDAO.updateFacture(facture);

            response.sendRedirect("listFacture");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}}

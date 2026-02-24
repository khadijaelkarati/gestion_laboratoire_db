package java.facture.servlet;
import java.facture.dao.FactureDAO;
import java.facture.bean.Facture;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            Facture facture = factureDAO.getFactureById(id);//recherche
            
            if (facture != null) {
                request.setAttribute("facture", facture);
                request.getRequestDispatcher("/updateFacture.jsp").forward(request, response);
            } else {
                response.sendRedirect("listeFactures.jsp?error=notfound");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("listeFactures.jsp?error=sql");
        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
        try {
            int idFacture = Integer.parseInt(request.getParameter("id"));
            String numero = request.getParameter("numero");
            int idPatient = Integer.parseInt(request.getParameter("idPatient"));
            double montant = Double.parseDouble(request.getParameter("montant"));
            String status = request.getParameter("status");
            String mode = request.getParameter("mode");
            String observation = request.getParameter("observation");
            String datePaiementStr = request.getParameter("datePaiement");
            
            Facture facture = factureDAO.getFactureById(idFacture);//recherche
            
            if (facture != null) {
                facture.setNumero_facture(numero);
                facture.setId_patient(idPatient);
                facture.setMontant_total(montant);
                facture.setStatus_paiement(status);
                facture.setMode_paiement(mode);
                facture.setObservation(observation);
                
                if (datePaiementStr != null && !datePaiementStr.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date datePaiement = sdf.parse(datePaiementStr);
                    facture.setDate_paiement(datePaiement);
                }
                
                factureDAO.updateFacture(facture);
                response.sendRedirect("listeFactures.jsp?success=update");
            } else {
                response.sendRedirect("listeFactures.jsp?error=notfound");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listeFactures.jsp?error=sql");
        }
    }	}


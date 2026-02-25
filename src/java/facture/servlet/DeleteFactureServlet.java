package java.facture.servlet;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.facture.dao.FactureDAO;
/**
 * Servlet implementation class DeleteFactureServlet
 */
@WebServlet("/DeleteFactureServlet")
public class DeleteFactureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private FactureDAO factureDAO = new FactureDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFactureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String action = request.getParameter("action");
	        
	        try {
	            if ("deleteANNULEE".equals(action)) {
	                factureDAO.deleteFacturesAnnulees();
	                response.sendRedirect("listeFactures.jsp?success=deleteannulees");
	                
	            } else if ("deleteByPatient".equals(action)) {
	                int CIN = Integer.parseInt(request.getParameter("patientId"));
	                factureDAO.deleteFacturesByPatient(CIN);
	                response.sendRedirect("listeFactures.jsp?success=deletepatient");
	                
	            } else if ("deleteFacture".equals(action)) {
	                
	                int numero_facture = Integer.parseInt(request.getParameter("numero_facture"));
                    factureDAO.deleteFacture(numero_facture);
	                response.sendRedirect("listeFactures.jsp?success=deleteFacture");
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
            int numero_facture= Integer.parseInt(request.getParameter("numero_facture"));
            String confirm = request.getParameter("confirm");
            
            if ("yes".equals(confirm)) {
                factureDAO.deleteFacture(numero_facture);
                response.sendRedirect("listeFactures.jsp?success=delete");
            } else {
                response.sendRedirect("listeFactures.jsp");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("listeFactures.jsp?error=sql");
        }
    	}

}

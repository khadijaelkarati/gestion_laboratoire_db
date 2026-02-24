package java.factureanalyse.servlet;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.factureanalyse.dao.FactureAnalyseDAO;
import java.factureanalyse.bean.FactureAnalyse;
/**
 * Servlet implementation class Deletefactureanalyse
 */
@WebServlet("/Deletefactureanalyse")
public class Deletefactureanalyse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private FactureAnalyseDAO faDAO = new FactureAnalyseDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletefactureanalyse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
		 try {
	            // Supprimer une relation spécifique
	            if ("deleteOne".equals(action)) {
	                int idFacture = Integer.parseInt(request.getParameter("idFacture"));
	                int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
	                
	                faDAO.delete(idFacture, idAnalyse);
	                response.sendRedirect("factureAnalyseListe.jsp?success=delete");
	            }
	            
	            // Supprimer toutes les relations d'une facture
	            else if ("deleteByFacture".equals(action)) {
	                int idFacture = Integer.parseInt(request.getParameter("idFacture"));
	                
	                faDAO.deleteByFacture(idFacture);
	                response.sendRedirect("factureAnalyseListe.jsp?success=deletefacture");
	            }
	            
	            // Supprimer toutes les relations d'une analyse
	            else if ("deleteByAnalyse".equals(action)) {
	                int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
	                
	                faDAO.deleteByAnalyse(idAnalyse);
	                response.sendRedirect("factureAnalyseListe.jsp?success=deleteanalyse");
	            }
	            
	            // Afficher la page de confirmation
	            else if ("confirm".equals(action)) {
	                int idFacture = Integer.parseInt(request.getParameter("idFacture"));
	                int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
	                
	                request.setAttribute("idFacture", idFacture);
	                request.setAttribute("idAnalyse", idAnalyse);
	                request.getRequestDispatcher("/confirmDeleteFactureAnalyse.jsp").forward(request, response);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("factureAnalyseListe.jsp?error=sql");
	        } catch (NumberFormatException e) {
	            response.sendRedirect("factureAnalyseListe.jsp?error=format");
	        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");
	        
	        try {
	            if ("deleteConfirmed".equals(action)) {
	                int idFacture = Integer.parseInt(request.getParameter("idFacture"));
	                int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
	                String confirm = request.getParameter("confirm");
	                
	                if ("yes".equals(confirm)) {
	                    faDAO.delete(idFacture, idAnalyse);
	                    response.sendRedirect("factureAnalyseListe.jsp?success=delete");
	                } else {
	                    response.sendRedirect("factureAnalyseListe.jsp");
	                }
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("factureAnalyseListe.jsp?error=sql");
	        }
	    	}

}

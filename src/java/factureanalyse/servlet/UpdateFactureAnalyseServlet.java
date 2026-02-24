package java.factureanalyse.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.factureanalyse.dao.FactureAnalyseDAO;
import java.sql.SQLException;
/**
 * Servlet implementation class UpdateFactureAnalyseServlet
 */
@WebServlet("/UpdateFactureAnalyseServlet")
public class UpdateFactureAnalyseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private FactureAnalyseDAO faDAO = new FactureAnalyseDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFactureAnalyseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
        try {
            int idFacture = Integer.parseInt(request.getParameter("idFacture"));
            int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
            
            // Stocker les anciennes valeurs dans la session ou request
            request.setAttribute("ancienneFacture", idFacture);
            request.setAttribute("ancienneAnalyse", idAnalyse);
            
            // Rediriger vers le formulaire de modification
            request.getRequestDispatcher("/updateFactureAnalyse.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            response.sendRedirect("factureAnalyseListe.jsp?error=format");
        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   try {
	            // Récupérer les anciennes valeurs
	            int ancienneFacture = Integer.parseInt(request.getParameter("ancienneFacture"));
	            int ancienneAnalyse = Integer.parseInt(request.getParameter("ancienneAnalyse"));
	            
	            // Récupérer les nouvelles valeurs
	            int nouvelleFacture = Integer.parseInt(request.getParameter("nouvelleFacture"));
	            int nouvelleAnalyse = Integer.parseInt(request.getParameter("nouvelleAnalyse"));
	            
	            // Vérifier si les nouvelles valeurs existent déjà
	            if (faDAO.existe(nouvelleFacture, nouvelleAnalyse)) {
	                response.sendRedirect("updateFactureAnalyse.jsp?error=exists&ancienneFacture=" + 
	                                    ancienneFacture + "&ancienneAnalyse=" + ancienneAnalyse);
	                return;
	            }
	            
	            // Exécuter la modification (supprimer ancienne + insérer nouvelle)
	            faDAO.update(ancienneFacture, ancienneAnalyse, nouvelleFacture, nouvelleAnalyse);
	            
	            response.sendRedirect("factureAnalyseListe.jsp?success=update");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("factureAnalyseListe.jsp?error=sql");
	        } catch (NumberFormatException e) {
	            response.sendRedirect("factureAnalyseListe.jsp?error=format");
	        }	}

}

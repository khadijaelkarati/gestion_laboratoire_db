package java.analyse.servlet;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.analyse.dao.AnalyseSouhaiteeDAO;
/**
 * Servlet implementation class UpdateAnalyseServlet
 */
@WebServlet("/UpdateAnalyseServlet")
public class UpdateAnalyseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private AnalyseSouhaiteeDAO analyseDAO = new AnalyseSouhaiteeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnalyseServlet() {
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
            if ("deleteOne".equals(action)) {
                // Supprimer une seule analyse
                int idAnalyse = Integer.parseInt(request.getParameter("id"));
                analyseDAO.deleteAnalyse(idAnalyse);
                response.sendRedirect("listeAnalyses.jsp?success=delete");
                
            } else if ("deleteByPatient".equals(action)) {
                // Supprimer par patient
                int idPatient = Integer.parseInt(request.getParameter("patientId"));
                analyseDAO.deleteAnalysesByPatient(idPatient);
                response.sendRedirect("listeAnalyses.jsp?success=deletepatient");
                
            } else if ("deleteTerminees".equals(action)) {
                // Supprimer toutes les analyses terminées
                analyseDAO.deleteAnalysesTerminees();
                response.sendRedirect("listeAnalyses.jsp?success=deleteterminees");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("listeAnalyses.jsp?error=sql");
        } catch (NumberFormatException e) {
            response.sendRedirect("listeAnalyses.jsp?error=format");
        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
        try {
            int idAnalyse = Integer.parseInt(request.getParameter("id"));
            String confirm = request.getParameter("confirm");
            
            if ("yes".equals(confirm)) {
                analyseDAO.deleteAnalyse(idAnalyse);
                response.sendRedirect("listeAnalyses.jsp?success=delete");
            } else {
                response.sendRedirect("listeAnalyses.jsp");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("listeAnalyses.jsp?error=sql");
        } catch (NumberFormatException e) {
            response.sendRedirect("listeAnalyses.jsp?error=format");
        }
    }
}

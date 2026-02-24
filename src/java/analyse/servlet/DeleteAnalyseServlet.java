package java.analyse.servlet;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.analyse.dao.AnalyseSouhaiteeDAO;
import java.analyse.bean.AnalyseSouhaitee;
/**
 * Servlet implementation class DeleteAnalyseServlet
 */
@WebServlet("/DeleteAnalyseServlet")
public class DeleteAnalyseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnalyseSouhaiteeDAO analyseDAO = new AnalyseSouhaiteeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAnalyseServlet() {
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
            AnalyseSouhaitee analyse = analyseDAO.getAnalyseById(id);//recherche
            
            if (analyse != null) {
                request.setAttribute("analyse", analyse);
                request.getRequestDispatcher("/updateAnalyse.jsp").forward(request, response);
            } else {
                response.sendRedirect("listeAnalyses.jsp?error=notfound");
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
        try {
            // Récupérer les paramètres du formulaire
            int idAnalyse = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status");
            String resultat = request.getParameter("resultat");
            String observations = request.getParameter("observations");
            
            // Récupérer l'analyse existante
            AnalyseSouhaitee analyse = analyseDAO.getAnalyseById(idAnalyse);//recherche
            
            if (analyse != null) {
                // Mettre à jour les champs
                analyse.setStatus(status);
                analyse.setResultat(resultat);
                analyse.setObservations(observations);
                
                // Exécuter la mise à jour
                analyseDAO.updateAnalyse(analyse);
                
                // Rediriger avec message de succès
                response.sendRedirect("listeAnalyses.jsp?success=update");//.jsp
            } else {
                response.sendRedirect("listeAnalyses.jsp?error=notfound");//.jsp
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("listeAnalyses.jsp?error=sql");//.jsp
        } catch (NumberFormatException e) {
            response.sendRedirect("listeAnalyses.jsp?error=format");//.jsp
        }
    }
	}

}

package java.patient.servlet;
import java.patien.dao.PatientDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeletePatientServlet")
public class DeletePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeletePatientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String cin = request.getParameter("cin");
	        
	        try {
	            // Appeler la méthode DAO pour supprimer
	            PatientDAO.deletePatient(cin);
	            
	            // Rediriger vers la liste des patients avec message de succès
	            response.sendRedirect("lien de servlet liste=deleted");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("lien de servlet liste=delete_failed");
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

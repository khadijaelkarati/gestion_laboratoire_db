package java.patient.servlet;
import java.io.IOException;
import java.patient.bean.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.patien.dao.PatientDAO;
@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdatePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      String cin = request.getParameter("cin");
    try {
        // Récupérer le patient à modifier
        Patient patient = PatientDAO.getPatientByCIN(cin);// getpatientbycin c'la recherche
        if (patient != null) {
            // Envoyer le patient à la JSP
            request.setAttribute("patient", patient);
            request.getRequestDispatcher("modifierPatient.jsp").forward(request, response);
        } else {
            response.sendRedirect("ListPatientsServlet?error=not_found");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("ListPatientsServlet?error=not_found");
    }
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            // Récupérer les données du formulaire
	            String cin = request.getParameter("cin");
	            String nom = request.getParameter("nom");
	            String prenom = request.getParameter("prenom");
	            String dateNais = request.getParameter("date_nais");
	            String genre = request.getParameter("genre");
	            String phone = request.getParameter("phone");
	            String email = request.getParameter("email");
	            String adress = request.getParameter("adress");
	            String medecin = request.getParameter("medecin_traitant");
	            String dateCreation = request.getParameter("date_creation");
	            String dateModification = request.getParameter("date_modification");
	            String creePar = request.getParameter("cree_par");
	            String modifiePar = request.getParameter("modifie_par");
	            //  Vérifier que les champs obligatoires sont présents
	            if (cin == null || cin.isEmpty() || nom == null || nom.isEmpty()) {
	                response.sendRedirect("ListPatientsServlet?error=missing_fields");
	                return;
	            }
	            // Créer l'objet Patient
	            Patient patient = new Patient();
	            patient.setCIN(cin);
	            patient.setNOM(nom);
	            patient.setPRENOM(prenom);
	            patient.setDATE_NAIS(dateNais);
	            patient.setGENRE(genre);
	            patient.setPHONE(phone);
	            patient.setEMAIL(email);
	            patient.setADRESS(adress);
	            patient.setMEDECIN_TRAITANT(medecin);
	            patient.setDATE_CREATION(dateCreation);
	            patient.setDATE_MODIFICATION(dateModification);
	            patient.setCREE_PAR(creePar);
	            patient.setMODIFIE_PAR(modifiePar);
	            
	            // Appeler la méthode DAO pour modifier
	            PatientDAO.updatePatient(patient);
	            
	            // Rediriger vers la liste avec message de succès
	            response.sendRedirect("ListPatientsServlet?success=updated");// liste
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("ListPatientsServlet?error=update_failed&cin=" + 
	                                 request.getParameter("cin"));
	        }
	    }
	}



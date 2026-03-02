<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.labo.patient.beans.PatientBean" %>
<%@ page import="com.labo.patient.doa.PatientDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation de suppression</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="StyleConfirmDeletePatient.css?v=1.0">
</head>
<body>
<%
    String cin = request.getParameter("cin");
    
    if(cin == null || cin.isEmpty()) {
        response.sendRedirect("Accuiel.jsp?error=missing_cin");
        return;
    }
    
    PatientDAO dao = new PatientDAO();
    PatientBean patient = dao.getPatientByCin(cin);
    
    if(patient == null) {
        response.sendRedirect("Accuiel.jsp?error=patient_not_found");
        return;
    }
%>

<div class="confirm-modal">
    <div class="confirm-header">
        <h2>
            <i class="fas fa-trash-alt"></i>
            Confirmation de suppression
        </h2>
    </div>
    
    <div class="confirm-body">
        <div class="confirm-icon">
            <i class="fas fa-exclamation-triangle"></i>
        </div>
        
        <h3>Êtes-vous sûr de vouloir supprimer ce patient ?</h3>
        
        <div class="confirm-patient-info">
            <div class="confirm-patient-item">
                <i class="fas fa-id-card"></i>
                <strong>CIN :</strong>
                <span><%= patient.GetCin() %></span>
            </div>
            <div class="confirm-patient-item">
                <i class="fas fa-user"></i>
                <strong>Nom complet :</strong>
                <span><%= patient.getNom() %> <%= patient.getPrenom() %></span>
            </div>
        </div>
    </div>
    <div class="confirm-footer">
        <a href="PatientDetail.jsp?cin=<%= cin %>" class="btn-cancel">
            <i class="fas fa-times"></i>
            Annuler
        </a>
        <form action="<%= request.getContextPath()%>/DeletePatientServlet" method="post">
         <input type="hidden" name="cin" value="<%= cin %>">
        <button type="submit" class="btn-delete">
            <i class="fas fa-trash-alt"></i>
            Oui, supprimer
        </button>
        </form>
    </div>
</div>

</body>
</html>
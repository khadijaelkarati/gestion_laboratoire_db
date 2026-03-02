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
    String success = request.getParameter("success");
    
    // Récupérer les infos du patient pour les afficher (optionnel)
    PatientDAO dao = new PatientDAO();
    PatientBean patient = dao.getPatientByCin(cin);
%>

<div class="confirm-modal">
    
    <!-- En-tête -->
    <div class="confirm-header">
        <h2>
            <i class="fas fa-trash-alt"></i>
            Suppression réussie
        </h2>
    </div>
    
    <!-- Corps -->
    <div class="confirm-body">
        
        <!-- Icône de succès -->
        <div class="confirm-icon">
            <i class="fas fa-check-circle"></i>
        </div>
        
        <!-- Titre -->
        <h3>Patient supprimé avec succès !</h3>
        
        <!-- Informations patient -->
        <% if (patient != null) { %>
        <div class="confirm-patient-info">
            <div class="confirm-patient-name">
                <%= patient.getNom() %> <%= patient.getPrenom() %>
            </div>
            <div class="confirm-patient-cin">
                <i class="fas fa-id-card"></i>
                CIN: <%= patient.GetCin() %>
            </div>
        </div>
        <% } %>
        
    </div>
    
    <!-- Pied -->
    <div class="confirm-footer">
        <a href="Accuiel.jsp?page=patient&t=<%= System.currentTimeMillis() %>" class="btn-confirm">
            <i class="fas fa-check"></i> OK
        </a>
    </div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.labo.patient.beans.PatientBean" %>
<%@ page import="com.labo.patient.doa.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails du patient</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="StylePatientDetail.css?v=1.0">
</head>
<body>
<%
    // 1. Récupérer le CIN depuis l'URL (pas de servlet !)
    String cin = request.getParameter("cin");
    
    if(cin == null || cin.isEmpty()) {
        response.sendRedirect("Accuiel.jsp?error=missing_cin");
        return;
    }
    
    // 2. Appeler directement le DAO depuis la JSP
    PatientDAO dao = new PatientDAO();
    PatientBean patient = dao.getPatientByCin(cin);
    
    // 3. Vérifier si le patient existe
    if(patient == null) {
        response.sendRedirect("Accuiel.jsp?error=patient_not_found");
        return;
    }
%>

<div class="modal">
    <!-- En-tête -->
    <div class="modal-header">
        <h2>
            <i class="fas fa-user-circle"></i>
            Détails du patient
        </h2>
    </div>
    
    <div class="modal-body">
 <form id="patientForm" class="patient-form" action="UpdatePatientServlet" method="post">
    
    <!-- Ligne 1: CIN et Date de naissance -->
    <div class="form-row">
        <div class="form-group">
            <label>CIN *</label>
            <input type="text" name="cin" class="form-control" value="<%= patient.GetCin() %>" readonly>
        </div>
        <div class="form-group">
    <label>Date de naissance</label>
    <input type="date" name="dateNaissance" class="form-control" 
           value="<%= patient.getDateNaissance() != null ? patient.getDateNaissance().replace(' ', 'T').substring(0,10) : "" %>">
</div>
    </div>
    
    <!-- Ligne 2: Nom et Prénom -->
    <div class="form-row">
        <div class="form-group">
            <label>Nom *</label>
            <input type="text" name="nom" class="form-control" value="<%= patient.getNom() != null ? patient.getNom() : "" %>" required>
        </div>
        <div class="form-group">
            <label>Prénom *</label>
            <input type="text" name="prenom" class="form-control" value="<%= patient.getPrenom() != null ? patient.getPrenom() : "" %>" required>
        </div>
    </div>
    
    <!-- Ligne 3: Genre et Téléphone -->
    <div class="form-row">
        <div class="form-group">
            <label>Genre</label>
            <select name="genre" class="form-control">
                <option value="">Sélectionner</option>
                <option value="M" <%= "M".equals(patient.getGenre()) ? "selected" : "" %>>Masculin</option>
                <option value="F" <%= "F".equals(patient.getGenre()) ? "selected" : "" %>>Féminin</option>
            </select>
        </div>
        <div class="form-group">
            <label>Téléphone *</label>
            <input type="tel" name="phone" class="form-control" value="<%= patient.getPhone() != null ? patient.getPhone() : "" %>" required>
        </div>
    </div>
    
    <!-- Ligne 4: Email et Médecin traitant -->
    <div class="form-row">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control" value="<%= patient.getEmail() != null ? patient.getEmail() : "" %>">
        </div>
        <div class="form-group">
            <label>Médecin traitant</label>
            <input type="text" name="medecinTraitant" class="form-control" value="<%= patient.getMedecinTraitant() != null ? patient.getMedecinTraitant() : "" %>">
        </div>
    </div>
    
    <!-- Ligne 5: Adresse -->
    <div class="form-row">
        <div class="form-group full-width">
            <label>Adresse</label>
            <textarea name="adresse" class="form-control" rows="3"><%= patient.getAddress() != null ? patient.getAddress() : "" %></textarea>
        </div>
    </div>
    
    <!-- Ligne 6: Dates de création/modification (lecture seule) -->
    <div class="form-row">
        <div class="form-group">
            <label>Date de création</label>
            <input type="text" class="form-control" readonly
               value="<%= patient.getDateCreation() != null ? patient.getDateCreation() : "" %>">
        </div>
        <div class="form-group">
            <label>Date de modification</label>
           <input type="text" class="form-control" readonly
               value="<%= patient.getDateModification() != null ? patient.getDateModification() : "" %>">
        </div>
    </div>
    
    <!-- Ligne 7: Créé par et Modifié -->
    <div class="form-row">
        <div class="form-group">
            <label>Créé par</label>
            <input type="text" name="creepar" class="form-control" value="<%= patient.getCreePar() != null ? patient.getCreePar() : "_" %>" >
        </div>
        <div class="form-group">
            <label>Modifié par</label>
            <input type="text" name="modifierpar" class="form-control" value="<%= patient.getModifiePar() != null ? patient.getModifiePar() : "_" %>">
        </div>
    </div>
    
</form>
    </div>
    
    <!-- Pied avec boutons -->
    <div class="modal-footer">
        <!-- Boutons... -->
    </div>
     <!-- Pied avec 3 boutons -->
    <div class="modal-footer">
        <!-- Bouton OK : retour au tableau -->
        <button type="submit" form="patientForm" formaction="Accuiel.jsp" class="btn btn-success" >
            <i class="fas fa-backward"></i> retour
		</button>      
        <!-- Bouton Modifier : va vers une page de confirmation d'edition -->
        <button type="submit" form="patientForm" class="btn btn-primary">
            <i class="fas fa-edit"></i> enregistrer
        </button>
        
        <!-- Bouton Supprimer : va vers une page de confirmation -->
        <button type="submit" form="patientForm"  formaction="ConfirmDeletePatient.jsp" class="btn btn-danger">
            <i class="fas fa-trash"></i> Supprimer
        </button>
    </div>
</div>
</body>
</html>
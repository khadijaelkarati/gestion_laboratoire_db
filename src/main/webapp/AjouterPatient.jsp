<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un patient - Laboratoire IBNO ROCHD</title>
    <link rel="stylesheet" href="StyleDashboard.css?v=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
	<link rel="stylesheet" href="StyleAjouterPatient.css?v=1.0">
</head>
<body>
    <div class="modal-overlay">
        <div class="modal-container">
            
            <!-- En-tête du modal -->
            <div class="modal-header">
                <h2>
                    <i class="fa-solid fa-user-plus"></i>
                    Ajouter un nouveau patient
                </h2>
                <a href="Accuiel.jsp" class="close-btn">
                    <i class="fa-solid fa-times"></i>
                </a>
            </div>
            
            <!-- Corps du formulaire -->
            <div class="modal-body">
                
                <%-- Affichage des messages d'erreur --%>
                <% if(request.getAttribute("erreur") != null) { %>
                    <div class="error-message">
                        <i class="fa-solid fa-circle-exclamation"></i>
                        <%= request.getAttribute("erreur") %>
                    </div>
                <% } %>
                
                <form action="<%= request.getContextPath()%>/AjouterPatientServlet" method="post" id="patientForm">
                    <div class="form-grid">
                        
                        <!-- CIN -->
                        <div class="form-group required-field">
                            <label><i class="fa-solid fa-id-card"></i> CIN</label>
                            <input type="text" name="cin" class="form-control" 
                                   placeholder="Ex: BK125548" required maxlength="20"
                                   value="<%= request.getParameter("cin") != null ? request.getParameter("cin") : "" %>">
                        </div>
                        
                        <!-- Nom  -->
                        <div class="form-group required-field">
                            <label><i class="fa-solid fa-user"></i> Nom</label>
                            <input type="text" name="nom" class="form-control" 
                                   placeholder="Ex: ELKARATI" required 
                                   value="<%= request.getParameter("nom") != null ? request.getParameter("nom") : "" %>">
                        </div>
                        
                        <!-- Prénom -->
                        <div class="form-group">
                            <label><i class="fa-solid fa-user"></i> Prénom</label>
                            <input type="text" name="prenom" class="form-control" 
                                   placeholder="Ex: KHADIJA" required
                                   value="<%= request.getParameter("prenom") != null ? request.getParameter("prenom") : "" %>">
                        </div>
                        
                        <!-- Date de naissance -->
                        <div class="form-group">
                            <label><i class="fa-solid fa-calendar"></i> Date de naissance</label>
                            <input type="date" name="dateNaissance" class="form-control" required
                                   value="<%= request.getParameter("dateNaissance") != null ? request.getParameter("dateNaissance") : "" %>">
                        </div>
                        
                        <!-- Genre -->
                        <div class="form-group">
                            <label><i class="fa-solid fa-venus-mars"></i> Genre</label>
                            <div class="radio-group">
                                <label class="radio-option">
                                    <input type="radio" name="genre" value="M" 
                                        <%= "Homme".equals(request.getParameter("genre")) ? "checked" : "" %>>
                                    <span>Homme</span>
                                </label>
                                <label class="radio-option">
                                    <input type="radio" name="genre" value="F"
                                        <%= "Femme".equals(request.getParameter("genre")) ? "checked" : "" %>>
                                    <span>Femme</span>
                                </label>
                            </div>
                        </div>
                        
                        <!-- Téléphone -->
                        <div class="form-group">
                            <label><i class="fa-solid fa-phone"></i> Téléphone</label>
                            <input type="tel" name="phone" class="form-control" 
                                   placeholder="Ex: 0777154767" required maxlength="15"
                                   value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : "" %>">
                        </div>
                        
                        <!-- Email -->
                        <div class="form-group">
                            <label><i class="fa-solid fa-envelope"></i> Email</label>
                            <input type="email" name="email" class="form-control" 
                                   placeholder="Ex: patient@email.com" maxlength="100"
                                   value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
                        </div>
                        
                        <!-- Adresse -->
                        <div class="form-group full-width">
                            <label><i class="fa-solid fa-location-dot"></i> Adresse</label>
                            <textarea name="adresse" class="form-control" required rows="2" 
                                      placeholder="Adresse complète..."><%= request.getParameter("adresse") != null ? request.getParameter("adresse") : "" %></textarea>
                        </div>
                        
                        <!-- Médecin traitant -->
                        <div class="form-group">
                            <label><i class="fa-solid fa-stethoscope"></i> Médecin traitant</label>
                            <input type="text" name="medecinTraitant" class="form-control" 
                                   placeholder="Ex: DR Nabil" maxlength="100"
                                   value="<%= request.getParameter("medecinTraitant") != null ? request.getParameter("medecinTraitant") : "" %>">
                        </div>
                        <div class="form-group">
                        <!-- Champs cachés pour les informations système -->
                        <label><i class="fa-solid fa-user-check"></i>Crée par </label>
                        <input type="text" name="creePar" value="" class="form-control">
                        <input type="hidden" name="modifiePar" value="">
                        </div>
                    </div>
                </form>
            </div>
            
            <!-- Pied du modal avec boutons -->
            <div class="modal-footer">
                <a href="Accuiel.jsp" class="btn-cancel">
                    <i class="fa-solid fa-times"></i>
                    Annuler
                </a>
                <button type="submit" form="patientForm" class="btn-save">
                    <i class="fa-solid fa-save"></i>
                    Enregistrer le patient
                </button>
            </div>
            
        </div>
    </div>
    
</body>
</html>
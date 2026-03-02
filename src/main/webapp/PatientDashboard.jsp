<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.labo.patient.beans.PatientBean" %>
<link rel="stylesheet" href="StyleDashboard.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <!-- Récuperer la liste des patient  -->
   <% List <PatientBean> patients = (List<PatientBean >) request.getAttribute("patients");
   
   %>
    
    <div class="dashboard-container">
    <h2>Gestion des patients</h2>
    
    <!-- Barre d'actions avec boutons -->
    <div class="action-bar">
    	<form method="post">
    	<div class="button-group">
        <button type="submit" formaction="AjouterPatient.jsp" class="btn-add">
            <i class="fa-solid fa-plus"></i>
            <span>Ajouter patient</span>
        </button>
         <div class="search-container">
            <button type="submit" formaction="RechercherPatient" class="btn-search">
                <i class="fa-solid fa-search"></i>
                <span>Rechercher</span>
            </button>
        </div>
        </div>
        </form>
    </div>
    
    <!-- Tableau des patients -->
    <div class="table-container">
    <table class="patients-table">
    	<thead>
    		<tr>
    			<th>CIN</th>
    			<th>NOM</th>
    			<th>Prénom</th>
    			<th>Phone</th>
    			<th>Medecin traitant</th>
    			<th>Plus d'informations</th>
    		</tr>
    	</thead>
    	<tbody>
    		<%
    			if(patients != null && !patients.isEmpty()){
    				for(PatientBean p : patients){
    		%>
    		<tr>
    			<td><b><%= p.GetCin() %></b></td>
    			<td><%= p.getNom() %></td>
    			<td><%= p.getPrenom()%></td>
    			<td><%= p.getPhone()%></td>
    			<td><%= p.getMedecinTraitant()%></td>
    			<td>
    			<a href="PatientDetail.jsp?cin=<%=p.GetCin() %>" class="btn-info">
    			<i class="fa-solid fa-magnifying-glass"></i>
    			</a>
    			</td>
    		</tr>
    		<%
    				}
    			}else{
    		%>
    		<tr>
    			<td colspan="13" style="text-align: center;">Aucun patient est trouvé ! </td>
    		</tr>
    		<% } %>
    	</tbody>
    </table>
    </div>
    </div>
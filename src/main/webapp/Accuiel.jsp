<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang='fr'>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="StyleAccuiel.css?v=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Laboratoire Ibno Rochd </title>
</head>
<body>
	<!-- HEADER -->
<div class="header-bar">
	<h1>
		<i class="fas fa-microscope"></i> 
		<b>LABORATOIRE IBNO ROCHD</b>
	</h1>
	<!-- BOUTON DE DECONNEXION -->
	<div style="display: flex; align-items: center; gap: 15px;">
		<a href="deconnexion.php" class="deconnexion-btn">
	 		<i class="fas fa-sign-out-alt"></i>
			<span>Déconnexion</span>
		</a>
	</div>
</div>
<hr>

	<!-- CONTENU PRINCIPAL -->
<div class="main-container">
		<!-- Menu -->
	<div class="menu-bar">
	 
    <!-- PROFIL UTILISATEUR STATIQUE pour le moment  -->
    <div class="user-profile">
            <!-- Photo centrée -->
            <img src="images/secretaire.png" alt="Photo de profil" class="profile-photo">
            
            <!-- Nom et rôle en dessous, centrés -->
            <div class="profile-info">
                <span class="profile-name">Mme. Fatima Alami</span>
                <span class="profile-role">Secrétaire</span>
            </div>
        </div>
	<div class="menu-items">
	<%
		String pageParam = request.getParameter("page");
		if(pageParam == null)
			pageParam = "patient";
	%>
	<!-- Accueil -->
 	<a href="<%= request.getContextPath() %>/home" 
       class="menu-item <%= pageParam.equals("home") ? "active" : "" %>">
        <i class="fa-solid fa-home"></i>
        <span>Home</span>
    </a>
	<!-- PATEINT -->
 	<a href="<%= request.getContextPath() %>/PateintContenu" 
       class="menu-item <%= pageParam.equals("patient") ? "active" : "" %>">
        <i class="fa-solid fa-user-circle"></i> 
        <span>Patient</span>
    </a>
    <!-- Analyses souhaitées -->
     <a href="<%= request.getContextPath()%>/analysesouhaitee"
    	class="menu-item <%= pageParam.equals("souhaite") ? "active" : "" %>">
    	<i class="fa-solid fa-flask"></i>
    	<span>Analyses souhaitées</span>
    </a>
    <!--  Facture -->
    <a href="<%= request.getContextPath()%>/FactureContenu"
    	class="menu-item <%= pageParam.equals("facture") ? "active" : "" %>">
		<i class="fa-solid fa-receipt"></i>
    	<span>Facture</span>
    </a>
   
    <!-- Catalogue d'analyses -->
    <a href="<%= request.getContextPath()%>/catalogueAnalyse"
    	class="menu-item <%= pageParam.equals("calalogue") ? "active" : "" %>">
		<i class="fa-solid fa-bars"></i>
    	<span>Catalogue d'analyses</span>
    </a>
    
	</div>
	</div>
		<!-- Zone de contenu changeable -->
	<div class="content-area">
	<%
		if(pageParam.equals("patient")){
	%>
		<!-- Inclusion de tableau de brod de patient -->	
	<jsp:include page="PatientDashboard.jsp" />
	<%
		}else{
	%>
	<h2>Bienvenu !</h2>
	<p>Sélectionner une option dans le menu </p>
	<% } %>
	
	
	
	
	
	</div> 



</div>
</body>
</html>
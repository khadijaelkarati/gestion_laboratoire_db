<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="StyleConfirmDeletePatient.css">
    <title>Supprimer Facture</title>
</head>
<body>
    <div class="delete-box">
        <h3>Êtes-vous sûr de vouloir supprimer la facture n° ${param.id} ?</h3>
        <form action="DeleteFactureServlet" method="POST">
            <input type="hidden" name="id" value="${param.id}">
            <button type="submit" class="btn-confirm">Oui, Supprimer</button>
            <a href="FactureDashboard.jsp" class="btn-cancel">Annuler</a>
        </form>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails Facture</title>
    <link rel="stylesheet" type="text/css" href="StylePatientDetail.css">
</head>
<body>
    <jsp:include page="Header.jspf" />
    <div class="container">
        <jsp:include page="Menu.jspf" />
        <div class="main-content">
            <div class="detail-card">
                <h2>Détails de la Facture</h2>
                <hr>
                <p><strong>N° Facture:</strong> ${facture.numeroFacture}</p>
                <p><strong>ID Patient:</strong> ${facture.idPatient}</p>
                <p><strong>Date:</strong> ${facture.dateEmission}</p>
                <p><strong>Montant:</strong> ${facture.montantTotal} DH</p>
                <p><strong>Statut:</strong> ${facture.statusPaiement}</p>
                <p><strong>Observation:</strong> ${facture.observation}</p>
                <a href="FactureDashboard.jsp" class="btn-back">Retour</a>
            </div>
        </div>
    </div>
</body>
</html>
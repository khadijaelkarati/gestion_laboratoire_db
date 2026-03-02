<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Facture</title>
    <link rel="stylesheet" type="text/css" href="StyleDashboard.css">
</head>
<body>
    <jsp:include page="Header.jspf" />
    <div class="container">
        <jsp:include page="Menu.jspf" />
        <div class="main-content">
            <div class="dashboard-header">
                <h2>Modifier la Facture N°: ${facture.numeroFacture}</h2>
            </div>
            <div class="form-container">
                <form action="UpdateFactureServlet" method="POST">
                    <input type="hidden" name="id_facture" value="${facture.idFacture}">
                    
                    <div class="form-group">
                        <label>Montant Total :</label>
                        <input type="number" name="montant_total" value="${facture.montantTotal}" required>
                    </div>
                    <div class="form-group">
                        <label>Statut :</label>
                        <select name="status_paiement">
                            <option value="PAYEE" ${facture.statusPaiement == 'PAYEE' ? 'selected' : ''}>Payée</option>
                            <option value="NON_PAYEE" ${facture.statusPaiement == 'NON_PAYEE' ? 'selected' : ''}>Non Payée</option>
                        </select>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn-add">Mettre à jour</button>
                        <a href="FactureDashboard.jsp" class="btn-search">Annuler</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
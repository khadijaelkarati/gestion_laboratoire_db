<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laboratoire - Ajouter Facture</title>
    <link rel="stylesheet" type="text/css" href="StyleDashboard.css">
</head>
<body>

    <jsp:include page="Header.jspf" />

    <div class="container">
        <jsp:include page="Menu.jspf" />

        <div class="main-content">
            <div class="dashboard-header">
                <h2>Ajouter une nouvelle facture</h2>
            </div>

            <div class="form-container">
                <form action="AjouterFactureServlet" method="POST">
                    
                    <div class="form-group">
                        <label>Numéro de Facture :</label>
                        <input type="text" name="numero_facture" placeholder="Ex: FAC12345" required>
                    </div>

                    <div class="form-group">
                        <label>ID Patient :</label>
                        <input type="number" name="id_patient" required>
                    </div>

                    <div class="form-group">
                        <label>Montant Total (DH) :</label>
                        <input type="number" step="0.01" name="montant_total" required>
                    </div>

                    <div class="form-group">
                        <label>Statut de Paiement :</label>
                        <select name="status_paiement">
                            <option value="NON_PAYEE">Non Payée</option>
                            <option value="PAYEE">Payée</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Mode de Paiement :</label>
                        <select name="mode_paiment">
                            <option value="ESPECE">Espèce</option>
                            <option value="CARTE">Carte Bancaire</option>
                            <option value="CHEQUE">Chèque</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Observation :</label>
                        <textarea name="observation" rows="3"></textarea>
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn-add">Enregistrer</button>
                        <a href="FactureDashboard.jsp" class="btn-search" style="text-decoration:none;">Annuler</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="Footer.jspf" />

</body>
</html>
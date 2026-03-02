<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laboratoire - Gestion des Factures</title>
    <link rel="stylesheet" type="text/css" href="StyleDashboard.css">
</head>
<body>

    <jsp:include page="Header.jspf" />

    <div class="container">
        <jsp:include page="Menu.jspf" />

        <div class="main-content">
            <div class="dashboard-header">
                <h2>Gestion des factures</h2>
                <div class="actions">
                    <a href="AjouterFacture.jsp" class="btn-add">+ Ajouter facture</a>
                    <button class="btn-search">Rechercher</button>
                </div>
            </div>

            <table class="table-patient">
                <thead>
                    <tr>
                        <th>N° FACTURE</th>
                        <th>ID PATIENT</th>
                        <th>DATE ÉMISSION</th>
                        <th>MONTANT TOTAL</th>
                        <th>STATUS</th>
                        <th>ACTIONS</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty listFactures}">
                            <tr>
                                <td colspan="6" style="text-align:center; padding: 20px;">
                                    Aucune facture n'est trouvée !
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="f" items="${listFactures}">
                                <tr>
                                    <td>${f.numeroFacture}</td>
                                    <td>${f.idPatient}</td>
                                    <td>${f.dateEmission}</td>
                                    <td>${f.montantTotal} DH</td>
                                    <td><span class="status-badge">${f.statusPaiement}</span></td>
                                    <td>
                                        <a href="ModifierFactureServlet?id=${f.idFacture}" class="btn-edit">Modifier</a>
                                        <a href="ConfirmDeleteFacture.jsp?id=${f.idFacture}" class="btn-delete">Supprimer</a>
                                        <a href="FactureDetail.jsp?id=${f.idFacture}" class="btn-detail">Détails</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>

    <jsp:include page="Footer.jspf" />

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="Style.css">
<div class="card">
  <h2 style="margin:0 0 6px;">Dashboard</h2>
  <p style="margin:0;color:var(--muted);">
    Accès rapide aux modules de la plateforme.
  </p>

  <div style="margin-top:14px;display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:14px;">
    
    <!-- Patients -->
    <a class="dash-card" href="<%= request.getContextPath() %>/SearchPatientServlet">
      <div class="dash-title">Patients</div>
      <div class="dash-desc">Ajouter, rechercher, consulter la fiche patient.</div>
      <div class="dash-action">Ouvrir →</div>
    </a>

    <!-- Analyses -->
    <a class="dash-card" href="<%= request.getContextPath() %>/AnalysesListServlet">
      <div class="dash-title">Analyses</div>
      <div class="dash-desc">Créer et suivre les demandes d’analyses.</div>
      <div class="dash-action">Ouvrir →</div>
    </a>

    <!-- Résultats -->
    <a class="dash-card" href="<%= request.getContextPath() %>/home?view=results_list">
      <div class="dash-title">Résultats</div>
      <div class="dash-desc">Saisie technicien & validation biologiste.</div>
      <div class="dash-action">Ouvrir →</div>
    </a>

    <!-- Paiement -->
    <a class="dash-card" href="<%= request.getContextPath() %>/home?view=payments_receipt">
      <div class="dash-title">Paiement</div>
      <div class="dash-desc">Total, reçu, suivi simple des paiements.</div>
      <div class="dash-action">Ouvrir →</div>
    </a>
  </div>

<div style="margin-top:16px;" class="card">
  <div style="display:flex;align-items:center;justify-content:space-between;gap:10px;flex-wrap:wrap;">
    <div style="font-weight:950;">Étapes du processus</div>
    <div style="color:var(--muted);font-size:13px;">Vue rapide du parcours patient</div>
  </div>

  <div class="steps" style="margin-top:12px;">
    <div class="step active">
      <div class="step-dot"></div>
      <div class="step-label">Patient</div>
    </div>

    <div class="step">
      <div class="step-dot"></div>
      <div class="step-label">Analyses</div>
    </div>

    <div class="step">
      <div class="step-dot"></div>
      <div class="step-label">Paiement</div>
    </div>

    <div class="step">
      <div class="step-dot"></div>
      <div class="step-label">Résultats</div>
    </div>

    <div class="step">
      <div class="step-dot"></div>
      <div class="step-label">Validation</div>
    </div>

    <div class="step">
      <div class="step-dot"></div>
      <div class="step-label">Remise</div>
    </div>
  </div>

  <div style="margin-top:10px;color:var(--muted);font-size:13px;line-height:1.5;">
    Astuce : commence par <b>Patients</b>, puis crée une demande dans <b>Analyses</b>. Le technicien saisit dans <b>Résultats</b>, le biologiste valide, puis remise au patient.
  </div>
</div>
</div>
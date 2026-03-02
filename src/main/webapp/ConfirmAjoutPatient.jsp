<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation - Laboratoire IBNO ROCHD</title>
    <link rel="stylesheet" href="StyleDashboard.css?v=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #f8fafc 0%, #f1f5f9 100%);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .confirmation-card {
            background: white;
            border-radius: 30px;
            padding: 50px;
            max-width: 500px;
            width: 90%;
            text-align: center;
            box-shadow: 0 20px 40px rgba(16, 185, 129, 0.15);
            animation: fadeIn 0.5s ease;
            border: 1px solid #bae6fd;
        }
        
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        .success-icon {
            width: 90px;
            height: 90px;
            background: linear-gradient(135deg, #6ee7b7, #34d399);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 25px;
            box-shadow: 0 10px 20px rgba(52, 211, 153, 0.3);
        }
        
        .success-icon i {
            color: white;
            font-size: 45px;
        }
        
        h2 {
            color: #0f172a;
            font-size: 28px;
            margin-bottom: 30px;
            font-weight: 600;
        }
        

        .info-row:last-child {
            border-bottom: none;
        }
        
        .info-icon {
            width: 35px;
            color: #06b6d4;
            font-size: 18px;
        }
        
        .info-label {
            width: 90px;
            text-align: left;
            color: #475569;
            font-weight: 500;
        }
        
        .info-value {
            flex: 1;
            text-align: left;
            font-weight: 600;
            color: #0f172a;
        }
        
        .cin-value {
            color: #0d9488;
            font-size: 16px;
        }
        
        .nom-prenom-container {
            display: flex;
            gap: 5px;
        }
        
        .nom-prenom-container .info-value {
            display: flex;
            gap: 5px;
        }
        
        .separator {
            color: #06b6d4;
            font-weight: normal;
        }
        
        .date-ajout {
            color: #64748b;
            font-size: 14px;
            margin: 25px 0 20px;
            padding: 15px;
            background: #ecfdf5;
            border-radius: 50px;
            display: inline-block;
            border: 1px solid #a7f3d0;
        }
        
        .date-ajout i {
            color: #10b981;
            margin-right: 8px;
        }
        
        .btn-ok {
            background: linear-gradient(135deg, #06b6d4, #0d9488);
            color: white;
            border: none;
            padding: 15px 50px;
            border-radius: 50px;
            font-size: 18px;
            font-weight: 600;
            cursor: pointer;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(6, 182, 212, 0.3);
            text-decoration: none;
            margin-top: 10px;
        }
        
        .btn-ok:hover {
            background: linear-gradient(135deg, #0891b2, #0f766e);
            transform: translateY(-3px);
            box-shadow: 0 8px 25px rgba(6, 182, 212, 0.4);
        }
        
        .btn-ok i {
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="confirmation-card">
        <div class="success-icon">
            <i class="fa-solid fa-check"></i>
        </div>
        <h2>Patient ajouté avec succès !</h2>
        
        <div class="date-ajout">
            <i class="fa-regular fa-calendar-check"></i>
            Ajouté le : <%= new java.text.SimpleDateFormat("dd/MM/yyyy à HH:mm").format(new java.util.Date()) %>
        </div>
        
        <a href="Accuiel.jsp" class="btn-ok">
            <i class="fa-solid fa-check-circle"></i>
            OK
        </a>
    </div>
</body>
</html>
CREATE TABLE utilisateur (
    id_utilisateur NUMBER PRIMARY KEY,
    nom VARCHAR2(50) NOT NULL,
    prenom VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    mot_de_passe VARCHAR2(64) NOT NULL,
    fonction VARCHAR2(20) NOT NULL,
    telephone VARCHAR2(20),
    date_creation DATE DEFAULT SYSDATE,
    actif CHAR(1) DEFAULT 'O',
    
    constraint chk_utilisateur_fonction
        check ( fonction in ('SECRETAIRE', 'TECHNICIEN', 'BIOLOGISTE')),
    constraint chk_utilisateur_actif 
        check (actif in( 'O', 'N'))
);
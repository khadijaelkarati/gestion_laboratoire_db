-- séquence pour catalogue_analyse
CREATE SEQUENCE seq_catalogue_analyse
    START WITH 1
    INCREMENT BY 1;

-- Création de la table catalogue_analyse
CREATE TABLE catalogue_analyse (
    id_catalogue NUMBER PRIMARY KEY,
    nom_analyse VARCHAR2(100) NOT NULL,
    description VARCHAR(500),
    prix number(10,2),
    duree NUMBER(3),
    categorie varchar2(50),
    unite_mesure VARCHAR2(20)
)

-- insertion dans la table catalogue_analyse 
INSERT INTO catalogue_analyse (
    id_catalogue, 
    nom_analyse, 
    description, 
    prix, 
    duree, 
    categorie, 
    unite_mesure
) VALUES (
    seq_catalogue_analyse.NEXTVAL,
    'Glycémie à jeun',
    'Mesure du taux de glucose dans le sang après 8h de jeûne',
    5000,
    30,
    'BIOCHIMIE',
    'mg/dL'
);
INSERT INTO catalogue_analyse (
    id_catalogue, 
    nom_analyse, 
    description, 
    prix, 
    duree, 
    categorie, 
    unite_mesure
) VALUES (
    seq_catalogue_analyse.NEXTVAL,
    'Numération Formule Sanguine (NFS)',
    'Comptage des globules rouges, blancs et plaquettes',
    8500,
    45,
    'HEMATOLOGIE',
    'millions/mm³'
);
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Hémoglobine', 'Dosage de l''hémoglobine dans le sang', 4500, 20, 'HEMATOLOGIE', 'g/dL');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Hématocrite', 'Volume des globules rouges', 4000, 20, 'HEMATOLOGIE', '%');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Plaquettes', 'Numération des plaquettes', 5000, 25, 'HEMATOLOGIE', 'x10³/µL');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Créatinine', 'Évaluation de la fonction rénale', 5500, 30, 'BIOCHIMIE', 'mg/L');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Urée', 'Dosage de l''urée sanguine', 5000, 30, 'BIOCHIMIE', 'g/L');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Cholestérol total', 'Bilan lipidique', 6000, 35, 'BIOCHIMIE', 'g/L');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Triglycérides', 'Dosage des triglycérides', 6000, 35, 'BIOCHIMIE', 'g/L');
INSERT INTO catalogue_analyse VALUES (seq_catalogue_analyse.NEXTVAL, 'Transaminases (ALAT)', 'Enzymes hépatiques', 5500, 40, 'BIOCHIMIE', 'UI/L');

-- afficher la table
select * from catalogue_analyse;
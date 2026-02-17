-- ======== Script 2 : Création de la table patient ============
CREATE TABLE patient (
    id_patient int,
    nom varchar2(50) not null,
    prenom varchar2(50) not null,
    date_nais date,
    genre varchar2(6) not null,
    phone varchar2(10) not null,
    email varchar2(20),
    adress varchar2(50) not null,
    medecin_traitant varchar2(50) not null,
    date_creation DATE not null,
    date_modification DATE not null,
    cree_par varchar2(50),
    modifie_par varchar2(50),
    CONSTRAINT pk_patient PRIMARY KEY (id_patient),
    CONSTRAINT chk_patient_genre CHECK ( genre IN ('F','M')),
    CONSTRAINT chk_patient_email CHECK (email IS NULL OR email LIKE '%@%.%'),
    CONSTRAINT uk_patient_email UNIQUE (email),
    CONSTRAINT uk_pateint_phone UNIQUE (phone)
    )
    
-- Création de auto increment 
CREATE SEQUENCE seq_patient
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
-- ============== Script 3 : Insertion dans  PATIENT ==================
-- Insertion de la table
INSERT INTO  patient (
    id_patient, nom, prenom, date_nais, genre, phone, email, adress,
    medecin_traitant, date_creation, date_modification, cree_par, modifie_par
    )VALUES (
        seq_patient.NEXTVAL,
        'ELKARATI',
        'KHADIJA',
        TO_DATE('01/08/2003','DD/MM/YYYY'),
        'F',
        '0777154767',
        'elkarati@gmail.com',
        '15 Rue de la paie',
        'DR Nabil',
        SYSDATE,
        SYSDATE,
        'secretaire1',
        null
    );
INSERT INTO patient (
 id_patient, nom, prenom, date_nais, genre, phone, email, adress,
    medecin_traitant, date_creation, date_modification, cree_par, modifie_par
    )VALUES (
        seq_patient.NEXTVAL,
        'Kchiri',
        'Nabil',
        TO_DATE('01/08/1980','DD/MM/YYYY'),
        'M',
        '0657892416',
        'kchiri@gmail.com',
        '15 Rue de la paie',
        'DR Khadija',
        SYSDATE,
        SYSDATE,
        'secretaire1',
        null
    );
    
    select * from patient;
    
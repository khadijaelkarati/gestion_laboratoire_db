-- sequence de la table analyse souhaitee
CREATE SEQUENCE seq_analyse_souhaitee
    START WITH 1
    INCREMENT BY 1;

-- création de la table analyse souhaitée 
CREATE TABLE analyse_souhaitee (
    id_analyse_souhaitee NUMBER PRIMARY KEY,
    id_patient NUMBER NOT NULL,
    id_catalogue NUMBER NOT NULL,
    date_demande DATE DEFAULT SYSDATE,
    status VARCHAR2(20) DEFAULT 'EN_ATTENTE',
    resultat VARCHAR2(1000),
    observations VARCHAR2(500),
    CONSTRAINT fk_analyse_patient 
        FOREIGN KEY (id_patient) 
        REFERENCES patient(id_patient),
    CONSTRAINT fk_analyse_catalogue 
        FOREIGN KEY (id_catalogue) 
        REFERENCES catalogue_analyse(id_catalogue),
    CONSTRAINT chk_status_analyse CHECK (
        status IN ('EN_ATTENTE', 'EN_COURS', 'TERMINEE', 'ANNULEE')
    )
);
select * from analyse_souhaitee;
-- insertion 
INSERT INTO analyse_souhaitee (
    id_analyse_souhaitee,
    id_patient,
    id_catalogue,
    date_demande,
    status,
    observations
) VALUES (
    seq_analyse_souhaitee.NEXTVAL,
    1, 
    1, 
    SYSDATE,
    'EN_ATTENTE',
    'Patient à jeun depuis 8h'
);
INSERT INTO analyse_souhaitee (
    id_analyse_souhaitee,
    id_patient,
    id_catalogue,
    date_demande,
    status,
    observations
) VALUES (
    seq_analyse_souhaitee.NEXTVAL,
    2, 
    3, 
    SYSDATE,
    'EN_COURS',
    'Urgent - Résultats attendus aujourd hui'
);

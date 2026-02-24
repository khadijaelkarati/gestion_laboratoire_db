CREATE SEQUENCE seq_facture 
    START WITH 1
    INCREMENT BY 1;
-- créattion de la table facture 
CREATE TABLE facture (
    id_facture NUMBER PRIMARY KEY NOT NULL,
    numero_facture varchar2(40)unique  not null,
    id_patient number not null,
    date_emission date default SYSDATE,
    montant_total number(10,2) not null,
    status_paiement varchar2(30) default 'NON_PAYEE',
    date_paiement DATE,
    mode_paiment varchar(30) default 'ESPECE',
    observation varchar(500),
    
    CONSTRAINT fk_facture_patient foreign key (id_patient) references patient(id_patient),
    constraint chk_status_facture check( 
        status_paiement in ('NON_PAYEE', 'PARTIELLE', 'PAYEE', 'ANNULEE')),
    constraint chk_mode_paiement check (
        mode_paiment in ('ESPECE', 'CARTE', 'CHEQUE', 'VIREMENT'))
    );
    
    -- insertion dans la table fature 
insert into facture (id_facture, numero_facture, id_patient, montant_total, status_paiement, observation)
    values ( seq_facture.nextval, 'FACT-2026-001', 1, 0, 'NON_PAYEE',' Premiére facture du patient');
insert into facture (id_facture, numero_facture, id_patient, montant_total, status_paiement, observation)
    values (seq_facture.nextval, 'FACT-2026-002', 2, 0, 'NON_PAYEE', 'Patient bénéficie d''une réduction de 10% pour paiement comptant');
    
    -- selection 
    select * from facture
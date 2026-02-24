create sequence seq_facture_analyse
    start with 1
    increment by 1;
    
    -- Création de la facture_analyse
create table facture_analyse (
    id_facture number,
    id_analyse_souhaitee number,
    primary key (id_facture, id_analyse_souhaitee),
    constraint fk_fa_facture
        foreign key (id_facture) references facture (id_facture) on delete cascade,
    constraint fk_fa_analyse
        foreign key (id_analyse_souhaitee) references analyse_souhaitee (id_analyse_souhaitee)
    );
  
  -- Insertion
  INSERT INTO facture_analyse (id_facture, id_analyse_souhaitee)
VALUES (1, 1);
INSERT INTO facture_analyse (id_facture, id_analyse_souhaitee)
VALUES (2, 2);
        
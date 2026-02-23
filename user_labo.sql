-- =============== Script 1 :  Création de l'utilisateur LABO_USER ============

-- Création de user_labo
Create user user_labo identified by "#WonderMint-flash#9324@"
default TABLESPACE users
QUOTA UNLIMITED ON users;
-- privilège de la bd
GRANT CREATE SESSION TO user_labo;
GRANT CREATE TABLE, CREATE SEQUENCE TO user_labo;
GRANT CREATE TRIGGER, CREATE PROCEDURE TO  user_labo;
SELECT sys_context('USERENV', 'DB_NAME') FROM dual;
XEPDB1
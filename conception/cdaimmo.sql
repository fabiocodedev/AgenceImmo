SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS cdaimmo ;
USE cdaimmo;
CREATE TABLE User(
        id       Int  Auto_increment  NOT NULL ,
        prenom   Varchar (30) ,
        nom      Varchar (30) ,
        email    Varchar (30) ,
        password Varchar (30),
		CONSTRAINT User_PK PRIMARY KEY (id)
);
CREATE TABLE Client(
        id        Int  Auto_increment  NOT NULL ,
        adresse   Mediumtext ,
        telephone Varchar (20) ,
        id_User   Int NOT NULL,
		CONSTRAINT Client_PK PRIMARY KEY (id)
);
CREATE TABLE Employe(
        id      Int  Auto_increment  NOT NULL ,
        id_User Int NOT NULL,
        id_Matricule Int NOT NULL,
		CONSTRAINT Employe_PK PRIMARY KEY (id)
);
CREATE TABLE Proprietaire(
        id        Int  Auto_increment  NOT NULL ,
        telephone Varchar (20) ,
        adresse   Varchar (20) ,
        id_User   Int NOT NULL,
		CONSTRAINT Proprietaire_PK PRIMARY KEY (id)
);
CREATE TABLE Achat(
        id               Int  Auto_increment  NOT NULL ,
        date             Date ,
        fraisAgenceAchat Float ,
        id_Client        Int NOT NULL,
        id_Bien        Int NOT NULL,
		CONSTRAINT Achat_PK PRIMARY KEY (id)
);
CREATE TABLE Bien(
        id              Int  Auto_increment  NOT NULL ,
        type            Varchar (30) ,
        categorie       Varchar (30) ,
        ville           Varchar (30) ,
        prix            Float ,
        nbPiece         Float ,
        superficie      Int ,
        commentaires    Mediumtext ,
        images          Varchar (30) ,
        status          Varchar (20) ,
        id_Employe      Int NOT NULL ,
        id_achat        Int NOT NULL ,
        id_location        Int NOT NULL ,
        id_Proprietaire Int NOT NULL,
		CONSTRAINT Bien_PK PRIMARY KEY (id)
);
CREATE TABLE Message(
        id        Int  Auto_increment  NOT NULL ,
        msg       Text ,
        id_Client Int NOT NULL ,
        id_Bien   Int NOT NULL,
		CONSTRAINT Message_PK PRIMARY KEY (id)
);
CREATE TABLE Location(
        id             Int  Auto_increment  NOT NULL ,
        fraisAgenceLoc Float ,
        dateDebut      Date ,
        dateFin        Date ,
        id_Client      Int NOT NULL,
        id_Bien        Int NOT NULL,
		CONSTRAINT Location_PK PRIMARY KEY (id)
);
CREATE TABLE Matricule(
        id  Int  Auto_increment  NOT NULL ,
        num Varchar (20),
		CONSTRAINT Matricule_PK PRIMARY KEY (id)
);
ALTER TABLE Client ADD CONSTRAINT Client_User_FK FOREIGN KEY (id_User) REFERENCES User(id);
ALTER TABLE Employe ADD CONSTRAINT Employe_User_FK FOREIGN KEY (id_User) REFERENCES User(id);
ALTER TABLE Employe ADD CONSTRAINT Employe_Matricule_FK FOREIGN KEY (id_Matricule) REFERENCES Matricule(id);
ALTER TABLE Proprietaire ADD CONSTRAINT Proprietaire_User_FK FOREIGN KEY (id_User) REFERENCES User(id);
ALTER TABLE Achat ADD CONSTRAINT Achat_Client_FK FOREIGN KEY (id_Client) REFERENCES Client(id);
ALTER TABLE Achat ADD CONSTRAINT Achat_Bien_FK FOREIGN KEY (id_Bien) REFERENCES Bien(id);
ALTER TABLE Bien ADD CONSTRAINT Bien_Employe_FK FOREIGN KEY (id_Employe) REFERENCES Employe(id);
ALTER TABLE Bien ADD CONSTRAINT Bien_Achat_FK FOREIGN KEY (id_Achat) REFERENCES Achat(id);
ALTER TABLE Bien ADD CONSTRAINT Bien_Location_FK FOREIGN KEY (id_Location) REFERENCES Location(id);
ALTER TABLE Bien ADD CONSTRAINT Bien_Proprietaire_FK FOREIGN KEY (id_Proprietaire) REFERENCES Proprietaire(id);
ALTER TABLE Message ADD CONSTRAINT Message_Client_FK FOREIGN KEY (id_Client) REFERENCES Client(id);
ALTER TABLE Message ADD CONSTRAINT Message_Bien_FK FOREIGN KEY (id_Bien) REFERENCES Bien(id);
ALTER TABLE Location ADD CONSTRAINT Location_Client_FK FOREIGN KEY (id_Client) REFERENCES Client(id);
ALTER TABLE Location ADD CONSTRAINT Location_Bien_FK FOREIGN KEY (id_Bien) REFERENCES Bien(id);
COMMIT;
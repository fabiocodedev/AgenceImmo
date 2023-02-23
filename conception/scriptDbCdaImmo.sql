SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
--
-- Base de données : `cdaimmo`
--
CREATE DATABASE IF NOT EXISTS `cdaimmo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cdaimmo`;
-- --------------------------------------------------------
-- Structure de la table `achat`
--
DROP TABLE IF EXISTS `achat`;
CREATE TABLE `achat` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `fraisAgenceAchat` float DEFAULT NULL,
  `id_Client` int(11) NOT NULL,
  `id_Bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Structure de la table `bien`
--
DROP TABLE IF EXISTS `bien`;
CREATE TABLE `bien` (
  `id` int(11) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `categorie` varchar(30) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `nbPiece` float DEFAULT NULL,
  `superficie` int(11) DEFAULT NULL,
  `commentaires` mediumtext DEFAULT NULL,
  `images` varchar(30) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `id_Employe` int(11) NOT NULL,
  `id_achat` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  `id_Proprietaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Structure de la table `client`
--
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `adresse` mediumtext DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `id_User` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
--
-- Structure de la table `employe`
--
DROP TABLE IF EXISTS `employe`;
CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `id_User` int(11) NOT NULL,
  `id_Matricule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Structure de la table `location`
--
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `fraisAgenceLoc` float DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `id_Client` int(11) NOT NULL,
  `id_Bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
--
-- Structure de la table `matricule`
--
DROP TABLE IF EXISTS `matricule`;
CREATE TABLE `matricule` (
  `id` int(11) NOT NULL,
  `num` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Structure de la table `message`
--
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `msg` text DEFAULT NULL,
  `id_Client` int(11) NOT NULL,
  `id_Bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Structure de la table `proprietaire`
--
DROP TABLE IF EXISTS `proprietaire`;
CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `adresse` varchar(20) DEFAULT NULL,
  `id_User` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- --------------------------------------------------------
--
-- Structure de la table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
-- Index pour les tables déchargées
--
-- Index pour la table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Achat_Client_FK` (`id_Client`),
  ADD KEY `Achat_Bien_FK` (`id_Bien`);
--
-- Index pour la table `bien`
--
ALTER TABLE `bien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Bien_Employe_FK` (`id_Employe`),
  ADD KEY `Bien_Achat_FK` (`id_Achat`),
  ADD KEY `Bien_Location_FK` (`id_Location`),
  ADD KEY `Bien_Proprietaire_FK` (`id_Proprietaire`);
--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Client_User_FK` (`id_User`);
--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Employe_User_FK` (`id_User`),
  ADD KEY `Employe_Matricule_FK` (`id_Matricule`);
--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Location_Client_FK` (`id_Client`),
  ADD KEY `Location_Bien_FK` (`id_Bien`);
--
-- Index pour la table `matricule`
--
ALTER TABLE `matricule`
  ADD PRIMARY KEY (`id`);

-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Message_Client_FK` (`id_Client`),
  ADD KEY `Message_Bien_FK` (`id_Bien`);
--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Proprietaire_User_FK` (`id_User`);
--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT pour les tables déchargées
--
-- AUTO_INCREMENT pour la table `achat`
--
ALTER TABLE `achat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `bien`
--
ALTER TABLE `bien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `matricule`
--
ALTER TABLE `matricule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables déchargées
--
--
-- Contraintes pour la table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `Achat_Bien_FK` FOREIGN KEY (`id_Bien`) REFERENCES `bien` (`id`),
  ADD CONSTRAINT `Achat_Client_FK` FOREIGN KEY (`id_Client`) REFERENCES `client` (`id`);
--
-- Contraintes pour la table `bien`
--
ALTER TABLE `bien`
  ADD CONSTRAINT `Bien_Achat_FK` FOREIGN KEY (`id_Achat`) REFERENCES `achat` (`id`),
  ADD CONSTRAINT `Bien_Employe_FK` FOREIGN KEY (`id_Employe`) REFERENCES `employe` (`id`),
  ADD CONSTRAINT `Bien_Location_FK` FOREIGN KEY (`id_Location`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `Bien_Proprietaire_FK` FOREIGN KEY (`id_Proprietaire`) REFERENCES `proprietaire` (`id`);
--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `Client_User_FK` FOREIGN KEY (`id_User`) REFERENCES `user` (`id`);
--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `Employe_Matricule_FK` FOREIGN KEY (`id_Matricule`) REFERENCES `matricule` (`id`),
  ADD CONSTRAINT `Employe_User_FK` FOREIGN KEY (`id_User`) REFERENCES `user` (`id`);
--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `Location_Bien_FK` FOREIGN KEY (`id_Bien`) REFERENCES `bien` (`id`),
  ADD CONSTRAINT `Location_Client_FK` FOREIGN KEY (`id_Client`) REFERENCES `client` (`id`);
--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `Message_Bien_FK` FOREIGN KEY (`id_Bien`) REFERENCES `bien` (`id`),
  ADD CONSTRAINT `Message_Client_FK` FOREIGN KEY (`id_Client`) REFERENCES `client` (`id`);
--
-- Contraintes pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD CONSTRAINT `Proprietaire_User_FK` FOREIGN KEY (`id_User`) REFERENCES `user` (`id`);
COMMIT;

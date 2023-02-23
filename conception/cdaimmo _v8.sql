

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



--
-- Base de données : `cdaimmo`
--
CREATE DATABASE IF NOT EXISTS `cdaimmo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cdaimmo`;

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE `achat` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `fraisAgenceAchat` float DEFAULT NULL,
  `client` int(11) NOT NULL,
  `bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

CREATE TABLE `bien` (
  `id` int(11) NOT NULL,
  `titre` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `categorie` varchar(30) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `nbPiece` float DEFAULT NULL,
  `superficie` int(11) DEFAULT NULL,
  `texte` mediumtext DEFAULT NULL,
  `images` varchar(30) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `proprietaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bien`
--

INSERT INTO `bien` (`id`, `titre`, `type`, `categorie`, `ville`, `prix`, `nbPiece`, `superficie`, `texte`, `images`, `status`, `proprietaire`) VALUES
(1, 'maison1', 'maison', 'achat', 'Obernai', 120000, 5, 120, 'azerty', 'maison1.jpg', 'vendre', 1),
(2, 'maison2', 'maison', 'achat', 'Bisho', 110000, 4, 110, 'azerty', 'maison2.jpg', 'vendre', 1),
(3, 'maison 3', 'maison', 'achat', 'Barr', 130000, 4, 100, 'azerty', 'maison_3.jpg', 'vendre', 1),
(4, 'maison4', 'maison', 'achat', 'Obernai', 200000, 6, 170, 'azerty', 'maison4.jpg', 'vendre', 1),
(5, 'appart1', 'appartement', 'achat', 'Boersh', 220000, 7, 220, 'azerty', 'appart1.jpg', 'vendre', 1),
(6, 'appart2', 'appartement', 'achat', 'Bisho', 140, 5, 150, 'azerty', 'appart2.jpg', 'vendre', 1),
(7, 'dsfsfhvndc', 'maison', 'achat', 'Paris', 450000, 5, 250, 'qdsfsdgfdbfdb cfsqdfqfdq', 'dsfsfhvndc.jpg', '', 1),
(8, 'Appartement 2048', '', 'achat', 'New York', 35000, 3, 80, 'Appartement celebre et bien connu dans le monde entier', 'Appartement_2048.jpg', 'vendre', 4),
(11, 'Meilleur appartement 3636', 'appartement', 'location', 'Paris', 4000, 3, 120, 'qssjss skssis iksfis idsqjssd  sidsdsduhs', 'Meilleur_appartement_3636.jpg', 'louer', 9);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `adresse` mediumtext DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `adresse`, `telephone`, `user`) VALUES
(1, '25 Rue Rene Villerme', '0601775971', 6),
(2, '25 Rue Rene Villerme', '0387512368', 11);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `matricule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `user`, `matricule`) VALUES
(1, 3, 1),
(2, 14, 2),
(3, 16, 3);

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `fraisAgenceLoc` float DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `client` int(11) NOT NULL,
  `bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `matricule`
--

CREATE TABLE `matricule` (
  `id` int(11) NOT NULL,
  `mat` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `matricule`
--

INSERT INTO `matricule` (`id`, `mat`) VALUES
(1, 'cdamat1'),
(2, 'cdamat2'),
(3, 'cdamat3'),
(4, 'cdamat4'),
(5, 'cdamat5'),
(6, 'cdamat6'),
(7, 'cdamat7'),
(8, 'cdamat8'),
(9, 'cdamat9'),
(10, 'cdamat10');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `msg` text DEFAULT NULL,
  `client` int(11) NOT NULL,
  `bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `telephone`, `adresse`, `user`) VALUES
(1, '0687654321', 'azerty', 1),
(2, '0601775971', '25 Rue Rene Villerme', 4),
(3, '0213456546', '25 Rue Rene Villerme', 9),
(4, '0355678465', '25 Rue Rene Villerme', 12);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `prenom`, `nom`, `email`, `password`) VALUES
(1, 'Moussa', 'Camara', 'test@test.fr', '*4F56EF3FCEF3F995F03D1E37E2D692D420111476'),
(2, NULL, NULL, NULL, ''),
(3, 'bafo', 'fof', 'fof@test.fr', '*4F56EF3FCEF3F995F03D1E37E2D692D420111476'),
(4, 'Antoine', 'Bred', 'bred@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(5, NULL, NULL, NULL, ''),
(6, 'Moris', 'Seguin', 'seguin@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(7, 'Narcisse', 'Balland', 'balland@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(8, NULL, NULL, NULL, ''),
(9, 'Loris', 'Maten', 'maten@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(10, NULL, NULL, NULL, ''),
(11, 'Aliou', 'Dieng', 'dieng@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(12, 'Hugo', 'Bento', 'bento@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(13, NULL, NULL, NULL, ''),
(14, 'Nuno', 'Gomes', 'gomes@test.fr', '*8BF6C0AB180B533ECB3D96BFA1986D64AD90E452'),
(15, 'Afred', 'Suza', 'suza@test.fr', '*EFC1689E7AF6006BE9CEDE9918B355458BCE76EA'),
(16, 'Jules', 'Kunde', 'kunde@test.fr', '*EFC1689E7AF6006BE9CEDE9918B355458BCE76EA');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Achat_Client_FK` (`client`),
  ADD KEY `Achat_Bien_FK` (`bien`);

--
-- Index pour la table `bien`
--
ALTER TABLE `bien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Bien_Proprietaire_FK` (`proprietaire`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Client_User_FK` (`user`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Employe_User_FK` (`user`),
  ADD KEY `Employe_Matricule_FK` (`matricule`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Location_Client_FK` (`client`),
  ADD KEY `Location_Bien_FK` (`bien`);

--
-- Index pour la table `matricule`
--
ALTER TABLE `matricule`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Message_Client_FK` (`client`),
  ADD KEY `Message_Bien_FK` (`bien`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Proprietaire_User_FK` (`user`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `achat`
--
ALTER TABLE `achat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `bien`
--
ALTER TABLE `bien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `matricule`
--
ALTER TABLE `matricule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `Achat_Bien_FK` FOREIGN KEY (`bien`) REFERENCES `bien` (`id`),
  ADD CONSTRAINT `Achat_Client_FK` FOREIGN KEY (`client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `bien`
--
ALTER TABLE `bien`
  ADD CONSTRAINT `Bien_Proprietaire_FK` FOREIGN KEY (`proprietaire`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `Client_User_FK` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `Employe_Matricule_FK` FOREIGN KEY (`matricule`) REFERENCES `matricule` (`id`),
  ADD CONSTRAINT `Employe_User_FK` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `Location_Bien_FK` FOREIGN KEY (`bien`) REFERENCES `bien` (`id`),
  ADD CONSTRAINT `Location_Client_FK` FOREIGN KEY (`client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `Message_Bien_FK` FOREIGN KEY (`bien`) REFERENCES `bien` (`id`),
  ADD CONSTRAINT `Message_Client_FK` FOREIGN KEY (`client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD CONSTRAINT `Proprietaire_User_FK` FOREIGN KEY (`user`) REFERENCES `user` (`id`);


COMMIT;
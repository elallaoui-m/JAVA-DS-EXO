-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 12 nov. 2019 à 21:20
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `forjdbc`
--

-- --------------------------------------------------------

--
-- Structure de la table `voitures`
--

CREATE TABLE `voitures` (
  `id_voiture` int(11) NOT NULL,
  `voiture` varchar(40) NOT NULL,
  `modele` varchar(40) NOT NULL,
  `type` varchar(40) NOT NULL,
  `prix_jour` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `voitures`
--

INSERT INTO `voitures` (`id_voiture`, `voiture`, `modele`, `type`, `prix_jour`) VALUES
(1, 'Dacia Logan', 'Model 2012', 'Diesel', 300),
(2, 'Hyundai i103', 'Model 2014', 'Essance', 280),
(3, 'Volkswagn polo', 'Model 2012', 'Diesel', 450),
(4, 'Peugeot 307', 'Model 2013', 'Diesel', 550),
(5, 'Mercedes 220', 'Model 2012', 'Diesel', 700),
(6, 'Range Rover', 'Model 2014', 'Diesel', 1000);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `voitures`
--
ALTER TABLE `voitures`
  ADD PRIMARY KEY (`id_voiture`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `voitures`
--
ALTER TABLE `voitures`
  MODIFY `id_voiture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

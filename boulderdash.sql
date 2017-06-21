-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 21 Juin 2017 à 15:18
-- Version du serveur :  5.5.55-0+deb8u1
-- Version de PHP :  5.6.30-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `boulderdash`
--

DELIMITER $$
--
-- Procédures
--
CREATE PROCEDURE `callMap`(IN id INT)
BEGIN
SELECT map_structure
FROM MAP
Where map_ID = id;
END$$

CREATE PROCEDURE `getHeight`(IN id INT)
BEGIN
SELECT height
FROM MAP
WHERE map_ID = id;
END$$

CREATE PROCEDURE `getWidth`(IN id INT)
BEGIN
SELECT width
FROM MAP
WHERE map_ID = id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `MAP`
--

CREATE TABLE IF NOT EXISTS `MAP` (
`map_ID` int(11) NOT NULL,
  `map_structure` varchar(2200) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `MAP`
--

INSERT INTO `MAP` (`map_ID`, `map_structure`, `width`, `height`) VALUES
(1, '123021322012', 12, 1),
(2, '0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\n0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,4,1,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,0\r\n0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,9,9,1,1,1,3,3,3,3,1,0\r\n0,1,3,3,1,1,1,1,1,1,0,1,1,1,1,1,1,9,A,1,1,3,3,1,4,1,3,0\r\n0,1,1,1,4,3,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,3,3,3,3,1,1,9,9,1,1,4,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,9,A,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0\r\n0,1,4,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,3,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,3,3,3,1,3,3,1,1,0\r\n0,0,0,0,0,0,0,0,0,1,1,1,1,9,9,1,1,1,1,3,1,3,1,1,1,1,1,0\r\n0,1,1,3,3,3,1,1,1,0,1,1,1,9,9,1,1,1,3,3,1,1,4,1,1,1,1,0\r\n0,1,3,3,1,4,1,1,1,1,0,1,1,9,A,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,1,1,3,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\n0,1,4,1,3,3,9,9,9,1,1,0,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,0\r\n0,1,1,1,1,1,9,9,9,1,1,1,1,1,1,1,4,1,1,1,1,1,3,3,1,4,1,0\r\n0,1,1,1,1,1,9,9,A,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,9,9,1,1,1,1,1,1,0\r\n0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,9,9,9,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,9,9,A,1,1,1,1,1,1,0\r\n0,1,1,4,1,3,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,1,1,3,3,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,0,9,B,9,9,4,0,4,9,9,B,9,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,4,0,1,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0\r\n0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,6,0\r\n0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\r\n', 28, 30);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `MAP`
--
ALTER TABLE `MAP`
 ADD PRIMARY KEY (`map_ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `MAP`
--
ALTER TABLE `MAP`
MODIFY `map_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

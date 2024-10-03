-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 03, 2024 at 06:45 AM
-- Server version: 5.7.39
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cars`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `plate` int(8) NOT NULL,
  `make` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`plate`, `make`, `model`) VALUES
(123, 'Toyota', 'Revo'),
(456, 'SLC', 'Mercedes Benz'),
(112233, '7 series', 'BMW'),
(213141, 'Lamboghini', 'Azura'),
(989796, 'Haval', 'Greatwall Motor'),
(111, 'revo', 'toyota'),
(110, 'Revo-z', 'toyota'),
(5454, 'wwwwe', 'qwqwe'),
(56412, 'safsafsaf', 'safasfasf'),
(164, 'asfasf', 'safasfa'),
(100, 'revo-z', 'toyota'),
(14, 'safasfasf', 'safasfasfasf'),
(200, 'revo-A', 'toyoda'),
(3333, 'fghk', 'honda'),
(5655656, 'fkfkfkfk', 'honda'),
(9, 'Liverpool', 'No.1'),
(123, 'Kok', 'KKKK'),
(1234, 'BMW-7', 'BMW');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

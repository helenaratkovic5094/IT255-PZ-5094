-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2024 at 08:19 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `metair`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `id` int(11) NOT NULL,
  `od` varchar(50) NOT NULL,
  `destinacija` varchar(60) NOT NULL,
  `vreme` varchar(10) NOT NULL,
  `brojputnika` int(11) NOT NULL,
  `cena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`id`, `od`, `destinacija`, `vreme`, `brojputnika`, `cena`) VALUES
(3, 'Beograd', 'Bec', '2024-06-13', 7660, 12000),
(4, 'Beograd', 'Cirih', '2024-06-27', 7684, 18000),
(10, 'Beograd', 'Njujork', '2024-06-26', 110, 80223),
(15, 'Njujork', 'Bec', '2024-06-17', 12202, 12345);

-- --------------------------------------------------------

--
-- Table structure for table `kupovine`
--

CREATE TABLE `kupovine` (
  `id` int(11) NOT NULL,
  `od` varchar(255) NOT NULL,
  `destinacija` varchar(255) NOT NULL,
  `vreme` varchar(30) NOT NULL,
  `brojputnika` int(11) NOT NULL,
  `zeljeniPrtljag` varchar(255) NOT NULL,
  `ukupnaCena` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kupovine`
--

INSERT INTO `kupovine` (`id`, `od`, `destinacija`, `vreme`, `brojputnika`, `zeljeniPrtljag`, `ukupnaCena`) VALUES
(4, 'Beograd', 'Bec', '2024-06-13', 1, '1', 13000.00),
(5, 'Beograd', 'Bec', '2024-06-13', 1, '0', 12000.00),
(6, 'Beograd', 'Bec', '2024-06-17', 1, '1', 14000.00),
(7, 'Beograd', 'Bec', '2024-06-17', 1, '0', 12000.00),
(8, 'Beograd', 'Bec', '2024-06-17', 1, '0', 12000.00),
(9, 'Cirih', 'Beograd', '2024-06-25', 1, '0', 12333.00),
(10, 'Cirih', 'Beograd', '2024-06-25', 1, '0', 12333.00),
(11, 'Beograd', 'Njujork', '2024-06-26', 1, '0', 80223.00),
(12, 'Beograd', 'Bec', '2024-06-13', 2, '0', 24000.00),
(13, 'Njujork', 'Bec', '2024-06-17', 2, '0', 24690.00),
(14, 'Beograd', 'Cirih', '2024-06-27', 22, '1', 398000.00),
(15, 'Beograd', 'Bec', '2024-06-13', 1, '0', 12000.00),
(16, 'Beograd', 'Cirih', '2024-06-27', 3, '0', 54000.00),
(17, 'Beograd', 'Njujork', '2024-06-26', 1, '0', 80223.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'lidija', '123');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `user`, `content`, `rating`) VALUES
(1, 'Stefan', 'Komentar', 4),
(6, 'Lidija', 'Nesto nesto', 5),
(7, 'lidija', 'xsaa', 5),
(8, '', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kupovine`
--
ALTER TABLE `kupovine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `kupovine`
--
ALTER TABLE `kupovine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

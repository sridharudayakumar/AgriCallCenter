-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2021 at 08:12 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `callcenter`
--

-- --------------------------------------------------------

--
-- Table structure for table `formers`
--

CREATE TABLE `formers` (
  `formerId` int(11) NOT NULL,
  `formerName` varchar(50) NOT NULL,
  `phoneNo` bigint(10) NOT NULL,
  `address` text NOT NULL,
  `query` text NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `formers`
--

INSERT INTO `formers` (`formerId`, `formerName`, `phoneNo`, `address`, `query`, `status`) VALUES
(1, 'Dejene', 982342342, 'Mettu', 'Need a detail about agri loan', 'Answered'),
(2, 'Lalisa', 897234452, 'Addis', 'Which pesticide is suitable for coffee production', 'Pending'),
(4, 'Kumera', 467467776, 'Addis', 'What are the schemes are available for animal husbandry', 'Answered'),
(5, 'sridhar', 9786757555, 'mettu', 'Schemes related animal husbandry', 'Answered'),
(6, 'Ramata', 9878678678, 'mettu', 'what are the deceases of coffee plant', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `informations`
--

CREATE TABLE `informations` (
  `infoId` int(11) NOT NULL,
  `category` varchar(40) NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `informations`
--

INSERT INTO `informations` (`infoId`, `category`, `title`, `description`) VALUES
(1, 'Crop Production', 'Process of Coffee Production', 'First, the freshly harvested cherries are passed through a pulping machine to separate the skin and pulp from the bean. Then the beans are separated by weight as they pass through water channels. The lighter beans float to the top, while the heavier ripe beans sink to the bottom.\r\n  \r\n  \r\n  \r\n  \r\n  \r\n  '),
(2, 'Crop Production', 'Types of coffee processings', '  Coffee is traditionally processed in three ways: washed, natural, and honey. There are alternatives, but these are both rare and typically localised, such as wet hulling in Indonesia.\r\n  '),
(5, 'Animal Husbandry', 'Types of breeding', '  Basically, there are two methods of breeding which are as follows: Inbreeding : Breeding of the related animals as sire (male) and dam (female) are known as inbreeding. Out breeding : Out breeding of unrelated animals as male and female is known as out breeding.\r\n  '),
(6, 'Crop Production', 'Deseaces of Cofee PLant', '  asdfjhkjghaksdfkhkjadsf  \r\n  zxcvxvcxv\r\n  '),
(7, 'Crop Production', 'What crops does Ethiopia grow', 'Ethiopia\'s major staple crops include a variety of cereals, pulses, oilseeds, and coffee. Grains are the most important field crops and the chief element in the diet of most Ethiopians. The principal grains are teff, wheat, barley, corn, sorghum, and millet.');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(20) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `firstName`, `lastName`, `email`, `password`, `role`, `status`) VALUES
(1, 'Sridhar', 'U', 'admin@gmail.com', '123456', 'Administrator', 'active'),
(3, 'Abdi', 'M', 'officer@gmail.com', '123456', 'Agri Officer', 'active'),
(6, 'Sagni', 'K', 'sagni@gmail.com', '123456', 'Administrator', 'active'),
(7, 'tedros', 'h', 'tele@gmail.com', '123456', 'Tele Caller', 'active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `formers`
--
ALTER TABLE `formers`
  ADD PRIMARY KEY (`formerId`);

--
-- Indexes for table `informations`
--
ALTER TABLE `informations`
  ADD PRIMARY KEY (`infoId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `formers`
--
ALTER TABLE `formers`
  MODIFY `formerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `informations`
--
ALTER TABLE `informations`
  MODIFY `infoId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

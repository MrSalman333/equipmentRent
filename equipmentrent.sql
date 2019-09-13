-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2019 at 07:15 PM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `equipmentrent`
--

-- --------------------------------------------------------

--
-- Table structure for table `damage`
--

CREATE TABLE `damage` (
  `id` int(10) NOT NULL,
  `description` varchar(300) COLLATE utf8_bin NOT NULL,
  `equId` int(11) NOT NULL,
  `userId` int(12) NOT NULL,
  `rentId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `damage`
--

INSERT INTO `damage` (`id`, `description`, `equId`, `userId`, `rentId`) VALUES
(1, 'SOME DAMGE', 3321, 1100, 112),
(2, 'SOME DAMGE', 3321, 1100, 114),
(3, 'SOME DAMGE', 3321, 1100, 116),
(4, 'SOME DAMGE', 3321, 1100, 118),
(5, 'SOME DAMGE', 3321, 1100, 120),
(6, 'some damge', 3321, 1100, 122),
(7, 'oooops', 3321, 371100178, 125),
(8, 'SOME DAMGE', 3321, 1100, 124);

-- --------------------------------------------------------

--
-- Table structure for table `equipmentrent`
--

CREATE TABLE `equipmentrent` (
  `id` int(10) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `level` int(2) NOT NULL,
  `model` varchar(50) COLLATE utf8_bin NOT NULL,
  `available` tinyint(1) NOT NULL,
  `rentedBy` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `equipmentrent`
--

INSERT INTO `equipmentrent` (`id`, `name`, `level`, `model`, `available`, `rentedBy`) VALUES
(3321, 'cam', 2, '44524', 1, NULL),
(467308, 'canon', 2, 'pro', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `id` int(10) NOT NULL,
  `checkIn` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `checkOut` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `equId` int(4) NOT NULL,
  `userId` bigint(10) NOT NULL,
  `open` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`id`, `checkIn`, `checkOut`, `equId`, `userId`, `open`) VALUES
(100, '2019-09-07 13:57:28', '2019-09-07 13:57:27', 3321, 1100, 0),
(101, '2019-09-07 13:57:48', '2019-09-07 13:57:47', 3321, 1100, 0),
(102, '2019-09-07 14:12:11', '2019-09-07 14:12:10', 3321, 1100, 0),
(103, '2019-09-07 14:15:00', '2019-09-07 14:14:59', 3321, 1100, 0),
(104, '2019-09-07 14:15:53', '2019-09-07 14:15:52', 3321, 1100, 0),
(105, '2019-09-07 14:17:40', '2019-09-07 14:17:39', 3321, 1100, 0),
(106, '2019-09-07 14:18:51', '2019-09-07 14:18:50', 3321, 1100, 0),
(107, '2019-09-07 14:19:19', '2019-09-07 14:19:18', 3321, 1100, 0),
(108, '2019-09-07 15:34:59', '2019-09-07 15:34:58', 3321, 1100, 0),
(109, '2019-09-07 15:40:01', '2019-09-07 15:40:00', 3321, 1100, 0),
(110, '2019-09-07 15:41:54', '2019-09-07 15:40:01', 3321, 1100, 0),
(111, '2019-09-07 15:42:51', '2019-09-07 15:41:53', 3321, 1100, 0),
(112, '2019-09-07 15:42:51', '2019-09-07 15:41:54', 3321, 1100, 0),
(113, '2019-09-07 15:45:17', '2019-09-07 15:42:50', 3321, 1100, 0),
(114, '2019-09-07 15:45:17', '2019-09-07 15:42:51', 3321, 1100, 0),
(115, '2019-09-07 15:45:54', '2019-09-07 15:45:16', 3321, 1100, 0),
(116, '2019-09-07 15:45:54', '2019-09-07 15:45:17', 3321, 1100, 0),
(117, '2019-09-07 15:46:14', '2019-09-07 15:45:53', 3321, 1100, 0),
(118, '2019-09-07 15:46:14', '2019-09-07 15:45:54', 3321, 1100, 0),
(119, '2019-09-07 15:46:47', '2019-09-07 15:46:13', 3321, 1100, 0),
(120, '2019-09-07 15:46:47', '2019-09-07 15:46:14', 3321, 1100, 0),
(121, '2019-09-09 04:03:58', '2019-09-07 15:46:46', 3321, 1100, 0),
(122, '2019-09-09 04:03:59', '2019-09-07 15:46:47', 3321, 1100, 0),
(123, '2019-09-11 13:22:20', '2019-09-09 04:03:57', 3321, 1100, 0),
(124, '2019-09-11 13:22:20', '2019-09-09 04:03:58', 3321, 1100, 0),
(125, '2019-09-09 05:09:55', '2019-09-09 04:40:52', 3321, 371100178, 0),
(126, NULL, '2019-09-09 04:43:04', 3321, 371100178, 1),
(127, NULL, '2019-09-11 13:22:19', 3321, 1100, 1),
(128, NULL, '2019-09-11 13:22:20', 3321, 1100, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `keyId` bigint(18) NOT NULL,
  `jucId` bigint(10) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `level` int(2) NOT NULL,
  `phone` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`keyId`, `jucId`, `name`, `level`, `phone`) VALUES
(1, 1, 'admin', 99, '0555555'),
(387171236777292915, 371100178, '????? ???????', 5, '0537243511');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `damage`
--
ALTER TABLE `damage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `equipmentrent`
--
ALTER TABLE `equipmentrent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`keyId`),
  ADD UNIQUE KEY `jucId` (`jucId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `damage`
--
ALTER TABLE `damage`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2019 at 06:02 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

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
  `rentId` int(100) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `equipmentrent`
--

CREATE TABLE `equipmentrent` (
  `id` int(10) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `level` int(2) NOT NULL,
  `model` varchar(50) COLLATE utf8_bin NOT NULL,
  `available` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
(61, '2019-03-05 09:12:49', '2019-03-05 09:12:39', 32, -1633100204793221089, 0),
(62, '2019-03-05 09:13:05', '2019-03-05 09:12:55', 32, 7610739277820626250, 0),
(63, '2019-03-05 11:03:50', '2019-03-05 11:03:40', 32, 1654030894767275148, 0);

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
(1, 371100178, 'salman', 4, '0537243511'),
(58358032372303421, -3696894261130203420, 'salman new key', 43, '05'),
(121325709461542479, 2199287604571330523, 'salman new key', 43, '05'),
(139817439246540865, 37000178, 'salman new key', 43, '05'),
(164974896262521949, -6000795959654385231, 'salman new key', 43, '05'),
(184948404753201651, -640666768188263191, 'salman new key', 43, '05'),
(193930573608659755, 7709427749402723644, 'salman new key', 43, '05'),
(210372834825321022, 8511872008570444853, 'salman new key', 43, '05'),
(225274754954619215, -6646875574213723639, 'salman new key', 43, '05'),
(229467463926854140, 54692095518364737, 'salman new key', 43, '05'),
(236558202003862705, 8008558350083461995, 'salman new key', 43, '05'),
(244228134605596357, -5513777683656643570, 'salman new key', 43, '05'),
(258809247746103056, 5356613784283892839, 'salman new key', 43, '05'),
(301014632141280294, 8708910184980961085, 'salman new key', 43, '05'),
(324314919439236045, 371000178, 'salman new key', 43, '05'),
(395853745691232302, 1654030894767275148, 'salman new key', 43, '05'),
(446969928200196643, 2220280616463571139, 'salman new key', 43, '05'),
(455319771866523115, -2113271982287579285, 'salman new key', 43, '05'),
(512762962340972301, 112123, 'salman new key', 43, '05'),
(525592901794214435, 5161385246758231798, 'salman new key', 43, '05'),
(545606388380332021, -2480904387370099125, 'salman new key', 43, '05'),
(556926190783960982, 7610739277820626250, 'salman new key', 43, '05'),
(601981564870589933, -6404860065579097401, 'salman new key', 43, '05'),
(631586323854921049, 5881182080410309913, 'salman new key', 43, '05'),
(647847707380330692, 3154428608235567915, 'salman new key', 43, '05'),
(664188176615953763, -1987786233737628828, 'salman new key', 43, '05'),
(674013572504466751, -5332427331381161240, 'salman new key', 43, '05'),
(682456872497655947, 3029770324258851382, 'salman new key', 43, '05'),
(705202802288337000, -1912265524718457069, 'salman new key', 43, '05'),
(747351184821334918, 3704178, 'salman new key', 43, '05'),
(751444760406438059, 1048945790109284255, 'salman new key', 43, '05'),
(758421958277925429, 8848609946746255516, 'salman new key', 43, '05'),
(767344868066380249, -1633100204793221089, 'salman new key', 43, '05'),
(786939169201885024, -3895397936266539744, 'salman new key', 43, '05'),
(809743476251768903, 370004178, 'salman new key', 43, '05'),
(852299589200792211, 1884264562666749621, 'salman new key', 43, '05'),
(856109640228208889, -7918609369048552770, 'salman new key', 43, '05'),
(866059851569896836, -7450562529587271864, 'salman new key', 43, '05'),
(875483117535557222, 11123, 'salman new key', 43, '05'),
(896658919998167290, -4112832579397286620, 'salman new key', 43, '05'),
(897781284463789188, 405140817591825113, 'salman new key', 43, '05'),
(916551789235778894, -5603003810690289918, 'salman new key', 43, '05'),
(929057596596349092, 3012067956708384614, 'salman new key', 43, '05'),
(958894567302926871, 2098005212304318335, 'salman new key', 43, '05'),
(962475631743178769, 5218006545804142697, 'salman new key', 43, '05'),
(971943886427765300, 4327800380003895248, 'salman new key', 43, '05'),
(974260857486367811, 576186234532444930, 'salman new key', 43, '05'),
(975440943924356104, -5697556118782245978, 'salman new key', 43, '05');

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
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

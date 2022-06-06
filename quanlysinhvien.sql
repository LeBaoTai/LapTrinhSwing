-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2022 at 01:10 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlysinhvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblaccounts`
--

CREATE TABLE `tblaccounts` (
  `msUsername` varchar(20) NOT NULL,
  `msPassword` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblaccounts`
--

INSERT INTO `tblaccounts` (`msUsername`, `msPassword`) VALUES
('tai', '123'),
('admin', 'root');

-- --------------------------------------------------------

--
-- Table structure for table `tblthongtinsv`
--

CREATE TABLE `tblthongtinsv` (
  `msMssv` varchar(15) NOT NULL,
  `msHoTen` varchar(20) NOT NULL,
  `msLop` varchar(20) NOT NULL,
  `msKhoa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblthongtinsv`
--

INSERT INTO `tblthongtinsv` (`msMssv`, `msHoTen`, `msLop`, `msKhoa`) VALUES
('123456789', 'Test', 'Test', 'Test'),
('20108421', 'Doan Ngoc My Ngan', '16C-7510401', 'Cong Nghe Hoa Hoc'),
('3120410457', 'LB Tai', 'DCT1205', 'CNTT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblaccounts`
--
ALTER TABLE `tblaccounts`
  ADD PRIMARY KEY (`msPassword`);

--
-- Indexes for table `tblthongtinsv`
--
ALTER TABLE `tblthongtinsv`
  ADD PRIMARY KEY (`msMssv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2022 at 04:12 PM
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
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(5) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(5, 'admin', 'admin'),
(9, 'jod', 'jod'),
(12, 'mel', 'mel'),
(18, 'gg', 'gg');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(30) NOT NULL,
  `nama_customer` varchar(40) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_customer`, `nama_customer`, `alamat`, `telp`) VALUES
(10, 'ayam', 'rumahj', '123421'),
(12, 'orang', 'bumi', '666666'),
(13, 'meja', 'lantai', '213124');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_cucian`
--

CREATE TABLE `jenis_cucian` (
  `kd_jenis` int(11) NOT NULL,
  `jenis_cucian` varchar(30) NOT NULL,
  `harga` int(110) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_cucian`
--

INSERT INTO `jenis_cucian` (`kd_jenis`, `jenis_cucian`, `harga`) VALUES
(2, 'Cuci  + Setrika', 8000),
(3, 'Cuci + Parfum', 7500),
(4, 'Cuci Saja', 4500);

-- --------------------------------------------------------

--
-- Table structure for table `orderm`
--

CREATE TABLE `orderm` (
  `no_order` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `nama_customer` varchar(40) NOT NULL,
  `bayar` int(20) NOT NULL,
  `kd_jenis` int(11) NOT NULL,
  `jenis_cucian` varchar(40) NOT NULL,
  `harga` int(11) NOT NULL,
  `berat` int(11) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderm`
--

INSERT INTO `orderm` (`no_order`, `id_customer`, `nama_customer`, `bayar`, `kd_jenis`, `jenis_cucian`, `harga`, `berat`, `keterangan`, `status`) VALUES
(18, 12, 'ayam', 8000, 2, 'Cuci  + Setrika', 8000, 1, 'baju', 'Lunas'),
(19, 12, 'ayam', 4500, 2, 'Cuci  + Setrika', 8000, 1, 'baju', 'Belum Lunas'),
(20, 12, 'orang', 12000, 3, 'Cuci + Parfum', 7500, 2, '', 'Belum Lunas'),
(21, 12, 'orang', 3444, 4, 'Cuci Saja', 4500, 1, 'asd', 'Belum Lunas'),
(22, 13, 'meja', 9000, 4, 'Cuci Saja', 4500, 2, 'kursi', 'Lunas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indexes for table `jenis_cucian`
--
ALTER TABLE `jenis_cucian`
  ADD PRIMARY KEY (`kd_jenis`),
  ADD KEY `kd_jenis` (`kd_jenis`);

--
-- Indexes for table `orderm`
--
ALTER TABLE `orderm`
  ADD PRIMARY KEY (`no_order`),
  ADD KEY `id_pelanggan` (`id_customer`),
  ADD KEY `kd_jenis` (`kd_jenis`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `jenis_cucian`
--
ALTER TABLE `jenis_cucian`
  MODIFY `kd_jenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orderm`
--
ALTER TABLE `orderm`
  MODIFY `no_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

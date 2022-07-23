-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2022 at 05:17 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_hotel_12407`
--

-- --------------------------------------------------------

--
-- Table structure for table `cek_in`
--

CREATE TABLE `cek_in` (
  `Kode_tamu` char(12) NOT NULL,
  `Tgl_checkin` date NOT NULL,
  `Jam_checkin` time NOT NULL,
  `Kode_kamar` char(12) NOT NULL,
  `Posisi_kamar` varchar(12) NOT NULL,
  `Lama_inap` int(2) DEFAULT NULL,
  `Harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cek_in`
--

INSERT INTO `cek_in` (`Kode_tamu`, `Tgl_checkin`, `Jam_checkin`, `Kode_kamar`, `Posisi_kamar`, `Lama_inap`, `Harga`) VALUES
('pelanggan002', '2022-07-01', '15:00:00', 'kamar-B-0001', 'Lantai 2', 3, 2550000);

-- --------------------------------------------------------

--
-- Table structure for table `cek_out`
--

CREATE TABLE `cek_out` (
  `Kode_tamu` char(12) NOT NULL,
  `Tgl_checkout` date NOT NULL,
  `Jam_checkout` time NOT NULL,
  `Kode_kamar` char(12) NOT NULL,
  `Lama_inap` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cek_out`
--

INSERT INTO `cek_out` (`Kode_tamu`, `Tgl_checkout`, `Jam_checkout`, `Kode_kamar`, `Lama_inap`) VALUES
('pelanggan001', '2022-07-02', '09:00:00', 'kamar-A-0001', 2);

-- --------------------------------------------------------

--
-- Table structure for table `kamar`
--

CREATE TABLE `kamar` (
  `Kode_kamar` char(12) NOT NULL,
  `Nama_kamar` varchar(40) DEFAULT NULL,
  `Kelas` char(1) DEFAULT NULL,
  `Harga` int(12) DEFAULT NULL,
  `Fasilitas` varchar(25) DEFAULT NULL,
  `Posisi_kamar` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kamar`
--

INSERT INTO `kamar` (`Kode_kamar`, `Nama_kamar`, `Kelas`, `Harga`, `Fasilitas`, `Posisi_kamar`) VALUES
('kamar-A-0001', 'Kamar 01 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0002', 'Kamar 02 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0003', 'Kamar 03 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0004', 'Kamar 04 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0005', 'Kamar 05 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0006', 'Kamar 06 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0007', 'Kamar 07 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0008', 'Kamar 08 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0009', 'Kamar 09 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-A-0010', 'Kamar 10 Kelas A', 'A', 1200000, 'Family Bed', 'Lantai 1'),
('kamar-B-0002', 'Kamar 02 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0003', 'Kamar 03 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0004', 'Kamar 04 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0005', 'Kamar 05 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0006', 'Kamar 06 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0007', 'Kamar 07 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0008', 'Kamar 08 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0009', 'Kamar 09 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-B-0010', 'Kamar 10 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2'),
('kamar-C-0001', 'Kamar 01 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0002', 'Kamar 02 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0003', 'Kamar 03 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0004', 'Kamar 04 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0005', 'Kamar 05 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0006', 'Kamar 06 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0007', 'Kamar 07 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0008', 'Kamar 08 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0009', 'Kamar 09 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3'),
('kamar-C-0010', 'Kamar 10 Kelas C', 'C', 500000, 'Single-bed', 'Lantai 3');

-- --------------------------------------------------------

--
-- Table structure for table `kamar_terisi`
--

CREATE TABLE `kamar_terisi` (
  `Kode_kamar` char(12) NOT NULL,
  `Nama_kamar` varchar(40) DEFAULT NULL,
  `Kelas` char(1) DEFAULT NULL,
  `Harga` int(12) DEFAULT NULL,
  `Fasilitas` varchar(25) DEFAULT NULL,
  `Posisi_kamar` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kamar_terisi`
--

INSERT INTO `kamar_terisi` (`Kode_kamar`, `Nama_kamar`, `Kelas`, `Harga`, `Fasilitas`, `Posisi_kamar`) VALUES
('kamar-B-0001', 'Kamar 01 Kelas B', 'B', 850000, 'Double-bed', 'Lantai 2');

-- --------------------------------------------------------

--
-- Table structure for table `laporan`
--

CREATE TABLE `laporan` (
  `kamarA_terisi` int(11) DEFAULT NULL,
  `kamarB_terisi` int(11) DEFAULT NULL,
  `kamarC_terisi` int(11) DEFAULT NULL,
  `kamarA_kosong` int(11) DEFAULT NULL,
  `kamarB_kosong` int(11) DEFAULT NULL,
  `kamarC_kosong` int(11) DEFAULT NULL,
  `Pendapatan_keuangan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laporan`
--

INSERT INTO `laporan` (`kamarA_terisi`, `kamarB_terisi`, `kamarC_terisi`, `kamarA_kosong`, `kamarB_kosong`, `kamarC_kosong`, `Pendapatan_keuangan`) VALUES
(0, 1, 0, 10, 9, 10, 5450000);

-- --------------------------------------------------------

--
-- Table structure for table `tamu`
--

CREATE TABLE `tamu` (
  `Kode_tamu` char(12) NOT NULL,
  `Nama_tamu` varchar(50) NOT NULL,
  `Jns_kel` char(1) NOT NULL,
  `Usia` int(2) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tamu`
--

INSERT INTO `tamu` (`Kode_tamu`, `Nama_tamu`, `Jns_kel`, `Usia`, `alamat`) VALUES
('pelanggan001', 'Bambang', 'L', 28, 'Bogor'),
('pelanggan002', 'Budi', 'L', 26, 'Gorontalo'),
('pelanggan003', 'Santi', 'P', 21, 'Semarang'),
('pelanggan004', 'Dewi', 'P', 24, 'Jakarta'),
('pelanggan005', 'Reyhan', 'L', 20, 'Pekalongan'),
('pelanggan006', 'Paijo', 'L', 30, 'Semarang'),
('pelanggan007', 'Susi', 'P', 18, 'Pekuncen');

-- --------------------------------------------------------

--
-- Table structure for table `temporary_checkin`
--

CREATE TABLE `temporary_checkin` (
  `Kode_tamu` char(12) DEFAULT NULL,
  `Nama_tamu` varchar(45) DEFAULT NULL,
  `Jns_kel` char(1) DEFAULT NULL,
  `Usia` char(2) DEFAULT NULL,
  `Tgl_checkin` date DEFAULT NULL,
  `Jam_checkin` time DEFAULT NULL,
  `Kode_kamar` char(12) DEFAULT NULL,
  `Kelas_kamar` char(1) DEFAULT NULL,
  `Harga` int(12) DEFAULT NULL,
  `Lama_inap` int(2) DEFAULT NULL,
  `fasilitas` varchar(20) DEFAULT NULL,
  `Posisi_kamar` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `temporary_checkout`
--

CREATE TABLE `temporary_checkout` (
  `Kode_tamu` char(12) DEFAULT NULL,
  `Nama_tamu` varchar(45) DEFAULT NULL,
  `Jns_kel` char(1) DEFAULT NULL,
  `Usia` char(2) DEFAULT NULL,
  `Tgl_checkout` date DEFAULT NULL,
  `Jam_checkout` time DEFAULT NULL,
  `Kode_kamar` char(12) DEFAULT NULL,
  `Kelas_kamar` char(1) DEFAULT NULL,
  `Harga` int(12) DEFAULT NULL,
  `Lama_inap` int(2) DEFAULT NULL,
  `fasilitas` varchar(20) DEFAULT NULL,
  `Posisi_kamar` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cek_in`
--
ALTER TABLE `cek_in`
  ADD PRIMARY KEY (`Kode_tamu`);

--
-- Indexes for table `cek_out`
--
ALTER TABLE `cek_out`
  ADD PRIMARY KEY (`Kode_tamu`);

--
-- Indexes for table `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`Kode_kamar`);

--
-- Indexes for table `kamar_terisi`
--
ALTER TABLE `kamar_terisi`
  ADD PRIMARY KEY (`Kode_kamar`);

--
-- Indexes for table `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`Pendapatan_keuangan`);

--
-- Indexes for table `tamu`
--
ALTER TABLE `tamu`
  ADD PRIMARY KEY (`Kode_tamu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

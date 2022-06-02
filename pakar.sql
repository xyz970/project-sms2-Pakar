-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2022 at 11:06 PM
-- Server version: 10.5.12-MariaDB-0+deb11u1
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pakar`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `nama_admin` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Username`, `Password`, `nama_admin`) VALUES
('smkn6', '123', 'Mustofa');

-- --------------------------------------------------------

--
-- Table structure for table `backup_presensi`
--

CREATE TABLE `backup_presensi` (
  `id` varchar(35) NOT NULL,
  `tanggal` date NOT NULL,
  `karyawan_nik` varchar(20) NOT NULL,
  `keterangan` enum('Hadir','Tidak Hadir','Lembur','Sakit','Izin') NOT NULL DEFAULT 'Tidak Hadir',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `backup_presensi`
--

INSERT INTO `backup_presensi` (`id`, `tanggal`, `karyawan_nik`, `keterangan`, `created_at`) VALUES
('2022-06-01_341229478334', '2022-06-01', '341229478334', 'Hadir', '2022-06-01 08:31:39'),
('2022-06-01_351110002', '2022-06-01', '351110002', 'Hadir', '2022-06-01 08:29:58'),
('2022-06-01_9892486293', '2022-06-01', '9892486293', 'Sakit', '2022-06-01 08:30:24'),
('2022-06-20_351110002', '2022-06-20', '351110002', 'Sakit', '2022-06-01 14:32:01'),
('2022-06-21_351110002', '2022-06-21', '351110002', 'Hadir', '2022-06-01 14:25:24'),
('2022-06-30_351110002', '2022-06-30', '351110002', 'Sakit', '2022-06-01 14:32:48');

-- --------------------------------------------------------

--
-- Table structure for table `detail_presensi`
--

CREATE TABLE `detail_presensi` (
  `id_presensi` varchar(35) NOT NULL,
  `id_jenis_presensi` varchar(8) NOT NULL,
  `jam` time NOT NULL,
  `keterangan` enum('Tepat Waktu','Toleransi','Terlambat') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_presensi`
--

INSERT INTO `detail_presensi` (`id_presensi`, `id_jenis_presensi`, `jam`, `keterangan`) VALUES
('2022-06-01_351110002', 'LMBR', '15:42:27', 'Toleransi'),
('2022-06-01_341229478334', 'LMBR', '21:13:23', 'Toleransi'),
('2022-06-01_9892486293', 'LMBR', '21:13:44', 'Toleransi');

--
-- Triggers `detail_presensi`
--
DELIMITER $$
CREATE TRIGGER `change_status` AFTER INSERT ON `detail_presensi` FOR EACH ROW UPDATE presensi set keterangan = "Hadir" WHERE id = (SELECT id_presensi FROM detail_presensi where id_presensi = new.id_presensi AND id_jenis_presensi = "DTG")
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `check_duplicate` BEFORE INSERT ON `detail_presensi` FOR EACH ROW IF(EXISTS(SELECT 1 from detail_presensi WHERE id_presensi = new.id_presensi AND id_jenis_presensi = new.id_jenis_presensi))
THEN
SIGNAL SQLSTATE VALUE '45000' SET MESSAGE_TEXT = 'Anda Telah melakukan presensi di jam sekarang';
   END IF
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `check_if_else_present` BEFORE INSERT ON `detail_presensi` FOR EACH ROW IF((SELECT keterangan from presensi WHERE id = new.id_presensi) != "Hadir" )
THEN
SIGNAL SQLSTATE VALUE '45000' SET MESSAGE_TEXT = 'Lembur tidak tersedia, dikarenakan anda tidak presensi pada hari itu';
   END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id` int(11) NOT NULL,
  `keterangan` varchar(30) NOT NULL,
  `status_kepeguruan` enum('Honorer','Tidak dicantumkan') NOT NULL DEFAULT 'Tidak dicantumkan' COMMENT 'Isi jika jabatan guru, jika tidak maka tulis Tidak dicantumkan'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id`, `keterangan`, `status_kepeguruan`) VALUES
(1, 'Guru', 'Honorer'),
(2, 'Satpam', 'Tidak dicantumkan'),
(3, 'Karyawan', 'Tidak dicantumkan');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_libur`
--

CREATE TABLE `jadwal_libur` (
  `id` varchar(20) NOT NULL,
  `hari` enum('Senin','Selasa','Rabu','Kamis','Jumat','Sabtu','Minggu') NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jadwal_libur`
--

INSERT INTO `jadwal_libur` (`id`, `hari`, `tanggal`, `keterangan`) VALUES
('Gatau', 'Sabtu', '2022-06-18', 'Gatau kok'),
('ghsd', 'Jumat', '2022-05-25', 'dsadjh'),
('ISALMSH', 'Kamis', '2022-05-25', 'Wafat Isa Al-Masih'),
('TB', 'Jumat', '2022-05-27', 'sdahjksdhkjsahd');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_presensi`
--

CREATE TABLE `jenis_presensi` (
  `id` varchar(8) NOT NULL,
  `ket_jenis_presensi` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenis_presensi`
--

INSERT INTO `jenis_presensi` (`id`, `ket_jenis_presensi`) VALUES
('DTG', 'Masuk'),
('ISTRHT1', 'Istirahat '),
('ISTRHT2', 'Istirahat Pulang'),
('LMBR', 'Lembur'),
('PLNG', 'Pulang');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jabatan` varchar(11) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `alamat` text NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `card_code` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`nik`, `nama`, `jabatan`, `jenis_kelamin`, `alamat`, `no_hp`, `card_code`) VALUES
('341229478334', 'Nabila', 'Guru', 'P', 'Situbondo', '9023198341', '1511723524'),
('351110002', 'Adi', 'Guru', 'L', 'ahf', '9023109283', '0604933637'),
('9892486293', 'Malik', 'Guru', 'P', 'LMJ', '972398174', '0008751621');

-- --------------------------------------------------------

--
-- Table structure for table `presensi`
--

CREATE TABLE `presensi` (
  `id` varchar(35) NOT NULL,
  `tanggal` date NOT NULL,
  `karyawan_nik` varchar(20) NOT NULL,
  `keterangan` enum('Hadir','Tidak Hadir','Lembur','Sakit','Izin') NOT NULL DEFAULT 'Tidak Hadir',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `presensi`
--

INSERT INTO `presensi` (`id`, `tanggal`, `karyawan_nik`, `keterangan`, `created_at`) VALUES
('2022-06-01_341229478334', '2022-06-01', '341229478334', 'Hadir', '2022-06-01 08:31:39'),
('2022-06-01_351110002', '2022-06-01', '351110002', 'Hadir', '2022-06-01 08:29:58'),
('2022-06-01_9892486293', '2022-06-01', '9892486293', 'Sakit', '2022-06-01 08:30:24'),
('2022-06-20_351110002', '2022-06-20', '351110002', 'Sakit', '2022-06-01 14:32:01'),
('2022-06-21_351110002', '2022-06-21', '351110002', 'Hadir', '2022-06-01 14:25:24'),
('2022-06-30_351110002', '2022-06-30', '351110002', 'Sakit', '2022-06-01 14:32:48');

--
-- Triggers `presensi`
--
DELIMITER $$
CREATE TRIGGER `insert_backup_items` BEFORE INSERT ON `presensi` FOR EACH ROW INSERT into `backup_presensi`(`id`, `tanggal`, `karyawan_nik`, `keterangan`) VALUES (new.id, new.tanggal,new.karyawan_nik,new.keterangan)
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_backup_presensi` AFTER UPDATE ON `presensi` FOR EACH ROW UPDATE backup_presensi SET keterangan = new.keterangan WHERE id = old.id
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `backup_presensi`
--
ALTER TABLE `backup_presensi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `karyawan_nik` (`karyawan_nik`);

--
-- Indexes for table `detail_presensi`
--
ALTER TABLE `detail_presensi`
  ADD KEY `id_presensi` (`id_presensi`),
  ADD KEY `id_jenis_presensi` (`id_jenis_presensi`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jadwal_libur`
--
ALTER TABLE `jadwal_libur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jenis_presensi`
--
ALTER TABLE `jenis_presensi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `presensi`
--
ALTER TABLE `presensi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `karyawan_nik` (`karyawan_nik`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_presensi`
--
ALTER TABLE `detail_presensi`
  ADD CONSTRAINT `detail_presensi_ibfk_1` FOREIGN KEY (`id_presensi`) REFERENCES `presensi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_presensi_ibfk_2` FOREIGN KEY (`id_jenis_presensi`) REFERENCES `jenis_presensi` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `presensi`
--
ALTER TABLE `presensi`
  ADD CONSTRAINT `presensi_ibfk_1` FOREIGN KEY (`karyawan_nik`) REFERENCES `karyawan` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

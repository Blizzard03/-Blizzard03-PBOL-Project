-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versi server:                 8.0.30 - MySQL Community Server - GPL
-- OS Server:                    Win64
-- HeidiSQL Versi:               12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Membuang struktur basisdata untuk database_pbol_uts
CREATE DATABASE IF NOT EXISTS `database_pbol_uts` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `database_pbol_uts`;

-- membuang struktur untuk table database_pbol_uts.cooler
CREATE TABLE IF NOT EXISTS `cooler` (
  `ID_COOLER` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nama_Cooler` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Socket` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_COOLER`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.cooler: ~12 rows (lebih kurang)
DELETE FROM `cooler`;
INSERT INTO `cooler` (`ID_COOLER`, `Nama_Cooler`, `Type`, `Socket`, `Harga`) VALUES
	('CM_ABT2', 'Cooling Master BLIZZARD T2', 'Air Cooling', 'AM4', 250000),
	('CM_AH212-T', 'Cooling Master Hyper 212 LED Turbo', 'Air Cooling', 'AM4', 430000),
	('CM_AHT4', 'Cooling Master Hyper T4', 'Air Cooling', 'AM4', 420000),
	('CM_L120', 'Cooling Master MasterLiquid 120', 'Liquid Cooling', 'AM4', 450000),
	('CM_L240', 'Cooling Master MasterLiquid 240', 'Liquid Cooling', 'AM4', 1345000),
	('CM_Lt_120', 'Cooling Master MasterLiquid Lite 120', 'Liquid Cooling', 'AM4', 650000),
	('MSI-MAG-C360A', 'MSI MAG CORELIQUID C360', 'Liquid Cooling', 'AM4', 1930000),
	('MSI-MAG-C360I', 'MSI MAG CORELIQUID C360', 'Liquid Cooling', 'LGA 1700', 1930000),
	('MSI-MAGP40I', 'MSI MAG CORELIQUID P240', 'Liquid Cooling', 'LGA 1700', 1400000),
	('MSI-MEG-S360A', 'MSI MEG CORELIQUID S360', 'Liquid Cooling', 'AM4', 4200000),
	('MSI-MEG-S360I', 'MSI MEG CORELIQUID S360', 'Liquid Cooling', 'LGA 1700', 4200000),
	('MSI-MPG-K360', 'MSI MPG CORELIQUID K360', 'Liquid Cooling', 'AM4', 3000000);

-- membuang struktur untuk table database_pbol_uts.cpu
CREATE TABLE IF NOT EXISTS `cpu` (
  `ID_CPU` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nama_CPU` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Socket` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Base_Clock` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0 GHz',
  `Max_Turbo_Clock` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'Up to 0 Ghz',
  `Cores` int DEFAULT NULL,
  `Thread` int DEFAULT NULL,
  `TDP` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0 W',
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_CPU`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.cpu: ~30 rows (lebih kurang)
DELETE FROM `cpu`;
INSERT INTO `cpu` (`ID_CPU`, `Nama_CPU`, `Socket`, `Base_Clock`, `Max_Turbo_Clock`, `Cores`, `Thread`, `TDP`, `Harga`) VALUES
	('AMD_R55500', 'AMD Ryzen™ 5 5500', 'AM4', '3.6 GHz', 'Up to 4.2 Ghz', 6, 12, '65 W', 2500000),
	('AMD_R55600', 'AMD Ryzen™ 5 5600', 'AM4', '3.5 GHz', 'Up to 4.4 Ghz', 6, 12, '65 W', 3200000),
	('AMD_R55600X', 'AMD Ryzen™ 5 5600X', 'AM4', '3.7 GHz', 'Up to 4.6 Ghz', 6, 12, '65 W', 3200000),
	('AMD_R56000G', 'AMD Ryzen™ 5 5600G', 'AM4', '3.9 GHz', 'Up to 4.4 Ghz', 6, 12, '65 W', 2550000),
	('AMD_R57600X', 'AMD Ryzen™ 5 7600X', 'AM5', '4.7 GHz', 'Up to 5.3 Ghz', 6, 12, '105 W', 5180000),
	('AMD_R75700G', 'AMD Ryzen™ 7 5700G', 'AM4', '3.8 GHz', 'Up to 4.6 Ghz', 8, 16, '65 W', 3950000),
	('AMD_R75700X', 'AMD Ryzen™ 7 5700X', 'AM4', '3.4 GHz', 'Up to 4.6 Ghz', 8, 16, '65 W', 3600000),
	('AMD_R75800X', 'AMD Ryzen™ 7 5800X', 'AM4', '3.8GHz', 'Up to 4.7 Ghz', 8, 16, '105 W', 7500000),
	('AMD_R75800X3D', 'AMD Ryzen™ 7 5800X3D', 'AM4', '3.4 GHz', 'Up to 4.5 Ghz', 8, 16, '105 W', 7000000),
	('AMD_R7700X', 'AMD Ryzen™ 7 7700X', 'AM5', '4.5 GHz', 'Up to 5.4 Ghz', 8, 16, '105 W', 6890000),
	('AMD_R95900X', 'AMD Ryzen™ 9 5900X', 'AM4', '3.7 GHz', 'Up to 4.8 Ghz', 12, 24, '105 W', 9100000),
	('AMD_R95950X', 'AMD Ryzen™ 9 5950X', 'AM4', '3.4 GHz', 'Up to 4.9 Ghz', 16, 32, '105 W', 9845000),
	('AMD_R97900X', ' AMD Ryzen™ 9 7900X', 'AM5', '4.7 GHz', 'Up to 5.6 Ghz', 12, 24, '170 W', 9490000),
	('AMD_R97950X', 'AMD Ryzen™ 9 7950X', 'AM4', '4.5 GHz', 'Up to 5.7 Ghz', 16, 32, '170 W', 11990000),
	('INTEL_i312100', 'Intel Core i3-12100', 'LGA 1700', '3.3GHz', 'Up to 4.3 Ghz', 4, 8, '60 W', 1875000),
	('INTEL_i312100T', 'Intel Core i3-12100T', 'LGA 1700', '2.2 GHz', 'Up to 4.1 Ghz', 4, 8, '35 W', 1885000),
	('INTEL_i312300', 'Intel Core i3-12300', 'LGA 1700', '3.5 GHz', 'Up to 4.3 Ghz', 4, 8, '60 W', 2125000),
	('INTEL_i3_12300T', 'Intel Core i3-12300T', 'LGA 1700', '2.3 GHz', 'Up to 4.2 Ghz', 4, 8, '35 W', 989632),
	('INTEL_i512400', 'Intel Core i5-12400', 'LGA 1700', '2.5 GHz', 'Up to 4.4 Ghz', 6, 12, '65 W', 2777000),
	('INTEL_i512500', 'Intel Core i5-12500', 'LGA 1700', '3.0 GHz', 'Up to 4.6 Ghz', 6, 12, '65 W', 3282000),
	('INTEL_i512600', 'Intel Core i5-12600', 'LGA 1700', '3.3 GHz', 'Up to 4.8 Ghz', 6, 12, '65 W', 3740000),
	('INTEL_i5_12400T', 'Intel Core i5-12400T', 'LGA 1700', '1.8 GHz', 'Up to 4.2 Ghz', 6, 12, '35 W', 2877000),
	('INTEL_i5_12500T', 'Intel Core i5-12500T', 'LGA 1700', '2.0 GHz', 'Up to 4.4 Ghz', 6, 12, '35 W', 3382000),
	('INTEL_i5_12600T', 'Intel Core i5-12600T', 'LGA 1700', '2.1 GHz', 'Up to 4.6 Ghz', 6, 12, '35 W', 3740000),
	('INTEL_i5_13600K', 'Intel Core i5-13600K', 'LGA 1700', ' 3.5 GHz', 'Up to 5.1 Ghz', 14, 20, '181 W', 5650000),
	('INTEL_i5_13600KF', 'Intel Core i5-13600KF', 'LGA 1700', '3.5 GHz', 'Up to 5.1 Ghz', 14, 20, '181 W', 6450000),
	('INTEL_i712700', 'Intel Core i7-12700', 'LGA 1700', '2.1 GHz', 'Up to 4.8 Ghz', 12, 20, '65 W', 5175000),
	('INTEL_i7_12700T', 'Intel Core i7-12700T', 'LGA 1700', '1.4 GHz', 'Up to 4.6 Ghz', 12, 20, '35 W', 5275000),
	('INTEL_i912900', 'Intel Core i9-12900', 'LGA 1700', '2.4 GHz', 'Up to 5.0 Ghz', 16, 24, '65 W', 7949000),
	('INTEL_i9_12900T', 'Intel Core i9-12900T', 'LGA 1700', '1.4 GHz', 'Up to 4.8 Ghz', 16, 24, '35 W', 8500000);

-- membuang struktur untuk table database_pbol_uts.detail_cpu
CREATE TABLE IF NOT EXISTS `detail_cpu` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_CPU` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_detail_CPU_ID_CPU` (`ID_CPU`),
  CONSTRAINT `FK_Detail_CPU_ID_CPU` FOREIGN KEY (`ID_CPU`) REFERENCES `cpu` (`ID_CPU`),
  CONSTRAINT `FK_Detail_CPU_Nomor_Transakasi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_cpu: ~0 rows (lebih kurang)
DELETE FROM `detail_cpu`;

-- membuang struktur untuk table database_pbol_uts.detail_gpu
CREATE TABLE IF NOT EXISTS `detail_gpu` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_GPU` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_Detail_GPU_ID_GPU` (`ID_GPU`) USING BTREE,
  CONSTRAINT `FK_Detail_GPU_ID_GPU` FOREIGN KEY (`ID_GPU`) REFERENCES `gpu` (`ID_GPU`),
  CONSTRAINT `FK_Detail_GPU_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_gpu: ~0 rows (lebih kurang)
DELETE FROM `detail_gpu`;

-- membuang struktur untuk table database_pbol_uts.detail_mother_board
CREATE TABLE IF NOT EXISTS `detail_mother_board` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_MOTHER_BOARD` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_Detail_Mother_Board_ID_MOTHER_BOARD` (`ID_MOTHER_BOARD`) USING BTREE,
  CONSTRAINT `FK_Detail_Mother_Board_ID_MOTHER_BOARD` FOREIGN KEY (`ID_MOTHER_BOARD`) REFERENCES `mother_board` (`ID_MOTHER_BOARD`),
  CONSTRAINT `FK_Detail_Mother_Board_Nomor_Transasksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_mother_board: ~0 rows (lebih kurang)
DELETE FROM `detail_mother_board`;

-- membuang struktur untuk table database_pbol_uts.detail_ssd
CREATE TABLE IF NOT EXISTS `detail_ssd` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_SSD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_Detail_SSD_ID_SSD` (`ID_SSD`) USING BTREE,
  CONSTRAINT `FK_Detail_SSD_ID_SSD` FOREIGN KEY (`ID_SSD`) REFERENCES `ssd` (`ID_SSD`),
  CONSTRAINT `FK_Detail_SSD_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_ssd: ~0 rows (lebih kurang)
DELETE FROM `detail_ssd`;

-- membuang struktur untuk table database_pbol_uts.detai_cooler
CREATE TABLE IF NOT EXISTS `detai_cooler` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_COOLER` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_Detail_RAM_ID_RAM` (`ID_COOLER`) USING BTREE,
  CONSTRAINT `FK_Detail_Cooler_ID_COOLER` FOREIGN KEY (`ID_COOLER`) REFERENCES `cooler` (`ID_COOLER`),
  CONSTRAINT `FK_Detail_Cooler_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detai_cooler: ~0 rows (lebih kurang)
DELETE FROM `detai_cooler`;

-- membuang struktur untuk table database_pbol_uts.detai_power_supply
CREATE TABLE IF NOT EXISTS `detai_power_supply` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_PSU` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_Detail_RAM_ID_RAM` (`ID_PSU`) USING BTREE,
  CONSTRAINT `detai_power_supply_ibfk_1` FOREIGN KEY (`ID_PSU`) REFERENCES `cooler` (`ID_COOLER`),
  CONSTRAINT `detai_power_supply_ibfk_2` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detai_power_supply: ~0 rows (lebih kurang)
DELETE FROM `detai_power_supply`;

-- membuang struktur untuk table database_pbol_uts.detai_ram
CREATE TABLE IF NOT EXISTS `detai_ram` (
  `Nomor_Transaksi` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_RAM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`),
  KEY `FK_Detail_RAM_ID_RAM` (`ID_RAM`),
  CONSTRAINT `FK_Detail_RAM_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`),
  CONSTRAINT `FKDetail_RAM_ID_RAM` FOREIGN KEY (`ID_RAM`) REFERENCES `ram` (`ID_RAM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.detai_ram: ~0 rows (lebih kurang)
DELETE FROM `detai_ram`;

-- membuang struktur untuk table database_pbol_uts.gpu
CREATE TABLE IF NOT EXISTS `gpu` (
  `ID_GPU` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Vendor` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Nama_GPU` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `VRAM` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' GB',
  `Memory_Type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'GDDR ',
  `Frequency` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' MHz',
  `GDP` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' W',
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_GPU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.gpu: ~23 rows (lebih kurang)
DELETE FROM `gpu`;
INSERT INTO `gpu` (`ID_GPU`, `Vendor`, `Nama_GPU`, `VRAM`, `Memory_Type`, `Frequency`, `GDP`, `Harga`) VALUES
	('AMD_Radeon_RX_6400', 'AMD', 'AMD Radeon™ RX 6400', '4 GB', 'GDDR 6', '2039 MHz', '35 W', 2437760),
	('AMD_Radeon_RX_6500_XT', 'AMD', 'AMD Radeon™ RX 6500 XT', '8 GB', 'GDDR 6', '2650 MHz', '113 W', 3047200),
	('AMD_Radeon_RX_6600_XT', 'AMD', 'AMD Radeon™ RX 6600 XT', '8 GB', 'GDDR 6', '2359 MHz', '160 W', 5789680),
	('AMD_Radeon_RX_6650_XT', 'AMD', 'AMD Radeon™ RX 6650 XT', '8 GB', 'GDDR 6', '2410 MHz', '180W', 6094400),
	('AMD_Radeon_RX_6700', 'AMD', 'AMD Radeon™ RX 6700', '10 GB', 'GDDR 6', '2174 MHz', '175 W', 7450000),
	('AMD_Radeon_RX_6700_XT', 'AMD', 'AMD Radeon™ RX 6700 XT', '12 GB', 'GDDR 6', '2424 MHz', '230 W', 7500000),
	('AMD_Radeon_RX_6750_XT', 'AMD', 'AMD Radeon™ RX 6750 XT', '12 GB', 'GDDR 6', '2495 MHz', '250 W', 8600000),
	('AMD_Radeon_RX_6800', 'AMD', 'AMD Radeon™ RX 6800', '16 GB', 'GDDR 6', '1815 MHz', '250 W', 8965645),
	('AMD_Radeon_RX_6800_XT', 'AMD', 'AMD Radeon™ RX 6800 XT', '16 GB', 'GDDR 6', '2015 MHz', '300 W', 10047700),
	('AMD_Radeon_RX_6900_XT', 'AMD', 'AMD Radeon™ RX 6900 XT', '16 GB', 'GDDR 6', '2015 MHz', '300 W', 15458000),
	('AMD_Radeon_RX_6950_XT', 'AMD', 'AMD Radeon™ RX 6950 XT', '16 GB', 'GDDR 6', '2100 MHz', '335 W', 17005900),
	('AMD_Radon_RX_6600', 'AMD', 'AMD Radeon™ RX 6600', '8 GB', 'GDDR 6', '2044 MHz', '132 W', 5102000),
	('NVDIA_RTX_4070', 'NVIDIA', 'NVIDIA Geforce RTX 4070', '12 GB', 'GDDR 6X', '2310 MHz', '285 W', 7618000),
	('NVIDIA_RTX3050', 'NVIDIA', 'NVIDIA GeForce RTX 3050', '4 GB', 'GDDR 6', '1777 Mhz\r\n', '130 W', 3808848),
	('NVIDIA_RTX3060', 'NVIDIA', 'NVIDIA GeForce RTX 3060', '12 GB', 'GDDR 6', '1777 Mhz', '170 W', 5012644),
	('NVIDIA_RTX3060_Ti', 'NVIDIA', 'NVIDIA Geforce RTX 3060 Ti', '8 GB', 'GDDR 6', '2250 MHz', '200 W', 6079164),
	('NVIDIA_RTX3070', 'NVIDIA', 'NVIDIA Geforce RTX 3070', '8 GB', 'GDDR 6', '2240 MHz', '220 W', 7602764),
	('NVIDIA_RTX_3070_Ti', 'NVIDIA', 'NVIDIA Geforce RTX 3070 Ti', '8 GB', 'GDDR 6X', '2105 MHz', '290 W', 9126364),
	('NVIDIA_RTX_3080', 'NVIDIA', 'NVIDIA Geforce RTX 3080', '10 GB', 'GDDR 6X', '2581 MHz', '320 W', 10649964),
	('NVIDIA_RTX_3090', 'NVIDIA', 'NVIDIA Geforce RTX 3090', '24 GB', 'GDDR 6X', '2491 MHz', '350 W', 19791564),
	('NVIDIA_RTX_4060', 'NVIDIA', 'NVIDIA Geforce RTX 4060', '8 GB', 'GDDR 6/X', '2505 MHz', '200 W', 5027880),
	('NVIDIA_RTX_4080_12GB', 'NVIDIA', 'NVIDIA Geforce RTX 4080 12GB', '12 GB', 'GDDR 6X', '2610 MHz', '285 W', 13697164),
	('NVIDIA_RTX_4080_16_GB', 'NVIDIA', 'NVIDIA Geforce RTX 4080 16GB', '16 GB', 'GDDR 6X', '2510  MHz', '320 W', 18267964);

-- membuang struktur untuk table database_pbol_uts.mother_board
CREATE TABLE IF NOT EXISTS `mother_board` (
  `ID_MOTHER_BOARD` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Vendor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Nama_Mother_Board` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Type` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Socket` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_MOTHER_BOARD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.mother_board: ~6 rows (lebih kurang)
DELETE FROM `mother_board`;
INSERT INTO `mother_board` (`ID_MOTHER_BOARD`, `Vendor`, `Nama_Mother_Board`, `Type`, `Socket`, `Harga`) VALUES
	('MSI_MAG A520M BAZOOKA WIFI', 'MSI', 'MAG A520M BAZOOKA WIFI', 'M-ATX', 'AM4', 1800000),
	('MSI_MAG A520M VECTOR WIFI', 'MSI', 'MAG A520M VECTOR WIFI', 'M-ATX', 'AM4', 1500000),
	('MSI_MAG B660 Tomahawk Wifi DDR4', 'MSI', 'MAG B660 Tomahawk Wifi DDR4', 'ATX', 'LGA 1700', 4300000),
	('MSI_MAG B660M Mortar Wifi DDR4', 'MSI', 'MAG B660M Mortar Wifi DDR4', 'ATX', 'LGA 1700', 3600000),
	('MSI_MAG X570S Tomahawk MAX Wifi', 'MSI', 'MAG X570S Tomahawk MAX Wifi', 'ATX', 'AM4', 4800000),
	('MSI_MPG Z690 FORCE WIFI ', 'MSI', ' MPG Z690 FORCE WIFI ', 'ATX', 'LGA 1700', 6850000);

-- membuang struktur untuk table database_pbol_uts.power_supply
CREATE TABLE IF NOT EXISTS `power_supply` (
  `ID_PSU` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Vendor` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Nama_PSU` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Watt` int DEFAULT NULL,
  `Tier` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_PSU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.power_supply: ~19 rows (lebih kurang)
DELETE FROM `power_supply`;
INSERT INTO `power_supply` (`ID_PSU`, `Vendor`, `Nama_PSU`, `Watt`, `Tier`, `Harga`) VALUES
	('ASUS_ROG-STRIX-1000G', 'ASUS', 'ROG-STRIX-1000G', 1000, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-550G', 'ASUS', 'ROG-STRIX-550G', 550, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-650G', 'ASUS', 'ROG-STRIX-650G', 650, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-750G', 'ASUS', 'ROG-STRIX-750G', 750, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-850G', 'ASUS', 'ROG-STRIX-850G', 850, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-850G-GUNDAM-EDITION', 'ASUS', 'ROG-STRIX-850G-GUNDAM-EDITION', 850, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-850G-WHITE', 'ASUS', 'ROG-STRIX-850G-WHITE', 850, '80+ GOLD', NULL),
	('ASUS_ROG_LOKI_SFX-L_1000W_Platinum', 'ASUS', 'ROG LOKI SFX-L 1000W Platinum', 1000, '80+ PLATINUM', NULL),
	('ASUS_ROG_LOKI_SFX-L_750W_Platinum', 'ASUS', 'ROG LOKI SFX-L 750W Platinum', 750, '80+ PLATINUM', NULL),
	('ASUS_ROG_LOKI_SFX-L_850W_Platinum', 'ASUS', 'ROG LOKI SFX-L 850W Platinum', 850, '80+ PLATINUM', NULL),
	('ASUS_ROG_LOKI_SFX-L_850W_Platinum_White_Edition', 'ASUS', 'ROG LOKI SFX-L 850W Platinum White Edition', 850, '80+ PLATINUM', NULL),
	('MSI_MAG_A650BN_EVA_e-PROJECT', 'MSI', 'MAG A650BN EVA e-PROJECT', 650, '80+ BRONZE', NULL),
	('MSI_MEG Ai1000P_PICE5', 'MSI', 'MEG Ai1000P PICE5 ', 1000, '80+ PLATINUM', NULL),
	('MSI_MEG_Ai1300P_PCIE5 ', 'MSI', 'MEG Ai1300P PCIE5 ', 1300, '80+ PLATINUM', NULL),
	('MSI_MPG_A1000G', 'MSI', 'MPG A1000G', 1000, '80+ GOLD', NULL),
	('MSI_MPG_A650GF ', 'MSI', 'MPG A650GF ', 650, '80+ GOLD', NULL),
	('MSI_MPG_A750', 'MSI', 'MPG A750GF ', 750, '80+ GOLD', NULL),
	('MSI_MPG_A750GF_WHITE', 'MSI', 'MPG A750GF WHITE ', 750, '80+ GOLD', NULL),
	('MSI_MPG_A850', 'MSI', 'MPG A850GF ', 850, '80+ GOLD', NULL);

-- membuang struktur untuk table database_pbol_uts.ram
CREATE TABLE IF NOT EXISTS `ram` (
  `ID_RAM` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nama_RAM` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DDR` int DEFAULT NULL,
  `Frequency` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' Mhz',
  `Capacity` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'GB',
  `CL` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_RAM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.ram: ~3 rows (lebih kurang)
DELETE FROM `ram`;
INSERT INTO `ram` (`ID_RAM`, `Nama_RAM`, `DDR`, `Frequency`, `Capacity`, `CL`, `Harga`) VALUES
	('TG-4-216', 'Teamgroup Memory T-FORCE Dark Z Alpha ', 4, '3200 MHZ', '2 X 16 GB', '16-20-20-40', 2000000),
	('TG-4-28', 'TEAMGROUP T-Force ZEUS DDR4  GAMING', 4, '3200 Mhz', '2 X 8 GB', '20-22-22-46', 1950000),
	('TG-4-29', 'Team Elite Memory DDR5', 5, ' 4800 Mhz', '1 x 8 GB', '40-40-40-77', 895000);

-- membuang struktur untuk table database_pbol_uts.ssd
CREATE TABLE IF NOT EXISTS `ssd` (
  `ID_SSD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Vendor` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Nama_SSD` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Capacity` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' GB',
  `TBW` int DEFAULT NULL,
  `Read` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' MB/s',
  `Write` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ' MB/s',
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_SSD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.ssd: ~19 rows (lebih kurang)
DELETE FROM `ssd`;
INSERT INTO `ssd` (`ID_SSD`, `Vendor`, `Nama_SSD`, `Type`, `Capacity`, `TBW`, `Read`, `Write`, `Harga`) VALUES
	('MSI-SS270-120', 'MSI ', 'SPATIUM S270 120GB', 'SATA 2.5"', '120 GB', 40, '500 MB/s', '360 MB/s', 300000),
	('MSI_SM390-1024', 'MSI', 'SPATIUM M390 NVMe M.2 1TB ', 'NVMe', '1024 GB', 400, '3300 MB/s', '3000 MB/s', 1800000),
	('MSI_SM390-2048', 'MSI', 'SPATIUM M390 NVMe M.2 2TB', 'NVMe', '2048 GB', 1200, '3300 MB/s', '3000 MB/s', 3450000),
	('MSI_SM390-250', 'MSI', 'SPATIUM M390 NVMe M.2 250GB', 'NVMe', '250 GB', 150, '3300 MB/s', '1200 MB/s', 590000),
	('MSI_SM390-500', 'MSI', 'SPATIUM M390 NVMe M.2 500GB ', 'NVMe', '500 GB', 200, '3300 MB/s', '2300 MB/s', 680000),
	('MSI_SS270-240', 'MSI', 'SPATIUM S270 240GB', 'SATA 2.5"', '240 GB', 110, '500 MB/s', '400 MB/s', 450000),
	('ST-B120-1024', 'Seagate', 'BarraCuda 120 SATA 1 TB', 'SATA 2.5"', '1024 GB', 600, '560 MB/s', '540 MB/s', 1900000),
	('ST-B120-2048', 'Seagate', 'BarraCuda 120 SATA 2 TB', 'SATA 2.5"', '2048 GB', 1170, '560 MB/s', '540 MB/s', 3800000),
	('ST-B120-250', 'Seagate', 'BarraCuda 120 SATA 250 GB', 'SATA 2.5"', '250 GB', 150, '560 MB/s', '540 MB/s', 855000),
	('ST-B120-500', 'Seagate', 'BarraCuda 120 SATA 500 GB', 'SATA 2.5"', '500 GB', 300, '560 MB/s', '540 MB/s', 1200000),
	('ST-B510-250', 'Seagate', 'BarraCuda 510 SSD 250GB', 'NVMe', '250 GB', 160, '3100 MB/s', '1200 MB/s', 550000),
	('ST-BQ-1-960', 'Seagate', 'Barracuda Q1 SSD 960 GB', 'SATA 2.5"', '960 GB', 280, '550 MB/s', '500 MB/s', 1800000),
	('ST-BQ1-240', 'Seagate', 'Barracuda Q1 SSD 240 GB', 'SATA 2.5"', '240 GB', 50, '550 MB/s', '450 MB/s', 610000),
	('ST-BQ1-480', 'Seagate', 'Barracuda Q1 SSD 480 GB', 'SATA 2.5"', '480 GB', 110, '550 MB/s', '500 MB/s', 955000),
	('ST-IRW2.5-1024', 'Seagate', 'IronWolf 125 NAS SSD 1TB', 'SATA 2.5"', '1024 GB', 1400, '560 MB/s', '540 MB/s', 2300000),
	('ST-IRW2.5-2048', 'Seagate ', 'IronWolf 125 NAS SSD 2TB', 'SATA 2.5"', ' 2048 GB', 2800, '560 MB/s', '540 MB/s', 6000000),
	('ST-IRW2.5-500', 'Seagate', 'IronWolf 125 NAS SSD 500GB', 'SATA 2.5"', ' 500 GB', 700, '560 MB/s', '540 MB/s', 1600000),
	('ST-IRWP2.5-1967', 'Seagate', ' IronWolf 125 Pro NAS SSD 1.92TB', 'SATA 2.5"', '1967 GB', 3500, '545 MB/s', '520 MB/s', 6500000),
	('ST-IRWP2.5-3933', 'Seagate', 'IronWolf 125 Pro NAS SSD 3.84TB', 'SATA 2.5"', '3933 GB', 7000, '545 MB/s', ' 520MB/s', 12000000);

-- membuang struktur untuk table database_pbol_uts.transaksi
CREATE TABLE IF NOT EXISTS `transaksi` (
  `Nomor_Transaksi` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ID_User` int DEFAULT NULL,
  `Tanggal_Transaksi` date DEFAULT NULL,
  `Waktu_Transaksi` time DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`),
  KEY `FKTransaksi_Id_User` (`ID_User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.transaksi: ~0 rows (lebih kurang)
DELETE FROM `transaksi`;
INSERT INTO `transaksi` (`Nomor_Transaksi`, `ID_User`, `Tanggal_Transaksi`, `Waktu_Transaksi`) VALUES
	('TRS_001', 101, '2022-10-03', NULL);

-- membuang struktur untuk table database_pbol_uts.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID_User` int NOT NULL AUTO_INCREMENT,
  `Nama_User` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Email_User` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Alamat_User` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Nomor_Telepon_User` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '08',
  `Password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.user: ~2 rows (lebih kurang)
DELETE FROM `user`;
INSERT INTO `user` (`ID_User`, `Nama_User`, `Email_User`, `Alamat_User`, `Nomor_Telepon_User`, `Password`) VALUES
	(101, 'Muhamad Ariq Rasyid', 'mariq.rasyid@gmail.com', 'Jl. Suryala I 1', '083879527973', 'Blizzard03'),
	(102, 'Blizzard Wolf Smith', 'BlizzardWP@WesternPack.com', 'Western Pack, Bridge Stone Forest', '085348953216', 'Blizzard12');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

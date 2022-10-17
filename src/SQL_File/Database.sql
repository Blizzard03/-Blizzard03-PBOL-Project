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
DROP DATABASE IF EXISTS `database_pbol_uts`;
CREATE DATABASE IF NOT EXISTS `database_pbol_uts` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `database_pbol_uts`;

-- membuang struktur untuk table database_pbol_uts.cooler
DROP TABLE IF EXISTS `cooler`;
CREATE TABLE IF NOT EXISTS `cooler` (
  `ID_COOLER` varchar(30) NOT NULL,
  `Picture` longblob,
  `Nama_Cooler` varchar(50) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Socket` varchar(15) DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_COOLER`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.cooler: ~1 rows (lebih kurang)
DELETE FROM `cooler`;
INSERT INTO `cooler` (`ID_COOLER`, `Picture`, `Nama_Cooler`, `Type`, `Socket`, `Harga`) VALUES
	('CM_L240', _binary 0x496d616765732f436f6f6c65722f436f6f6c696e67204d61737465722f4c697175696420436f6f6c65722f4d61737465724c6971756964203234302e706e67, 'Cooling Master MasterLiquid 240', 'Liquid Cooling', 'AM4', NULL);

-- membuang struktur untuk table database_pbol_uts.cpu
DROP TABLE IF EXISTS `cpu`;
CREATE TABLE IF NOT EXISTS `cpu` (
  `ID_CPU` varchar(24) NOT NULL,
  `Nama_CPU` varchar(50) DEFAULT NULL,
  `Base_Clock` varchar(12) DEFAULT '0 GHz',
  `Max_Turbo_Clock` varchar(30) DEFAULT 'Up to 0 Ghz',
  `Cores` int DEFAULT NULL,
  `Thread` int DEFAULT NULL,
  `TDP` varchar(6) DEFAULT '0 W',
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_CPU`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.cpu: ~30 rows (lebih kurang)
DELETE FROM `cpu`;
INSERT INTO `cpu` (`ID_CPU`, `Nama_CPU`, `Base_Clock`, `Max_Turbo_Clock`, `Cores`, `Thread`, `TDP`, `Harga`) VALUES
	('AMD_R55500', 'AMD Ryzen™ 5 5500', '3.6 GHz', 'Up to 4.2 Ghz', 6, 12, '65 W', NULL),
	('AMD_R55600', 'AMD Ryzen™ 5 5600', '3.5 GHz', 'Up to 4.4 Ghz', 6, 12, '65 W', NULL),
	('AMD_R55600X', 'AMD Ryzen™ 5 5600X', '3.7 GHz', 'Up to 4.6 Ghz', 6, 12, '65 W', NULL),
	('AMD_R56000G', 'AMD Ryzen™ 5 5600G', '3.9 GHz', 'Up to 4.4 Ghz', 6, 12, '65 W', NULL),
	('AMD_R57600X', 'AMD Ryzen™ 5 7600X', '4.7 GHz', 'Up to 5.3 Ghz', 6, 12, '105 W', NULL),
	('AMD_R75700G', 'AMD Ryzen™ 7 5700G', '3.8 GHz', 'Up to 4.6 Ghz', 8, 16, '65 W', NULL),
	('AMD_R75700X', 'AMD Ryzen™ 7 5700X', '3.4 GHz', 'Up to 4.6 Ghz', 8, 16, '65 W', NULL),
	('AMD_R75800X', 'AMD Ryzen™ 7 5800X', '3.8GHz', 'Up to 4.7 Ghz', 8, 16, '105 W', NULL),
	('AMD_R75800X3D', 'AMD Ryzen™ 7 5800X3D', '3.4 GHz', 'Up to 4.5 Ghz', 8, 16, '105 W', NULL),
	('AMD_R7700X', 'AMD Ryzen™ 7 7700X', '4.5 GHz', 'Up to 5.4 Ghz', 8, 16, '105 W', NULL),
	('AMD_R95900X', 'AMD Ryzen™ 9 5900X', '3.7 GHz', 'Up to 4.8 Ghz', 12, 24, '105 W', NULL),
	('AMD_R95950X', 'AMD Ryzen™ 9 5950X', '3.4 GHz', 'Up to 4.9 Ghz', 16, 32, '105 W', NULL),
	('AMD_R97900X', ' AMD Ryzen™ 9 7900X', '4.7 GHz', 'Up to 5.6 Ghz', 12, 24, '170 W', NULL),
	('AMD_R97950X', 'AMD Ryzen™ 9 7950X', '4.5 GHz', 'Up to 5.7 Ghz', 16, 32, '170 W', NULL),
	('INTEL_i3_12300T', 'Intel Core i3-12300T', '2.3 GHz', 'Up to 4.2 Ghz', 4, 8, '35 W', NULL),
	('INTEL_i312100', 'Intel Core i3-12100', '3.3GHz', 'Up to 4.3 Ghz', 4, 8, '60 W', NULL),
	('INTEL_i312100T', 'Intel Core i3-12100T', '2.2 GHz', 'Up to 4.1 Ghz', 4, 8, '35 W', NULL),
	('INTEL_i312300', 'Intel Core i3-12300', '3.5 GHz', 'Up to 4.3 Ghz', 4, 8, '60 W', NULL),
	('INTEL_i5_12400T', 'Intel Core i5-12400T', '1.8 GHz', 'Up to 4.2 Ghz', 6, 12, '35 W', NULL),
	('INTEL_i5_12500T', 'Intel Core i5-12500T', '2.0 GHz', 'Up to 4.4 Ghz', 6, 12, '35 W', NULL),
	('INTEL_i5_12600T', 'Intel Core i5-12600T', '2.1 GHz', 'Up to 4.6 Ghz', 6, 12, '35 W', NULL),
	('INTEL_i5_13600K', 'Intel Core i5-13600K', ' GHz', 'Up to 0 Ghz', 14, 20, '181 W', NULL),
	('INTEL_i5_13600KF', 'Intel Core i5-13600KF', '3.5 GHz', 'Up to 5.1 Ghz', 14, 20, '181 W', NULL),
	('INTEL_i512400', 'Intel Core i5-12400', '2.5 GHz', 'Up to 4.4 Ghz', 6, 12, '65 W', NULL),
	('INTEL_i512500', 'Intel Core i5-12500', '3.0 GHz', 'Up to 4.6 Ghz', 6, 12, '65 W', NULL),
	('INTEL_i512600', 'Intel Core i5-12600', '3.3 GHz', 'Up to 4.8 Ghz', 6, 12, '65 W', NULL),
	('INTEL_i7_12700T', 'Intel Core i7-12700T', '1.4 GHz', 'Up to 4.6 Ghz', 12, 20, '35 W', NULL),
	('INTEL_i712700', 'Intel Core i7-12700', '2.1 GHz', 'Up to 4.8 Ghz', 12, 20, '65 W', NULL),
	('INTEL_i9_12900T', 'Intel Core i9-12900T', '1.4 GHz', 'Up to 4.8 Ghz', 16, 24, '35 W', NULL),
	('INTEL_i912900', 'Intel Core i9-12900', '2.4 GHz', 'Up to 5.0 Ghz', 16, 24, '65 W', NULL);

-- membuang struktur untuk table database_pbol_uts.detail_cpu
DROP TABLE IF EXISTS `detail_cpu`;
CREATE TABLE IF NOT EXISTS `detail_cpu` (
  `Nomor_Transaksi` varchar(12) NOT NULL,
  `ID_CPU` varchar(12) NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_detail_CPU_ID_CPU` (`ID_CPU`),
  CONSTRAINT `FK_detail_CPU_ID_CPU` FOREIGN KEY (`ID_CPU`) REFERENCES `cpu` (`ID_CPU`),
  CONSTRAINT `FK_detail_CPU_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_cpu: ~0 rows (lebih kurang)
DELETE FROM `detail_cpu`;

-- membuang struktur untuk table database_pbol_uts.detail_gpu
DROP TABLE IF EXISTS `detail_gpu`;
CREATE TABLE IF NOT EXISTS `detail_gpu` (
  `Nomor_Transaksi` varchar(12) NOT NULL,
  `ID_GPU` varchar(12) NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_detail_CPU_ID_CPU` (`ID_GPU`) USING BTREE,
  CONSTRAINT `DK_Detail_GP0_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`),
  CONSTRAINT `FK_Detail_GPU_ID_GPU` FOREIGN KEY (`ID_GPU`) REFERENCES `gpu` (`ID_GPU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_gpu: ~0 rows (lebih kurang)
DELETE FROM `detail_gpu`;

-- membuang struktur untuk table database_pbol_uts.detail_mother_board
DROP TABLE IF EXISTS `detail_mother_board`;
CREATE TABLE IF NOT EXISTS `detail_mother_board` (
  `Nomor_Transaksi` varchar(12) NOT NULL,
  `ID_CPU` varchar(12) NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`) USING BTREE,
  KEY `FK_detail_CPU_ID_CPU` (`ID_CPU`) USING BTREE,
  CONSTRAINT `detail_mother_board_ibfk_1` FOREIGN KEY (`ID_CPU`) REFERENCES `cpu` (`ID_CPU`),
  CONSTRAINT `detail_mother_board_ibfk_2` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Membuang data untuk tabel database_pbol_uts.detail_mother_board: ~0 rows (lebih kurang)
DELETE FROM `detail_mother_board`;

-- membuang struktur untuk table database_pbol_uts.detai_ram
DROP TABLE IF EXISTS `detai_ram`;
CREATE TABLE IF NOT EXISTS `detai_ram` (
  `Nomor_Transaksi` varchar(12) NOT NULL,
  `ID_RAM` varchar(12) NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`),
  KEY `FK_Detail_RAM_ID_RAM` (`ID_RAM`),
  CONSTRAINT `FK_Detail_RAM_ID_RAM` FOREIGN KEY (`ID_RAM`) REFERENCES `ram` (`ID_RAM`),
  CONSTRAINT `FK_Detail_RAM_Nomor_Transaksi` FOREIGN KEY (`Nomor_Transaksi`) REFERENCES `transaksi` (`Nomor_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.detai_ram: ~0 rows (lebih kurang)
DELETE FROM `detai_ram`;

-- membuang struktur untuk table database_pbol_uts.gpu
DROP TABLE IF EXISTS `gpu`;
CREATE TABLE IF NOT EXISTS `gpu` (
  `ID_GPU` varchar(30) NOT NULL,
  `Vendor` varchar(10) DEFAULT NULL,
  `Nama_GPU` varchar(50) DEFAULT NULL,
  `VRAM` varchar(6) DEFAULT ' GB',
  `Memory Type` varchar(8) DEFAULT 'GDDR ',
  `Frequency` varchar(10) DEFAULT ' MHz',
  `GDP` varchar(10) DEFAULT ' W',
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_GPU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.gpu: ~23 rows (lebih kurang)
DELETE FROM `gpu`;
INSERT INTO `gpu` (`ID_GPU`, `Vendor`, `Nama_GPU`, `VRAM`, `Memory Type`, `Frequency`, `GDP`, `Harga`) VALUES
	('AMD_Radeon_RX_6400', 'AMD', 'AMD Radeon™ RX 6400', '4 GB', 'GDDR 6', '2039 MHz', '35 W', 2437760),
	('AMD_Radeon_RX_6500_XT', 'AMD', 'AMD Radeon™ RX 6500 XT', '8 GB', 'GDDR 6', '2650 MHz', '113 W', 3047200),
	('AMD_Radeon_RX_6600_XT', 'AMD', 'AMD Radeon™ RX 6600 XT', '8 GB', 'GDDR 6', '2359 MHz', '160 W', 5789680),
	('AMD_Radeon_RX_6650_XT', 'AMD', 'AMD Radeon™ RX 6650 XT', '8 GB', 'GDDR 6', '2410 MHz', '180W', 6094400),
	('AMD_Radeon_RX_6700', 'AMD', 'AMD Radeon™ RX 6700', '10 GB', 'GDDR 6', '2174 MHz', '175 W', NULL),
	('AMD_Radeon_RX_6700_XT', 'AMD', 'AMD Radeon™ RX 6700 XT', '12 GB', 'GDDR 6', '2424 MHz', '230 W', NULL),
	('AMD_Radeon_RX_6750_XT', 'AMD', 'AMD Radeon™ RX 6750 XT', '12 GB', 'GDDR 6', '2495 MHz', '250 W', NULL),
	('AMD_Radeon_RX_6800', 'AMD', 'AMD Radeon™ RX 6800', '16 GB', 'GDDR 6', '1815 MHz', '250 W', NULL),
	('AMD_Radeon_RX_6800_XT', 'AMD', 'AMD Radeon™ RX 6800 XT', '16 GB', 'GDDR 6', '2015 MHz', '300 W', NULL),
	('AMD_Radeon_RX_6900_XT', 'AMD', 'AMD Radeon™ RX 6900 XT', '16 GB', 'GDDR 6', '2015 MHz', '300 W', NULL),
	('AMD_Radeon_RX_6950_XT', 'AMD', 'AMD Radeon™ RX 6950 XT', '16 GB', 'GDDR 6', '2100 MHz', '335 W', NULL),
	('AMD_Radon_RX_6600', 'AMD', 'AMD Radeon™ RX 6600', '8 GB', 'GDDR 6', '2044 MHz', '132 W', NULL),
	('NVDIA_RTX_4070', 'NVIDIA', 'NVIDIA Geforce RTX 4070', '12 GB', 'GDDR 6X', '2310 MHz', '285 W', 7618000),
	('NVIDIA_RTX_3070_Ti', 'NVIDIA', 'NVIDIA Geforce RTX 3070 Ti', '8 GB', 'GDDR 6X', '2105 MHz', '290 W', 9126364),
	('NVIDIA_RTX_3080', 'NVIDIA', 'NVIDIA Geforce RTX 3080', '10 GB', 'GDDR 6X', '2581 MHz', '320 W', 10649964),
	('NVIDIA_RTX_3090', 'NVIDIA', 'NVIDIA Geforce RTX 3090', '24 GB', 'GDDR 6X', '2491 MHz', '350 W', 19791564),
	('NVIDIA_RTX_4060', 'NVIDIA', 'NVIDIA Geforce RTX 4060', '8 GB', 'GDDR 6/X', '2505 MHz', '200 W', 5027880),
	('NVIDIA_RTX_4080_12GB', 'NVIDIA', 'NVIDIA Geforce RTX 4080 12GB', '12 GB', 'GDDR 6X', '2610 MHz', '285 W', 13697164),
	('NVIDIA_RTX_4080_16_GB', 'NVIDIA', 'NVIDIA Geforce RTX 4080 16GB', '16 GB', 'GDDR 6X', '2510  MHz', '320 W', 18267964),
	('NVIDIA_RTX3050', 'NVIDIA', 'NVIDIA GeForce RTX 3050', '4 GB', 'GDDR 6', '1777 Mhz\r\n', '130 W', 3808848),
	('NVIDIA_RTX3060', 'NVIDIA', 'NVIDIA GeForce RTX 3060', '12 GB', 'GDDR 6', '1777 Mhz', '170 W', 5012644),
	('NVIDIA_RTX3060_Ti', 'NVIDIA', 'NVIDIA Geforce RTX 3060 Ti', '8 GB', 'GDDR 6', '2250 MHz', '200 W', 6079164),
	('NVIDIA_RTX3070', 'NVIDIA', 'NVIDIA Geforce RTX 3070', '8 GB', 'GDDR 6', '2240 MHz', '220 W', 7602764);

-- membuang struktur untuk table database_pbol_uts.mother_board
DROP TABLE IF EXISTS `mother_board`;
CREATE TABLE IF NOT EXISTS `mother_board` (
  `ID_MOTHER_BOARD` varchar(30) NOT NULL,
  `Vendor` varchar(20) DEFAULT NULL,
  `Nama_Mother_Board` varchar(50) DEFAULT NULL,
  `Type` varchar(15) DEFAULT NULL,
  `Socket` varchar(15) DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_MOTHER_BOARD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.mother_board: ~0 rows (lebih kurang)
DELETE FROM `mother_board`;

-- membuang struktur untuk table database_pbol_uts.power_supply
DROP TABLE IF EXISTS `power_supply`;
CREATE TABLE IF NOT EXISTS `power_supply` (
  `ID_PSU` varchar(50) NOT NULL,
  `Image` longblob,
  `Vendor` varchar(12) DEFAULT NULL,
  `Nama_PSU` varchar(50) DEFAULT NULL,
  `Watt` int DEFAULT NULL,
  `Tier` varchar(20) DEFAULT NULL,
  `Harga` int DEFAULT NULL,
  PRIMARY KEY (`ID_PSU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.power_supply: ~18 rows (lebih kurang)
DELETE FROM `power_supply`;
INSERT INTO `power_supply` (`ID_PSU`, `Image`, `Vendor`, `Nama_PSU`, `Watt`, `Tier`, `Harga`) VALUES
	('ASUS_ROG LOKI SFX-L 750W Platinum', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f4c4f4b492f524f47204c4f4b49205346582d4c203735305720506c6174696e756d2e706e67, 'ASUS', 'ROG LOKI SFX-L 750W Platinum', 750, '80+ PLATINUM', NULL),
	('ASUS_ROG LOKI SFX-L 850W Platinum', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f4c4f4b492f524f47204c4f4b49205346582d4c203835305720506c6174696e756d2e706e67, 'ASUS', 'ROG LOKI SFX-L 850W Platinum', 850, '80+ PLATINUM', NULL),
	('ASUS_ROG LOKI SFX-L 850W Platinum White Edition', _binary 0x524f47204c4f4b49205346582d4c203835305720506c6174696e756d2057686974652045646974696f6e2e706e67, 'ASUS', 'ROG LOKI SFX-L 850W Platinum White Edition', 850, '80+ PLATINUM', NULL),
	('ASUS_ROG-STRIX-1000G', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d31303030472e706e67, 'ASUS', 'ROG-STRIX-1000G', 1000, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-550G', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d353530472e706e67, 'ASUS', 'ROG-STRIX-550G', 550, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-650G', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d363530472e706e67, 'ASUS', 'ROG-STRIX-650G', 650, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-750G', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d373530472e706e67, 'ASUS', 'ROG-STRIX-750G', 750, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-850G', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d383530472e706e67, 'ASUS', 'ROG-STRIX-850G', 850, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-850G-GUNDAM-EDITION', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d383530472d47554e44414d2d45444954494f4e2e706e67, 'ASUS', 'ROG-STRIX-850G-GUNDAM-EDITION', 850, '80+ GOLD', NULL),
	('ASUS_ROG-STRIX-850G-WHITE', _binary 0x496d616765732f506f77657220537570706c792f415355532f524f472f53545249582f524f472d53545249582d383530472d57484954452e706e67, 'ASUS', 'ROG-STRIX-850G-WHITE', 850, '80+ GOLD', NULL),
	('MSI_MAG_A650BN_EVA_e-PROJECT', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d41472041363530424e2045564120652d50524f4a4543542e706e67, 'MSI', 'MAG A650BN EVA e-PROJECT', 650, '80+ BRONZE', NULL),
	('MSI_MEG Ai1000P_PICE5', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d454720416931303030502050494345352e706e67, 'MSI', 'MEG Ai1000P PICE5 ', 1000, '80+ PLATINUM', NULL),
	('MSI_MEG_Ai1300P_PCIE5 ', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d454720416931333030502050434945352e706e67, 'MSI', 'MEG Ai1300P PCIE5 ', 1300, '80+ PLATINUM', NULL),
	('MSI_MPG_A1000G', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d5047204131303030472e706e67, 'MSI', 'MPG A1000G', 1000, '80+ GOLD', NULL),
	('MSI_MPG_A650GF ', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d5047204136353047462e706e67, 'MSI', 'MPG A650GF ', 650, '80+ GOLD', NULL),
	('MSI_MPG_A750', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d5047204137353047462e706e67, 'MSI', 'MPG A750GF ', 750, '80+ GOLD', NULL),
	('MSI_MPG_A750GF_WHITE', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d5047204137353047462057484954452e706e67, 'MSI', 'MPG A750GF WHITE ', 750, '80+ GOLD', NULL),
	('MSI_MPG_A850', _binary 0x496d616765732f506f77657220537570706c792f4d53492f4d5047204138353047462e706e67, 'MSI', 'MPG A850GF ', 850, '80+ GOLD', NULL);

-- membuang struktur untuk table database_pbol_uts.ram
DROP TABLE IF EXISTS `ram`;
CREATE TABLE IF NOT EXISTS `ram` (
  `ID_RAM` varchar(12) NOT NULL,
  `Nama_RAM` varchar(15) DEFAULT NULL,
  `DDR` int DEFAULT NULL,
  `Frequency` varchar(50) DEFAULT NULL,
  `Capacity` varchar(10) DEFAULT NULL,
  `CL` varchar(10) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  PRIMARY KEY (`ID_RAM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.ram: ~0 rows (lebih kurang)
DELETE FROM `ram`;

-- membuang struktur untuk table database_pbol_uts.ssd
DROP TABLE IF EXISTS `ssd`;
CREATE TABLE IF NOT EXISTS `ssd` (
  `ID_SSD` varchar(50) NOT NULL,
  `Vendor` varchar(12) DEFAULT NULL,
  `Nama_SSD` varchar(35) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Capacity` varchar(10) DEFAULT NULL,
  `TBW` int DEFAULT NULL,
  `Read` varchar(6) DEFAULT NULL,
  `Write` varchar(6) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  PRIMARY KEY (`ID_SSD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.ssd: ~0 rows (lebih kurang)
DELETE FROM `ssd`;

-- membuang struktur untuk table database_pbol_uts.transaksi
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE IF NOT EXISTS `transaksi` (
  `Nomor_Transaksi` varchar(20) NOT NULL,
  `ID_User` int DEFAULT NULL,
  `Tanggal_Transaksi` datetime DEFAULT NULL,
  PRIMARY KEY (`Nomor_Transaksi`),
  KEY `FKTransaksi_Id_User` (`ID_User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.transaksi: ~1 rows (lebih kurang)
DELETE FROM `transaksi`;
INSERT INTO `transaksi` (`Nomor_Transaksi`, `ID_User`, `Tanggal_Transaksi`) VALUES
	('TRS_001', 101, '2022-10-03 10:08:41');

-- membuang struktur untuk table database_pbol_uts.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID_User` int NOT NULL AUTO_INCREMENT,
  `Nama_User` varchar(60) DEFAULT NULL,
  `Email_User` varchar(50) DEFAULT NULL,
  `Alamat_User` varchar(60) DEFAULT NULL,
  `Nomor_Telepon_User` varchar(12) DEFAULT '08',
  `Password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID_User`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Membuang data untuk tabel database_pbol_uts.user: ~1 rows (lebih kurang)
DELETE FROM `user`;
INSERT INTO `user` (`ID_User`, `Nama_User`, `Email_User`, `Alamat_User`, `Nomor_Telepon_User`, `Password`) VALUES
	(101, 'Muhamad Ariq Rasyid', 'mariq.rasyid@gmail.com', 'Jl. Suryala I 1', '083879527973', 'Blizzard03');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

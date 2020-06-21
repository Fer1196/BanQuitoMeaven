-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2020 at 10:20 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banquito`
--
CREATE DATABASE IF NOT EXISTS `banquito` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `banquito`;

-- --------------------------------------------------------

--
-- Table structure for table `aplicacion`
--

DROP TABLE IF EXISTS `aplicacion`;
CREATE TABLE `aplicacion` (
  `CODIGO_APLICACION` decimal(15,0) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `DESCRIPCIONAPP` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contrasena`
--

DROP TABLE IF EXISTS `contrasena`;
CREATE TABLE `contrasena` (
  `CONTRASENA_ACTUAL` varchar(100) NOT NULL,
  `PEEMP_CODIGO` char(6) NOT NULL,
  `CONTRASENA_PASADA` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `historial_sistema`
--

DROP TABLE IF EXISTS `historial_sistema`;
CREATE TABLE `historial_sistema` (
  `XESIS_CODSIS` char(10) NOT NULL,
  `PEEMP_CODIGO` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pecar_cargo`
--

DROP TABLE IF EXISTS `pecar_cargo`;
CREATE TABLE `pecar_cargo` (
  `PEDEP_CODIGO` char(3) NOT NULL,
  `PECAR_CODIGO` char(3) NOT NULL,
  `PECAR_DESCRI` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad utilizada para realizar el CRUD de los diferentes ca';

-- --------------------------------------------------------

--
-- Table structure for table `pedep_depar`
--

DROP TABLE IF EXISTS `pedep_depar`;
CREATE TABLE `pedep_depar` (
  `PEDEP_CODIGO` char(3) NOT NULL,
  `PEDEP_DESCRI` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad utilizada para realizar el CRUD de los diferentes de';

-- --------------------------------------------------------

--
-- Table structure for table `peemp_emple`
--

DROP TABLE IF EXISTS `peemp_emple`;
CREATE TABLE `peemp_emple` (
  `PEEMP_CODIGO` char(6) NOT NULL,
  `PESEX_CODIGO` char(1) NOT NULL,
  `PEESC_CODIGO` char(1) DEFAULT NULL,
  `PEEMP_APELLI` varchar(100) NOT NULL,
  `PEEMP_NOMBRE` varchar(100) NOT NULL,
  `PEEMP_CEDULA` char(10) DEFAULT NULL,
  `PEEMP_FECNAC` date NOT NULL,
  `PEEMP_DIREC` varchar(200) DEFAULT NULL,
  `PEEMP_TELEFO` varchar(15) DEFAULT NULL,
  `PEEMP_CARGAS` decimal(3,0) NOT NULL,
  `PEEMP_EMAIL` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad utilizada para realiar el CRUD de empleados\r\n\r\n                                ';

-- --------------------------------------------------------

--
-- Table structure for table `peesc_estciv`
--

DROP TABLE IF EXISTS `peesc_estciv`;
CREATE TABLE `peesc_estciv` (
  `PEESC_CODIGO` char(1) NOT NULL,
  `PEESC_DESCRI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad utilizada para realziar el CRUD del ESTADO CIVIL de ';

-- --------------------------------------------------------

--
-- Table structure for table `perfil_rol`
--

DROP TABLE IF EXISTS `perfil_rol`;
CREATE TABLE `perfil_rol` (
  `XEP_XEPER_CODPER` char(10) NOT NULL,
  `PEEMP_CODIGO` char(6) NOT NULL,
  `XEPER_CODPER` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pesex_sexo`
--

DROP TABLE IF EXISTS `pesex_sexo`;
CREATE TABLE `pesex_sexo` (
  `PESEX_CODIGO` char(1) NOT NULL,
  `PESEX_DESCRI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad utilizada para realziar el CRUD del g[enero o sexo d';

-- --------------------------------------------------------

--
-- Table structure for table `rol_aplicacion`
--

DROP TABLE IF EXISTS `rol_aplicacion`;
CREATE TABLE `rol_aplicacion` (
  `XEPER_CODPER` char(10) NOT NULL,
  `CODIGO_APLICACION` decimal(15,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `xeest_estado`
--

DROP TABLE IF EXISTS `xeest_estado`;
CREATE TABLE `xeest_estado` (
  `XEU_PEEMP_CODIGO` char(6) NOT NULL,
  `XEEST_CODIGO` char(1) NOT NULL,
  `PEEMP_CODIGO` char(6) NOT NULL,
  `XEEST_DESCRI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='cosita\r\n\r\n\r\nMARI bno te olvide mi arroz con h';

-- --------------------------------------------------------

--
-- Table structure for table `xeopc_opcion`
--

DROP TABLE IF EXISTS `xeopc_opcion`;
CREATE TABLE `xeopc_opcion` (
  `XEOPC_CODOPC` char(10) NOT NULL,
  `XESIS_CODSIS` char(10) NOT NULL,
  `XEOPC_DESCRI` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entrada utilizada para realizar el CRUD de Opciones de la em';

-- --------------------------------------------------------

--
-- Table structure for table `xeope_operfi`
--

DROP TABLE IF EXISTS `xeope_operfi`;
CREATE TABLE `xeope_operfi` (
  `XEOPE_FASIGN` datetime NOT NULL,
  `XEOPC_CODOPC` char(10) NOT NULL,
  `XEOPE_ESTADO` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entrada utilizada para realizar el CRUD de Opciones de Perfi';

-- --------------------------------------------------------

--
-- Table structure for table `xeper_perfil2`
--

DROP TABLE IF EXISTS `xeper_perfil2`;
CREATE TABLE `xeper_perfil2` (
  `XEPER_CODPER` char(10) NOT NULL,
  `XEPER_DESCRI` varchar(100) NOT NULL,
  `XEPER_OBSERV` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entrada utilizada para realizar el CRUD de perfil de la empr';

-- --------------------------------------------------------

--
-- Table structure for table `xerol_rol2`
--

DROP TABLE IF EXISTS `xerol_rol2`;
CREATE TABLE `xerol_rol2` (
  `PEEMP_CODIGO` char(6) NOT NULL,
  `XEROL_INSERC` char(5) NOT NULL,
  `XEPER_CODPER` char(10) NOT NULL,
  `XEROL_ACTUAL` char(5) NOT NULL,
  `XEROL_ELIMIN` char(5) NOT NULL,
  `XEROL_CONSUL` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entrada utilizada para realizar el CRUD de roles de la empre';

-- --------------------------------------------------------

--
-- Table structure for table `xesis_sistem`
--

DROP TABLE IF EXISTS `xesis_sistem`;
CREATE TABLE `xesis_sistem` (
  `XESIS_CODSIS` char(10) NOT NULL,
  `XESIS_DESCRI` varchar(100) NOT NULL,
  `XEU_PEEMP_CODIGO` char(6) NOT NULL,
  `XEEST_CODIGO` char(1) NOT NULL,
  `CODIGO_APLICACION` decimal(15,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entrada utilizada para realizar el CRUD de Sistema de la emp';

-- --------------------------------------------------------

--
-- Table structure for table `xeusu_usuar`
--

DROP TABLE IF EXISTS `xeusu_usuar`;
CREATE TABLE `xeusu_usuar` (
  `PEEMP_CODIGO` char(6) NOT NULL,
  `XEUSU_PASSWORD` char(8) NOT NULL,
  `XEUSU_PIEFIRMA` varchar(100) NOT NULL,
  `XEUSU_FEC_CREA` datetime NOT NULL,
  `XEUSU_FEC_ULTIMO_CAMBIO` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entidad utilizada para realizar en CRUD de los usuarios que ';

-- --------------------------------------------------------

--
-- Table structure for table `xeuxp_usuper`
--

DROP TABLE IF EXISTS `xeuxp_usuper`;
CREATE TABLE `xeuxp_usuper` (
  `PEEMP_CODIGO` char(6) NOT NULL,
  `XEUXP_FECASI` date NOT NULL,
  `XEUXP_FECCAM` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `xeven_ventan`
--

DROP TABLE IF EXISTS `xeven_ventan`;
CREATE TABLE `xeven_ventan` (
  `XEVEN_CODVEN` char(10) NOT NULL,
  `XEOPC_CODOPC` char(10) NOT NULL,
  `XEVEN_DESCRI` varchar(100) NOT NULL,
  `XEVEN_MENSAJ` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Entrada utilizada para realizar el CRUD de Ventanas de Segur';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aplicacion`
--
ALTER TABLE `aplicacion`
  ADD PRIMARY KEY (`CODIGO_APLICACION`);

--
-- Indexes for table `contrasena`
--
ALTER TABLE `contrasena`
  ADD PRIMARY KEY (`CONTRASENA_ACTUAL`),
  ADD KEY `FK_USU_CON` (`PEEMP_CODIGO`);

--
-- Indexes for table `historial_sistema`
--
ALTER TABLE `historial_sistema`
  ADD PRIMARY KEY (`XESIS_CODSIS`,`PEEMP_CODIGO`),
  ADD KEY `FK_USU_HIS` (`PEEMP_CODIGO`);

--
-- Indexes for table `pecar_cargo`
--
ALTER TABLE `pecar_cargo`
  ADD PRIMARY KEY (`PECAR_CODIGO`,`PEDEP_CODIGO`),
  ADD KEY `FK_PR_PEDEP_PECAR` (`PEDEP_CODIGO`);

--
-- Indexes for table `pedep_depar`
--
ALTER TABLE `pedep_depar`
  ADD PRIMARY KEY (`PEDEP_CODIGO`);

--
-- Indexes for table `peemp_emple`
--
ALTER TABLE `peemp_emple`
  ADD PRIMARY KEY (`PEEMP_CODIGO`),
  ADD KEY `FK_PR_PEESC_PEEMP` (`PEESC_CODIGO`),
  ADD KEY `FK_PR_PESEX_PEEMP` (`PESEX_CODIGO`);

--
-- Indexes for table `peesc_estciv`
--
ALTER TABLE `peesc_estciv`
  ADD PRIMARY KEY (`PEESC_CODIGO`);

--
-- Indexes for table `perfil_rol`
--
ALTER TABLE `perfil_rol`
  ADD PRIMARY KEY (`XEP_XEPER_CODPER`,`PEEMP_CODIGO`,`XEPER_CODPER`),
  ADD KEY `FK_RELATIONSHIP_21` (`PEEMP_CODIGO`,`XEPER_CODPER`);

--
-- Indexes for table `pesex_sexo`
--
ALTER TABLE `pesex_sexo`
  ADD PRIMARY KEY (`PESEX_CODIGO`);

--
-- Indexes for table `rol_aplicacion`
--
ALTER TABLE `rol_aplicacion`
  ADD PRIMARY KEY (`XEPER_CODPER`,`CODIGO_APLICACION`),
  ADD KEY `FK_ROL_APP` (`CODIGO_APLICACION`);

--
-- Indexes for table `xeest_estado`
--
ALTER TABLE `xeest_estado`
  ADD PRIMARY KEY (`XEU_PEEMP_CODIGO`,`XEEST_CODIGO`),
  ADD KEY `FK_XR_XEEST_XEUSU` (`PEEMP_CODIGO`);

--
-- Indexes for table `xeopc_opcion`
--
ALTER TABLE `xeopc_opcion`
  ADD PRIMARY KEY (`XEOPC_CODOPC`),
  ADD KEY `FK_XR_XESIS_XEOPC` (`XESIS_CODSIS`);

--
-- Indexes for table `xeope_operfi`
--
ALTER TABLE `xeope_operfi`
  ADD PRIMARY KEY (`XEOPE_FASIGN`),
  ADD KEY `FK_XR_XEOPC_XEOPE_OPERFI` (`XEOPC_CODOPC`);

--
-- Indexes for table `xeper_perfil2`
--
ALTER TABLE `xeper_perfil2`
  ADD PRIMARY KEY (`XEPER_CODPER`);

--
-- Indexes for table `xerol_rol2`
--
ALTER TABLE `xerol_rol2`
  ADD PRIMARY KEY (`PEEMP_CODIGO`,`XEPER_CODPER`);

--
-- Indexes for table `xesis_sistem`
--
ALTER TABLE `xesis_sistem`
  ADD PRIMARY KEY (`XESIS_CODSIS`),
  ADD KEY `FK_SIS_APP` (`CODIGO_APLICACION`),
  ADD KEY `FK_XR_XEEST_XESIS` (`XEU_PEEMP_CODIGO`,`XEEST_CODIGO`);

--
-- Indexes for table `xeusu_usuar`
--
ALTER TABLE `xeusu_usuar`
  ADD PRIMARY KEY (`PEEMP_CODIGO`);

--
-- Indexes for table `xeuxp_usuper`
--
ALTER TABLE `xeuxp_usuper`
  ADD PRIMARY KEY (`PEEMP_CODIGO`,`XEUXP_FECASI`);

--
-- Indexes for table `xeven_ventan`
--
ALTER TABLE `xeven_ventan`
  ADD PRIMARY KEY (`XEVEN_CODVEN`),
  ADD KEY `FK_XR_XEOPC_XEVEN` (`XEOPC_CODOPC`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contrasena`
--
ALTER TABLE `contrasena`
  ADD CONSTRAINT `FK_USU_CON` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `xeusu_usuar` (`PEEMP_CODIGO`);

--
-- Constraints for table `historial_sistema`
--
ALTER TABLE `historial_sistema`
  ADD CONSTRAINT `FK_USU_HIS` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `xeusu_usuar` (`PEEMP_CODIGO`),
  ADD CONSTRAINT `FK_USU_SIS` FOREIGN KEY (`XESIS_CODSIS`) REFERENCES `xesis_sistem` (`XESIS_CODSIS`);

--
-- Constraints for table `pecar_cargo`
--
ALTER TABLE `pecar_cargo`
  ADD CONSTRAINT `FK_PR_PEDEP_PECAR` FOREIGN KEY (`PEDEP_CODIGO`) REFERENCES `pedep_depar` (`PEDEP_CODIGO`);

--
-- Constraints for table `peemp_emple`
--
ALTER TABLE `peemp_emple`
  ADD CONSTRAINT `FK_PR_PEESC_PEEMP` FOREIGN KEY (`PEESC_CODIGO`) REFERENCES `peesc_estciv` (`PEESC_CODIGO`),
  ADD CONSTRAINT `FK_PR_PESEX_PEEMP` FOREIGN KEY (`PESEX_CODIGO`) REFERENCES `pesex_sexo` (`PESEX_CODIGO`);

--
-- Constraints for table `perfil_rol`
--
ALTER TABLE `perfil_rol`
  ADD CONSTRAINT `FK_RELATIONSHIP_21` FOREIGN KEY (`PEEMP_CODIGO`,`XEPER_CODPER`) REFERENCES `xerol_rol2` (`PEEMP_CODIGO`, `XEPER_CODPER`),
  ADD CONSTRAINT `FK_RELATIONSHIP_22` FOREIGN KEY (`XEP_XEPER_CODPER`) REFERENCES `xeper_perfil2` (`XEPER_CODPER`);

--
-- Constraints for table `rol_aplicacion`
--
ALTER TABLE `rol_aplicacion`
  ADD CONSTRAINT `FK_APP_PER` FOREIGN KEY (`XEPER_CODPER`) REFERENCES `xeper_perfil2` (`XEPER_CODPER`),
  ADD CONSTRAINT `FK_ROL_APP` FOREIGN KEY (`CODIGO_APLICACION`) REFERENCES `aplicacion` (`CODIGO_APLICACION`);

--
-- Constraints for table `xeest_estado`
--
ALTER TABLE `xeest_estado`
  ADD CONSTRAINT `FK_USU_ESTADO` FOREIGN KEY (`XEU_PEEMP_CODIGO`) REFERENCES `xeusu_usuar` (`PEEMP_CODIGO`),
  ADD CONSTRAINT `FK_XR_XEEST_XEUSU` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `xeusu_usuar` (`PEEMP_CODIGO`);

--
-- Constraints for table `xeopc_opcion`
--
ALTER TABLE `xeopc_opcion`
  ADD CONSTRAINT `FK_XR_XESIS_XEOPC` FOREIGN KEY (`XESIS_CODSIS`) REFERENCES `xesis_sistem` (`XESIS_CODSIS`);

--
-- Constraints for table `xeope_operfi`
--
ALTER TABLE `xeope_operfi`
  ADD CONSTRAINT `FK_XR_XEOPC_XEOPE_OPERFI` FOREIGN KEY (`XEOPC_CODOPC`) REFERENCES `xeopc_opcion` (`XEOPC_CODOPC`);

--
-- Constraints for table `xerol_rol2`
--
ALTER TABLE `xerol_rol2`
  ADD CONSTRAINT `FK_USU_ROL` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `xeusu_usuar` (`PEEMP_CODIGO`);

--
-- Constraints for table `xesis_sistem`
--
ALTER TABLE `xesis_sistem`
  ADD CONSTRAINT `FK_SIS_APP` FOREIGN KEY (`CODIGO_APLICACION`) REFERENCES `aplicacion` (`CODIGO_APLICACION`),
  ADD CONSTRAINT `FK_XR_XEEST_XESIS` FOREIGN KEY (`XEU_PEEMP_CODIGO`,`XEEST_CODIGO`) REFERENCES `xeest_estado` (`XEU_PEEMP_CODIGO`, `XEEST_CODIGO`);

--
-- Constraints for table `xeusu_usuar`
--
ALTER TABLE `xeusu_usuar`
  ADD CONSTRAINT `FK_XR_PEEMP_XEUSU` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `peemp_emple` (`PEEMP_CODIGO`);

--
-- Constraints for table `xeuxp_usuper`
--
ALTER TABLE `xeuxp_usuper`
  ADD CONSTRAINT `FK_XR_XEUSU_EXUXP` FOREIGN KEY (`PEEMP_CODIGO`) REFERENCES `xeusu_usuar` (`PEEMP_CODIGO`);

--
-- Constraints for table `xeven_ventan`
--
ALTER TABLE `xeven_ventan`
  ADD CONSTRAINT `FK_XR_XEOPC_XEVEN` FOREIGN KEY (`XEOPC_CODOPC`) REFERENCES `xeopc_opcion` (`XEOPC_CODOPC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

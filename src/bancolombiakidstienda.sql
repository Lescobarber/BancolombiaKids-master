-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2023 a las 15:21:15
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bancolombiakidstienda`
--
CREATE DATABASE `bancolombiakidstienda`;

USE `bancolombiakidstienda`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cart`
--

CREATE TABLE `cart` (
  `CartID` int(11) NOT NULL,
  `UserKidID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartproduct`
--

CREATE TABLE `cartproduct` (
  `CartID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `ProductID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Description` text NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shoppingregistry`
--

CREATE TABLE `shoppingregistry` (
  `RegisterID` int(11) NOT NULL,
  `UserKidID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `ShoppingDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userkid`
--

CREATE TABLE `userkid` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `UserKidID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Hobbies` varchar(255) DEFAULT NULL,
  `LoginData` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`CartID`),
  ADD KEY `UserKidID` (`UserKidID`);

--
-- Indices de la tabla `cartproduct`
--
ALTER TABLE `cartproduct`
  ADD PRIMARY KEY (`CartID`,`ProductID`),
  ADD KEY `ProductID` (`ProductID`),
  ADD KEY `CartID` (`CartID`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indices de la tabla `shoppingregistry`
--
ALTER TABLE `shoppingregistry`
  ADD PRIMARY KEY (`RegisterID`),
  ADD KEY `UserKidID` (`UserKidID`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Indices de la tabla `userkid`
--
ALTER TABLE `userkid`
  ADD PRIMARY KEY (`UserKidID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cart`
--
ALTER TABLE `cart`
  MODIFY `CartID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT de la tabla `shoppingregistry`
--
ALTER TABLE `shoppingregistry`
  MODIFY `RegisterID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `userkid`
--
ALTER TABLE `userkid`
  MODIFY `UserKidID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`UserKidID`) REFERENCES `userkid` (`UserKidID`);

--
-- Filtros para la tabla `cartproduct`
--
ALTER TABLE `cartproduct`
  ADD CONSTRAINT `cartproduct_ibfk_1` FOREIGN KEY (`CartID`) REFERENCES `cart` (`CartID`),
  ADD CONSTRAINT `cartproduct_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`);

--
-- Filtros para la tabla `shoppingregistry`
--
ALTER TABLE `shoppingregistry`
  ADD CONSTRAINT `shoppingregistry_ibfk_1` FOREIGN KEY (`UserKidID`) REFERENCES `userkid` (`UserKidID`),
  ADD CONSTRAINT `shoppingregistry_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

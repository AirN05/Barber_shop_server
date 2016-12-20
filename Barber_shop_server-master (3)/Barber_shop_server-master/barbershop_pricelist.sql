-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: barbershop
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pricelist`
--

DROP TABLE IF EXISTS `pricelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pricelist` (
  `id_price` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `options` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_price`),
  UNIQUE KEY `id_price_UNIQUE` (`id_price`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricelist`
--

LOCK TABLES `pricelist` WRITE;
/*!40000 ALTER TABLE `pricelist` DISABLE KEYS */;
INSERT INTO `pricelist` VALUES (1,'муж/жен стрижка','650р','+укладка'),(2,'детская стрижка','450р','+укладка'),(3,'мужская укладка','250р','London Look'),(4,'женская укладка','350р',NULL),(5,'оформление бороды','250р',NULL),(6,'тонирование седины','650р','голова, Precision Blend Americam Crew'),(7,'тонирование седины','350р','борода, Precision Blend Americam Crew'),(8,'бритье опаской','750р','Precision Blend Americam Crew'),(9,'окрашивание длинных волос со смывкой','3400р','+ укладка Loreal Steampod'),(10,'окрашивание длинных волос','2450р','+ укладка Loreal Steampod'),(11,'окрашивание средних волос  со смывкой','2600р','+ укладка Loreal Steampod'),(12,'окрашивание средних волос','1800р','+ укладка Loreal Steampod'),(13,'окрашивание коротких волос со смывкой','1800р','+ укладка Loreal Steampod'),(14,'окрашивание коротких волос','1150р','+ укладка Loreal Steampod'),(15,'уход Loreal Color Vitamino','250р',NULL),(16,'уход Loreal Absolut Celluar Repair','250р',NULL),(17,'Ботокс для волос ','2500р','L+B Essence shots');
/*!40000 ALTER TABLE `pricelist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12  2:46:35

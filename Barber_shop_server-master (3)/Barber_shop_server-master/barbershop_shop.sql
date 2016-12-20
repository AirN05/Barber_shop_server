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
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `id_item` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  UNIQUE KEY `id_item_UNIQUE` (`id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'American Crew Tea Tree-\"3 в 1\" Средство по уходу за волосами и телом 100 мл','/shop/get/americancrew3teatree','Быстрое и эффективное решение для очистки тела и волос в одном продукте.',NULL),(2,'American Crew Tea Tree-Кондиционер на основе чайного дерева 250мл','/shop/get/calmingconditioner250','Легкий увлажнитель волос и кожи головы.',NULL),(3,'American Crew CLASSIC Stimulating- Стимулирующий кондиционер 250 мл','/shop/get/stimulatingconditioner250','Защищает и увлажняет волосы, не утяжеляя их.',NULL),(4,'American Crew CLASSIC Daily -Кондиционер для ежедневного использования 250мл','/shop/get/largeamericancrewdailyconditioner','Уход за волосами и кожей головы.',NULL),(5,'American Crew CLASSIC-\"3-в-1\" Средство по уходу за волосами и телом 450мл','/shop/get/bottle3in1','3-в-1 Средство по уходу за волосами и телом.',NULL),(6,'American Crew Tea Tree-\"3-в-1\" Средство по уходу за волосами и телом 450 мл','/shop/get/americancrew3teatree','Быстрое и эффективное решение для очистки тела и волос в одном продукте.',NULL),(7,'American Crew CLASSIC Daily-Кондиционер для ежедневного использования 1л','/shop/get/6546','Уход за волосами и кожей головы.',NULL),(8,'American Crew CLASSIC Classic Gray -Шампунь для седых волос классический 250мл','/shop/get/bottlegrayshampoo','Оптимальный уход для седых волос.',NULL),(9,'American Crew CLASSIC Hair Recovery+Thickening-Шампунь восстановление+уплотнение волос 250мл','/shop/get/bottlehairrecoveryshampoo','Шампунь для восстановления и уплотнения волос.',NULL),(10,'American Crew CLASSIC Daily-Шампунь ежедневный 250мл','/shop/get/bottledailymoisturingshampoo1','Для нормальных и жирных волос. Нежно очищает волосы и кожу головы.',NULL),(11,'American Crew CLASSIC Daily Moisturizing-Шампунь увлажняющий ежедневный 250мл','/shop/get/6896','Для нормальных и сухих волос. Тонизирует и увлажняет волосы и кожу головы.',NULL),(12,'American Crew CLASSIC Power Cleanser Style Remover-Шампунь глубокой очистки ежедневный 250мл','/shop/get/bottlepowercleanserstyleremover1','Шампунь для глубокого очищения.',NULL),(13,'American Crew CLASSIC Anti Dandruff + Sebum Control-Шампунь против перхоти для жирной кожи головы 250мл','/shop/get/classicantidandruffsebumcontrol','Шампунь против перхоти для жирной кожи головы.',NULL),(14,'American Crew CLASSIC Daily Moisturizing-Шампунь увлажняющий ежедневный 1л','/shop/get/dailymoisturizing','Тонизирует и увлажняет волосы и кожу головы.',NULL),(15,'American Crew CLASSIC Power Cleanser Style Remover-Шампунь глубокой очистки ежедневный 1л','/shop/get/bottlepowercleanserstyleremover','Шампунь для глубокого очищения.',NULL),(16,'American Crew CLASSIC Daily-Шампунь ежедневный 1л','/shop/get/bottledailymoisturingshampoo1','Для нормальных и жирных волос. Нежно очищает волосы и кожу головы.',NULL),(17,'TIJI WISE UP SCALP SHAMPOO','/shop/get/4620bhfmwiseupsha','Jчищает волосы, максимально увлажняет чувствительную кожу головы, избавляя от сухости и дискомфорта.',NULL),(18,'TIJI CLEAN UP DAILY SHAMPOO','/shop/get/cleanupsha','Идеально подходит для ежедневного применения.',NULL),(19,'TIJI CLEAN UP PEPPERMINT CONDITIONER','/shop/get/cleanupcon','Для мужчин, придающих особое значение здоровью волос и кожи головы.',NULL),(20,'TIJI CHARGE UP THICKENING SHAMPOO','/shop/get/chargeupsha','Увеличивает объем и добавляет плотности волосам.',NULL),(21,'TIJI SLICK TRICK','/shop/get/4620bhfmcleanupsha','Идеально подходит для мужчин, готовых к экспериментам. ',NULL),(22,'TIJI PURE TEXTURE MOLDING PASTE','/shop/get/puretexture','Идеально для мужчин, желающих обрести контроль над текстурой. ',NULL),(23,'TIJI POWER PLAY','/shop/get/powerplay','Идеально подходит для фанатов классического геля и сильной фиксации.',NULL),(24,'TIJI MATTE SEPARATION WAX','/shop/get/mattseparation','Идеален для мужчин, которые ценят в укладке степень фиксации и текстуру, без излишнего блеска.',NULL);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12  2:46:34

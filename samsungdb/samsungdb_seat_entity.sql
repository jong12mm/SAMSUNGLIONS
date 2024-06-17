-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: samsungdb
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `seat_entity`
--

DROP TABLE IF EXISTS `seat_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_entity` (
  `seatid` bigint NOT NULL AUTO_INCREMENT,
  `price` decimal(38,2) DEFAULT NULL,
  `reserved` bit(1) NOT NULL,
  `seat_number` varchar(255) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seatid`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_entity`
--

LOCK TABLES `seat_entity` WRITE;
/*!40000 ALTER TABLE `seat_entity` DISABLE KEYS */;
INSERT INTO `seat_entity` VALUES (1,10000.00,_binary '\0','1','Zone 1'),(2,15000.00,_binary '','2','Zone 1'),(3,12000.00,_binary '\0','6','Zone 2'),(4,13000.00,_binary '','2','Zone 2'),(5,20000.00,_binary '\0','6','Zone 3'),(6,25000.00,_binary '','7','Zone 3'),(7,10000.00,_binary '\0','2','Zone 1'),(8,15000.00,_binary '','6','Zone 2'),(9,12000.00,_binary '\0','4','Zone 3'),(10,13000.00,_binary '','5','Zone 4'),(11,20000.00,_binary '\0','3','Zone 5'),(12,25000.00,_binary '','6','Zone 6'),(13,10000.00,_binary '\0','1','Zone 1'),(14,10000.00,_binary '\0','2','Zone 1'),(15,10000.00,_binary '\0','3','Zone 1'),(16,15000.00,_binary '\0','4','Zone 2'),(17,12000.00,_binary '\0','5','Zone 3'),(18,13000.00,_binary '\0','1','Zone 4'),(19,20000.00,_binary '\0','2','Zone 5'),(20,25000.00,_binary '\0','3','Zone 6'),(21,15120.00,_binary '\0','4','Zone 7'),(22,25000.00,_binary '\0','5','Zone 8'),(23,25000.00,_binary '\0','1','Zone 9'),(24,25000.00,_binary '\0','2','Zone 10'),(25,25000.00,_binary '\0','3','Zone 11'),(26,10000.00,_binary '\0','1','Zone 1'),(27,10000.00,_binary '\0','2','Zone 1'),(28,10000.00,_binary '\0','3','Zone 1'),(29,10000.00,_binary '\0','4','Zone 1'),(30,15000.00,_binary '\0','5','Zone 2'),(31,12000.00,_binary '\0','1','Zone 3'),(32,13000.00,_binary '\0','2','Zone 4'),(33,20000.00,_binary '\0','3','Zone 5'),(34,25000.00,_binary '\0','4','Zone 6'),(35,15120.00,_binary '\0','5','Zone 7'),(36,25000.00,_binary '\0','1','Zone 8'),(37,25000.00,_binary '\0','2','Zone 9'),(38,25000.00,_binary '\0','3','Zone 10'),(39,25000.00,_binary '\0','4','Zone 11'),(40,10000.00,_binary '\0','5','Zone 1'),(41,10000.00,_binary '\0','1','Zone 1'),(42,10000.00,_binary '\0','2','Zone 1'),(43,10000.00,_binary '\0','3','Zone 1'),(44,10000.00,_binary '\0','4','Zone 1'),(45,15000.00,_binary '\0','5','Zone 2'),(46,15000.00,_binary '\0','1','Zone 2'),(47,15000.00,_binary '\0','2','Zone 2'),(48,15000.00,_binary '\0','3','Zone 2'),(49,15000.00,_binary '\0','4','Zone 2'),(50,20000.00,_binary '\0','5','Zone 3'),(51,20000.00,_binary '\0','1','Zone 3'),(52,20000.00,_binary '\0','2','Zone 3'),(53,20000.00,_binary '\0','3','Zone 3'),(54,20000.00,_binary '\0','4','Zone 3'),(55,25000.00,_binary '\0','5','Zone 4'),(56,25000.00,_binary '\0','1','Zone 4'),(57,25000.00,_binary '\0','2','Zone 4'),(58,25000.00,_binary '\0','3','Zone 4'),(59,25000.00,_binary '\0','4','Zone 4'),(60,30000.00,_binary '\0','5','Zone 5'),(61,30000.00,_binary '\0','1','Zone 5'),(62,30000.00,_binary '\0','2','Zone 5'),(63,30000.00,_binary '\0','3','Zone 5'),(64,30000.00,_binary '\0','4','Zone 5');
/*!40000 ALTER TABLE `seat_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-17 17:49:09

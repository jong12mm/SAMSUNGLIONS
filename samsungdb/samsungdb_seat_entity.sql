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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_entity`
--

LOCK TABLES `seat_entity` WRITE;
/*!40000 ALTER TABLE `seat_entity` DISABLE KEYS */;
INSERT INTO `seat_entity` VALUES (1,50000.00,_binary '\0','A1','Zone 1'),(2,50000.00,_binary '\0','A2','Zone 1'),(3,60000.00,_binary '\0','A1','Zone 2'),(4,60000.00,_binary '\0','A2','Zone 2'),(5,40000.00,_binary '\0','A1','Zone 3'),(6,40000.00,_binary '\0','A2','Zone 3'),(7,45000.00,_binary '\0','A1','Zone 4'),(8,45000.00,_binary '\0','A2','Zone 4'),(9,50000.00,_binary '\0','A1','Zone 1'),(10,50000.00,_binary '\0','A2','Zone 1'),(11,60000.00,_binary '\0','A1','Zone 2'),(12,60000.00,_binary '\0','A2','Zone 2'),(13,40000.00,_binary '\0','A1','Zone 3'),(14,40000.00,_binary '\0','A2','Zone 3'),(15,45000.00,_binary '\0','A1','Zone 4'),(16,45000.00,_binary '\0','A2','Zone 4');
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

-- Dump completed on 2024-06-18 17:40:44

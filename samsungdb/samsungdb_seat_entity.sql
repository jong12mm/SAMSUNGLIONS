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
  `main_zone` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `reserved` bit(1) NOT NULL,
  `seat_number` varchar(255) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  `game_info_id` bigint DEFAULT NULL,
  `bookid` bigint DEFAULT NULL,
  PRIMARY KEY (`seatid`),
  KEY `FKlu5xlvspi1xdo33y37ht4mfln` (`bookid`),
  CONSTRAINT `FKlu5xlvspi1xdo33y37ht4mfln` FOREIGN KEY (`bookid`) REFERENCES `book_entity` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_entity`
--

LOCK TABLES `seat_entity` WRITE;
/*!40000 ALTER TABLE `seat_entity` DISABLE KEYS */;
INSERT INTO `seat_entity` VALUES (1,'sky_top',50000.00,_binary '\0','A1','Zone 1',NULL,NULL),(2,'sky_top',50000.00,_binary '\0','A2','Zone 1',NULL,NULL),(3,'sky_top',60000.00,_binary '','A1','Zone 2',NULL,NULL),(4,'sky_top',60000.00,_binary '','A2','Zone 2',NULL,NULL),(5,'sky_top',40000.00,_binary '','A1','Zone 3',NULL,NULL),(6,'sky_top',40000.00,_binary '','A2','Zone 3',NULL,NULL),(7,'sky_top',45000.00,_binary '\0','A1','Zone 4',NULL,NULL),(8,'sky_top',45000.00,_binary '\0','A2','Zone 4',NULL,NULL),(9,'blue_zone',50000.00,_binary '\0','A1','Zone 1',NULL,NULL),(10,'blue_zone',50000.00,_binary '\0','A2','Zone 1',NULL,NULL),(11,'blue_zone',60000.00,_binary '','A1','Zone 2',NULL,NULL),(12,'blue_zone',60000.00,_binary '','A2','Zone 2',NULL,NULL),(13,'blue_zone',40000.00,_binary '','A1','Zone 3',NULL,NULL),(14,'blue_zone',40000.00,_binary '','A2','Zone 3',NULL,NULL),(15,'blue_zone',45000.00,_binary '\0','A1','Zone 4',NULL,NULL),(16,'blue_zone',45000.00,_binary '\0','A2','Zone 4',NULL,NULL),(17,'sky_top',10000.00,_binary '\0','A1','Zone 1',NULL,NULL),(18,'sky_top',10000.00,_binary '','A2','Zone 1',NULL,NULL),(19,'sky_top',10000.00,_binary '','A3','Zone 1',NULL,NULL),(20,'sky_top',10000.00,_binary '','B1','Zone 2',NULL,NULL),(21,'sky_top',10000.00,_binary '','B2','Zone 2',NULL,NULL),(22,'sky_top',10000.00,_binary '','B3','Zone 2',NULL,NULL),(23,'blue_zone',20000.00,_binary '','C1','Zone 1',NULL,NULL),(24,'blue_zone',20000.00,_binary '','C2','Zone 1',NULL,NULL),(25,'blue_zone',20000.00,_binary '\0','C3','Zone 1',NULL,NULL),(26,'blue_zone',20000.00,_binary '','D1','Zone 2',NULL,NULL),(27,'blue_zone',20000.00,_binary '','D2','Zone 2',NULL,NULL),(28,'blue_zone',20000.00,_binary '','D3','Zone 2',NULL,NULL),(29,'3rd_tb',15000.00,_binary '\0','E1','Zone 1',NULL,NULL),(30,'3rd_tb',15000.00,_binary '','E2','Zone 1',NULL,NULL),(31,'3rd_tb',15000.00,_binary '\0','E3','Zone 1',NULL,NULL),(32,'3rd_tb',15000.00,_binary '','F1','Zone 2',NULL,NULL),(33,'3rd_tb',15000.00,_binary '\0','F2','Zone 2',NULL,NULL),(34,'3rd_tb',15000.00,_binary '','F3','Zone 2',NULL,NULL),(35,'sky_bot',12000.00,_binary '\0','G1','Zone 1',NULL,NULL),(36,'sky_bot',12000.00,_binary '\0','G2','Zone 1',NULL,NULL),(37,'sky_bot',12000.00,_binary '\0','G3','Zone 1',NULL,NULL),(38,'sky_bot',12000.00,_binary '','H1','Zone 2',NULL,NULL),(39,'sky_bot',12000.00,_binary '\0','H2','Zone 2',NULL,NULL),(40,'sky_bot',12000.00,_binary '\0','H3','Zone 2',NULL,NULL),(41,'vip',25000.00,_binary '\0','I1','Zone 1',NULL,NULL),(42,'vip',25000.00,_binary '','I2','Zone 1',NULL,NULL),(43,'vip',25000.00,_binary '\0','I3','Zone 1',NULL,NULL),(44,'vip',25000.00,_binary '','J1','Zone 2',NULL,NULL),(45,'vip',25000.00,_binary '\0','J2','Zone 2',NULL,NULL),(46,'vip',25000.00,_binary '\0','J3','Zone 2',NULL,NULL),(47,'1st_tb',17000.00,_binary '\0','K1','Zone 1',NULL,NULL),(48,'1st_tb',17000.00,_binary '\0','K2','Zone 1',NULL,NULL),(49,'1st_tb',17000.00,_binary '\0','K3','Zone 1',NULL,NULL),(50,'1st_tb',17000.00,_binary '','L1','Zone 2',NULL,NULL),(51,'1st_tb',17000.00,_binary '\0','L2','Zone 2',NULL,NULL),(52,'1st_tb',17000.00,_binary '\0','L3','Zone 2',NULL,NULL),(53,'1st_tb',1.00,_binary '','L4','Zone 2',NULL,NULL);
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

-- Dump completed on 2024-06-25 17:51:07

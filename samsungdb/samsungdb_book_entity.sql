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
-- Table structure for table `book_entity`
--

DROP TABLE IF EXISTS `book_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_entity` (
  `bookid` bigint NOT NULL AUTO_INCREMENT,
  `bookstatus` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `gameinfo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `payid` varchar(255) DEFAULT NULL,
  `seat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_entity`
--

LOCK TABLES `book_entity` WRITE;
/*!40000 ALTER TABLE `book_entity` DISABLE KEYS */;
INSERT INTO `book_entity` VALUES (1,'예약됨','2024-06-18 14:45:52.144232','NC다이노스','이종일',NULL,NULL),(2,'예약됨','2024-06-18 15:06:50.648922','SSG랜더스','sdf',NULL,NULL),(3,'예약됨','2024-06-18 15:09:05.451854','SSG랜더스','sdf',NULL,NULL),(4,'예약됨','2024-06-18 15:20:13.387278','SSG랜더스','이종일','bank',NULL),(5,'예약됨','2024-06-18 15:22:10.889732','NC다이노스','이종일','bank',NULL),(6,'예약됨','2024-06-18 16:54:57.905095','SSG랜더스','이종일','card',NULL);
/*!40000 ALTER TABLE `book_entity` ENABLE KEYS */;
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

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
-- Table structure for table `payment_entity`
--

DROP TABLE IF EXISTS `payment_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_entity` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(38,2) DEFAULT NULL,
  `payment_date_time` datetime(6) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  `cancel_amount` decimal(38,2) DEFAULT NULL,
  `imp_uid` varchar(255) DEFAULT NULL,
  `merchant_uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FKcty5cjs5mjj3ymbgh5rgyq9e` (`book_id`),
  CONSTRAINT `FKcty5cjs5mjj3ymbgh5rgyq9e` FOREIGN KEY (`book_id`) REFERENCES `book_entity` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_entity`
--

LOCK TABLES `payment_entity` WRITE;
/*!40000 ALTER TABLE `payment_entity` DISABLE KEYS */;
INSERT INTO `payment_entity` VALUES (1,40000.00,'2024-06-24 16:50:22.587039','bank','성공',12,NULL,NULL,NULL),(2,25000.00,'2024-06-24 17:25:22.316916','mobile','성공',13,NULL,NULL,NULL),(3,40000.00,'2024-06-24 17:44:26.160692','bank','성공',14,NULL,NULL,NULL),(11,45000.00,'2024-06-25 16:24:37.303411','mobile','성공',50,NULL,NULL,NULL),(12,45000.00,'2024-06-25 16:34:49.467046','mobile','성공',51,NULL,NULL,NULL),(13,15000.00,'2024-06-25 16:39:11.029445','mobile','성공',52,NULL,NULL,NULL),(14,20000.00,'2024-06-25 17:02:23.454370','card','성공',54,NULL,NULL,NULL),(15,1.00,'2024-06-25 17:24:21.957668','phone','paid',NULL,0.00,'imp_234832741539','merchant_b9fa0c16-a2ed-4c4c-a809-c83c597a5573'),(16,1.00,'2024-06-26 15:48:48.750333','phone','paid',NULL,0.00,'imp_900487993183','merchant_117d667e-82a4-4bae-8128-b3c6686ddfaf'),(17,1.00,'2024-06-27 10:27:58.827775','phone','cancelled',63,1.00,'imp_472632466211','merchant_ed9a5c47-e21f-444c-86a7-899bcd850635'),(18,1.00,'2024-06-27 10:47:54.266697','phone','paid',64,0.00,'imp_451838454128','merchant_f4e85a0e-7251-497e-b8bc-0d8ecdd6591c'),(19,9.00,'2024-06-27 11:06:49.716431','phone','cancelled',65,9.00,'imp_749986228207','merchant_d468b30f-3b01-4e25-9504-a1ee9dd7c98b');
/*!40000 ALTER TABLE `payment_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-27 11:21:53

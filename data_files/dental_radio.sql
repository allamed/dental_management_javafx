-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: dental
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `radio`
--

DROP TABLE IF EXISTS `radio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radio` (
  id int PRIMARY KEY NOT NULL,
  date date DEFAULT NULL,
  chemin_image varchar(120) DEFAULT NULL,
  id_type int DEFAULT NULL,
  id_acte int DEFAULT NULL
  
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radio`
--

/*!40000 ALTER TABLE `radio` DISABLE KEYS */;
INSERT INTO `radio` VALUES (8,'2022-04-07','dental-xray-2-825x550.jpg',3,5),(9,'2022-04-13','The-Science-of-Modern-Dental-X-Rays.jpg',3,5),(10,'2022-03-29','22.jpg',4,5),(11,'2022-03-29','dental-xray-2-825x550.jpg',5,5),(12,'2022-04-08','images.jpg',2,5),(13,'2022-04-07','images (1).jpg',3,5),(14,'2022-04-13','22.jpg',2,8),(15,'2022-04-13','images.jpg',4,8),(16,'2022-05-10','The-Science-of-Modern-Dental-X-Rays.jpg',3,6);
/*!40000 ALTER TABLE `radio` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04  0:54:08

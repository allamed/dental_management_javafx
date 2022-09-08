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
-- Table structure for table `acte_medical`
--

DROP TABLE IF EXISTS `acte_medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acte_medical` (
  id int PRIMARY KEY NOT NULL,
  debut_soin date DEFAULT NULL,
  prix_comptabilise float DEFAULT NULL,
  etat_acte varchar(45) DEFAULT NULL,
fin_soin date DEFAULT NULL,
  id_patient int DEFAULT NULL
  
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acte_medical`
--

/*!40000 ALTER TABLE `acte_medical` DISABLE KEYS */;
INSERT INTO `acte_medical` VALUES (1,'2022-04-14',0,'en cours',NULL,5),(2,'2022-04-13',0,'terminé','2022-04-04',9),(3,'2022-04-20',0,'terminé','2022-04-06',6),(4,'2022-04-21',0,'terminé','2022-04-04',10),(5,'2022-04-15',1520,'en cours',NULL,5),(6,'2022-04-14',0,'en cours',NULL,6),(7,'2022-04-14',0,'terminé','2022-04-08',NULL),(8,'2022-04-13',300,'en cours',NULL,5),(9,'2022-04-21',0,'en cours',NULL,9),(10,'2022-04-05',0,'en cours',NULL,4),(11,'2022-04-22',0,'en cours',NULL,17),(12,'2022-04-22',0,'en cours',NULL,22),(13,'2022-04-22',0,'en cours',NULL,21);
/*!40000 ALTER TABLE `acte_medical` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04  0:54:06

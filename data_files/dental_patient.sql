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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  id integer primary key NOT NULL ,
  naissance date DEFAULT NULL,
  cin varchar(45) DEFAULT NULL,
  nom varchar(45) DEFAULT NULL,
  prenom varchar(45) DEFAULT NULL,
  sexe varchar(45) DEFAULT NULL,
  date_inscription date DEFAULT (curdate()) ) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'2022-04-06','hv552','fettah','imadeddine','Masculin','2022-04-01'),(4,'2022-04-20','qh52663','aouad','oussama','Masculin','2022-04-02'),(5,'2022-04-14','gh5225','allam','mohamed','Masculin','2022-04-02'),(6,'2022-04-06','gf5566','diouhri ','aya','Féminin','2022-04-05'),(8,'2022-04-27','5522hg','yassmina','aarabe','Féminin','2022-04-05'),(9,'2022-04-27','5522hg','ihssan','dahbi','Féminin','2022-04-07'),(10,'2022-04-27','5522hg','youssra','slimani','Féminin','2022-04-07'),(11,'2022-04-10','gh558','elhasbi','ayat','Féminin','2022-04-10'),(12,'2022-04-07','fg5554','tlemsani','anas','Masculin','2022-04-10'),(14,'2022-04-06','gf213','lamin','younesse','Masculin','2022-04-13'),(15,'2022-04-04','fg2169','wahabi','samira','Féminin','2022-04-13'),(16,'2022-04-04','fg2169','lambarki','ikram','Féminin','2022-04-13'),(17,'2022-04-04','fg55895','loukili','mehdi','Masculin','2022-04-13'),(18,'2001-04-13','ff5566','najib','mahfoud','Masculin','2022-04-13'),(19,'2001-04-13','ff5566','malki','samira','Féminin','2022-04-13'),(20,'2003-04-17','gh5544','malainine','limame','Masculin','2022-04-15'),(21,'2022-04-21','fg5566','echarfaouy','mohamed','Masculin','2022-04-23'),(22,'2001-04-12','zg12554','ngadi','abdelilah','Masculin','2022-04-30');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04  0:54:07

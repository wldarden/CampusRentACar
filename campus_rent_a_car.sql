-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: campus_rent_a_car
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
`uta_id` varchar(10) NOT NULL,
  `role` varchar(10) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(35) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(65) NOT NULL,
  `auto_club_member` tinyint(4),
  `dob` varchar(45) DEFAULT NULL,
  `revoked` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`User_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES 
('1002456871','User','echo123','mikePass3&','Jeff Wall','8178751234','jeffWall@gmail.com','1246 Main Arlington 5429','1','05-04-1980','0'),
('1001112356','Manager','johnManager','pass1#cW','John Lee','817-443-3666','johnLee@gmail.com','1245 Main Arlington 5429','0','05-04-2001','0'),
('1009875123','User','table','pTT$3rtg','Mike Miami','8177778899','mike@uta.mavs.edu','1247 Main Arlington 5429','0','10-03-1996','0'),
('1001112356','Admin','utaJohn','pass1#cW','John Lee','(817)443-3666','johnLee@gmail.com','1245 Main Arlington 5429','0','05-04-2001','0'),
('1005774584','User','refreshe','drinkingW&4','Ann doan','8145122299','ann@uta.mavs.edu','4578 South St Arlington 5429','0','10-03-1985','0'),
('1008877994','User','dj34567%','dj34567%','Amy Sali','8175426894','amy@uta.mavs.edu','9999 South St Arlington 5429','0','05-02-2000','0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-02 13:59:19

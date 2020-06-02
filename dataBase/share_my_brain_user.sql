-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: share_my_brain
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(256) NOT NULL,
  `id_avatar` int(11) NOT NULL,
  `id_skill` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `user_avatar_FK` (`id_avatar`),
  KEY `user_skill0_FK` (`id_skill`),
  CONSTRAINT `user_avatar_FK` FOREIGN KEY (`id_avatar`) REFERENCES `avatar` (`id_avatar`),
  CONSTRAINT `user_skill0_FK` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id_skill`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'elisego','elise@wild.com','ccadd99b16cd3d200c22d6db45d8b6630ef3d936767127347ec8a76ab992c2ea',3,4),(7,'marcus18','marcus@gmail.com','0b1b8e9fc13fa4c07a6d7983ee14619bd71f2ea4001c2c6dba9ab79da4920d5c',1,3),(8,'kakou','kakou@gmail.com','312f9d6d8559d52ebff1dc501db57b29b96afb9aabb8d6293aa30f8f43c8f3b0',1,1),(16,'macaco','macaco@gmail.com','688787d8ff144c502c7f5cffaafe2cc588d86079f9de88304c26b0cb99ce91c6',4,1),(17,'minestroni','minestroni@gmail.com','688787d8ff144c502c7f5cffaafe2cc588d86079f9de88304c26b0cb99ce91c6',8,4),(18,'pecas','pecas@gmail.com','688787d8ff144c502c7f5cffaafe2cc588d86079f9de88304c26b0cb99ce91c6',1,4),(19,'aurelien','aurelien@wild.com','57438ed23418ec8ac69b39a051f4438799013f83c3ffbcace5f6021a8faa2001',8,3),(20,'alan','alan@wil.co','708b1a7a6c6507b55ab537894493b61d46230ceeb21b605838a050a75c7ef0bb',7,6),(21,'swann','swann@wild.co','f26bcd2a270d586f811db3b51969dbbc6203633768c2c5182860ff32e08563d1',5,2),(22,'morgan','morgan@wild.co','5d5e0a0a2c2f5580ea71d0a8bef1c121471435e678dad23ad85c9205d721b406',6,4),(23,'anne','anne@wild.co','8bd31ef92a9bb5d9eacf47c5d5ec2f54ff8805e254b33c33708eb6726780abdb',1,5),(24,'mroldan','mroldan@gmail.com','0b1b8e9fc13fa4c07a6d7983ee14619bd71f2ea4001c2c6dba9ab79da4920d5c',6,4),(25,'mroldan747','mroldan747@gmail.com','0b1b8e9fc13fa4c07a6d7983ee14619bd71f2ea4001c2c6dba9ab79da4920d5c',5,3),(26,'merlu','merlu@gmail.com','55eaa01db8877a58d3955b7654822f30cd286a631930e819a9299accda9e88bc',8,4),(27,'goofy','goofy@gmail.com','0b1b8e9fc13fa4c07a6d7983ee14619bd71f2ea4001c2c6dba9ab79da4920d5c',3,3),(28,'floofy','foolfy@gmail.com','0b1b8e9fc13fa4c07a6d7983ee14619bd71f2ea4001c2c6dba9ab79da4920d5c',6,5);
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

-- Dump completed on 2020-05-26 17:50:37

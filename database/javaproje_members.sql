 SET NAMES utf8 ;

DROP TABLE IF EXISTS `members`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `members` (
  `ad` varchar(45) NOT NULL,
  `soyad` varchar(45) NOT NULL,
  `kullaniciadi` varchar(30) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sifre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `members` WRITE;

UNLOCK TABLES;
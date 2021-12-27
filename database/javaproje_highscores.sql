 SET NAMES utf8 ;

DROP TABLE IF EXISTS `highscores`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `highscores` (
  `kullaniciadi` varchar(45) NOT NULL,
  `skor` int(11) NOT NULL,
  `sure` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `highscores` WRITE;

UNLOCK TABLES;
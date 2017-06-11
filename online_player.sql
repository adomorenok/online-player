-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: online_player
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author_tag`
--

DROP TABLE IF EXISTS `author_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author_tag` (
  `author_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`author_id`,`tag_id`),
  KEY `FK7u4elvrjbqr9ydtmggje64sva` (`tag_id`),
  CONSTRAINT `FK2o47m42wm7uslsmd9kfk2qu2a` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FK7u4elvrjbqr9ydtmggje64sva` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_tag`
--

LOCK TABLES `author_tag` WRITE;
/*!40000 ALTER TABLE `author_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `author_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8q80g2puy49wsp49p3taqllv` (`user_id`),
  CONSTRAINT `FKj8q80g2puy49wsp49p3taqllv` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_track`
--

DROP TABLE IF EXISTS `playlist_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist_track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `playlist_id` bigint(20) DEFAULT NULL,
  `track_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2n53hmeho3pcyrrrl12ck69r4` (`playlist_id`),
  KEY `FKf9qyasbwmrlc4tb1vfll54bot` (`track_id`),
  CONSTRAINT `FKf9qyasbwmrlc4tb1vfll54bot` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`),
  CONSTRAINT `FK2n53hmeho3pcyrrrl12ck69r4` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_track`
--

LOCK TABLES `playlist_track` WRITE;
/*!40000 ALTER TABLE `playlist_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `playlist_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5hr3mvggn58rxsvuc7oadkaik` (`playlist_id`),
  CONSTRAINT `FK5hr3mvggn58rxsvuc7oadkaik` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `album_id` bigint(20) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaxm9pbgk7ptorfyk3o6911q05` (`album_id`),
  KEY `FKct0bno4edm11afwl1l79uco6y` (`author_id`),
  CONSTRAINT `FKct0bno4edm11afwl1l79uco6y` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKaxm9pbgk7ptorfyk3o6911q05` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_team`
--

DROP TABLE IF EXISTS `users_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_team` (
  `team_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK9sxddw43xnts7af421l1vn0oy` (`user_id`),
  KEY `FKju2qittgiknj29l07uji9lfsv` (`team_id`),
  CONSTRAINT `FKju2qittgiknj29l07uji9lfsv` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FK9sxddw43xnts7af421l1vn0oy` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_team`
--

LOCK TABLES `users_team` WRITE;
/*!40000 ALTER TABLE `users_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-11  3:10:02

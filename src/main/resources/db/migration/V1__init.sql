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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `FK_author_tag_tag_id` (`tag_id`),
  CONSTRAINT `FK_author_tag_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FK_author_tag_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `FK_playlist_user_id` (`user_id`),
  CONSTRAINT `FK_playlist_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `FK_playlist_track_playlist_id` (`playlist_id`),
  KEY `FK_playlist_track_track_id` (`track_id`),
  CONSTRAINT `FK_playlist_track_track_id` FOREIGN KEY (`track_id`) REFERENCES `track` (`id`),
  CONSTRAINT `FK_playlist_track_playlist_id` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `FK_team_playlist_id` (`playlist_id`),
  CONSTRAINT `FK_team_playlist_id` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  KEY `FK_track_album_id` (`album_id`),
  KEY `FK_track_author_id` (`author_id`),
  CONSTRAINT `FK_track_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FK_track_album_id` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  UNIQUE KEY `UK_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users_playlist`
--

DROP TABLE IF EXISTS `users_playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_team` (
  `team_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK_users_playlist_user_id` (`user_id`),
  KEY `FK_users_playlist_team_id` (`team_id`),
  CONSTRAINT `FK_users_playlist_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FK_users_playlist_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

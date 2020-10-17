-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.16-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for sex
DROP DATABASE IF EXISTS `sex`;
CREATE DATABASE IF NOT EXISTS `sex` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sex`;


-- Dumping structure for table sex.cities
DROP TABLE IF EXISTS `cities`;
CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table sex.cities: ~6 rows (approximately)
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` (`id`, `name`) VALUES
	(1, 'Voenna Rampa'),
	(2, 'Burgas'),
	(4, 'Varna'),
	(5, 'Chepinsko'),
	(6, 'Plovdiv'),
	(7, 'Sofia');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;


-- Dumping structure for table sex.countries
DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table sex.countries: ~6 rows (approximately)
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` (`id`, `name`) VALUES
	(1, 'Bulgaria'),
	(2, 'Румъния'),
	(3, 'Sweden'),
	(4, 'Russia'),
	(5, 'Ukraine'),
	(6, 'Yarkutstk');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;


-- Dumping structure for table sex.genders
DROP TABLE IF EXISTS `genders`;
CREATE TABLE IF NOT EXISTS `genders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sex.genders: ~2 rows (approximately)
/*!40000 ALTER TABLE `genders` DISABLE KEYS */;
INSERT INTO `genders` (`id`, `name`) VALUES
	(1, 'Male'),
	(2, 'Female');
/*!40000 ALTER TABLE `genders` ENABLE KEYS */;


-- Dumping structure for table sex.messages
DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL DEFAULT '0',
  `recipient_id` int(11) NOT NULL DEFAULT '0',
  `message` mediumtext NOT NULL,
  `is_read` bit(1) NOT NULL DEFAULT b'0',
  `deleted_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_messages_sender_id_people_id` (`sender_id`),
  KEY `FK_messages_recipient_id_people_id` (`recipient_id`),
  CONSTRAINT `FK_messages_recipient_id_people_id` FOREIGN KEY (`recipient_id`) REFERENCES `people` (`id`),
  CONSTRAINT `FK_messages_sender_id_people_id` FOREIGN KEY (`sender_id`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table sex.messages: ~0 rows (approximately)
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` (`id`, `sender_id`, `recipient_id`, `message`, `is_read`, `deleted_on`) VALUES
	(1, 5, 17, 'zdr kp ceco az sam w beograd are da se widime na krachma', b'1', NULL),
	(2, 17, 17, 'ae pishi be', b'1', NULL),
	(3, 17, 16, 'mile kp we', b'0', NULL),
	(4, 23, 17, 'Cecoooo\r\n', b'0', NULL),
	(5, 17, 5, 'mi nishto penche ko da pr', b'0', NULL),
	(6, 17, 5, 'emi nishto penche ko da si praq', b'0', NULL);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;


-- Dumping structure for table sex.people
DROP TABLE IF EXISTS `people`;
CREATE TABLE IF NOT EXISTS `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `born_on` datetime NOT NULL,
  `gender_id` int(11) DEFAULT NULL,
  `sexual_orientation_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `city_id` int(11) DEFAULT NULL,
  `description` mediumtext,
  `picture` varchar(255) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_people_countries` (`country_id`),
  KEY `FK_people_cities` (`city_id`),
  KEY `FK_people_genders` (`gender_id`),
  KEY `FK_people_sexual_orientations` (`sexual_orientation_id`),
  CONSTRAINT `FK_people_cities` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_people_countries` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_people_genders` FOREIGN KEY (`gender_id`) REFERENCES `genders` (`id`),
  CONSTRAINT `FK_people_sexual_orientations` FOREIGN KEY (`sexual_orientation_id`) REFERENCES `sexual_orientations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumping data for table sex.people: ~15 rows (approximately)
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` (`id`, `first_name`, `last_name`, `nickname`, `phone`, `password`, `email`, `born_on`, `gender_id`, `sexual_orientation_id`, `country_id`, `city_id`, `description`, `picture`, `deleted_on`) VALUES
	(5, 'Penka', 'Petrova', 'Пенчето', '', '6267437a1732f140951ade25a7d68a0b', 'пенка@abv.bg', '1994-04-23 14:38:51', 2, 2, 2, 5, NULL, NULL, NULL),
	(6, 'Митко', 'Митачев', 'Митачето', '', '*531E182E2F72080AB0740FE2F2D689DBE0146E04', 'mitkomitkoooo@abv.bg', '1993-11-11 12:11:23', 1, 1, 1, 5, NULL, NULL, NULL),
	(7, 'Maria', 'StamatovA', 'Марчето', '', '*68484737735FFCDEEB048B050540FAAF3C26EB4B', 'm.stamatova@abv.bg', '2001-03-21 12:31:33', 2, 2, 5, 4, 'Маааарче, кажи ми имаш ли другарче', NULL, NULL),
	(8, 'Митко', 'Митачев', 'Митачето1', '', '250cf8b51c773f3f8dc8b4be867a9a02', 'mitkomitkoooo1@abv.bg', '1993-11-11 12:11:23', 1, 1, 4, 4, NULL, NULL, '2017-02-27 17:13:05'),
	(9, 'Penka\' OR country_id = 4 ORDER BY id DESC; -- ', 'StamatovA', 'Марчето1', '', '562d088869acc123fd63c3184a2ade3f', 'm.stamatova@abv.bg1', '1996-03-21 12:31:33', 2, 3, 2, 6, 'Маааарче, кажи ми имаш ли другарче', NULL, NULL),
	(10, 'gsaf', 'gdfgdf', 'dgdfg', '', 'dfgfdg', 'dgdfgdf', '2000-02-27 16:38:50', 2, 1, 4, 1, NULL, NULL, NULL),
	(11, 'doncho', 'manolov', 'stamat', '08883332222', '$2y$10$/TdyrDQSiqi4tp1XdRV2T.OLe9Ni5gDZtJp9yWx6LuSXmnWxe9YMm', 'turbomanolov13@abv.bg', '1996-02-03 00:00:00', 1, 1, 6, 5, '', '/workshop-0803/avatars/K01.png', NULL),
	(12, 'Mara', 'Otvarachkova', 'Obshtata', '123333', '$2y$10$p2.QG.MpT2UMcKQwKqE1eO69sP37rhBFLTFVdr07OG3vJW5HvbLwa', 'mara@obshtata.com', '1994-12-11 00:00:00', 2, 2, 1, 6, 'Аз съм общата, да си знаете!', NULL, NULL),
	(13, 'DrugaMara', 'DrugaOtvarachka', 'Obshta', '134355325', '$2y$10$Ij3VxXPfqPjUdo1UVJXth.7EkKt2G37LVQX3X4She9Btt3IwcKQme', 'obshta@mara.com', '1993-03-01 00:00:00', 2, 2, 5, 1, ':))', '/workshop-0803/avatars/G21.png', NULL),
	(14, 'TretaObsht', 'TretaObshtata', 'Druga', '234235346', '$2y$10$PwjxrOZ7jfZg4YQlxyGc2eVJoXZ20lNTjoqS7MoxxZx9z9yyn6YFe', 'sdfsg@sdfsg.com', '1992-02-02 00:00:00', 2, 2, 2, 6, '(((:', '/workshop-0803/avatars/N03.png', NULL),
	(15, 'Gruio', 'Gechev', 'Gruikata', 'wsdq3r4245', '$2y$10$CB2QoZU1I59.Atcx7LnqF.D8hVl7V4Dzl2R22cadanptKhmhZEyk6', 'gruio@habv.bg', '1990-11-21 21:43:46', 1, 2, 3, 6, '', NULL, NULL),
	(16, 'Mil3', 'K1t1c', 'KralicaTrotoara', '24534t346', '$2y$10$JNp9RHHERE8aTnLzVRLfW.Ir.XR8jAIPSpAs/7pLLLaLcgD2sUSaS', 'saban@pink.com', '1988-12-13 00:00:00', 1, 3, 2, 2, 'Paklene godine', '/workshop-0803/avatars/G48.png', NULL),
	(17, 'Sv3tl4n4', 'R4zn4t0vic', 'Ceca', '24534657', '$2y$10$pRsaz82hiibd9j9j0fxftuq6D6Ryjn1CkUDbz8vHr5XPIJwBBD/ee', 'ceca@p1nk.com', '1971-10-09 00:00:00', 2, 1, 4, 5, 'Ti si samo jedna vise kukavicaaaaa', '/workshop-0803/avatars/G11.png', NULL),
	(19, 'nqkoi na 50', 'sffdg', 'sgfdgh', 'dgfhgfh', 'fhgfhgfh', 'fghgfh', '1990-12-12 12:12:12', 2, 3, 3, 4, NULL, NULL, NULL),
	(21, 'sgdfgfg', 'dfgdfg', 'dfgdfgfdg', 'dgfdg', 'dfgfdgfdgdfgdfg', '23rfwe23e', '1961-11-12 13:14:15', 2, 3, 6, 4, NULL, NULL, NULL),
	(23, 'msg', 'msg', 'msg', 'msg', '$2y$10$TV4qBw3rlPQ3SmeHF/04PODXMwH4gQNeEp74xEar4ocMMuNCucJtu', 'msg2msg@msg.x', '1971-10-09 00:00:00', 2, 1, 1, 2, 'sfdfbdg', '/workshop-0803\\avatars\\58c01613ca84c_C05.png', NULL);
/*!40000 ALTER TABLE `people` ENABLE KEYS */;


-- Dumping structure for table sex.sexual_orientations
DROP TABLE IF EXISTS `sexual_orientations`;
CREATE TABLE IF NOT EXISTS `sexual_orientations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table sex.sexual_orientations: ~3 rows (approximately)
/*!40000 ALTER TABLE `sexual_orientations` DISABLE KEYS */;
INSERT INTO `sexual_orientations` (`id`, `name`) VALUES
	(1, 'Straight'),
	(2, 'Bi'),
	(3, 'Homo');
/*!40000 ALTER TABLE `sexual_orientations` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

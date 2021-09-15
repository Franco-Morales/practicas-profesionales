/*
SQLyog Ultimate v9.63 
MySQL - 5.5.5-10.4.11-MariaDB : Database - videojuegos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`videojuegos` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `videojuegos`;

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `categorias` */

insert  into `categorias`(`id`,`activo`,`nombre`) values (1,'','Sandbox'),(2,'','Aventura'),(3,'\0','Terror');

/*Table structure for table `estudios` */

DROP TABLE IF EXISTS `estudios`;

CREATE TABLE `estudios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `estudios` */

insert  into `estudios`(`id`,`activo`,`nombre`) values (1,'','Estudio 1'),(2,'','Estudio 2'),(3,'\0','Estudio Test');

/*Table structure for table `videojuegos` */

DROP TABLE IF EXISTS `videojuegos`;

CREATE TABLE `videojuegos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_lanzamiento` datetime DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL,
  `titulo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_categoria` bigint(20) NOT NULL,
  `fk_estudio` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK54ev8cdsfhbdfxufd9wc8g23x` (`fk_categoria`),
  KEY `FKev9v8m1hnvqlpne73pgko027c` (`fk_estudio`),
  CONSTRAINT `FK54ev8cdsfhbdfxufd9wc8g23x` FOREIGN KEY (`fk_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `FKev9v8m1hnvqlpne73pgko027c` FOREIGN KEY (`fk_estudio`) REFERENCES `estudios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `videojuegos` */

insert  into `videojuegos`(`id`,`activo`,`descripcion`,`fecha_lanzamiento`,`imagen`,`precio`,`stock`,`titulo`,`fk_categoria`,`fk_estudio`) values (1,'\0','Descripcion 1a','2021-08-28 03:00:00','https://e.rpp-noticias.io/normal/2016/10/14/035103_266475.png',155,10,'Tetris ',1,1),(2,'','Descripcion 2','2021-07-26 21:49:36','https://e.rpp-noticias.io/normal/2016/10/14/035103_266475.png',250,0,'Tetris II ',1,1),(3,'','Descripcion 3','2021-09-06 21:50:17','https://e.rpp-noticias.io/normal/2016/10/14/035103_266475.png',375,12,'Tetris III',1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

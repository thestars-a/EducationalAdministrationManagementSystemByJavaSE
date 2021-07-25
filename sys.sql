/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.50-log : Database - db_stu_sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_stu_sys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_stu_sys`;

/*Table structure for table `computer_subject` */

DROP TABLE IF EXISTS `computer_subject`;

CREATE TABLE `computer_subject` (
  `subject_name` varchar(20) NOT NULL,
  `tec_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `computer_subject` */

insert  into `computer_subject`(`subject_name`,`tec_num`) values ('javaEE',NULL),('云计算',NULL),('数值计算',NULL),('数据库系统',NULL),('离散数学',NULL),('移动端开发',NULL),('程序理论','192030429'),('自然语言处理',NULL),('计算机网络应用',NULL),('软件工程','192030429');

/*Table structure for table `game_subject` */

DROP TABLE IF EXISTS `game_subject`;

CREATE TABLE `game_subject` (
  `subject_name` varchar(20) NOT NULL,
  `tec_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `game_subject` */

insert  into `game_subject`(`subject_name`,`tec_num`) values ('Facker的核心技术',NULL),('LPL经验之谈',NULL),('上单教学',NULL),('产业管理','192030427'),('战队管理',NULL),('打野思路',NULL),('最强王者的晋级之路',NULL),('极限拉扯','192030427'),('电竞文化史',NULL),('课程设计',NULL);

/*Table structure for table `login_info` */

DROP TABLE IF EXISTS `login_info`;

CREATE TABLE `login_info` (
  `id` varchar(20) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `login_info` */

insert  into `login_info`(`id`,`category`,`time`) values ('123456789','学生','2021-06-21 20:35:22'),('192030429','教师','2021-06-21 20:36:37'),('192030429','教师','2021-06-21 20:37:33'),('192030429','教师','2021-06-21 20:38:06');

/*Table structure for table `stu_info` */

DROP TABLE IF EXISTS `stu_info`;

CREATE TABLE `stu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `colloege` varchar(30) DEFAULT NULL,
  `secret_que` varchar(40) DEFAULT NULL,
  `secret_ans` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `stu_info` */

insert  into `stu_info`(`id`,`stu_id`,`name`,`sex`,`colloege`,`secret_que`,`secret_ans`) values (5,'192030429','聂成鹏','女','合肥推拿','聂成鹏的爸爸是谁呀','张文豪'),(6,'192030427','白天宇','男','计算机科学与技术','爸爸是谁','张文豪'),(7,'192030425','薛江源','男','计算机科学与技术','爸爸是谁','张文豪'),(8,'192030423','杨永麒','男','电子竞技','爸爸是谁呀','张文豪'),(9,'192030420','张世龙','男','电子竞技','爸爸是谁呀','当然是张文豪'),(27,'192030430','上官婉儿','女','计算机科学与技术','爸爸是谁','张文豪'),(28,'192030431','尔康','男','计算机科学与技术','爸爸是谁','张文豪'),(29,'192030432','明世隐','男','计算机科学与技术','爸爸是谁','张文豪'),(30,'192030433','后裔','男','计算机科学与技术','爸爸是谁','张文豪'),(31,'192030434','白起','男','计算机科学与技术','爸爸是谁','张文豪'),(32,'192030435','佩琴','女','计算机科学与技术','爸爸是谁','张文豪'),(33,'192030436','张辉','男','计算机科学与技术','爸爸是谁','张文豪'),(34,'192030437','夏洛','男','计算机科学与技术','爸爸是谁','张文豪'),(35,'192030438','郝建','男','计算机科学与技术','爸爸是谁','张文豪'),(36,'192030439','郝仁','男','计算机科学与技术','爸爸是谁','张文豪'),(37,'192030440','南宫若萱','女','计算机科学与技术','爸爸是谁','张文豪'),(38,'192030441','司徒温柔','女','计算机科学与技术','爸爸是谁','张文豪'),(39,'192030442','白描吗','女','计算机科学与技术','爸爸是谁','张文豪'),(40,'192030443','王西瓜','女','计算机科学与技术','爸爸是谁','张文豪'),(41,'192030444','张威威','女','计算机科学与技术','爸爸是谁','张文豪'),(42,'192030445','上官潇洒','女','计算机科学与技术','爸爸是谁','张文豪'),(43,'192030446','上官无敌','女','计算机科学与技术','爸爸是谁','张文豪'),(44,'182030429','帝释天','女','计算机科学与技术','1+1=？','2'),(45,'182030428','无极','男','电子竞技','我是谁','无极'),(46,'182030427','步惊云','男','计算机科学与技术','绝招是啥','排云掌'),(47,'132030429','天下都','男','合肥推拿','锄禾日当午','汗滴禾下土'),(48,'1','1','男','计算机科学与技术','1','1'),(49,'1920304444','塔里木','男','电子竞技','1111','11111'),(50,'11111','11111111','男','电子竞技','11111111','111111111'),(51,'22222222','22222222','男','计算机科学与技术','2222222','2222222'),(52,'00','00','男','电子竞技','00','00'),(53,'123456','张文宏','女','计算机科学与技术','爸爸是谁','张文豪'),(54,'12','12','男','计算机科学与技术','12','12'),(55,'23','23','男','计算机科学与技术','23','23'),(56,'125','125','男','计算机科学与技术','125','125'),(57,'123456789','冯杨','男','计算机科学与技术','爸爸是谁','张文豪');

/*Table structure for table `stu_login` */

DROP TABLE IF EXISTS `stu_login`;

CREATE TABLE `stu_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu_login` */

insert  into `stu_login`(`username`,`password`) values ('00','00'),('1','1'),('11111','1111111'),('12','12'),('123456','125'),('123456789','123'),('125','125'),('132030429','123'),('182030427','123'),('182030428','123'),('182030429','123'),('192030420','123'),('192030423','123'),('192030425','123'),('192030427','125'),('192030429','123'),('192030430','123'),('192030431','123'),('192030432','123'),('192030433','123'),('192030434','123'),('192030435','123'),('192030436','123'),('192030437','123'),('192030438','123'),('192030439','123'),('192030440','123'),('192030441','123'),('192030442','123'),('192030443','123'),('192030444','123'),('1920304444','11111'),('192030445','123'),('192030446','123'),('22222222','22222222'),('23','23');

/*Table structure for table `stu_subject_info` */

DROP TABLE IF EXISTS `stu_subject_info`;

CREATE TABLE `stu_subject_info` (
  `stu_num` int(11) DEFAULT NULL,
  `subject_name` varchar(30) DEFAULT NULL,
  `score` double(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu_subject_info` */

insert  into `stu_subject_info`(`stu_num`,`subject_name`,`score`) values (192030429,'小儿推拿按摩',NULL),(192030427,'数据库系统',NULL),(192030425,'javaEE',NULL),(192030425,'软件工程',96.51),(192030423,'上单教学',NULL),(192030423,'Facker的核心技术',NULL),(192030423,'极限拉扯',90.00),(192030425,'程序理论',99.00),(192030420,'战队管理',NULL),(192030429,'腰椎按摩',NULL),(192030429,'刮痧拔罐',NULL),(192030430,'软件工程',99.00),(192030431,'软件工程',79.00),(192030432,'软件工程',56.00),(192030433,'软件工程',0.00),(192030434,'软件工程',0.00),(192030435,'软件工程',0.00),(192030436,'软件工程',0.00),(192030437,'软件工程',0.00),(192030438,'软件工程',0.00),(192030439,'软件工程',0.00),(192030440,'软件工程',0.00),(192030441,'软件工程',0.00),(192030442,'软件工程',0.00),(192030443,'软件工程',0.00),(192030444,'软件工程',0.00),(192030445,'软件工程',0.00),(192030446,'软件工程',0.00),(192030430,'程序理论',15.00),(192030431,'程序理论',99.00),(192030432,'程序理论',0.00),(192030433,'程序理论',0.00),(192030434,'程序理论',0.00),(192030435,'程序理论',0.00),(192030436,'程序理论',0.00),(192030437,'程序理论',0.00),(192030438,'程序理论',0.00),(192030439,'程序理论',0.00),(192030440,'程序理论',0.00),(192030441,'程序理论',0.00),(192030442,'程序理论',0.00),(192030443,'程序理论',0.00),(192030444,'程序理论',0.00),(192030445,'程序理论',0.00),(192030446,'程序理论',0.00),(182030429,'数值计算',NULL),(182030429,'云计算',NULL),(182030429,'软件工程',0.00),(182030427,'程序理论',0.00),(182030428,'产业管理',99.00),(182030428,'上单教学',NULL),(182030428,'LPL经验之谈',NULL),(132030429,'脏腑点穴',NULL),(132030429,'艾灸',NULL),(132030429,'足疗',NULL),(123456,'云计算',NULL),(123456,'程序理论',0.00),(123456,'程序理论',0.00),(192030427,'软件工程',0.00),(123456789,'javaEE',NULL),(123456789,'离散数学',NULL),(123456789,'数据库系统',NULL),(192030427,'程序理论',NULL);

/*Table structure for table `tec_info` */

DROP TABLE IF EXISTS `tec_info`;

CREATE TABLE `tec_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tec_id` varchar(20) DEFAULT NULL,
  `tec_name` varchar(20) DEFAULT NULL,
  `tec_sex` varchar(10) DEFAULT NULL,
  `tec_college` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tec_info` */

insert  into `tec_info`(`id`,`tec_id`,`tec_name`,`tec_sex`,`tec_college`) values (1,'192030429','张文豪','男','计算机科学与技术'),(7,'192030428','神之一手','男','合肥推拿'),(8,'192030427','张译文','男','电子竞技'),(9,'142030429','彰武','男','合肥推拿');

/*Table structure for table `tec_login` */

DROP TABLE IF EXISTS `tec_login`;

CREATE TABLE `tec_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tec_login` */

insert  into `tec_login`(`username`,`password`) values ('142030429','123'),('192030427','123'),('192030428','123'),('192030429','123');

/*Table structure for table `tuina_subject` */

DROP TABLE IF EXISTS `tuina_subject`;

CREATE TABLE `tuina_subject` (
  `subject_name` varchar(20) NOT NULL,
  `tec_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tuina_subject` */

insert  into `tuina_subject`(`subject_name`,`tec_num`) values ('中医基础理论','192030428'),('中医概论',NULL),('刮痧拔罐','142030429'),('小儿推拿按摩','192030428'),('脏腑点穴',NULL),('腰椎按摩','142030429'),('艾灸',NULL),('足疗',NULL),('颈椎按摩',NULL),('黯然销魂掌',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

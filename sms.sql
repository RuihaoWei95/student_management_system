/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.33 : Database - sms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sms`;

/*Data for the table `course` */

insert  into `course`(`CourseName`,`CourseId`,`CourseTime`) values 
('COEN275','1','MW 7:00PM-9:00PM'),
('COEN345','2','TTH 5:00PM-7:00PM'),
('COEN233','3','TTH 5:00PM-7:00PM'),
('COEN285','4','MW 8:00AM-10:00AM'),
('COEN317','5','TTH 8:00AM-10AM');

/*Data for the table `person` */

insert  into `person`(`userAccount`,`userPassword`,`userName`,`userBirthday`,`userIdCard`,`userIdentify`) values 
('Cao@scu.edu','Cao','Cao','1997-05-14','1865431',0),
('Hao@scu.edu','Hao','Hao','2000-06-11','1433824',0),
('Hui@scu.edu','Hui','Hui','2001-03-21','1945789',0),
('Jia@scu.edu','Jia','Jia','1999-07-21','1924577',0),
('Nan@scu.edu','Nan','Nan','1977-11-21','1359428',1),
('Qi@scu.edu','Qi','Qi','1980-08-07','1346937',1),
('Rui@scu.edu','Rui','Rui','1998-03-20','1784932',0),
('Tian@scu.edu','Tian','Tian','2001-03-15','1783422',0),
('Tie@scu.edu','Tie','Tie','1965-04-20','1876532',1),
('Wei@scu.edu','Wei','Wei','1995-09-11','1648525',0),
('Yu@scu.edu','Yu','Yu','2002-09-17','1984322',0),
('Zou@scu.edu','Zou','Zou','1999-02-27','1863422',0),
('admin','admin','admin',NULL,NULL,2);

/*Data for the table `studentcourse` */

insert  into `studentcourse`(`UID`,`userAccount`,`courseId`,`score`) values 
('2023-05-30 21:01:38','Cao@scu.edu','1',82),
('2023-05-30 21:01:46','Cao@scu.edu','3',77.9),
('2023-05-30 21:01:57','Cao@scu.edu','4',97),
('2023-05-30 21:02:04','Hao@scu.edu','1',88),
('2023-05-30 21:02:15','Hao@scu.edu','2',67),
('2023-05-30 21:02:28','Hui@scu.edu','4',86),
('2023-05-30 21:03:11','Hui@scu.edu','5',0),
('2023-05-30 21:03:21','Hui@scu.edu','3',99),
('2023-05-30 21:03:32','Jia@scu.edu','2',67),
('2023-05-30 21:03:39','Jia@scu.edu','3',87),
('2023-05-30 21:08:20','Rui@scu.edu','4',77),
('2023-05-30 21:08:34','Rui@scu.edu','3',96),
('2023-05-30 21:08:44','Tian@scu.edu','2',79),
('2023-05-30 21:08:51','Tian@scu.edu','5',0),
('2023-05-30 21:09:06','Wei@scu.edu','1',88),
('2023-05-30 21:09:14','Wei@scu.edu','2',69),
('2023-05-30 21:09:23','Wei@scu.edu','3',88),
('2023-05-30 21:09:36','Wei@scu.edu','4',84),
('2023-05-30 21:09:44','Wei@scu.edu','5',0),
('2023-05-30 21:09:54','Yu@scu.edu','3',99),
('2023-05-30 21:10:05','Yu@scu.edu','4',78),
('2023-05-30 21:10:17','Zou@scu.edu','3',89),
('2023-05-30 21:10:31','Zou@scu.edu','4',93);

/*Data for the table `teachercourse` */

insert  into `teachercourse`(`UID`,`userAccount`,`courseID`) values 
('2023-05-30 20:59:30','Qi@scu.edu','1'),
('2023-05-30 21:00:55','Qi@scu.edu','2'),
('2023-05-30 21:01:01','Nan@scu.edu','3'),
('2023-05-30 21:01:05','Tie@scu.edu','4'),
('2023-05-30 21:01:18','Tie@scu.edu','5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

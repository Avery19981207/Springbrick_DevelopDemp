-- MySQL dump 10.17  Distrib 10.3.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: jtsys
-- ------------------------------------------------------
-- Server version	10.3.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `jtsys`
--
DROP DATABASE IF EXISTS `jtsys`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `jtsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jtsys`;

--
-- Table structure for table `sys_depts`
--

DROP TABLE IF EXISTS `sys_depts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='部门管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_depts`
--

LOCK TABLES `sys_depts` WRITE;
/*!40000 ALTER TABLE `sys_depts` DISABLE KEYS */;
INSERT INTO `sys_depts` VALUES (2,'集团教研部',NULL,1,'集团教学和研发','2018-04-19 18:59:09','2020-01-12 14:13:22','admin',NULL),(4,'课程研发部',2,22,'负责课程研发','2018-04-22 18:10:58','2020-01-12 14:13:56',NULL,NULL),(5,'集团MIS部',NULL,13,'负责集团网络环境运维','2020-01-12 14:14:26','2020-01-12 14:14:26',NULL,NULL);
/*!40000 ALTER TABLE `sys_depts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logs`
--

DROP TABLE IF EXISTS `sys_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logs`
--

LOCK TABLES `sys_logs` WRITE;
/*!40000 ALTER TABLE `sys_logs` DISABLE KEYS */;
INSERT INTO `sys_logs` VALUES (9,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',3,'0:0:0:0:0:0:0:1','2018-04-17 19:53:38'),(10,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05'),(11,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',1,'0:0:0:0:0:0:0:1','2018-04-17 19:54:36'),(12,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',155,'0:0:0:0:0:0:0:1','2018-04-18 15:14:44'),(13,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',165,'0:0:0:0:0:0:0:1','2018-04-19 18:52:35'),(14,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-19 19:10:36'),(15,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-19 19:12:46'),(16,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',187,'0:0:0:0:0:0:0:1','2018-04-19 23:27:14'),(17,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',103,'0:0:0:0:0:0:0:1','2018-04-20 13:11:37'),(18,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',85,'0:0:0:0:0:0:0:1','2018-04-20 13:55:04'),(19,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',89,'0:0:0:0:0:0:0:1','2018-04-20 13:57:12'),(20,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-20 13:58:32'),(21,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',291,'0:0:0:0:0:0:0:1','2018-04-20 15:22:55'),(22,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',158,'0:0:0:0:0:0:0:1','2018-04-22 16:20:56'),(23,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',94,'0:0:0:0:0:0:0:1','2018-04-22 17:05:34'),(24,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',138,'0:0:0:0:0:0:0:1','2018-04-22 17:20:32'),(25,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',124,'0:0:0:0:0:0:0:1','2018-04-22 17:24:12'),(26,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-22 17:31:51'),(27,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',148,'0:0:0:0:0:0:0:1','2018-04-22 17:33:25'),(28,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-22 17:39:26'),(29,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',120,'0:0:0:0:0:0:0:1','2018-04-22 19:10:28'),(39,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',13,'0:0:0:0:0:0:0:1','2020-01-12 08:54:53'),(40,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 09:29:59'),(41,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',6,'0:0:0:0:0:0:0:1','2020-01-12 09:35:25'),(42,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"admin\",1]',5,'0:0:0:0:0:0:0:1','2020-01-12 09:35:30'),(43,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',7,'0:0:0:0:0:0:0:1','2020-01-12 09:35:44'),(44,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',5,'0:0:0:0:0:0:0:1','2020-01-12 09:35:46'),(45,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',5,'0:0:0:0:0:0:0:1','2020-01-12 09:36:07'),(46,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:36:19'),(47,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:36:55'),(48,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:37:05'),(49,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',25,'0:0:0:0:0:0:0:1','2020-01-12 09:42:35'),(50,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',2,'0:0:0:0:0:0:0:1','2020-01-12 09:42:38'),(51,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',4,'0:0:0:0:0:0:0:1','2020-01-12 09:43:23'),(52,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[15,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:45:04'),(53,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',25,'0:0:0:0:0:0:0:1','2020-01-12 09:53:54'),(54,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',2,'0:0:0:0:0:0:0:1','2020-01-12 09:53:55'),(55,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',1,'0:0:0:0:0:0:0:1','2020-01-12 09:54:18'),(56,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',6,'0:0:0:0:0:0:0:1','2020-01-12 09:55:00'),(57,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,1,\"admin\"]',4,'0:0:0:0:0:0:0:1','2020-01-12 09:55:01'),(58,'admin','禁用启用','com.cy.pj.sys.service.impl.SysUserServiceImpl.validById','[16,0,\"admin\"]',2,'0:0:0:0:0:0:0:1','2020-01-12 09:55:04'),(59,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'0:0:0:0:0:0:0:1','2020-01-12 09:55:23'),(60,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',10,'0:0:0:0:0:0:0:1','2020-01-12 10:37:24'),(61,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 10:37:49'),(62,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',27,'0:0:0:0:0:0:0:1','2020-01-12 11:04:16'),(63,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 11:05:58'),(64,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',9,'0:0:0:0:0:0:0:1','2020-01-12 11:07:22'),(65,'xiaoli','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',6,'0:0:0:0:0:0:0:1','2020-01-12 11:07:51'),(66,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',32,'0:0:0:0:0:0:0:1','2020-01-12 13:34:57'),(67,'admin','用户查询','com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects','[\"\",1]',22,'0:0:0:0:0:0:0:1','2020-01-12 14:14:38');
/*!40000 ALTER TABLE `sys_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menus`
--

DROP TABLE IF EXISTS `sys_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8 COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menus`
--

LOCK TABLES `sys_menus` WRITE;
/*!40000 ALTER TABLE `sys_menus` DISABLE KEYS */;
INSERT INTO `sys_menus` VALUES (8,'系统管理','请求路径',1,8,NULL,NULL,'','2017-07-12 15:15:59','2020-01-12 14:11:15','admin',NULL),(25,'日志管理','log/log_list',1,25,NULL,8,'sys:log:view','2017-07-12 15:15:59','2020-01-12 14:09:44','admin',NULL),(45,'用户管理','user/user_list',1,45,NULL,8,'sys:user:view','2017-07-12 15:15:59','2020-01-12 14:10:10','admin',NULL),(46,'菜单管理','menu/menu_list',1,46,NULL,8,'sys:menu:view','2017-07-12 15:15:59','2020-01-12 14:10:28','admin',NULL),(47,'角色管理','role/role_list',1,47,NULL,8,'sys:role:view','2017-07-12 15:15:59','2020-01-12 14:10:48','admin',NULL),(115,'查询','menu/doFindObjects',2,1,NULL,46,'sys:menu:view','2017-07-13 16:33:41','2020-01-12 14:21:29',NULL,NULL),(116,'添加','menu/doSaveObject',2,2,NULL,46,'sys:menu:add','2017-07-13 16:34:02','2020-01-12 14:21:56',NULL,NULL),(117,'修改','menu/doUpdateObject',2,3,NULL,46,'sys:menu:update','2017-07-13 16:34:25','2020-01-12 14:22:12',NULL,NULL),(118,'删除','role/doDeleteObject',2,4,NULL,46,'sys:menu:delete','2017-07-13 16:34:46','2020-01-12 14:22:41',NULL,NULL),(119,'查询','user/doFindPageObjects',2,1,NULL,45,'sys:user:view','2017-07-13 16:35:05','2020-01-12 14:20:28',NULL,NULL),(120,'查询','role/doFindPageObjects',2,1,NULL,47,'sys:role:view','2017-07-13 16:35:26','2020-01-12 14:23:05',NULL,NULL),(126,'新增','user/doSaveObject',2,2,NULL,45,'sys:user:add','2017-07-21 11:11:34','2020-01-12 14:20:45',NULL,NULL),(127,'修改','user/doUpdateObject',2,3,NULL,45,'sys:user:update','2017-07-21 11:11:56','2020-01-12 14:21:05',NULL,NULL),(128,'添加','role/doSaveObject',2,2,NULL,47,'sys:role:add','2017-07-21 11:14:24','2020-01-12 14:23:29',NULL,NULL),(129,'修改','role/doUpdateObject',2,3,NULL,47,'sys:role:update','2017-07-21 11:14:48','2020-01-12 14:23:44',NULL,NULL),(130,'删除','role/doDeleteObject',2,4,NULL,47,'sys:role:delete','2017-07-21 11:15:09','2020-01-12 14:24:05',NULL,NULL),(131,'删除','log/doDeleteObjects',2,27,NULL,25,'sys:log:delete','2020-01-10 17:34:31','2020-01-10 17:34:31',NULL,NULL),(137,'禁用启用','user/doValidById',2,123,NULL,45,'sys:user:update','2020-01-12 09:34:58','2020-01-12 09:34:58',NULL,NULL),(138,'部门管理','dept/dept_list',1,100,NULL,8,'sys:dept:view','2020-01-12 14:15:45','2020-01-12 14:15:59',NULL,NULL),(139,'添加','dept/doSaveObject',2,123,NULL,138,'sys:dept:add','2020-01-12 14:16:33','2020-01-12 14:16:33',NULL,NULL),(140,'修改','dept/dept_edit',1,121,NULL,138,'sys:dept:update','2020-01-12 14:17:14','2020-01-12 14:17:14',NULL,NULL),(141,'删除','dept/doDeleteObject',1,120,NULL,138,'sys:dept:delete','2020-01-12 14:18:20','2020-01-12 14:18:20',NULL,NULL),(142,'查询','dept/doFindObjects',1,124,NULL,138,'sys:dept:view','2020-01-12 14:19:01','2020-01-12 14:19:01',NULL,NULL),(143,'查询','log/doFindPageObjects',2,210,NULL,25,'sys:log:view','2020-01-12 14:20:02','2020-01-12 14:20:02',NULL,NULL);
/*!40000 ALTER TABLE `sys_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menus`
--

DROP TABLE IF EXISTS `sys_role_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1308 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menus`
--

LOCK TABLES `sys_role_menus` WRITE;
/*!40000 ALTER TABLE `sys_role_menus` DISABLE KEYS */;
INSERT INTO `sys_role_menus` VALUES (1250,46,8),(1252,46,47),(1253,46,120),(1254,46,128),(1255,46,129),(1256,46,130),(1294,1,8),(1296,1,25),(1297,1,131),(1298,1,46),(1299,1,115),(1300,1,116),(1301,1,117),(1302,1,118),(1303,1,47),(1304,1,120),(1305,1,128),(1306,1,129),(1307,1,130);
/*!40000 ALTER TABLE `sys_role_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_roles`
--

DROP TABLE IF EXISTS `sys_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_roles`
--

LOCK TABLES `sys_roles` WRITE;
/*!40000 ALTER TABLE `sys_roles` DISABLE KEYS */;
INSERT INTO `sys_roles` VALUES (1,'系统管理员','系统管理员','2017-07-13 17:44:11','2020-01-12 09:54:51','admin',NULL),(46,'软件工程师','负责软件设计及研发','2020-01-11 15:52:00','2020-01-11 15:52:00',NULL,NULL);
/*!40000 ALTER TABLE `sys_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_roles`
--

DROP TABLE IF EXISTS `sys_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_roles`
--

LOCK TABLES `sys_user_roles` WRITE;
/*!40000 ALTER TABLE `sys_user_roles` DISABLE KEYS */;
INSERT INTO `sys_user_roles` VALUES (68,1,1),(69,17,46);
/*!40000 ALTER TABLE `sys_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_users`
--

DROP TABLE IF EXISTS `sys_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_users`
--

LOCK TABLES `sys_users` WRITE;
/*!40000 ALTER TABLE `sys_users` DISABLE KEYS */;
INSERT INTO `sys_users` VALUES (1,'admin','c4c33035c5d8e840616c128db9f87b25','016a0948-b581-43aa-8a5f-9bb76a80e737','admin@t.cn','13624356789',1,3,NULL,'2020-01-12 09:35:43',NULL,NULL),(2,'zhangli','bdcf69375bdb532e50279b91eb00940d','5e7cbd36-e897-4951-b42b-19809caf3caa','zhangli@t.cn','13678909876',0,3,'2017-07-18 10:01:51','2018-04-22 20:49:19',NULL,'admin'),(3,'wangke','c5dc32ec66041aeddf432b3146bd2257','5e3e1475-1ea9-4a6a-976e-b07545827139','wangke@t.cn','18678900987',1,3,'2017-07-18 11:40:53','2018-04-22 20:48:52',NULL,NULL),(4,'zhangql','+HBpqtPuj9KLBIpneR5X0A==','ed487fac-9952-45c9-acaa-21dab9c689cc','zhangql@t.cn','13678909876',1,2,'2017-07-18 12:17:30','2018-04-22 20:48:04',NULL,NULL),(5,'fanwei','1acab7425d6dfae670f26bd160518902','34fbedb2-e135-4f8d-b595-24360edc348d','fanwei@t.cn','13876545678',1,3,'2017-07-20 17:03:22','2018-04-22 20:47:49',NULL,NULL),(6,'wumei','431ebdcccf3404787a144f9ba669a8e2','8a14f46f-7a17-4dfe-85ab-08e63cb618ce','wumei@t.cn','13567898765',1,2,'2017-07-21 10:57:40','2018-04-22 20:46:49',NULL,NULL),(7,'user-003','689c673a0d8bda7ee795dd45a126ae96','3faa1d2b-a99f-4ffb-9d29-0e71563258af','t@t.com','123',1,3,'2018-01-12 23:19:58','2018-04-22 20:46:07',NULL,'admin'),(9,'user-002','e10adc3949ba59abbe56e057f20f883e',NULL,'t@t.com','123',1,3,'2018-01-12 23:20:31','2018-04-22 20:45:55',NULL,NULL),(12,'user-001','5bf6593afd106aa544000d559f0c2241','9528e727-2901-4746-8558-9010d9607da2','t@t.com','123',1,3,'2018-01-13 01:48:32','2018-04-22 20:45:37',NULL,NULL),(13,'user-c','2630d8bd50c76abf001a9daceeae97e6','30fff766-e245-4a93-9f5e-6eb2c2cec494','t@t.com','123456',0,3,'2018-01-13 02:01:56','2018-04-22 20:43:58',NULL,'admin'),(15,'user-b','2ce586af95c6431112092f653659c85f','eaedbaee-d760-40e4-b71e-ccecf01b6187','t@t.com','123456',0,3,'2018-01-13 02:02:06','2020-01-12 09:45:04',NULL,'admin'),(16,'user-a','710058cf374a38d76510d009f63bf28d','e8e35b96-bbdd-4090-81ee-b71a36141760','1@t.com','121212',0,2,'2018-04-22 19:43:11','2020-01-12 09:55:04',NULL,'admin'),(17,'xiaoli','dd93e70c79e12b5c734080fb9ee91229','e0036733-1378-4ff0-a5c3-8ddc5f8e0db2','xl@t.com','1111111111',1,3,'2020-01-12 10:37:47','2020-01-12 10:37:47',NULL,NULL);
/*!40000 ALTER TABLE `sys_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-12 14:30:20

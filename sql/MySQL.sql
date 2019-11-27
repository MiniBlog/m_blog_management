-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mblog
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_mb_blob`
--

DROP TABLE IF EXISTS `t_mb_blob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_blob` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `_blob` varchar(50) NOT NULL COMMENT '附件ID(seq_id=BLOB_ID)',
  `_name` varchar(100) NOT NULL COMMENT '附件名称',
  `_original_name` varchar(200) NOT NULL COMMENT '附件原始名称',
  `_address` varchar(200) NOT NULL COMMENT '附件地址',
  `note` varchar(200) DEFAULT NULL,
  `create_by` varchar(50) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` int(10) DEFAULT '0' COMMENT '删除标记(0：未删除 1：已删除)',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_blob`
--

LOCK TABLES `t_mb_blob` WRITE;
/*!40000 ALTER TABLE `t_mb_blob` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_mb_blob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_log_request`
--

DROP TABLE IF EXISTS `t_mb_log_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_log_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'KEY,NO_DISPLAY',
  `_user_uuid` varchar(80) DEFAULT NULL COMMENT '用户UUID',
  `_user_name` varchar(200) DEFAULT NULL COMMENT '用户名',
  `_source` varchar(10) DEFAULT NULL COMMENT '请求来源',
  `_path` varchar(500) DEFAULT NULL COMMENT '请求路径',
  `_query` varchar(500) DEFAULT NULL COMMENT '请求路径参数',
  `_params` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `_ip` varchar(40) DEFAULT NULL COMMENT 'IP',
  `note` varchar(200) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '请求时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=974 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_log_request`
--

LOCK TABLES `t_mb_log_request` WRITE;
/*!40000 ALTER TABLE `t_mb_log_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_mb_log_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_menu`
--

DROP TABLE IF EXISTS `t_mb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_title` varchar(50) NOT NULL COMMENT '菜单名',
  `_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `_icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `_href` varchar(200) DEFAULT NULL COMMENT 'href属性',
  `_order` int(11) DEFAULT NULL COMMENT '菜单循序',
  `_group` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是分组',
  `_parent` varchar(40) DEFAULT NULL COMMENT '父菜单',
  `ed_flag` tinyint(1) DEFAULT '1',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(20) NOT NULL,
  `update_date` datetime NOT NULL,
  `delete_flag` int(1) NOT NULL DEFAULT '0',
  `delete_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_menu`
--

LOCK TABLES `t_mb_menu` WRITE;
/*!40000 ALTER TABLE `t_mb_menu` DISABLE KEYS */;
INSERT INTO `t_mb_menu` VALUES (1,'首页','0-welcome','el-icon-s-home','/welcome.html',0,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(2,'内容管理','100-content','el-icon-notebook-2',NULL,100,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(3,'分类设置','110-category','el-icon-coin','/category.html',110,0,'2',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(4,'标签设置','120-tag','el-icon-price-tag','/tag.html',120,0,'2',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(5,'模块管理','200-modal','el-icon-copy-document',NULL,200,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(6,'添加模块','210-add-module','el-icon-copy-document','/edit-module.html',210,0,'5',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(7,'模块列表','220-module-list','el-icon-copy-document','/module-list.html',220,0,'5',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(8,'文章管理','300-article','el-icon-document',NULL,300,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(9,'创建文章','310-add-article','el-icon-document-add','/add-article.html',310,0,'8',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(10,'文章列表','320-article-list','el-icon-tickets','/article-list.html',320,0,'8',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(11,'文章评论列表','330-article-comment-list','el-icon-chat-dot-square','/article-comment-list.html',330,0,'8',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(12,'页面管理','400-page','el-icon-document',NULL,400,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(13,'创建页面','410-add-page','el-icon-document-add','/add-page.html',410,0,'12',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(14,'页面列表','420-page-list','el-icon-document-copy','/page-list.html',420,0,'12',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(15,'页面评论列表','430-page-comment-list','el-icon-chat-dot-square','/page-comment-list.html',430,0,'12',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(16,'附件管理','500-annex','el-icon-paperclip',NULL,500,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(17,'图片列表','510-pic','el-icon-picture','/pic.html',510,0,'16',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(18,'文件列表','520-file','el-icon-s-order','/file.html',520,0,'16',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(19,'SEO管理','600-seo','el-icon-s-marketing',NULL,600,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(20,'TKD设置','610-tkd','el-icon-s-operation','/tkd.html',610,0,'19',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(21,'广告位设置','620-advertisement','el-icon-s-operation','/advertisement.html',620,0,'19',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(22,'系统管理','800-sys','el-icon-s-operation',NULL,800,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(23,'系统设置','810-sys-set','el-icon-s-operation',NULL,810,1,'22',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(24,'菜单设置','811-sys-set-menu','el-icon-s-operation','/sys/menu.html',811,0,'23',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(25,'用户设置','812-sys-set-user','el-icon-s-operation','/sys/user.html',812,0,'23',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(26,'系统信息','820-sys-info','el-icon-s-operation',NULL,820,1,'22',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(27,'请求日志','821-sys-info-log-request','el-icon-s-marketing','/sys/log/request.html',821,0,'26',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(28,'Demo','900-demo','el-icon-menu',NULL,900,0,NULL,1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(29,'demo','901-demo0','el-icon-menu','/demo/demo.html',901,0,'28',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL),(30,'demo图片上传','902-demo-pic-upload','el-icon-menu','/demo/picUpload.html',902,0,'28',1,NULL,'jacob','2019-11-21 11:03:52','jacob','2019-11-21 11:03:58',0,NULL);
/*!40000 ALTER TABLE `t_mb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_module`
--

DROP TABLE IF EXISTS `t_mb_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `_uid` varchar(20) NOT NULL COMMENT '模块uid',
  `_name` varchar(20) DEFAULT NULL COMMENT '模块名',
  `_type` varchar(12) DEFAULT NULL COMMENT 'TYPE_ID=MODULE_TYPE',
  `_template` longtext COMMENT '模块模板',
  `_css` longtext COMMENT 'CSS',
  `_js` longtext COMMENT 'JS',
  `_param` longtext COMMENT '参数例子',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标记(0：未删除 1：已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='模块表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_module`
--

LOCK TABLES `t_mb_module` WRITE;
/*!40000 ALTER TABLE `t_mb_module` DISABLE KEYS */;
INSERT INTO `t_mb_module` VALUES (20,'mod1911260001','模块名01','Thymeleaf','<th:block th:each=\"mapa:${mapaaa}\">\n	<h2 th:text=\"${mapa[\'key\']}\"></h2>\n	<p th:text=\"${mapa[\'value\']}\"></p>\n</th:block>\n','h2{\ncolor:red\n}','alert(\'a\');','{\"mapaaa\":[{\"key\":\"key1\",\"value\":\"value1\"},{\"key\":\"key2\",\"value\":\"value2\"}]}\n','文章模块','jacob','2019-11-26 01:54:44','jacob','2019-11-27 07:05:08',NULL,0);
/*!40000 ALTER TABLE `t_mb_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_sequence`
--

DROP TABLE IF EXISTS `t_mb_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_sequence` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `seq_id` varchar(50) NOT NULL COMMENT '序列ID',
  `prefix_value` varchar(10) DEFAULT NULL COMMENT '前缀值',
  `date_value` varchar(10) DEFAULT NULL COMMENT '日期值',
  `current_value` int(10) NOT NULL COMMENT '当前值',
  `current_value_init` int(10) NOT NULL COMMENT '当前值初始值',
  `current_value_length` int(10) NOT NULL COMMENT '当前值长度',
  `increment_value` int(10) NOT NULL COMMENT '增量值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_sequence`
--

LOCK TABLES `t_mb_sequence` WRITE;
/*!40000 ALTER TABLE `t_mb_sequence` DISABLE KEYS */;
INSERT INTO `t_mb_sequence` VALUES (1,'BLOB_ID','blob','191121',1,1,4,1),(2,'USER_ID','u','191121',2,1,4,1),(3,'MODULE_ID','mod','191126',2,1,4,1);
/*!40000 ALTER TABLE `t_mb_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_type_define`
--

DROP TABLE IF EXISTS `t_mb_type_define`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_type_define` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `_type` varchar(60) NOT NULL COMMENT '类型ID',
  `_order` int(10) DEFAULT NULL COMMENT '表示顺序',
  `_value` varchar(30) NOT NULL COMMENT '类型值',
  `_value_other` varchar(50) DEFAULT NULL COMMENT '其他类型值',
  `_desc` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` int(10) DEFAULT '0' COMMENT '删除标记(0:未删除 1:已删除)',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=287 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_type_define`
--

LOCK TABLES `t_mb_type_define` WRITE;
/*!40000 ALTER TABLE `t_mb_type_define` DISABLE KEYS */;
INSERT INTO `t_mb_type_define` VALUES (1,'SYS_UI_ICON',1,'el-icon-platform-eleme',NULL,'平台元素',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(2,'SYS_UI_ICON',2,'el-icon-eleme',NULL,'元音',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(3,'SYS_UI_ICON',3,'el-icon-delete-solid',NULL,'删除实体',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(4,'SYS_UI_ICON',4,'el-icon-delete',NULL,'删除',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(5,'SYS_UI_ICON',5,'el-icon-s-tools',NULL,'s工具',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(6,'SYS_UI_ICON',6,'el-icon-setting',NULL,'设置',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(7,'SYS_UI_ICON',7,'el-icon-user-solid',NULL,'用户固体',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(8,'SYS_UI_ICON',8,'el-icon-user',NULL,'用户',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(9,'SYS_UI_ICON',9,'el-icon-phone',NULL,'电话',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(10,'SYS_UI_ICON',10,'el-icon-phone-outline',NULL,'电话概述',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(11,'SYS_UI_ICON',11,'el-icon-more',NULL,'更多',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(12,'SYS_UI_ICON',12,'el-icon-more-outline',NULL,'更多概述',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(13,'SYS_UI_ICON',13,'el-icon-star-on',NULL,'上星',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(14,'SYS_UI_ICON',14,'el-icon-star-off',NULL,'脱颖而出',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(15,'SYS_UI_ICON',15,'el-icon-s-goods',NULL,'S商品',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(16,'SYS_UI_ICON',16,'el-icon-goods',NULL,'产品',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(17,'SYS_UI_ICON',17,'el-icon-warning',NULL,'警告',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(18,'SYS_UI_ICON',18,'el-icon-warning-outline',NULL,'警告概述',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(19,'SYS_UI_ICON',19,'el-icon-question',NULL,'题',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(20,'SYS_UI_ICON',20,'el-icon-info',NULL,'信息',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(21,'SYS_UI_ICON',21,'el-icon-remove',NULL,'去掉',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(22,'SYS_UI_ICON',22,'el-icon-circle-plus',NULL,'圈加',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(23,'SYS_UI_ICON',23,'el-icon-success',NULL,'成功',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(24,'SYS_UI_ICON',24,'el-icon-error',NULL,'错误',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(25,'SYS_UI_ICON',25,'el-icon-zoom-in',NULL,'放大',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(26,'SYS_UI_ICON',26,'el-icon-zoom-out',NULL,'缩小',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(27,'SYS_UI_ICON',27,'el-icon-remove-outline',NULL,'删除大纲',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(28,'SYS_UI_ICON',28,'el-icon-circle-plus-outline',NULL,'圈加大纲',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(29,'SYS_UI_ICON',29,'el-icon-circle-check',NULL,'循环检查',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(30,'SYS_UI_ICON',30,'el-icon-circle-close',NULL,'圈闭',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(31,'SYS_UI_ICON',31,'el-icon-s-help',NULL,'帮助',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(32,'SYS_UI_ICON',32,'el-icon-help',NULL,'救命',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(33,'SYS_UI_ICON',33,'el-icon-minus',NULL,'减去',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(34,'SYS_UI_ICON',34,'el-icon-plus',NULL,'加',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(35,'SYS_UI_ICON',35,'el-icon-check',NULL,'校验',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(36,'SYS_UI_ICON',36,'el-icon-close',NULL,'关',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(37,'SYS_UI_ICON',37,'el-icon-picture',NULL,'图片',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(38,'SYS_UI_ICON',38,'el-icon-picture-outline',NULL,'图片轮廓',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(39,'SYS_UI_ICON',39,'el-icon-picture-outline-round',NULL,'图片轮廓轮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(40,'SYS_UI_ICON',40,'el-icon-upload',NULL,'上载',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(41,'SYS_UI_ICON',41,'el-icon-upload2',NULL,'上载2',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(42,'SYS_UI_ICON',42,'el-icon-download',NULL,'下载',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(43,'SYS_UI_ICON',43,'el-icon-camera-solid',NULL,'相机固体',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(44,'SYS_UI_ICON',44,'el-icon-camera',NULL,'相机',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(45,'SYS_UI_ICON',45,'el-icon-video-camera-solid',NULL,'摄影机固体',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(46,'SYS_UI_ICON',46,'el-icon-video-camera',NULL,'摄像机',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(47,'SYS_UI_ICON',47,'el-icon-message-solid',NULL,'消息牢固',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(48,'SYS_UI_ICON',48,'el-icon-bell',NULL,'钟',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(49,'SYS_UI_ICON',49,'el-icon-s-cooperation',NULL,'合作',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(50,'SYS_UI_ICON',50,'el-icon-s-order',NULL,'顺序',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(51,'SYS_UI_ICON',51,'el-icon-s-platform',NULL,'S平台',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(52,'SYS_UI_ICON',52,'el-icon-s-fold',NULL,'折',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(53,'SYS_UI_ICON',53,'el-icon-s-unfold',NULL,'展开',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(54,'SYS_UI_ICON',54,'el-icon-s-operation',NULL,'操作',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(55,'SYS_UI_ICON',55,'el-icon-s-promotion',NULL,'促销',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(56,'SYS_UI_ICON',56,'el-icon-s-home',NULL,'家庭',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(57,'SYS_UI_ICON',57,'el-icon-s-release',NULL,'释放',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(58,'SYS_UI_ICON',58,'el-icon-s-ticket',NULL,'门票',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(59,'SYS_UI_ICON',59,'el-icon-s-management',NULL,'管理',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(60,'SYS_UI_ICON',60,'el-icon-s-open',NULL,'开',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(61,'SYS_UI_ICON',61,'el-icon-s-shop',NULL,'商店',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(62,'SYS_UI_ICON',62,'el-icon-s-marketing',NULL,'营销',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(63,'SYS_UI_ICON',63,'el-icon-s-flag',NULL,'s标志',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(64,'SYS_UI_ICON',64,'el-icon-s-comment',NULL,'评论',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(65,'SYS_UI_ICON',65,'el-icon-s-finance',NULL,'金融',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(66,'SYS_UI_ICON',66,'el-icon-s-claim',NULL,'索赔',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(67,'SYS_UI_ICON',67,'el-icon-s-custom',NULL,'习惯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(68,'SYS_UI_ICON',68,'el-icon-s-opportunity',NULL,'机会',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(69,'SYS_UI_ICON',69,'el-icon-s-data',NULL,'数据',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(70,'SYS_UI_ICON',70,'el-icon-s-check',NULL,'S检查',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(71,'SYS_UI_ICON',71,'el-icon-s-grid',NULL,'网格',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(72,'SYS_UI_ICON',72,'el-icon-menu',NULL,'菜单',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(73,'SYS_UI_ICON',73,'el-icon-share',NULL,'分享',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(74,'SYS_UI_ICON',74,'el-icon-d-caret',NULL,'插入符号',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(75,'SYS_UI_ICON',75,'el-icon-caret-left',NULL,'左尖号',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(76,'SYS_UI_ICON',76,'el-icon-caret-right',NULL,'右插入符',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(77,'SYS_UI_ICON',77,'el-icon-caret-bottom',NULL,'尖号底部',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(78,'SYS_UI_ICON',78,'el-icon-caret-top',NULL,'尖顶',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(79,'SYS_UI_ICON',79,'el-icon-bottom-left',NULL,'左下方',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(80,'SYS_UI_ICON',80,'el-icon-bottom-right',NULL,'右下',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(81,'SYS_UI_ICON',81,'el-icon-back',NULL,'背部',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(82,'SYS_UI_ICON',82,'el-icon-right',NULL,'对',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(83,'SYS_UI_ICON',83,'el-icon-bottom',NULL,'底部',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(84,'SYS_UI_ICON',84,'el-icon-top',NULL,'最佳',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(85,'SYS_UI_ICON',85,'el-icon-top-left',NULL,'左上方',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(86,'SYS_UI_ICON',86,'el-icon-top-right',NULL,'右上',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(87,'SYS_UI_ICON',87,'el-icon-arrow-left',NULL,'向左箭头',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(88,'SYS_UI_ICON',88,'el-icon-arrow-right',NULL,'向右箭头',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(89,'SYS_UI_ICON',89,'el-icon-arrow-down',NULL,'向下箭头',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(90,'SYS_UI_ICON',90,'el-icon-arrow-up',NULL,'向上箭头',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(91,'SYS_UI_ICON',91,'el-icon-d-arrow-left',NULL,'左箭头',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(92,'SYS_UI_ICON',92,'el-icon-d-arrow-right',NULL,'右箭头',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(93,'SYS_UI_ICON',93,'el-icon-video-pause',NULL,'视频暂停',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(94,'SYS_UI_ICON',94,'el-icon-video-play',NULL,'影片播放',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(95,'SYS_UI_ICON',95,'el-icon-refresh',NULL,'刷新',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(96,'SYS_UI_ICON',96,'el-icon-refresh-right',NULL,'向右刷新',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(97,'SYS_UI_ICON',97,'el-icon-refresh-left',NULL,'向左刷新',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(98,'SYS_UI_ICON',98,'el-icon-finished',NULL,'完了',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(99,'SYS_UI_ICON',99,'el-icon-sort',NULL,'分类',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(100,'SYS_UI_ICON',100,'el-icon-sort-up',NULL,'整理',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(101,'SYS_UI_ICON',101,'el-icon-sort-down',NULL,'排序',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(102,'SYS_UI_ICON',102,'el-icon-rank',NULL,'秩',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(103,'SYS_UI_ICON',103,'el-icon-loading',NULL,'装货',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(104,'SYS_UI_ICON',104,'el-icon-view',NULL,'视图',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(105,'SYS_UI_ICON',105,'el-icon-c-scale-to-original',NULL,'c刻度到原始',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(106,'SYS_UI_ICON',106,'el-icon-date',NULL,'日期',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(107,'SYS_UI_ICON',107,'el-icon-edit',NULL,'编辑',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(108,'SYS_UI_ICON',108,'el-icon-edit-outline',NULL,'编辑大纲',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(109,'SYS_UI_ICON',109,'el-icon-folder',NULL,'夹',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(110,'SYS_UI_ICON',110,'el-icon-folder-opened',NULL,'资料夹已开启',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(111,'SYS_UI_ICON',111,'el-icon-folder-add',NULL,'文件夹添加',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(112,'SYS_UI_ICON',112,'el-icon-folder-remove',NULL,'文件夹删除',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(113,'SYS_UI_ICON',113,'el-icon-folder-delete',NULL,'文件夹删除',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(114,'SYS_UI_ICON',114,'el-icon-folder-checked',NULL,'资料夹检查',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(115,'SYS_UI_ICON',115,'el-icon-tickets',NULL,'车票',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(116,'SYS_UI_ICON',116,'el-icon-document-remove',NULL,'删除文件',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(117,'SYS_UI_ICON',117,'el-icon-document-delete',NULL,'文件删除',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(118,'SYS_UI_ICON',118,'el-icon-document-copy',NULL,'文件副本',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(119,'SYS_UI_ICON',119,'el-icon-document-checked',NULL,'文件检查',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(120,'SYS_UI_ICON',120,'el-icon-document',NULL,'文献',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(121,'SYS_UI_ICON',121,'el-icon-document-add',NULL,'文件添加',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(122,'SYS_UI_ICON',122,'el-icon-printer',NULL,'打印机',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(123,'SYS_UI_ICON',123,'el-icon-paperclip',NULL,'回形针',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(124,'SYS_UI_ICON',124,'el-icon-takeaway-box',NULL,'外卖盒',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(125,'SYS_UI_ICON',125,'el-icon-search',NULL,'搜索',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(126,'SYS_UI_ICON',126,'el-icon-monitor',NULL,'监控',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(127,'SYS_UI_ICON',127,'el-icon-attract',NULL,'吸引',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(128,'SYS_UI_ICON',128,'el-icon-mobile',NULL,'移动',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(129,'SYS_UI_ICON',129,'el-icon-scissors',NULL,'剪刀',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(130,'SYS_UI_ICON',130,'el-icon-umbrella',NULL,'雨伞',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(131,'SYS_UI_ICON',131,'el-icon-headset',NULL,'耳机',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(132,'SYS_UI_ICON',132,'el-icon-brush',NULL,'刷',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(133,'SYS_UI_ICON',133,'el-icon-mouse',NULL,'老鼠',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(134,'SYS_UI_ICON',134,'el-icon-coordinate',NULL,'坐标',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(135,'SYS_UI_ICON',135,'el-icon-magic-stick',NULL,'魔术棒',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(136,'SYS_UI_ICON',136,'el-icon-reading',NULL,'读',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(137,'SYS_UI_ICON',137,'el-icon-data-line',NULL,'数据线',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(138,'SYS_UI_ICON',138,'el-icon-data-board',NULL,'数据板',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(139,'SYS_UI_ICON',139,'el-icon-pie-chart',NULL,'饼形图',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(140,'SYS_UI_ICON',140,'el-icon-data-analysis',NULL,'数据分析',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(141,'SYS_UI_ICON',141,'el-icon-collection-tag',NULL,'收集标签',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(142,'SYS_UI_ICON',142,'el-icon-film',NULL,'电影',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(143,'SYS_UI_ICON',143,'el-icon-suitcase',NULL,'手提箱',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(144,'SYS_UI_ICON',144,'el-icon-suitcase-1',NULL,'手提箱1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(145,'SYS_UI_ICON',145,'el-icon-receiving',NULL,'接收',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(146,'SYS_UI_ICON',146,'el-icon-collection',NULL,'采集',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(147,'SYS_UI_ICON',147,'el-icon-files',NULL,'档案',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(148,'SYS_UI_ICON',148,'el-icon-notebook-1',NULL,'笔记本1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(149,'SYS_UI_ICON',149,'el-icon-notebook-2',NULL,'笔记本2',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(150,'SYS_UI_ICON',150,'el-icon-toilet-paper',NULL,'卫生纸',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(151,'SYS_UI_ICON',151,'el-icon-office-building',NULL,'办公楼',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(152,'SYS_UI_ICON',152,'el-icon-school',NULL,'学校',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(153,'SYS_UI_ICON',153,'el-icon-table-lamp',NULL,'台灯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(154,'SYS_UI_ICON',154,'el-icon-house',NULL,'屋',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(155,'SYS_UI_ICON',155,'el-icon-no-smoking',NULL,'禁止抽烟',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(156,'SYS_UI_ICON',156,'el-icon-smoking',NULL,'抽烟',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(157,'SYS_UI_ICON',157,'el-icon-shopping-cart-full',NULL,'购物车满',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(158,'SYS_UI_ICON',158,'el-icon-shopping-cart-1',NULL,'购物车1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(159,'SYS_UI_ICON',159,'el-icon-shopping-cart-2',NULL,'购物车2',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(160,'SYS_UI_ICON',160,'el-icon-shopping-bag-1',NULL,'购物袋1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(161,'SYS_UI_ICON',161,'el-icon-shopping-bag-2',NULL,'购物袋2',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(162,'SYS_UI_ICON',162,'el-icon-sold-out',NULL,'卖光了',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(163,'SYS_UI_ICON',163,'el-icon-sell',NULL,'卖',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(164,'SYS_UI_ICON',164,'el-icon-present',NULL,'当下',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(165,'SYS_UI_ICON',165,'el-icon-box',NULL,'框',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(166,'SYS_UI_ICON',166,'el-icon-bank-card',NULL,'银行卡',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(167,'SYS_UI_ICON',167,'el-icon-money',NULL,'钱',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(168,'SYS_UI_ICON',168,'el-icon-coin',NULL,'硬币',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(169,'SYS_UI_ICON',169,'el-icon-wallet',NULL,'钱包',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(170,'SYS_UI_ICON',170,'el-icon-discount',NULL,'折扣',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(171,'SYS_UI_ICON',171,'el-icon-price-tag',NULL,'价格标签',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(172,'SYS_UI_ICON',172,'el-icon-news',NULL,'新闻',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(173,'SYS_UI_ICON',173,'el-icon-guide',NULL,'指南',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(174,'SYS_UI_ICON',174,'el-icon-male',NULL,'男',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(175,'SYS_UI_ICON',175,'el-icon-female',NULL,'女',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(176,'SYS_UI_ICON',176,'el-icon-thumb',NULL,'拇指',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(177,'SYS_UI_ICON',177,'el-icon-cpu',NULL,'中央处理器',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(178,'SYS_UI_ICON',178,'el-icon-link',NULL,'链接',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(179,'SYS_UI_ICON',179,'el-icon-connection',NULL,'连接',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(180,'SYS_UI_ICON',180,'el-icon-open',NULL,'打开',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(181,'SYS_UI_ICON',181,'el-icon-turn-off',NULL,'关掉',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(182,'SYS_UI_ICON',182,'el-icon-set-up',NULL,'设定',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(183,'SYS_UI_ICON',183,'el-icon-chat-round',NULL,'聊天轮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(184,'SYS_UI_ICON',184,'el-icon-chat-line-round',NULL,'聊天线轮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(185,'SYS_UI_ICON',185,'el-icon-chat-square',NULL,'聊天广场',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(186,'SYS_UI_ICON',186,'el-icon-chat-dot-round',NULL,'圆点聊天',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(187,'SYS_UI_ICON',187,'el-icon-chat-dot-square',NULL,'聊天点广场',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(188,'SYS_UI_ICON',188,'el-icon-chat-line-square',NULL,'聊天线广场',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(189,'SYS_UI_ICON',189,'el-icon-message',NULL,'信息',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(190,'SYS_UI_ICON',190,'el-icon-postcard',NULL,'明信片',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(191,'SYS_UI_ICON',191,'el-icon-position',NULL,'位置',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(192,'SYS_UI_ICON',192,'el-icon-turn-off-microphone',NULL,'关机麦克风',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(193,'SYS_UI_ICON',193,'el-icon-microphone',NULL,'麦克风',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(194,'SYS_UI_ICON',194,'el-icon-close-notification',NULL,'封闭通知',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(195,'SYS_UI_ICON',195,'el-icon-bangzhu',NULL,'帮主',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(196,'SYS_UI_ICON',196,'el-icon-time',NULL,'时间',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(197,'SYS_UI_ICON',197,'el-icon-odometer',NULL,'里程表',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(198,'SYS_UI_ICON',198,'el-icon-crop',NULL,'作物',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(199,'SYS_UI_ICON',199,'el-icon-aim',NULL,'目标',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(200,'SYS_UI_ICON',200,'el-icon-switch-button',NULL,'开关按钮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(201,'SYS_UI_ICON',201,'el-icon-full-screen',NULL,'全屏',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(202,'SYS_UI_ICON',202,'el-icon-copy-document',NULL,'复制文件',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(203,'SYS_UI_ICON',203,'el-icon-mic',NULL,'麦克风',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(204,'SYS_UI_ICON',204,'el-icon-stopwatch',NULL,'跑表',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(205,'SYS_UI_ICON',205,'el-icon-medal-1',NULL,'奖牌1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(206,'SYS_UI_ICON',206,'el-icon-medal',NULL,'勋章',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(207,'SYS_UI_ICON',207,'el-icon-trophy',NULL,'杯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(208,'SYS_UI_ICON',208,'el-icon-trophy-1',NULL,'奖杯1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(209,'SYS_UI_ICON',209,'el-icon-first-aid-kit',NULL,'急救箱',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(210,'SYS_UI_ICON',210,'el-icon-discover',NULL,'发现',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(211,'SYS_UI_ICON',211,'el-icon-place',NULL,'地点',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(212,'SYS_UI_ICON',212,'el-icon-location',NULL,'位置',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(213,'SYS_UI_ICON',213,'el-icon-location-outline',NULL,'位置概述',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(214,'SYS_UI_ICON',214,'el-icon-location-information',NULL,'地点信息',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(215,'SYS_UI_ICON',215,'el-icon-add-location',NULL,'添加位置',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(216,'SYS_UI_ICON',216,'el-icon-delete-location',NULL,'删除位置',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(217,'SYS_UI_ICON',217,'el-icon-map-location',NULL,'地图位置',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(218,'SYS_UI_ICON',218,'el-icon-alarm-clock',NULL,'闹钟',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(219,'SYS_UI_ICON',219,'el-icon-timer',NULL,'计时器',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(220,'SYS_UI_ICON',220,'el-icon-watch-1',NULL,'看1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(221,'SYS_UI_ICON',221,'el-icon-watch',NULL,'看',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(222,'SYS_UI_ICON',222,'el-icon-lock',NULL,'锁',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(223,'SYS_UI_ICON',223,'el-icon-unlock',NULL,'开锁',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(224,'SYS_UI_ICON',224,'el-icon-key',NULL,'键',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(225,'SYS_UI_ICON',225,'el-icon-service',NULL,'服务',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(226,'SYS_UI_ICON',226,'el-icon-mobile-phone',NULL,'移动电话',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(227,'SYS_UI_ICON',227,'el-icon-bicycle',NULL,'自行车',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(228,'SYS_UI_ICON',228,'el-icon-truck',NULL,'卡车',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(229,'SYS_UI_ICON',229,'el-icon-ship',NULL,'船',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(230,'SYS_UI_ICON',230,'el-icon-basketball',NULL,'篮球',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(231,'SYS_UI_ICON',231,'el-icon-football',NULL,'足球',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(232,'SYS_UI_ICON',232,'el-icon-soccer',NULL,'足球',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(233,'SYS_UI_ICON',233,'el-icon-baseball',NULL,'棒球',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(234,'SYS_UI_ICON',234,'el-icon-wind-power',NULL,'风力',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(235,'SYS_UI_ICON',235,'el-icon-light-rain',NULL,'小雨',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(236,'SYS_UI_ICON',236,'el-icon-lightning',NULL,'闪电',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(237,'SYS_UI_ICON',237,'el-icon-heavy-rain',NULL,'倾盆大雨',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(238,'SYS_UI_ICON',238,'el-icon-sunrise',NULL,'日出',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(239,'SYS_UI_ICON',239,'el-icon-sunrise-1',NULL,'日出1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(240,'SYS_UI_ICON',240,'el-icon-sunset',NULL,'日落',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(241,'SYS_UI_ICON',241,'el-icon-sunny',NULL,'阳光明媚',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(242,'SYS_UI_ICON',242,'el-icon-cloudy',NULL,'多云的',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(243,'SYS_UI_ICON',243,'el-icon-partly-cloudy',NULL,'局部阴天',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(244,'SYS_UI_ICON',244,'el-icon-cloudy-and-sunny',NULL,'晴间多云',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(245,'SYS_UI_ICON',245,'el-icon-moon',NULL,'月亮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(246,'SYS_UI_ICON',246,'el-icon-moon-night',NULL,'月夜',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(247,'SYS_UI_ICON',247,'el-icon-dish',NULL,'碟',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(248,'SYS_UI_ICON',248,'el-icon-dish-1',NULL,'碟1',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(249,'SYS_UI_ICON',249,'el-icon-food',NULL,'餐饮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(250,'SYS_UI_ICON',250,'el-icon-chicken',NULL,'鸡',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(251,'SYS_UI_ICON',251,'el-icon-fork-spoon',NULL,'叉勺',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(252,'SYS_UI_ICON',252,'el-icon-knife-fork',NULL,'刀叉',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(253,'SYS_UI_ICON',253,'el-icon-burger',NULL,'汉堡包',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(254,'SYS_UI_ICON',254,'el-icon-tableware',NULL,'餐具',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(255,'SYS_UI_ICON',255,'el-icon-sugar',NULL,'糖',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(256,'SYS_UI_ICON',256,'el-icon-dessert',NULL,'甜点',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(257,'SYS_UI_ICON',257,'el-icon-ice-cream',NULL,'冰淇淋',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(258,'SYS_UI_ICON',258,'el-icon-hot-water',NULL,'热水',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(259,'SYS_UI_ICON',259,'el-icon-water-cup',NULL,'水杯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(260,'SYS_UI_ICON',260,'el-icon-coffee-cup',NULL,'咖啡杯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(261,'SYS_UI_ICON',261,'el-icon-cold-drink',NULL,'冷饮',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(262,'SYS_UI_ICON',262,'el-icon-goblet',NULL,'高脚杯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(263,'SYS_UI_ICON',263,'el-icon-goblet-full',NULL,'高脚杯',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(264,'SYS_UI_ICON',264,'el-icon-goblet-square',NULL,'酒杯广场',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(265,'SYS_UI_ICON',265,'el-icon-goblet-square-full',NULL,'酒杯方形满',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(266,'SYS_UI_ICON',266,'el-icon-refrigerator',NULL,'冰箱',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(267,'SYS_UI_ICON',267,'el-icon-grape',NULL,'葡萄',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(268,'SYS_UI_ICON',268,'el-icon-watermelon',NULL,'西瓜',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(269,'SYS_UI_ICON',269,'el-icon-cherry',NULL,'樱桃',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(270,'SYS_UI_ICON',270,'el-icon-apple',NULL,'苹果',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(271,'SYS_UI_ICON',271,'el-icon-pear',NULL,'梨',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(272,'SYS_UI_ICON',272,'el-icon-orange',NULL,'橙子',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(273,'SYS_UI_ICON',273,'el-icon-coffee',NULL,'咖啡',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(274,'SYS_UI_ICON',274,'el-icon-ice-tea',NULL,'冰茶',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(275,'SYS_UI_ICON',275,'el-icon-ice-drink',NULL,'喝冰',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(276,'SYS_UI_ICON',276,'el-icon-milk-tea',NULL,'奶茶',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(277,'SYS_UI_ICON',277,'el-icon-potato-strips',NULL,'马铃薯条',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(278,'SYS_UI_ICON',278,'el-icon-lollipop',NULL,'棒糖',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(279,'SYS_UI_ICON',279,'el-icon-ice-cream-square',NULL,'冰淇淋广场',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(280,'SYS_UI_ICON',280,'el-icon-ice-cream-round',NULL,'一轮冰淇淋',NULL,'jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(281,'MODULE_TYPE',0,'Beetl',NULL,'Beetl',NULL,'jacob','2019-11-27 14:54:56','jacob','2019-11-27 14:54:56',0,NULL),(282,'MODULE_TYPE',1,'Enjoy',NULL,'Enjoy',NULL,'jacob','2019-11-27 14:54:56','jacob','2019-11-27 14:54:56',0,NULL),(283,'MODULE_TYPE',2,'Rythm',NULL,'Rythm',NULL,'jacob','2019-11-27 14:54:56','jacob','2019-11-27 14:54:56',0,NULL),(284,'MODULE_TYPE',3,'FreeMarker',NULL,'FreeMarker',NULL,'jacob','2019-11-27 14:54:56','jacob','2019-11-27 14:54:56',0,NULL),(285,'MODULE_TYPE',4,'Velocity',NULL,'Velocity',NULL,'jacob','2019-11-27 14:54:56','jacob','2019-11-27 14:54:56',0,NULL),(286,'MODULE_TYPE',5,'Thymeleaf',NULL,'Thymeleaf',NULL,'jacob','2019-11-27 14:54:56','jacob','2019-11-27 14:54:56',0,NULL);
/*!40000 ALTER TABLE `t_mb_type_define` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_user`
--

DROP TABLE IF EXISTS `t_mb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_uid` varchar(20) DEFAULT NULL COMMENT 'uid',
  `_name` varchar(20) NOT NULL COMMENT '用户名',
  `_pass` varchar(200) NOT NULL COMMENT '用户密码',
  `_email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `note` varchar(200) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `create_by` varchar(20) NOT NULL,
  `update_date` datetime NOT NULL,
  `update_by` varchar(20) NOT NULL,
  `delete_flag` int(1) NOT NULL DEFAULT '0',
  `delete_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_user`
--

LOCK TABLES `t_mb_user` WRITE;
/*!40000 ALTER TABLE `t_mb_user` DISABLE KEYS */;
INSERT INTO `t_mb_user` VALUES (1,'u1911210002','jacob','1a100d2c0dab19c4430e7d73762b3423','jacob1996@gmail.com',NULL,'2019-09-19 17:05:32','jacob','2019-11-25 09:45:21','jacob',0,NULL);
/*!40000 ALTER TABLE `t_mb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-27 15:17:03

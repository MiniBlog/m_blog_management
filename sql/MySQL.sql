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
                             `create_by` varchar(20) NOT NULL,
                             `create_date` datetime NOT NULL,
                             `update_by` varchar(20) NOT NULL,
                             `update_date` datetime NOT NULL,
                             `delete_flag` int(1) NOT NULL DEFAULT '0',
                             `delete_date` datetime DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_menu`
--

LOCK TABLES `t_mb_menu` WRITE;
/*!40000 ALTER TABLE `t_mb_menu`
    DISABLE KEYS */;
INSERT INTO `t_mb_menu`
VALUES (1, '首页', '0-welcome', 'el-icon-s-home', '/welcome.html', 0, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (2, '内容管理', '100-content', 'el-icon-notebook-2', NULL, 100, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (3, '分类设置', '110-category', 'el-icon-coin', '/category.html', 110, 0, '2', 1, 'jacob', '2019-11-21 11:03:52',
        'jacob', '2019-11-21 11:03:58', 0, NULL),
       (4, '标签设置', '120-tag', 'el-icon-price-tag', '/tag.html', 120, 0, '2', 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (5, '模块管理', '200-modal', 'el-icon-copy-document', NULL, 200, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (6, '添加模块', '210-add-module', 'el-icon-copy-document', '/edit-module.html', 210, 0, '5', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (7, '模块列表', '220-module-list', 'el-icon-copy-document', '/module-list.html', 220, 0, '5', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (8, '文章管理', '300-article', 'el-icon-document', NULL, 300, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (9, '创建文章', '310-add-article', 'el-icon-document-add', '/add-article.html', 310, 0, '8', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (10, '文章列表', '320-article-list', 'el-icon-tickets', '/article-list.html', 320, 0, '8', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (11, '文章评论列表', '330-article-comment-list', 'el-icon-chat-dot-square', '/article-comment-list.html', 330, 0, '8',
        1, 'jacob', '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (12, '页面管理', '400-page', 'el-icon-document', NULL, 400, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (13, '创建页面', '410-add-page', 'el-icon-document-add', '/add-page.html', 410, 0, '12', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (14, '页面列表', '420-page-list', 'el-icon-document-copy', '/page-list.html', 420, 0, '12', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (15, '页面评论列表', '430-page-comment-list', 'el-icon-chat-dot-square', '/page-comment-list.html', 430, 0, '12', 1,
        'jacob', '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (16, '附件管理', '500-annex', 'el-icon-paperclip', NULL, 500, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (17, '图片列表', '510-pic', 'el-icon-picture', '/pic.html', 510, 0, '16', 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (18, '文件列表', '520-file', 'el-icon-s-order', '/file.html', 520, 0, '16', 1, 'jacob', '2019-11-21 11:03:52',
        'jacob', '2019-11-21 11:03:58', 0, NULL),
       (19, 'SEO管理', '600-seo', 'el-icon-s-marketing', NULL, 600, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (20, 'TKD设置', '610-tkd', 'el-icon-s-operation', '/tkd.html', 610, 0, '19', 1, 'jacob', '2019-11-21 11:03:52',
        'jacob', '2019-11-21 11:03:58', 0, NULL),
       (21, '广告位设置', '620-advertisement', 'el-icon-s-operation', '/advertisement.html', 620, 0, '19', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (22, '系统管理', '800-sys', 'el-icon-s-operation', NULL, 800, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (23, '系统设置', '810-sys-set', 'el-icon-s-operation', NULL, 810, 1, '22', 1, 'jacob', '2019-11-21 11:03:52',
        'jacob', '2019-11-21 11:03:58', 0, NULL),
       (24, '菜单设置', '811-sys-set-menu', 'el-icon-s-operation', '/sys/menu.html', 811, 0, '23', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (25, '用户设置', '812-sys-set-user', 'el-icon-s-operation', '/sys/user.html', 812, 0, '23', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (26, '系统信息', '820-sys-info', 'el-icon-s-operation', NULL, 820, 1, '22', 1, 'jacob', '2019-11-21 11:03:52',
        'jacob', '2019-11-21 11:03:58', 0, NULL),
       (27, '请求日志', '821-sys-info-log-request', 'el-icon-s-marketing', '/sys/log/request.html', 821, 0, '26', 1,
        'jacob', '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL),
       (28, 'Demo', '900-demo', 'el-icon-menu', NULL, 900, 0, NULL, 1, 'jacob', '2019-11-21 11:03:52', 'jacob',
        '2019-11-21 11:03:58', 0, NULL),
       (29, 'demo', '901-demo0', 'el-icon-menu', '/demo/demo.html', 901, 0, '28', 1, 'jacob', '2019-11-21 11:03:52',
        'jacob', '2019-11-21 11:03:58', 0, NULL),
       (30, 'demo图片上传', '902-demo-pic-upload', 'el-icon-menu', '/demo/picUpload.html', 902, 0, '28', 1, 'jacob',
        '2019-11-21 11:03:52', 'jacob', '2019-11-21 11:03:58', 0, NULL);
/*!40000 ALTER TABLE `t_mb_menu`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mb_module`
--

DROP TABLE IF EXISTS `t_mb_module`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_mb_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `_uid` varchar(20) NOT NULL COMMENT '模块uid',
  `_name` varchar(20) DEFAULT NULL COMMENT '模块名',
  `_template` blob COMMENT '模块模板',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` int(1) DEFAULT '0' COMMENT '删除标记(0：未删除 1：已删除)',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='模块表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_module`
--

LOCK TABLES `t_mb_module` WRITE;
/*!40000 ALTER TABLE `t_mb_module` DISABLE KEYS */;
INSERT INTO `t_mb_module` VALUES (19,'mod1911250018','23',_binary '','23','jacob','2019-11-25 09:42:28','jacob','2019-11-25 09:42:28',0,NULL);
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
INSERT INTO `t_mb_sequence` VALUES (1,'BLOB_ID','blob','191121',1,1,4,1),(2,'USER_ID','u','191121',2,1,4,1),(3,'MODULE_ID','mod','191125',18,1,4,1);
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
  `_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `delete_flag` int(10) DEFAULT '0' COMMENT '删除标记(0:未删除 1:已删除)',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mb_type_define`
--

LOCK TABLES `t_mb_type_define` WRITE;
/*!40000 ALTER TABLE `t_mb_type_define` DISABLE KEYS */;
INSERT INTO `t_mb_type_define` VALUES (1,'SYS_UI_ICON',1,'el-icon-platform-eleme','平台元素','type.define.SYS_UI_ICON.el-icon-platform-eleme','平台元素','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(2,'SYS_UI_ICON',2,'el-icon-eleme','元音','type.define.SYS_UI_ICON.el-icon-eleme','元音','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(3,'SYS_UI_ICON',3,'el-icon-delete-solid','删除实体','type.define.SYS_UI_ICON.el-icon-delete-solid','删除实体','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(4,'SYS_UI_ICON',4,'el-icon-delete','删除','type.define.SYS_UI_ICON.el-icon-delete','删除','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(5,'SYS_UI_ICON',5,'el-icon-s-tools','s工具','type.define.SYS_UI_ICON.el-icon-s-tools','s工具','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(6,'SYS_UI_ICON',6,'el-icon-setting','设置','type.define.SYS_UI_ICON.el-icon-setting','设置','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(7,'SYS_UI_ICON',7,'el-icon-user-solid','用户固体','type.define.SYS_UI_ICON.el-icon-user-solid','用户固体','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(8,'SYS_UI_ICON',8,'el-icon-user','用户','type.define.SYS_UI_ICON.el-icon-user','用户','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(9,'SYS_UI_ICON',9,'el-icon-phone','电话','type.define.SYS_UI_ICON.el-icon-phone','电话','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(10,'SYS_UI_ICON',10,'el-icon-phone-outline','电话概述','type.define.SYS_UI_ICON.el-icon-phone-outline','电话概述','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(11,'SYS_UI_ICON',11,'el-icon-more','更多','type.define.SYS_UI_ICON.el-icon-more','更多','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(12,'SYS_UI_ICON',12,'el-icon-more-outline','更多概述','type.define.SYS_UI_ICON.el-icon-more-outline','更多概述','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(13,'SYS_UI_ICON',13,'el-icon-star-on','上星','type.define.SYS_UI_ICON.el-icon-star-on','上星','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(14,'SYS_UI_ICON',14,'el-icon-star-off','脱颖而出','type.define.SYS_UI_ICON.el-icon-star-off','脱颖而出','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(15,'SYS_UI_ICON',15,'el-icon-s-goods','S商品','type.define.SYS_UI_ICON.el-icon-s-goods','S商品','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(16,'SYS_UI_ICON',16,'el-icon-goods','产品','type.define.SYS_UI_ICON.el-icon-goods','产品','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(17,'SYS_UI_ICON',17,'el-icon-warning','警告','type.define.SYS_UI_ICON.el-icon-warning','警告','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(18,'SYS_UI_ICON',18,'el-icon-warning-outline','警告概述','type.define.SYS_UI_ICON.el-icon-warning-outline','警告概述','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(19,'SYS_UI_ICON',19,'el-icon-question','题','type.define.SYS_UI_ICON.el-icon-question','题','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(20,'SYS_UI_ICON',20,'el-icon-info','信息','type.define.SYS_UI_ICON.el-icon-info','信息','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(21,'SYS_UI_ICON',21,'el-icon-remove','去掉','type.define.SYS_UI_ICON.el-icon-remove','去掉','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(22,'SYS_UI_ICON',22,'el-icon-circle-plus','圈加','type.define.SYS_UI_ICON.el-icon-circle-plus','圈加','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(23,'SYS_UI_ICON',23,'el-icon-success','成功','type.define.SYS_UI_ICON.el-icon-success','成功','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(24,'SYS_UI_ICON',24,'el-icon-error','错误','type.define.SYS_UI_ICON.el-icon-error','错误','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(25,'SYS_UI_ICON',25,'el-icon-zoom-in','放大','type.define.SYS_UI_ICON.el-icon-zoom-in','放大','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(26,'SYS_UI_ICON',26,'el-icon-zoom-out','缩小','type.define.SYS_UI_ICON.el-icon-zoom-out','缩小','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(27,'SYS_UI_ICON',27,'el-icon-remove-outline','删除大纲','type.define.SYS_UI_ICON.el-icon-remove-outline','删除大纲','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(28,'SYS_UI_ICON',28,'el-icon-circle-plus-outline','圈加大纲','type.define.SYS_UI_ICON.el-icon-circle-plus-outline','圈加大纲','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(29,'SYS_UI_ICON',29,'el-icon-circle-check','循环检查','type.define.SYS_UI_ICON.el-icon-circle-check','循环检查','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(30,'SYS_UI_ICON',30,'el-icon-circle-close','圈闭','type.define.SYS_UI_ICON.el-icon-circle-close','圈闭','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(31,'SYS_UI_ICON',31,'el-icon-s-help','帮助','type.define.SYS_UI_ICON.el-icon-s-help','帮助','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(32,'SYS_UI_ICON',32,'el-icon-help','救命','type.define.SYS_UI_ICON.el-icon-help','救命','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(33,'SYS_UI_ICON',33,'el-icon-minus','减去','type.define.SYS_UI_ICON.el-icon-minus','减去','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(34,'SYS_UI_ICON',34,'el-icon-plus','加','type.define.SYS_UI_ICON.el-icon-plus','加','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(35,'SYS_UI_ICON',35,'el-icon-check','校验','type.define.SYS_UI_ICON.el-icon-check','校验','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(36,'SYS_UI_ICON',36,'el-icon-close','关','type.define.SYS_UI_ICON.el-icon-close','关','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(37,'SYS_UI_ICON',37,'el-icon-picture','图片','type.define.SYS_UI_ICON.el-icon-picture','图片','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(38,'SYS_UI_ICON',38,'el-icon-picture-outline','图片轮廓','type.define.SYS_UI_ICON.el-icon-picture-outline','图片轮廓','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(39,'SYS_UI_ICON',39,'el-icon-picture-outline-round','图片轮廓轮','type.define.SYS_UI_ICON.el-icon-picture-outline-round','图片轮廓轮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(40,'SYS_UI_ICON',40,'el-icon-upload','上载','type.define.SYS_UI_ICON.el-icon-upload','上载','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(41,'SYS_UI_ICON',41,'el-icon-upload2','上载2','type.define.SYS_UI_ICON.el-icon-upload2','上载2','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(42,'SYS_UI_ICON',42,'el-icon-download','下载','type.define.SYS_UI_ICON.el-icon-download','下载','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(43,'SYS_UI_ICON',43,'el-icon-camera-solid','相机固体','type.define.SYS_UI_ICON.el-icon-camera-solid','相机固体','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(44,'SYS_UI_ICON',44,'el-icon-camera','相机','type.define.SYS_UI_ICON.el-icon-camera','相机','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(45,'SYS_UI_ICON',45,'el-icon-video-camera-solid','摄影机固体','type.define.SYS_UI_ICON.el-icon-video-camera-solid','摄影机固体','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(46,'SYS_UI_ICON',46,'el-icon-video-camera','摄像机','type.define.SYS_UI_ICON.el-icon-video-camera','摄像机','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(47,'SYS_UI_ICON',47,'el-icon-message-solid','消息牢固','type.define.SYS_UI_ICON.el-icon-message-solid','消息牢固','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(48,'SYS_UI_ICON',48,'el-icon-bell','钟','type.define.SYS_UI_ICON.el-icon-bell','钟','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(49,'SYS_UI_ICON',49,'el-icon-s-cooperation','合作','type.define.SYS_UI_ICON.el-icon-s-cooperation','合作','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(50,'SYS_UI_ICON',50,'el-icon-s-order','顺序','type.define.SYS_UI_ICON.el-icon-s-order','顺序','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(51,'SYS_UI_ICON',51,'el-icon-s-platform','S平台','type.define.SYS_UI_ICON.el-icon-s-platform','S平台','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(52,'SYS_UI_ICON',52,'el-icon-s-fold','折','type.define.SYS_UI_ICON.el-icon-s-fold','折','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(53,'SYS_UI_ICON',53,'el-icon-s-unfold','展开','type.define.SYS_UI_ICON.el-icon-s-unfold','展开','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(54,'SYS_UI_ICON',54,'el-icon-s-operation','操作','type.define.SYS_UI_ICON.el-icon-s-operation','操作','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(55,'SYS_UI_ICON',55,'el-icon-s-promotion','促销','type.define.SYS_UI_ICON.el-icon-s-promotion','促销','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(56,'SYS_UI_ICON',56,'el-icon-s-home','家庭','type.define.SYS_UI_ICON.el-icon-s-home','家庭','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(57,'SYS_UI_ICON',57,'el-icon-s-release','释放','type.define.SYS_UI_ICON.el-icon-s-release','释放','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(58,'SYS_UI_ICON',58,'el-icon-s-ticket','门票','type.define.SYS_UI_ICON.el-icon-s-ticket','门票','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(59,'SYS_UI_ICON',59,'el-icon-s-management','管理','type.define.SYS_UI_ICON.el-icon-s-management','管理','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(60,'SYS_UI_ICON',60,'el-icon-s-open','开','type.define.SYS_UI_ICON.el-icon-s-open','开','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(61,'SYS_UI_ICON',61,'el-icon-s-shop','商店','type.define.SYS_UI_ICON.el-icon-s-shop','商店','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(62,'SYS_UI_ICON',62,'el-icon-s-marketing','营销','type.define.SYS_UI_ICON.el-icon-s-marketing','营销','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(63,'SYS_UI_ICON',63,'el-icon-s-flag','s标志','type.define.SYS_UI_ICON.el-icon-s-flag','s标志','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(64,'SYS_UI_ICON',64,'el-icon-s-comment','评论','type.define.SYS_UI_ICON.el-icon-s-comment','评论','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(65,'SYS_UI_ICON',65,'el-icon-s-finance','金融','type.define.SYS_UI_ICON.el-icon-s-finance','金融','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(66,'SYS_UI_ICON',66,'el-icon-s-claim','索赔','type.define.SYS_UI_ICON.el-icon-s-claim','索赔','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(67,'SYS_UI_ICON',67,'el-icon-s-custom','习惯','type.define.SYS_UI_ICON.el-icon-s-custom','习惯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(68,'SYS_UI_ICON',68,'el-icon-s-opportunity','机会','type.define.SYS_UI_ICON.el-icon-s-opportunity','机会','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(69,'SYS_UI_ICON',69,'el-icon-s-data','数据','type.define.SYS_UI_ICON.el-icon-s-data','数据','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(70,'SYS_UI_ICON',70,'el-icon-s-check','S检查','type.define.SYS_UI_ICON.el-icon-s-check','S检查','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(71,'SYS_UI_ICON',71,'el-icon-s-grid','网格','type.define.SYS_UI_ICON.el-icon-s-grid','网格','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(72,'SYS_UI_ICON',72,'el-icon-menu','菜单','type.define.SYS_UI_ICON.el-icon-menu','菜单','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(73,'SYS_UI_ICON',73,'el-icon-share','分享','type.define.SYS_UI_ICON.el-icon-share','分享','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(74,'SYS_UI_ICON',74,'el-icon-d-caret','插入符号','type.define.SYS_UI_ICON.el-icon-d-caret','插入符号','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(75,'SYS_UI_ICON',75,'el-icon-caret-left','左尖号','type.define.SYS_UI_ICON.el-icon-caret-left','左尖号','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(76,'SYS_UI_ICON',76,'el-icon-caret-right','右插入符','type.define.SYS_UI_ICON.el-icon-caret-right','右插入符','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(77,'SYS_UI_ICON',77,'el-icon-caret-bottom','尖号底部','type.define.SYS_UI_ICON.el-icon-caret-bottom','尖号底部','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(78,'SYS_UI_ICON',78,'el-icon-caret-top','尖顶','type.define.SYS_UI_ICON.el-icon-caret-top','尖顶','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(79,'SYS_UI_ICON',79,'el-icon-bottom-left','左下方','type.define.SYS_UI_ICON.el-icon-bottom-left','左下方','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(80,'SYS_UI_ICON',80,'el-icon-bottom-right','右下','type.define.SYS_UI_ICON.el-icon-bottom-right','右下','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(81,'SYS_UI_ICON',81,'el-icon-back','背部','type.define.SYS_UI_ICON.el-icon-back','背部','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(82,'SYS_UI_ICON',82,'el-icon-right','对','type.define.SYS_UI_ICON.el-icon-right','对','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(83,'SYS_UI_ICON',83,'el-icon-bottom','底部','type.define.SYS_UI_ICON.el-icon-bottom','底部','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(84,'SYS_UI_ICON',84,'el-icon-top','最佳','type.define.SYS_UI_ICON.el-icon-top','最佳','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(85,'SYS_UI_ICON',85,'el-icon-top-left','左上方','type.define.SYS_UI_ICON.el-icon-top-left','左上方','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(86,'SYS_UI_ICON',86,'el-icon-top-right','右上','type.define.SYS_UI_ICON.el-icon-top-right','右上','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(87,'SYS_UI_ICON',87,'el-icon-arrow-left','向左箭头','type.define.SYS_UI_ICON.el-icon-arrow-left','向左箭头','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(88,'SYS_UI_ICON',88,'el-icon-arrow-right','向右箭头','type.define.SYS_UI_ICON.el-icon-arrow-right','向右箭头','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(89,'SYS_UI_ICON',89,'el-icon-arrow-down','向下箭头','type.define.SYS_UI_ICON.el-icon-arrow-down','向下箭头','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(90,'SYS_UI_ICON',90,'el-icon-arrow-up','向上箭头','type.define.SYS_UI_ICON.el-icon-arrow-up','向上箭头','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(91,'SYS_UI_ICON',91,'el-icon-d-arrow-left','左箭头','type.define.SYS_UI_ICON.el-icon-d-arrow-left','左箭头','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(92,'SYS_UI_ICON',92,'el-icon-d-arrow-right','右箭头','type.define.SYS_UI_ICON.el-icon-d-arrow-right','右箭头','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(93,'SYS_UI_ICON',93,'el-icon-video-pause','视频暂停','type.define.SYS_UI_ICON.el-icon-video-pause','视频暂停','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(94,'SYS_UI_ICON',94,'el-icon-video-play','影片播放','type.define.SYS_UI_ICON.el-icon-video-play','影片播放','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(95,'SYS_UI_ICON',95,'el-icon-refresh','刷新','type.define.SYS_UI_ICON.el-icon-refresh','刷新','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(96,'SYS_UI_ICON',96,'el-icon-refresh-right','向右刷新','type.define.SYS_UI_ICON.el-icon-refresh-right','向右刷新','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(97,'SYS_UI_ICON',97,'el-icon-refresh-left','向左刷新','type.define.SYS_UI_ICON.el-icon-refresh-left','向左刷新','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(98,'SYS_UI_ICON',98,'el-icon-finished','完了','type.define.SYS_UI_ICON.el-icon-finished','完了','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(99,'SYS_UI_ICON',99,'el-icon-sort','分类','type.define.SYS_UI_ICON.el-icon-sort','分类','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(100,'SYS_UI_ICON',100,'el-icon-sort-up','整理','type.define.SYS_UI_ICON.el-icon-sort-up','整理','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(101,'SYS_UI_ICON',101,'el-icon-sort-down','排序','type.define.SYS_UI_ICON.el-icon-sort-down','排序','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(102,'SYS_UI_ICON',102,'el-icon-rank','秩','type.define.SYS_UI_ICON.el-icon-rank','秩','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(103,'SYS_UI_ICON',103,'el-icon-loading','装货','type.define.SYS_UI_ICON.el-icon-loading','装货','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(104,'SYS_UI_ICON',104,'el-icon-view','视图','type.define.SYS_UI_ICON.el-icon-view','视图','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(105,'SYS_UI_ICON',105,'el-icon-c-scale-to-original','c刻度到原始','type.define.SYS_UI_ICON.el-icon-c-scale-to-original','c刻度到原始','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(106,'SYS_UI_ICON',106,'el-icon-date','日期','type.define.SYS_UI_ICON.el-icon-date','日期','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(107,'SYS_UI_ICON',107,'el-icon-edit','编辑','type.define.SYS_UI_ICON.el-icon-edit','编辑','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(108,'SYS_UI_ICON',108,'el-icon-edit-outline','编辑大纲','type.define.SYS_UI_ICON.el-icon-edit-outline','编辑大纲','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(109,'SYS_UI_ICON',109,'el-icon-folder','夹','type.define.SYS_UI_ICON.el-icon-folder','夹','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(110,'SYS_UI_ICON',110,'el-icon-folder-opened','资料夹已开启','type.define.SYS_UI_ICON.el-icon-folder-opened','资料夹已开启','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(111,'SYS_UI_ICON',111,'el-icon-folder-add','文件夹添加','type.define.SYS_UI_ICON.el-icon-folder-add','文件夹添加','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(112,'SYS_UI_ICON',112,'el-icon-folder-remove','文件夹删除','type.define.SYS_UI_ICON.el-icon-folder-remove','文件夹删除','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(113,'SYS_UI_ICON',113,'el-icon-folder-delete','文件夹删除','type.define.SYS_UI_ICON.el-icon-folder-delete','文件夹删除','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(114,'SYS_UI_ICON',114,'el-icon-folder-checked','资料夹检查','type.define.SYS_UI_ICON.el-icon-folder-checked','资料夹检查','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(115,'SYS_UI_ICON',115,'el-icon-tickets','车票','type.define.SYS_UI_ICON.el-icon-tickets','车票','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(116,'SYS_UI_ICON',116,'el-icon-document-remove','删除文件','type.define.SYS_UI_ICON.el-icon-document-remove','删除文件','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(117,'SYS_UI_ICON',117,'el-icon-document-delete','文件删除','type.define.SYS_UI_ICON.el-icon-document-delete','文件删除','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(118,'SYS_UI_ICON',118,'el-icon-document-copy','文件副本','type.define.SYS_UI_ICON.el-icon-document-copy','文件副本','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(119,'SYS_UI_ICON',119,'el-icon-document-checked','文件检查','type.define.SYS_UI_ICON.el-icon-document-checked','文件检查','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(120,'SYS_UI_ICON',120,'el-icon-document','文献','type.define.SYS_UI_ICON.el-icon-document','文献','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(121,'SYS_UI_ICON',121,'el-icon-document-add','文件添加','type.define.SYS_UI_ICON.el-icon-document-add','文件添加','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(122,'SYS_UI_ICON',122,'el-icon-printer','打印机','type.define.SYS_UI_ICON.el-icon-printer','打印机','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(123,'SYS_UI_ICON',123,'el-icon-paperclip','回形针','type.define.SYS_UI_ICON.el-icon-paperclip','回形针','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(124,'SYS_UI_ICON',124,'el-icon-takeaway-box','外卖盒','type.define.SYS_UI_ICON.el-icon-takeaway-box','外卖盒','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(125,'SYS_UI_ICON',125,'el-icon-search','搜索','type.define.SYS_UI_ICON.el-icon-search','搜索','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(126,'SYS_UI_ICON',126,'el-icon-monitor','监控','type.define.SYS_UI_ICON.el-icon-monitor','监控','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(127,'SYS_UI_ICON',127,'el-icon-attract','吸引','type.define.SYS_UI_ICON.el-icon-attract','吸引','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(128,'SYS_UI_ICON',128,'el-icon-mobile','移动','type.define.SYS_UI_ICON.el-icon-mobile','移动','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(129,'SYS_UI_ICON',129,'el-icon-scissors','剪刀','type.define.SYS_UI_ICON.el-icon-scissors','剪刀','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(130,'SYS_UI_ICON',130,'el-icon-umbrella','雨伞','type.define.SYS_UI_ICON.el-icon-umbrella','雨伞','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(131,'SYS_UI_ICON',131,'el-icon-headset','耳机','type.define.SYS_UI_ICON.el-icon-headset','耳机','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(132,'SYS_UI_ICON',132,'el-icon-brush','刷','type.define.SYS_UI_ICON.el-icon-brush','刷','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(133,'SYS_UI_ICON',133,'el-icon-mouse','老鼠','type.define.SYS_UI_ICON.el-icon-mouse','老鼠','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(134,'SYS_UI_ICON',134,'el-icon-coordinate','坐标','type.define.SYS_UI_ICON.el-icon-coordinate','坐标','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(135,'SYS_UI_ICON',135,'el-icon-magic-stick','魔术棒','type.define.SYS_UI_ICON.el-icon-magic-stick','魔术棒','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(136,'SYS_UI_ICON',136,'el-icon-reading','读','type.define.SYS_UI_ICON.el-icon-reading','读','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(137,'SYS_UI_ICON',137,'el-icon-data-line','数据线','type.define.SYS_UI_ICON.el-icon-data-line','数据线','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(138,'SYS_UI_ICON',138,'el-icon-data-board','数据板','type.define.SYS_UI_ICON.el-icon-data-board','数据板','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(139,'SYS_UI_ICON',139,'el-icon-pie-chart','饼形图','type.define.SYS_UI_ICON.el-icon-pie-chart','饼形图','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(140,'SYS_UI_ICON',140,'el-icon-data-analysis','数据分析','type.define.SYS_UI_ICON.el-icon-data-analysis','数据分析','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(141,'SYS_UI_ICON',141,'el-icon-collection-tag','收集标签','type.define.SYS_UI_ICON.el-icon-collection-tag','收集标签','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(142,'SYS_UI_ICON',142,'el-icon-film','电影','type.define.SYS_UI_ICON.el-icon-film','电影','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(143,'SYS_UI_ICON',143,'el-icon-suitcase','手提箱','type.define.SYS_UI_ICON.el-icon-suitcase','手提箱','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(144,'SYS_UI_ICON',144,'el-icon-suitcase-1','手提箱1','type.define.SYS_UI_ICON.el-icon-suitcase-1','手提箱1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(145,'SYS_UI_ICON',145,'el-icon-receiving','接收','type.define.SYS_UI_ICON.el-icon-receiving','接收','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(146,'SYS_UI_ICON',146,'el-icon-collection','采集','type.define.SYS_UI_ICON.el-icon-collection','采集','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(147,'SYS_UI_ICON',147,'el-icon-files','档案','type.define.SYS_UI_ICON.el-icon-files','档案','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(148,'SYS_UI_ICON',148,'el-icon-notebook-1','笔记本1','type.define.SYS_UI_ICON.el-icon-notebook-1','笔记本1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(149,'SYS_UI_ICON',149,'el-icon-notebook-2','笔记本2','type.define.SYS_UI_ICON.el-icon-notebook-2','笔记本2','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(150,'SYS_UI_ICON',150,'el-icon-toilet-paper','卫生纸','type.define.SYS_UI_ICON.el-icon-toilet-paper','卫生纸','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(151,'SYS_UI_ICON',151,'el-icon-office-building','办公楼','type.define.SYS_UI_ICON.el-icon-office-building','办公楼','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(152,'SYS_UI_ICON',152,'el-icon-school','学校','type.define.SYS_UI_ICON.el-icon-school','学校','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(153,'SYS_UI_ICON',153,'el-icon-table-lamp','台灯','type.define.SYS_UI_ICON.el-icon-table-lamp','台灯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(154,'SYS_UI_ICON',154,'el-icon-house','屋','type.define.SYS_UI_ICON.el-icon-house','屋','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(155,'SYS_UI_ICON',155,'el-icon-no-smoking','禁止抽烟','type.define.SYS_UI_ICON.el-icon-no-smoking','禁止抽烟','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(156,'SYS_UI_ICON',156,'el-icon-smoking','抽烟','type.define.SYS_UI_ICON.el-icon-smoking','抽烟','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(157,'SYS_UI_ICON',157,'el-icon-shopping-cart-full','购物车满','type.define.SYS_UI_ICON.el-icon-shopping-cart-full','购物车满','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(158,'SYS_UI_ICON',158,'el-icon-shopping-cart-1','购物车1','type.define.SYS_UI_ICON.el-icon-shopping-cart-1','购物车1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(159,'SYS_UI_ICON',159,'el-icon-shopping-cart-2','购物车2','type.define.SYS_UI_ICON.el-icon-shopping-cart-2','购物车2','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(160,'SYS_UI_ICON',160,'el-icon-shopping-bag-1','购物袋1','type.define.SYS_UI_ICON.el-icon-shopping-bag-1','购物袋1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(161,'SYS_UI_ICON',161,'el-icon-shopping-bag-2','购物袋2','type.define.SYS_UI_ICON.el-icon-shopping-bag-2','购物袋2','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(162,'SYS_UI_ICON',162,'el-icon-sold-out','卖光了','type.define.SYS_UI_ICON.el-icon-sold-out','卖光了','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(163,'SYS_UI_ICON',163,'el-icon-sell','卖','type.define.SYS_UI_ICON.el-icon-sell','卖','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(164,'SYS_UI_ICON',164,'el-icon-present','当下','type.define.SYS_UI_ICON.el-icon-present','当下','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(165,'SYS_UI_ICON',165,'el-icon-box','框','type.define.SYS_UI_ICON.el-icon-box','框','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(166,'SYS_UI_ICON',166,'el-icon-bank-card','银行卡','type.define.SYS_UI_ICON.el-icon-bank-card','银行卡','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(167,'SYS_UI_ICON',167,'el-icon-money','钱','type.define.SYS_UI_ICON.el-icon-money','钱','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(168,'SYS_UI_ICON',168,'el-icon-coin','硬币','type.define.SYS_UI_ICON.el-icon-coin','硬币','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(169,'SYS_UI_ICON',169,'el-icon-wallet','钱包','type.define.SYS_UI_ICON.el-icon-wallet','钱包','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(170,'SYS_UI_ICON',170,'el-icon-discount','折扣','type.define.SYS_UI_ICON.el-icon-discount','折扣','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(171,'SYS_UI_ICON',171,'el-icon-price-tag','价格标签','type.define.SYS_UI_ICON.el-icon-price-tag','价格标签','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(172,'SYS_UI_ICON',172,'el-icon-news','新闻','type.define.SYS_UI_ICON.el-icon-news','新闻','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(173,'SYS_UI_ICON',173,'el-icon-guide','指南','type.define.SYS_UI_ICON.el-icon-guide','指南','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(174,'SYS_UI_ICON',174,'el-icon-male','男','type.define.SYS_UI_ICON.el-icon-male','男','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(175,'SYS_UI_ICON',175,'el-icon-female','女','type.define.SYS_UI_ICON.el-icon-female','女','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(176,'SYS_UI_ICON',176,'el-icon-thumb','拇指','type.define.SYS_UI_ICON.el-icon-thumb','拇指','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(177,'SYS_UI_ICON',177,'el-icon-cpu','中央处理器','type.define.SYS_UI_ICON.el-icon-cpu','中央处理器','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(178,'SYS_UI_ICON',178,'el-icon-link','链接','type.define.SYS_UI_ICON.el-icon-link','链接','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(179,'SYS_UI_ICON',179,'el-icon-connection','连接','type.define.SYS_UI_ICON.el-icon-connection','连接','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(180,'SYS_UI_ICON',180,'el-icon-open','打开','type.define.SYS_UI_ICON.el-icon-open','打开','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(181,'SYS_UI_ICON',181,'el-icon-turn-off','关掉','type.define.SYS_UI_ICON.el-icon-turn-off','关掉','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(182,'SYS_UI_ICON',182,'el-icon-set-up','设定','type.define.SYS_UI_ICON.el-icon-set-up','设定','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(183,'SYS_UI_ICON',183,'el-icon-chat-round','聊天轮','type.define.SYS_UI_ICON.el-icon-chat-round','聊天轮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(184,'SYS_UI_ICON',184,'el-icon-chat-line-round','聊天线轮','type.define.SYS_UI_ICON.el-icon-chat-line-round','聊天线轮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(185,'SYS_UI_ICON',185,'el-icon-chat-square','聊天广场','type.define.SYS_UI_ICON.el-icon-chat-square','聊天广场','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(186,'SYS_UI_ICON',186,'el-icon-chat-dot-round','圆点聊天','type.define.SYS_UI_ICON.el-icon-chat-dot-round','圆点聊天','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(187,'SYS_UI_ICON',187,'el-icon-chat-dot-square','聊天点广场','type.define.SYS_UI_ICON.el-icon-chat-dot-square','聊天点广场','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(188,'SYS_UI_ICON',188,'el-icon-chat-line-square','聊天线广场','type.define.SYS_UI_ICON.el-icon-chat-line-square','聊天线广场','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(189,'SYS_UI_ICON',189,'el-icon-message','信息','type.define.SYS_UI_ICON.el-icon-message','信息','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(190,'SYS_UI_ICON',190,'el-icon-postcard','明信片','type.define.SYS_UI_ICON.el-icon-postcard','明信片','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(191,'SYS_UI_ICON',191,'el-icon-position','位置','type.define.SYS_UI_ICON.el-icon-position','位置','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(192,'SYS_UI_ICON',192,'el-icon-turn-off-microphone','关机麦克风','type.define.SYS_UI_ICON.el-icon-turn-off-microphone','关机麦克风','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(193,'SYS_UI_ICON',193,'el-icon-microphone','麦克风','type.define.SYS_UI_ICON.el-icon-microphone','麦克风','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(194,'SYS_UI_ICON',194,'el-icon-close-notification','封闭通知','type.define.SYS_UI_ICON.el-icon-close-notification','封闭通知','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(195,'SYS_UI_ICON',195,'el-icon-bangzhu','帮主','type.define.SYS_UI_ICON.el-icon-bangzhu','帮主','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(196,'SYS_UI_ICON',196,'el-icon-time','时间','type.define.SYS_UI_ICON.el-icon-time','时间','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(197,'SYS_UI_ICON',197,'el-icon-odometer','里程表','type.define.SYS_UI_ICON.el-icon-odometer','里程表','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(198,'SYS_UI_ICON',198,'el-icon-crop','作物','type.define.SYS_UI_ICON.el-icon-crop','作物','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(199,'SYS_UI_ICON',199,'el-icon-aim','目标','type.define.SYS_UI_ICON.el-icon-aim','目标','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(200,'SYS_UI_ICON',200,'el-icon-switch-button','开关按钮','type.define.SYS_UI_ICON.el-icon-switch-button','开关按钮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(201,'SYS_UI_ICON',201,'el-icon-full-screen','全屏','type.define.SYS_UI_ICON.el-icon-full-screen','全屏','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(202,'SYS_UI_ICON',202,'el-icon-copy-document','复制文件','type.define.SYS_UI_ICON.el-icon-copy-document','复制文件','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(203,'SYS_UI_ICON',203,'el-icon-mic','麦克风','type.define.SYS_UI_ICON.el-icon-mic','麦克风','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(204,'SYS_UI_ICON',204,'el-icon-stopwatch','跑表','type.define.SYS_UI_ICON.el-icon-stopwatch','跑表','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(205,'SYS_UI_ICON',205,'el-icon-medal-1','奖牌1','type.define.SYS_UI_ICON.el-icon-medal-1','奖牌1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(206,'SYS_UI_ICON',206,'el-icon-medal','勋章','type.define.SYS_UI_ICON.el-icon-medal','勋章','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(207,'SYS_UI_ICON',207,'el-icon-trophy','杯','type.define.SYS_UI_ICON.el-icon-trophy','杯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(208,'SYS_UI_ICON',208,'el-icon-trophy-1','奖杯1','type.define.SYS_UI_ICON.el-icon-trophy-1','奖杯1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(209,'SYS_UI_ICON',209,'el-icon-first-aid-kit','急救箱','type.define.SYS_UI_ICON.el-icon-first-aid-kit','急救箱','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(210,'SYS_UI_ICON',210,'el-icon-discover','发现','type.define.SYS_UI_ICON.el-icon-discover','发现','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(211,'SYS_UI_ICON',211,'el-icon-place','地点','type.define.SYS_UI_ICON.el-icon-place','地点','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(212,'SYS_UI_ICON',212,'el-icon-location','位置','type.define.SYS_UI_ICON.el-icon-location','位置','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(213,'SYS_UI_ICON',213,'el-icon-location-outline','位置概述','type.define.SYS_UI_ICON.el-icon-location-outline','位置概述','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(214,'SYS_UI_ICON',214,'el-icon-location-information','地点信息','type.define.SYS_UI_ICON.el-icon-location-information','地点信息','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(215,'SYS_UI_ICON',215,'el-icon-add-location','添加位置','type.define.SYS_UI_ICON.el-icon-add-location','添加位置','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(216,'SYS_UI_ICON',216,'el-icon-delete-location','删除位置','type.define.SYS_UI_ICON.el-icon-delete-location','删除位置','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(217,'SYS_UI_ICON',217,'el-icon-map-location','地图位置','type.define.SYS_UI_ICON.el-icon-map-location','地图位置','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(218,'SYS_UI_ICON',218,'el-icon-alarm-clock','闹钟','type.define.SYS_UI_ICON.el-icon-alarm-clock','闹钟','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(219,'SYS_UI_ICON',219,'el-icon-timer','计时器','type.define.SYS_UI_ICON.el-icon-timer','计时器','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(220,'SYS_UI_ICON',220,'el-icon-watch-1','看1','type.define.SYS_UI_ICON.el-icon-watch-1','看1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(221,'SYS_UI_ICON',221,'el-icon-watch','看','type.define.SYS_UI_ICON.el-icon-watch','看','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(222,'SYS_UI_ICON',222,'el-icon-lock','锁','type.define.SYS_UI_ICON.el-icon-lock','锁','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(223,'SYS_UI_ICON',223,'el-icon-unlock','开锁','type.define.SYS_UI_ICON.el-icon-unlock','开锁','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(224,'SYS_UI_ICON',224,'el-icon-key','键','type.define.SYS_UI_ICON.el-icon-key','键','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(225,'SYS_UI_ICON',225,'el-icon-service','服务','type.define.SYS_UI_ICON.el-icon-service','服务','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(226,'SYS_UI_ICON',226,'el-icon-mobile-phone','移动电话','type.define.SYS_UI_ICON.el-icon-mobile-phone','移动电话','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(227,'SYS_UI_ICON',227,'el-icon-bicycle','自行车','type.define.SYS_UI_ICON.el-icon-bicycle','自行车','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(228,'SYS_UI_ICON',228,'el-icon-truck','卡车','type.define.SYS_UI_ICON.el-icon-truck','卡车','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(229,'SYS_UI_ICON',229,'el-icon-ship','船','type.define.SYS_UI_ICON.el-icon-ship','船','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(230,'SYS_UI_ICON',230,'el-icon-basketball','篮球','type.define.SYS_UI_ICON.el-icon-basketball','篮球','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(231,'SYS_UI_ICON',231,'el-icon-football','足球','type.define.SYS_UI_ICON.el-icon-football','足球','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(232,'SYS_UI_ICON',232,'el-icon-soccer','足球','type.define.SYS_UI_ICON.el-icon-soccer','足球','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(233,'SYS_UI_ICON',233,'el-icon-baseball','棒球','type.define.SYS_UI_ICON.el-icon-baseball','棒球','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(234,'SYS_UI_ICON',234,'el-icon-wind-power','风力','type.define.SYS_UI_ICON.el-icon-wind-power','风力','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(235,'SYS_UI_ICON',235,'el-icon-light-rain','小雨','type.define.SYS_UI_ICON.el-icon-light-rain','小雨','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(236,'SYS_UI_ICON',236,'el-icon-lightning','闪电','type.define.SYS_UI_ICON.el-icon-lightning','闪电','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(237,'SYS_UI_ICON',237,'el-icon-heavy-rain','倾盆大雨','type.define.SYS_UI_ICON.el-icon-heavy-rain','倾盆大雨','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(238,'SYS_UI_ICON',238,'el-icon-sunrise','日出','type.define.SYS_UI_ICON.el-icon-sunrise','日出','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(239,'SYS_UI_ICON',239,'el-icon-sunrise-1','日出1','type.define.SYS_UI_ICON.el-icon-sunrise-1','日出1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(240,'SYS_UI_ICON',240,'el-icon-sunset','日落','type.define.SYS_UI_ICON.el-icon-sunset','日落','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(241,'SYS_UI_ICON',241,'el-icon-sunny','阳光明媚','type.define.SYS_UI_ICON.el-icon-sunny','阳光明媚','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(242,'SYS_UI_ICON',242,'el-icon-cloudy','多云的','type.define.SYS_UI_ICON.el-icon-cloudy','多云的','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(243,'SYS_UI_ICON',243,'el-icon-partly-cloudy','局部阴天','type.define.SYS_UI_ICON.el-icon-partly-cloudy','局部阴天','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(244,'SYS_UI_ICON',244,'el-icon-cloudy-and-sunny','晴间多云','type.define.SYS_UI_ICON.el-icon-cloudy-and-sunny','晴间多云','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(245,'SYS_UI_ICON',245,'el-icon-moon','月亮','type.define.SYS_UI_ICON.el-icon-moon','月亮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(246,'SYS_UI_ICON',246,'el-icon-moon-night','月夜','type.define.SYS_UI_ICON.el-icon-moon-night','月夜','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(247,'SYS_UI_ICON',247,'el-icon-dish','碟','type.define.SYS_UI_ICON.el-icon-dish','碟','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(248,'SYS_UI_ICON',248,'el-icon-dish-1','碟1','type.define.SYS_UI_ICON.el-icon-dish-1','碟1','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(249,'SYS_UI_ICON',249,'el-icon-food','餐饮','type.define.SYS_UI_ICON.el-icon-food','餐饮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(250,'SYS_UI_ICON',250,'el-icon-chicken','鸡','type.define.SYS_UI_ICON.el-icon-chicken','鸡','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(251,'SYS_UI_ICON',251,'el-icon-fork-spoon','叉勺','type.define.SYS_UI_ICON.el-icon-fork-spoon','叉勺','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(252,'SYS_UI_ICON',252,'el-icon-knife-fork','刀叉','type.define.SYS_UI_ICON.el-icon-knife-fork','刀叉','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(253,'SYS_UI_ICON',253,'el-icon-burger','汉堡包','type.define.SYS_UI_ICON.el-icon-burger','汉堡包','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(254,'SYS_UI_ICON',254,'el-icon-tableware','餐具','type.define.SYS_UI_ICON.el-icon-tableware','餐具','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(255,'SYS_UI_ICON',255,'el-icon-sugar','糖','type.define.SYS_UI_ICON.el-icon-sugar','糖','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(256,'SYS_UI_ICON',256,'el-icon-dessert','甜点','type.define.SYS_UI_ICON.el-icon-dessert','甜点','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(257,'SYS_UI_ICON',257,'el-icon-ice-cream','冰淇淋','type.define.SYS_UI_ICON.el-icon-ice-cream','冰淇淋','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(258,'SYS_UI_ICON',258,'el-icon-hot-water','热水','type.define.SYS_UI_ICON.el-icon-hot-water','热水','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(259,'SYS_UI_ICON',259,'el-icon-water-cup','水杯','type.define.SYS_UI_ICON.el-icon-water-cup','水杯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(260,'SYS_UI_ICON',260,'el-icon-coffee-cup','咖啡杯','type.define.SYS_UI_ICON.el-icon-coffee-cup','咖啡杯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(261,'SYS_UI_ICON',261,'el-icon-cold-drink','冷饮','type.define.SYS_UI_ICON.el-icon-cold-drink','冷饮','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(262,'SYS_UI_ICON',262,'el-icon-goblet','高脚杯','type.define.SYS_UI_ICON.el-icon-goblet','高脚杯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(263,'SYS_UI_ICON',263,'el-icon-goblet-full','高脚杯','type.define.SYS_UI_ICON.el-icon-goblet-full','高脚杯','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(264,'SYS_UI_ICON',264,'el-icon-goblet-square','酒杯广场','type.define.SYS_UI_ICON.el-icon-goblet-square','酒杯广场','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(265,'SYS_UI_ICON',265,'el-icon-goblet-square-full','酒杯方形满','type.define.SYS_UI_ICON.el-icon-goblet-square-full','酒杯方形满','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(266,'SYS_UI_ICON',266,'el-icon-refrigerator','冰箱','type.define.SYS_UI_ICON.el-icon-refrigerator','冰箱','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(267,'SYS_UI_ICON',267,'el-icon-grape','葡萄','type.define.SYS_UI_ICON.el-icon-grape','葡萄','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(268,'SYS_UI_ICON',268,'el-icon-watermelon','西瓜','type.define.SYS_UI_ICON.el-icon-watermelon','西瓜','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(269,'SYS_UI_ICON',269,'el-icon-cherry','樱桃','type.define.SYS_UI_ICON.el-icon-cherry','樱桃','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(270,'SYS_UI_ICON',270,'el-icon-apple','苹果','type.define.SYS_UI_ICON.el-icon-apple','苹果','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(271,'SYS_UI_ICON',271,'el-icon-pear','梨','type.define.SYS_UI_ICON.el-icon-pear','梨','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(272,'SYS_UI_ICON',272,'el-icon-orange','橙子','type.define.SYS_UI_ICON.el-icon-orange','橙子','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(273,'SYS_UI_ICON',273,'el-icon-coffee','咖啡','type.define.SYS_UI_ICON.el-icon-coffee','咖啡','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(274,'SYS_UI_ICON',274,'el-icon-ice-tea','冰茶','type.define.SYS_UI_ICON.el-icon-ice-tea','冰茶','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(275,'SYS_UI_ICON',275,'el-icon-ice-drink','喝冰','type.define.SYS_UI_ICON.el-icon-ice-drink','喝冰','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(276,'SYS_UI_ICON',276,'el-icon-milk-tea','奶茶','type.define.SYS_UI_ICON.el-icon-milk-tea','奶茶','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(277,'SYS_UI_ICON',277,'el-icon-potato-strips','马铃薯条','type.define.SYS_UI_ICON.el-icon-potato-strips','马铃薯条','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(278,'SYS_UI_ICON',278,'el-icon-lollipop','棒糖','type.define.SYS_UI_ICON.el-icon-lollipop','棒糖','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(279,'SYS_UI_ICON',279,'el-icon-ice-cream-square','冰淇淋广场','type.define.SYS_UI_ICON.el-icon-ice-cream-square','冰淇淋广场','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL),(280,'SYS_UI_ICON',280,'el-icon-ice-cream-round','一轮冰淇淋','type.define.SYS_UI_ICON.el-icon-ice-cream-round','一轮冰淇淋','jacob','2019-11-04 17:57:09','jacob','2019-11-04 17:57:09',0,NULL);
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
INSERT INTO `t_mb_user` VALUES (1,'u1911210002','jacob','1a100d2c0dab19c4430e7d73762b3423','jacob1996@gmail.com','2019-09-19 17:05:32','jacob','2019-11-25 09:45:21','jacob',0,NULL);
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

-- Dump completed on 2019-11-25 17:45:56

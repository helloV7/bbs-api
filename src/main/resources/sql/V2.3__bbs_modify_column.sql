ALTER TABLE `post`
CHANGE COLUMN `file_url` `file_url` VARCHAR(100)  COMMENT '附件链接';


LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` VALUES (1,'https://photo.tuchong.com/381642/f/530514792.jpg','http://www.baidu.com',1,'美女',NULL),(2,'https://photo.tuchong.com/381642/f/103809864.jpg','http://www.baidu.com',1,NULL,NULL),(3,'https://photo.tuchong.com/381642/f/396624780.jpg','http://www.baidu.com',1,NULL,NULL),(4,'https://photo.tuchong.com/381642/f/308478843.jpg',NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;
UNLOCK TABLES;


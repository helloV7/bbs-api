
/*!40101 SET NAMES utf8 */;

#
# Structure for table "advertisement"
#

DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '广告\n',
  `image_url` varchar(45) DEFAULT NULL,
  `jump_url` varchar(45) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '广告商名',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告表';

#
# Data for table "advertisement"
#


#
# Structure for table "ad_click"
#

DROP TABLE IF EXISTS `ad_click`;
CREATE TABLE `ad_click` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_id` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ad_id` (`ad_id`),
  CONSTRAINT `ad_click_ibfk_1` FOREIGN KEY (`ad_id`) REFERENCES `advertisement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告点击次数记录表';

#
# Data for table "ad_click"
#


#
# Structure for table "area"
#

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '论坛分区',
  `parent_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `image_url` varchar(45) DEFAULT NULL,
  `area_ notice` text COMMENT '二级板块公告',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分区表';

#
# Data for table "area"
#


#
# Structure for table "banner"
#

DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '轮播图',
  `image_url` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '默认全为链接',
  `jump_url` varchar(45) DEFAULT NULL COMMENT '跳转地址',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播图表';

#
# Data for table "banner"
#


#
# Structure for table "message"
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息\n',
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `state` int(10) unsigned DEFAULT '0' COMMENT '0未读。1一读。2逻辑删除\n',
  `type` varchar(255) DEFAULT NULL COMMENT '0、禁言。1、解禁言。2、购买。3、举报别人帖子的处理。4、自己的帖子或者楼层被删除的消息。',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';

#
# Data for table "message"
#


#
# Structure for table "permission"
#

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL COMMENT '权限',
  `permission_name` varchar(45) DEFAULT NULL COMMENT '''权限名称''',
  `permission_code` varchar(45) DEFAULT NULL COMMENT '''权限代码 例如 user:get''',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "permission"
#


#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '''角色名称''',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "role"
#


#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`,`role_id`),
  KEY `fk_admin_role1_idx` (`role_id`),
  CONSTRAINT `fk_admin_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Data for table "admin"
#


#
# Structure for table "role_permission"
#

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `fk_role_has_permission_permission1_idx` (`permission_id`),
  KEY `fk_role_has_permission_role1_idx` (`role_id`),
  CONSTRAINT `fk_role_has_permission_permission1` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_permission_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "role_permission"
#


#
# Structure for table "score_water"
#

DROP TABLE IF EXISTS `score_water`;
CREATE TABLE `score_water` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `score` decimal(10,1) DEFAULT NULL COMMENT '积分变化情况',
  `type` int(1) DEFAULT NULL COMMENT '0、增加1、减少',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分流水';

#
# Data for table "score_water"
#


#
# Structure for table "shop"
#

DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '0、徽章。1、资料',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `score` decimal(10,1) DEFAULT NULL COMMENT '需要的积分',
  `url` varchar(255) DEFAULT NULL COMMENT '如果是徽章就是徽章图片的url，如果是资料文件就是资料文件的url',
  `create_time` date DEFAULT NULL,
  `state` int(11) DEFAULT '0' COMMENT '0上架、1下架，2、逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

#
# Data for table "shop"
#


#
# Structure for table "subject"
#

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL COMMENT '题目\n',
  `type` int(11) DEFAULT NULL COMMENT '1、单选。2、双选',
  `title` varchar(100) DEFAULT NULL COMMENT '题目',
  `right_answer` varchar(255) DEFAULT NULL COMMENT '正确答案',
  `answers_json` varchar(255) DEFAULT '' COMMENT '答案选项',
  `create_time` date DEFAULT NULL,
  `kind` int(11) DEFAULT NULL COMMENT '0、数据结构1、c语言2、java',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库表';

#
# Data for table "subject"
#


#
# Structure for table "system"
#

DROP TABLE IF EXISTS `system`;
CREATE TABLE `system` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统配置 ',
  `key` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL COMMENT '存放  今天访问量 ，关键字，等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

#
# Data for table "system"
#


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户',
  `username` varchar(25) DEFAULT NULL COMMENT '''用户名''',
  `avatar` varchar(45) DEFAULT NULL COMMENT '''头像''',
  `gender` int(11) DEFAULT NULL COMMENT '''性别''  1男 2女',
  `birthday` date DEFAULT NULL COMMENT '出生年月日',
  `password` varchar(32) DEFAULT NULL COMMENT '''密码md5''',
  `email` varchar(45) DEFAULT NULL COMMENT '''邮箱''',
  `nickname` varchar(10) DEFAULT NULL COMMENT '''昵称''',
  `score` decimal(10,1) DEFAULT '0.0' COMMENT '''积分''',
  `state` int(11) DEFAULT '0' COMMENT '账户状态 0 正常 1禁言 2逻辑删除',
  `introduce` varchar(255) DEFAULT NULL COMMENT '''个性签名''',
  `introduce_state` int(10) unsigned DEFAULT '0' COMMENT '用户动态是否显示\n 0 显示 1隐藏',
  `token` varchar(255) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "user"
#


#
# Structure for table "subject_record"
#

DROP TABLE IF EXISTS `subject_record`;
CREATE TABLE `subject_record` (
  `id` int(11) NOT NULL COMMENT '答题记录\n',
  `right_count` int(11) DEFAULT NULL COMMENT '正确题数',
  `type` int(1) DEFAULT NULL COMMENT '0、数据结构1、c语言2、java',
  `score` decimal(10,1) DEFAULT NULL COMMENT '获得积分\n',
  `user_id` int(11) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_subject_record_user1_idx` (`user_id`),
  CONSTRAINT `fk_subject_record_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答题记录表';

#
# Data for table "subject_record"
#


#
# Structure for table "sign"
#

DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL COMMENT '签到时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sign_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='签到表';

#
# Data for table "sign"
#


#
# Structure for table "punishment_record"
#

DROP TABLE IF EXISTS `punishment_record`;
CREATE TABLE `punishment_record` (
  `id` int(11) NOT NULL COMMENT '惩罚记录',
  `reason` varchar(45) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `punishmentcol` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `punishment_day` int(11) DEFAULT NULL COMMENT '惩罚天数\n',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_punishment_user1_idx` (`user_id`),
  CONSTRAINT `fk_punishment_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='禁言表';

#
# Data for table "punishment_record"
#


#
# Structure for table "post"
#

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perfect` int(1) DEFAULT '0' COMMENT '0、没加精。1、加精',
  `overhead` int(1) DEFAULT '0' COMMENT '0、没有顶置1、顶置',
  `user_id` int(11) DEFAULT NULL COMMENT '发布者id',
  `state` int(1) unsigned DEFAULT '0' COMMENT '0、正常。1、删除',
  `area_id` int(11) DEFAULT NULL COMMENT '二级分区id',
  `create_time` date DEFAULT NULL,
  `type` int(1) unsigned DEFAULT NULL COMMENT '0、讨论交流。1、分享。2、求助',
  `see` int(1) unsigned DEFAULT '0' COMMENT '0、可见1、回复可见',
  `score` decimal(10,1) DEFAULT NULL COMMENT '当type=2的时候，这个是分享资料需要的积分，null为不需要',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `qq_group` varchar(20) DEFAULT NULL COMMENT 'qq	群',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子表';

#
# Data for table "post"
#


#
# Structure for table "floor"
#

DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `post_id` int(11) DEFAULT NULL COMMENT '帖子id',
  `content` text COMMENT '内容（富文本）',
  `num` varchar(255) DEFAULT NULL COMMENT '第几楼',
  `to_num` varchar(255) DEFAULT NULL COMMENT '回复第几楼，null为正常回复',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `floor_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='楼层表';

#
# Data for table "floor"
#


#
# Structure for table "report"
#

DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) DEFAULT NULL COMMENT '举报人的id',
  `to_id` int(11) DEFAULT NULL COMMENT '被举报人的id',
  `state` int(11) DEFAULT NULL COMMENT '0、未处理。1、已处理',
  `create_time` date DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL COMMENT '帖子id',
  `floor_id` int(11) DEFAULT NULL COMMENT '楼层id',
  `content` varchar(255) DEFAULT NULL COMMENT '举报原因',
  `reason` varchar(255) DEFAULT NULL COMMENT '怎么处理，如言论不当，回复删除，禁言1天',
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`),
  KEY `floor_id` (`floor_id`),
  CONSTRAINT `report_ibfk_2` FOREIGN KEY (`floor_id`) REFERENCES `floor` (`id`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='举报管理';

#
# Data for table "report"
#


#
# Structure for table "appeal"
#

DROP TABLE IF EXISTS `appeal`;
CREATE TABLE `appeal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL COMMENT '申述内容',
  `state` varchar(1) DEFAULT NULL COMMENT '0、未处理。1、已处理',
  `create_time` date DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL COMMENT '帖子id',
  `floor_id` int(11) DEFAULT NULL COMMENT '楼层id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  KEY `floor_id` (`floor_id`),
  CONSTRAINT `appeal_ibfk_2` FOREIGN KEY (`floor_id`) REFERENCES `floor` (`id`),
  CONSTRAINT `appeal_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申述表';

#
# Data for table "appeal"
#


#
# Structure for table "user_message"
#

DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`message_id`),
  KEY `fk_user_has_message_message1_idx` (`message_id`),
  KEY `fk_user_has_message_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_message_message1` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_message_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_message"
#


#
# Structure for table "user_role"
#

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_has_role_role1_idx` (`role_id`),
  KEY `fk_user_has_role_user_idx` (`user_id`),
  CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#


#
# Structure for table "user_shop"
#

DROP TABLE IF EXISTS `user_shop`;
CREATE TABLE `user_shop` (
  `user_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`shop_id`),
  KEY `fk_user_has_medal_user1_idx` (`user_id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `fk_user_has_medal_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_shop_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_shop"
#


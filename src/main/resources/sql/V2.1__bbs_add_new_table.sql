ALTER TABLE `post`
ADD COLUMN `file_url` VARCHAR(50) NOT NULL COMMENT '附件链接';


CREATE TABLE `user_file`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int(11) NOT NULL,
    `post_id` int(11) NOT NULL,
    `score` DECIMAL(10,1) ,
    `create_time` DATETIME ,
    primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子附件用户关联表';

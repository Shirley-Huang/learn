-- auto Generated on 2019-09-21
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user2`(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户姓名',
	`password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '密码',
	mobile VARCHAR (50) NOT NULL DEFAULT '' COMMENT '手机号',
	age INT (11) NOT NULL DEFAULT -1 COMMENT '年龄',
	sex VARCHAR (50) NOT NULL DEFAULT '' COMMENT '性别',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user2';



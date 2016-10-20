/*
Navicat MySQL Data Transfer

Source Server         : mysql_local
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : dooriya

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-04-15 16:54:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `depart`
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `departId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(30) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `leaf` int(11) DEFAULT NULL,
  `isActive` bit(1) DEFAULT b'1' COMMENT '是否禁用，0禁用1启用',
  `modifyUsername` varchar(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='\r\n部门表，有父子级别、是否为子节点标示（leaf）';

-- ----------------------------
-- Records of depart
-- ----------------------------

-- ----------------------------
-- Table structure for `logger`
-- ----------------------------
DROP TABLE IF EXISTS `logger`;
CREATE TABLE `logger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `class` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `func` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `contents` varchar(8000) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of logger
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(200) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  `seq` int(11) NOT NULL,
  `linkUrl` varchar(100) DEFAULT NULL,
  `isActive` int(3) NOT NULL DEFAULT '1' COMMENT '0禁用1启用',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `reslevel` int(3) NOT NULL COMMENT '当前节点的父节点level',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=gb2312 COMMENT='菜单，包含父子级别与菜单连接';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '菜单列表', null, '1', null, '1', '2013-03-11 13:49:38', '1');
INSERT INTO `menu` VALUES ('10', '匠人管理', '1', '1', null, '1', '2014-12-26 08:54:29', '2');
INSERT INTO `menu` VALUES ('11', '匠人列表', '10', '1', 'userList.html', '1', '2014-12-26 08:55:31', '3');
INSERT INTO `menu` VALUES ('20', '会员管理', '1', '2', '', '1', '2015-10-29 16:18:32', '2');
INSERT INTO `menu` VALUES ('21', '会员列表', '20', '1', 'userPageList.html?orgType=0', '1', '2015-10-29 16:19:15', '3');
INSERT INTO `menu` VALUES ('90', '系统设置', '1', '20', null, '1', '2013-03-11 13:57:21', '2');
INSERT INTO `menu` VALUES ('92', '后台用户管理', '90', '2', 'userPageList.html?orgType=1', '1', '2013-03-11 13:57:51', '3');
INSERT INTO `menu` VALUES ('93', '角色权限管理', '90', '3', 'right/rolePageList.html', '1', '2013-03-11 13:57:53', '3');
INSERT INTO `menu` VALUES ('94', '角色1', '93', '2', '', '0', '2015-11-02 17:52:12', '4');
INSERT INTO `menu` VALUES ('97', '角色2', '93', '1', null, '0', '2015-11-02 17:52:39', '4');
INSERT INTO `menu` VALUES ('98', '菜单管理', '1', '3', '', '1', '2015-11-03 09:51:43', '2');
INSERT INTO `menu` VALUES ('99', '菜单列表', '98', '3', 'right/toMenuList.html', '1', '2015-11-03 09:57:07', '3');
INSERT INTO `menu` VALUES ('100', '菜单测试', '98', '2', 'right/toMenuListLeft.html', '1', '2015-11-03 13:25:23', '3');
INSERT INTO `menu` VALUES ('101', '一级子菜单测试', '10', '4', null, '1', '2015-11-03 16:16:06', '3');
INSERT INTO `menu` VALUES ('104', '会员列表子菜单', '21', '1', 'baidu.com', '0', '2015-11-12 19:50:10', '4');
INSERT INTO `menu` VALUES ('113', 'bbb', '99', '1', 'ddddb', '1', '2015-11-12 20:04:04', '4');
INSERT INTO `menu` VALUES ('168', 'wallet', '11', '2', 'userList.html', '0', '2015-11-16 10:02:35', '4');

-- ----------------------------
-- Table structure for `menurole`
-- ----------------------------
DROP TABLE IF EXISTS `menurole`;
CREATE TABLE `menurole` (
  `menuRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`menuRoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=541 DEFAULT CHARSET=gb2312 COMMENT='菜单角色表，用于连接角色与菜单';

-- ----------------------------
-- Records of menurole
-- ----------------------------
INSERT INTO `menurole` VALUES ('485', '2', '1', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('486', '2', '10', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('487', '2', '11', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('488', '2', '20', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('489', '2', '21', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('490', '2', '90', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('491', '2', '92', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('492', '2', '93', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('493', '2', '94', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('494', '2', '97', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('495', '2', '98', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('496', '2', '99', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('497', '2', '100', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('498', '2', '101', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('499', '2', '104', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('500', '2', '113', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('501', '2', '168', '2015-11-17 13:55:54');
INSERT INTO `menurole` VALUES ('521', '4', '1', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('522', '4', '98', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('523', '4', '100', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('524', '4', '99', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('525', '4', '113', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('526', '4', '90', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('527', '4', '93', '2015-11-17 14:44:19');
INSERT INTO `menurole` VALUES ('533', '3', '1', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('534', '3', '10', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('535', '3', '11', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('536', '3', '98', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('537', '3', '99', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('538', '3', '113', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('539', '3', '90', '2015-11-17 14:50:18');
INSERT INTO `menurole` VALUES ('540', '3', '92', '2015-11-17 14:50:18');

-- ----------------------------
-- Table structure for `param`
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paramName` varchar(30) DEFAULT NULL,
  `paramCode` varchar(30) DEFAULT NULL,
  `paramValue` varchar(50) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifyTime` timestamp NULL DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  `modifyUserName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param
-- ----------------------------
INSERT INTO `param` VALUES ('1', '', '', '', '', '2015-11-11 18:50:52', null, '1', '');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) NOT NULL,
  `remark` varchar(20) DEFAULT NULL,
  `modifyUsername` varchar(20) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '0禁用1启用',
  `modifyTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312 COMMENT='角色表是一个角色\r\n比如管理员、审核员==';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', 'admin', 'guanliyuan', '', '2015-10-30 10:33:56', '0', '2015-10-30 10:33:56');
INSERT INTO `role` VALUES ('3', '普通用户', '', null, '0000-00-00 00:00:00', '0', '2015-11-17 11:41:27');
INSERT INTO `role` VALUES ('4', '菜单管理员', '', null, '0000-00-00 00:00:00', '0', '2015-11-17 14:42:57');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('63', '杨海洋1ddddd2', '0');
INSERT INTO `test` VALUES ('64', 'haiyang', '0');
INSERT INTO `test` VALUES ('65', '这是临时测试', '0');
INSERT INTO `test` VALUES ('66', '这是临时测试', '0');
INSERT INTO `test` VALUES ('67', '这是临时测试', '0');
INSERT INTO `test` VALUES ('70', '这是临时测试1', '0');
INSERT INTO `test` VALUES ('71', '', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(15) NOT NULL DEFAULT '' COMMENT '用户名',
  `passWord` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `nickName` varchar(15) NOT NULL DEFAULT '' COMMENT '昵称',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `status` int(1) DEFAULT '0' COMMENT '用户状态0正常1禁用',
  `phone` varchar(15) DEFAULT '' COMMENT '联系电话',
  `sex` int(1) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `realName` varchar(15) DEFAULT '' COMMENT '真实姓名',
  `type` int(1) DEFAULT '0' COMMENT '0普通账户1后台管理员账户',
  `imagePath` varchar(100) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('59', 'dooriya', '123456', 'bbbbb', '2015-11-26 19:29:13', '0', '', null, '2015-10-26 21:23:44', '', '0', null);

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `userRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userRoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312 COMMENT='user_role表是用户角色表\r\n用来连接用户与角色的表';

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '25', '2', '2015-11-09 18:52:53');
INSERT INTO `userrole` VALUES ('4', '56', '3', '2015-11-17 14:50:33');

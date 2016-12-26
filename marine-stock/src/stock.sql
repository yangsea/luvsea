/*
Navicat MySQL Data Transfer

Source Server         : $local_link
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-24 20:18:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stock_income_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_income_detail`;
CREATE TABLE `t_stock_income_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money` float DEFAULT NULL,
  `note_number` bigint(20) NOT NULL COMMENT '笔记编号',
  `pay_user` bigint(20) DEFAULT NULL COMMENT '支付人',
  `paid_user` bigint(20) DEFAULT NULL COMMENT '被支付人',
  `pay_type` smallint(6) DEFAULT NULL COMMENT '支付类型 （1付款，2退款，3分账，4提成）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='收入明细';

-- ----------------------------
-- Records of t_stock_income_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_integral`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_integral`;
CREATE TABLE `t_stock_integral` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(40) NOT NULL COMMENT '微信id',
  `reg_number` varchar(40) DEFAULT NULL COMMENT '积分规则编号',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='积分信息';

-- ----------------------------
-- Records of t_stock_integral
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_integral_reg`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_integral_reg`;
CREATE TABLE `t_stock_integral_reg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(40) DEFAULT NULL COMMENT '规则编号',
  `name` varchar(100) DEFAULT NULL COMMENT '规则名称',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='积分规则';

-- ----------------------------
-- Records of t_stock_integral_reg
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_note`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_note`;
CREATE TABLE `t_stock_note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(40) NOT NULL,
  `title` varchar(100) NOT NULL COMMENT '笔记标题',
  `stock_code` varchar(10) NOT NULL COMMENT '股票代码',
  `invest_type` char(10) NOT NULL COMMENT '(投资类型,1短，2中，3长 线)',
  `invest_term` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '投资期限',
  `income_rate_arg` float DEFAULT NULL COMMENT '平均收益率',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `priced` float DEFAULT NULL COMMENT '定义',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='笔记信息';

-- ----------------------------
-- Records of t_stock_note
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_note_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_note_type`;
CREATE TABLE `t_stock_note_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `number` varchar(40) DEFAULT NULL COMMENT '笔记编号',
  `day` smallint(6) DEFAULT NULL COMMENT '笔记天数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='笔记类型';

-- ----------------------------
-- Records of t_stock_note_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_priced_reg`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_priced_reg`;
CREATE TABLE `t_stock_priced_reg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `integral_start` int(11) DEFAULT NULL COMMENT '起始积分',
  `integral_end` int(11) DEFAULT NULL COMMENT '结束积分',
  `money` float DEFAULT NULL COMMENT '定价金额',
  `ratio_earn` float DEFAULT NULL COMMENT '抽成比例',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='定价规则';

-- ----------------------------
-- Records of t_stock_priced_reg
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_spread_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_spread_detail`;
CREATE TABLE `t_stock_spread_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spread_user` bigint(20) NOT NULL COMMENT '推广人（会员身份）',
  `spreaded_user` bigint(20) NOT NULL COMMENT '被推广人',
  `source_url` varchar(200) DEFAULT NULL COMMENT '推广来源网络连接地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='推广明细';

-- ----------------------------
-- Records of t_stock_spread_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_spread_text`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_spread_text`;
CREATE TABLE `t_stock_spread_text` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) NOT NULL COMMENT '微信id',
  `text` varchar(50) DEFAULT NULL COMMENT '推广用语',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='推广用语';

-- ----------------------------
-- Records of t_stock_spread_text
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stock_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_user`;
CREATE TABLE `t_stock_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(40) NOT NULL COMMENT '微信id',
  `name` varchar(20) NOT NULL COMMENT '会员姓名',
  `nick_name` varchar(20) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `invalid` bit(1) NOT NULL DEFAULT b'0',
  `type` smallint(6) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='会员信息';

-- ----------------------------
-- Records of t_stock_user
-- ----------------------------

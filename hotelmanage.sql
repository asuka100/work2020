/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : hotelmanage

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-10-23 11:48:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `card_id` varchar(18) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_position_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `card_id` varchar(18) NOT NULL,
  `password` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `employee_postion` (`employee_position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '1', null, null, null, null, '440', '123456');
INSERT INTO `employee` VALUES ('2', '2', null, null, null, null, '555', '123456');
INSERT INTO `employee` VALUES ('3', '3', null, null, null, null, '66', '333333');
INSERT INTO `employee` VALUES ('4', '4', null, null, null, null, '44', '444444');
INSERT INTO `employee` VALUES ('5', '2', null, null, null, null, '222', '222222');

-- ----------------------------
-- Table structure for employee_position
-- ----------------------------
DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position` (
  `employee_position_id` int(11) NOT NULL AUTO_INCREMENT,
  `position_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_position
-- ----------------------------
INSERT INTO `employee_position` VALUES ('1', '经理');
INSERT INTO `employee_position` VALUES ('2', '前台人员');
INSERT INTO `employee_position` VALUES ('3', '维修人员');
INSERT INTO `employee_position` VALUES ('4', '保洁人员');

-- ----------------------------
-- Table structure for maintain_list
-- ----------------------------
DROP TABLE IF EXISTS `maintain_list`;
CREATE TABLE `maintain_list` (
  `maintain_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `employee_id_list` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maintain_id`),
  KEY `maintain_room_fk` (`room_id`),
  CONSTRAINT `maintain_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maintain_list
-- ----------------------------

-- ----------------------------
-- Table structure for menuitem
-- ----------------------------
DROP TABLE IF EXISTS `menuitem`;
CREATE TABLE `menuitem` (
  `id` int(11) NOT NULL,
  `position_id` int(11) DEFAULT NULL,
  `menuitem` varchar(64) DEFAULT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `urlLink` varchar(255) DEFAULT NULL,
  `success` varchar(255) DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menuitem
-- ----------------------------
INSERT INTO `menuitem` VALUES ('1', '1', '新增房间', '房间管理', null, null, null);
INSERT INTO `menuitem` VALUES ('2', '1', '房间列表', '房间管理', null, null, null);
INSERT INTO `menuitem` VALUES ('3', '1', '新增房间类型', '房间管理', null, null, null);
INSERT INTO `menuitem` VALUES ('4', '1', '房间类型列表', '房间管理', null, null, null);
INSERT INTO `menuitem` VALUES ('5', '1', '新增员工', '员工管理', null, null, null);
INSERT INTO `menuitem` VALUES ('6', '1', '员工列表', '员工管理', null, null, null);
INSERT INTO `menuitem` VALUES ('7', '1', '新增客户', '客户管理', null, null, null);
INSERT INTO `menuitem` VALUES ('8', '1', '客户列表', '客户管理', null, null, null);
INSERT INTO `menuitem` VALUES ('9', '1', '房态修改', '房态管理', null, null, null);
INSERT INTO `menuitem` VALUES ('10', '1', '房态查询', '房态管理', null, null, null);
INSERT INTO `menuitem` VALUES ('11', '1', '新增维修项目', '维修管理', null, null, null);
INSERT INTO `menuitem` VALUES ('12', '1', '房间维修查询', '维修管理', null, null, null);
INSERT INTO `menuitem` VALUES ('13', '1', '房间列表', '维修管理', null, null, null);
INSERT INTO `menuitem` VALUES ('14', '1', '预定房间', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('15', '1', '入住', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('16', '1', '退房结账', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('17', '1', '订单查询', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('18', '1', '财务报表', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('19', '2', '房间列表', '房间管理', null, null, null);
INSERT INTO `menuitem` VALUES ('20', '2', '新增客户', '客户管理', null, null, null);
INSERT INTO `menuitem` VALUES ('21', '2', '客户列表', '客户管理', null, null, null);
INSERT INTO `menuitem` VALUES ('22', '2', '新增维修项目', '维修管理', null, null, null);
INSERT INTO `menuitem` VALUES ('23', '2', '房间维修查询', '维修管理', null, null, null);
INSERT INTO `menuitem` VALUES ('24', '2', '预定房间', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('25', '2', '入住', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('26', '2', '退房结账', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('27', '2', '订单查询', '订单管理', null, null, null);
INSERT INTO `menuitem` VALUES ('28', '3', '房间维修查询', '维修管理', null, null, null);
INSERT INTO `menuitem` VALUES ('29', '4', '房间维修查询', '维修管理', null, null, null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `create_employee_id` int(11) NOT NULL,
  `check_employee_id` int(11) DEFAULT NULL,
  `pay_employee_id` int(11) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `total_price` double DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_client_fk` (`client_id`),
  KEY `order_create_fk` (`create_employee_id`),
  KEY `order_check_fk` (`check_employee_id`),
  KEY `order_pay_fk` (`pay_employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `price` double DEFAULT NULL,
  KEY `order_detail_room_fk` (`room_id`),
  KEY `order_detail_order_fk` (`order_id`),
  CONSTRAINT `order_detail_order_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `order_detail_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for position_menuitem
-- ----------------------------
DROP TABLE IF EXISTS `position_menuitem`;
CREATE TABLE `position_menuitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) DEFAULT NULL,
  `menuitem_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position_menuitem
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_status_id` int(11) NOT NULL,
  `room_type_id` int(11) NOT NULL,
  `price` double DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `room_status_id` (`room_status_id`),
  CONSTRAINT `room_status_id` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`room_status_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for room_status
-- ----------------------------
DROP TABLE IF EXISTS `room_status`;
CREATE TABLE `room_status` (
  `room_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`room_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_status
-- ----------------------------
INSERT INTO `room_status` VALUES ('1', 'df');
INSERT INTO `room_status` VALUES ('2', 'df');
INSERT INTO `room_status` VALUES ('3', 'fds');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `room_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`room_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------

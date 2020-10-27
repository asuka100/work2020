/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : hotelmanage

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-10-28 03:58:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `card_id` varchar(18) NOT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('16', '元圣杰', '女', '13636586895', '513221197102183838');
INSERT INTO `client` VALUES ('17', '孙尚香', '女', '12345678910', '440782200001011234');
INSERT INTO `client` VALUES ('18', '诸葛亮', '男', '12345678911', '632223197605233250');
INSERT INTO `client` VALUES ('19', '何炅', '男', '12345678910', '440782201001011234');
INSERT INTO `client` VALUES ('20', '曹操', '男', '13245678912', '440782199501011234');
INSERT INTO `client` VALUES ('21', '雷军', '男', '12345678910', '440785199001011234');
INSERT INTO `client` VALUES ('22', '周生生', '男', '12345678910', '440782199901011234');

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
  PRIMARY KEY (`employee_id`) USING BTREE,
  KEY `employee_postion` (`employee_position_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '1', '至高经理', '男', '30', '13630464646', '440782199001011234', '123456');
INSERT INTO `employee` VALUES ('15', '1', '赵信', '男', '21', '13635363236', '440782199901014561', '111111');
INSERT INTO `employee` VALUES ('16', '3', '李白', '男', '34', '13545123524', '610523198305134774', '222222');
INSERT INTO `employee` VALUES ('17', '4', '郑靖琪', '女', '46', '12345678910', '230111197104266110', '123456');
INSERT INTO `employee` VALUES ('18', '2', '齐怡悦', '男', '31', '12345678910', '510422198603243893', '987654');
INSERT INTO `employee` VALUES ('19', '4', '顾晟睿', '男', '42', '12345678910', '140825197508173636', '123456');
INSERT INTO `employee` VALUES ('20', '3', '俞开霁', '男', '29', '12345679810', '141032198805257380', '123456');
INSERT INTO `employee` VALUES ('21', '3', '钱歌阑', '男', '28', '12345678910', '150900198904133964', '123456');
INSERT INTO `employee` VALUES ('22', '2', '酆芳馨', '男', '38', '12345678910', '370725197904172667', '123456');
INSERT INTO `employee` VALUES ('23', '2', '周瑜', '女', '32', '12345678910', '610122198502268749', '123456');
INSERT INTO `employee` VALUES ('24', '1', '武则天', '女', '20', '12345678911', '123456781234567891', '123456');
INSERT INTO `employee` VALUES ('25', '4', '诸葛孔明', '女', '31', '12345678910', '36100119860426330X', '456456');

-- ----------------------------
-- Table structure for employee_position
-- ----------------------------
DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position` (
  `employee_position_id` int(11) NOT NULL AUTO_INCREMENT,
  `position_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_position_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `employee_id_list` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maintain_id`) USING BTREE,
  KEY `maintain_room_fk` (`room_id`) USING BTREE,
  CONSTRAINT `maintain_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of maintain_list
-- ----------------------------
INSERT INTO `maintain_list` VALUES ('13', '202', '25', '保洁', '3');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of menuitem
-- ----------------------------
INSERT INTO `menuitem` VALUES ('1', '1', '新增房间', '房间管理', '/room/viewAddRoom', null, null);
INSERT INTO `menuitem` VALUES ('2', '1', '房间列表', '房间管理', '/room/viewRoomList', null, null);
INSERT INTO `menuitem` VALUES ('3', '1', '新增房间类型', '房间管理', '/roomType/viewAddRoomType', null, null);
INSERT INTO `menuitem` VALUES ('4', '1', '房间类型列表', '房间管理', '/roomType/viewRoomTypeList', null, null);
INSERT INTO `menuitem` VALUES ('5', '1', '新增员工', '员工管理', '/employee/viewAddEmployee', null, null);
INSERT INTO `menuitem` VALUES ('6', '1', '员工列表', '员工管理', '/employee/viewEmployeeList', null, null);
INSERT INTO `menuitem` VALUES ('7', '1', '新增客户', '客户管理', '/client/viewAddClient', null, null);
INSERT INTO `menuitem` VALUES ('8', '1', '客户列表', '客户管理', '/client/viewClientList', null, null);
INSERT INTO `menuitem` VALUES ('10', '1', '房态查询', '房态管理', '/room/viewRoomStatus', null, null);
INSERT INTO `menuitem` VALUES ('11', '1', '新增维修项目', '维修管理', '/maintainlist/viewAddMaintain', null, null);
INSERT INTO `menuitem` VALUES ('12', '1', '房间维修查询', '维修管理', '/maintainlist/viewMaintainList', null, null);
INSERT INTO `menuitem` VALUES ('14', '1', '预定房间', '订单管理', '/order/createOrderJsp', null, null);
INSERT INTO `menuitem` VALUES ('15', '1', '办理入住', '订单管理', '/order/liveIn', null, null);
INSERT INTO `menuitem` VALUES ('16', '1', '退房结账', '订单管理', '/order/payOrder', null, null);
INSERT INTO `menuitem` VALUES ('17', '1', '订单查询', '订单管理', '/order/orderList', null, null);
INSERT INTO `menuitem` VALUES ('19', '2', '房间列表', '房间管理', '/room/viewRoomList', null, null);
INSERT INTO `menuitem` VALUES ('20', '2', '新增客户', '客户管理', '/client/viewAddClient', null, null);
INSERT INTO `menuitem` VALUES ('21', '2', '客户列表', '客户管理', '/client/viewClientList', null, null);
INSERT INTO `menuitem` VALUES ('22', '2', '新增维修项目', '维修管理', '/maintainlist/viewAddMaintain', null, null);
INSERT INTO `menuitem` VALUES ('23', '2', '房间维修查询', '维修管理', '/maintainlist/viewMaintainList', null, null);
INSERT INTO `menuitem` VALUES ('24', '2', '预定房间', '订单管理', '/order/createOrderJsp', null, null);
INSERT INTO `menuitem` VALUES ('25', '2', '办理入住', '订单管理', '/order/liveIn', null, null);
INSERT INTO `menuitem` VALUES ('26', '2', '退房结账', '订单管理', '/order/payOrder', null, null);
INSERT INTO `menuitem` VALUES ('27', '2', '订单查询', '订单管理', '/order/orderList', null, null);
INSERT INTO `menuitem` VALUES ('28', '3', '房间维修查询', '维修管理', '/maintainlist/viewMaintainList', null, null);
INSERT INTO `menuitem` VALUES ('29', '4', '房间维修查询', '维修管理', '/maintainlist/viewMaintainList', null, null);
INSERT INTO `menuitem` VALUES ('30', '2', '房态查询', '房态管理', '/room/viewRoomStatus', null, null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `create_employee_id` int(11) NOT NULL,
  `check_employee_id` int(11) DEFAULT NULL,
  `pay_employee_id` int(11) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `total_price` double DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `order_client_fk` (`client_id`) USING BTREE,
  KEY `order_create_fk` (`create_employee_id`) USING BTREE,
  KEY `order_check_fk` (`check_employee_id`) USING BTREE,
  KEY `order_pay_fk` (`pay_employee_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('39', '17', '18', '18', null, '入住', '99', '2020-10-28 03:52:45');
INSERT INTO `orders` VALUES ('40', '20', '18', '18', null, '入住', '10000', '2020-10-28 03:52:22');
INSERT INTO `orders` VALUES ('41', '21', '18', '23', null, '入住', '99', '2020-10-28 03:56:08');
INSERT INTO `orders` VALUES ('42', '22', '23', null, null, '创建', '138', '2020-10-28 03:55:47');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `order_detail_room_fk` (`room_id`) USING BTREE,
  KEY `order_detail_order_fk` (`order_id`) USING BTREE,
  CONSTRAINT `order_detail_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('15', '39', '101', '99');
INSERT INTO `order_detail` VALUES ('16', '40', '303', '10000');
INSERT INTO `order_detail` VALUES ('17', '41', '201', '99');
INSERT INTO `order_detail` VALUES ('18', '42', '106', '138');

-- ----------------------------
-- Table structure for position_menuitem
-- ----------------------------
DROP TABLE IF EXISTS `position_menuitem`;
CREATE TABLE `position_menuitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) DEFAULT NULL,
  `menuitem_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

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
  `descriptions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE,
  KEY `room_status_id` (`room_status_id`) USING BTREE,
  KEY `room_type_id` (`room_type_id`) USING BTREE,
  CONSTRAINT `room_status_id` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`room_status_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `room_type_id` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('101', '4', '1', '无1');
INSERT INTO `room` VALUES ('102', '1', '1', '无2');
INSERT INTO `room` VALUES ('103', '1', '1', '无');
INSERT INTO `room` VALUES ('105', '1', '2', '双人房');
INSERT INTO `room` VALUES ('106', '5', '2', '双人房');
INSERT INTO `room` VALUES ('201', '4', '1', '无');
INSERT INTO `room` VALUES ('202', '3', '2', '无');
INSERT INTO `room` VALUES ('203', '1', '1', '无');
INSERT INTO `room` VALUES ('205', '1', '4', '高级双人房');
INSERT INTO `room` VALUES ('206', '1', '4', '高级双人房');
INSERT INTO `room` VALUES ('301', '1', '4', '高级双人房');
INSERT INTO `room` VALUES ('302', '1', '4', '高级双人房');
INSERT INTO `room` VALUES ('303', '4', '5', '唯一总统套房');

-- ----------------------------
-- Table structure for room_status
-- ----------------------------
DROP TABLE IF EXISTS `room_status`;
CREATE TABLE `room_status` (
  `room_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(50) DEFAULT NULL,
  `descriptions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_status_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of room_status
-- ----------------------------
INSERT INTO `room_status` VALUES ('1', '空闲', '已完成保洁工作，能够正常出租');
INSERT INTO `room_status` VALUES ('2', '维修', '房间设备故障，需要维修，暂时不能出租');
INSERT INTO `room_status` VALUES ('3', '未清扫', '顾客刚结账退房，未完成保洁工作');
INSERT INTO `room_status` VALUES ('4', '入住中', '入住中');
INSERT INTO `room_status` VALUES ('5', '已预定', '已预订');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `room_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `descriptions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('1', '普通单人房', '99', '单人房吧');
INSERT INTO `room_type` VALUES ('2', '普通双人房', '138', '双人房');
INSERT INTO `room_type` VALUES ('4', '高级双人房', '298', '高双');
INSERT INTO `room_type` VALUES ('5', '总统套房', '10000', '总统套房体验');

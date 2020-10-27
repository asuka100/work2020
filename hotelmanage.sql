/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : hotelmanage

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 27/10/2020 12:26:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (1, '何鑫', '男', '123153', '81238');
INSERT INTO `client` VALUES (2, '何鑫2', '男', '23455123', '1238456845384');
INSERT INTO `client` VALUES (3, '何鑫3', '女', '278245355', '5434532348684');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_position_id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE,
  INDEX `employee_postion`(`employee_position_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 1, 'saddda', '男', '18', '12345678912', '440', 123456);
INSERT INTO `employee` VALUES (2, 1, 'ge4', '男', '188', '12345678924', '555', 1234567);
INSERT INTO `employee` VALUES (3, 3, 'fe', '男', '18', '12345678912', '66', 333333);
INSERT INTO `employee` VALUES (4, 4, 'dvc', '男', '18', '12345678912', '44', 444444);
INSERT INTO `employee` VALUES (6, 2, 'fff', '男', '18', '12345678912', '21335464354', 123456);
INSERT INTO `employee` VALUES (7, 2, '何鑫', '男', '21', '11111111111', '440555555555555555', 123456);
INSERT INTO `employee` VALUES (9, 3, '何三', '男', '15', '12345678954', '445612345645648978', 123456);
INSERT INTO `employee` VALUES (10, 2, '何四', '女', '18', '12345684563', '4561238456', 123456);
INSERT INTO `employee` VALUES (11, 4, '何五', '女', '85', '12348915', '1234568231', 123456);
INSERT INTO `employee` VALUES (13, 1, 'dfed', '女', '55', '38353', '3252452', 123456);
INSERT INTO `employee` VALUES (14, 2, '2542', '男', '15', '5434', '3533', 123456);

-- ----------------------------
-- Table structure for employee_position
-- ----------------------------
DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position`  (
  `employee_position_id` int(11) NOT NULL AUTO_INCREMENT,
  `position_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`employee_position_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_position
-- ----------------------------
INSERT INTO `employee_position` VALUES (1, '经理');
INSERT INTO `employee_position` VALUES (2, '前台人员');
INSERT INTO `employee_position` VALUES (3, '维修人员');
INSERT INTO `employee_position` VALUES (4, '保洁人员');

-- ----------------------------
-- Table structure for maintain_list
-- ----------------------------
DROP TABLE IF EXISTS `maintain_list`;
CREATE TABLE `maintain_list`  (
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `employee_id_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`maintain_id`) USING BTREE,
  INDEX `maintain_room_fk`(`room_id`) USING BTREE,
  CONSTRAINT `maintain_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of maintain_list
-- ----------------------------
INSERT INTO `maintain_list` VALUES (5, 201, '4', 'gsdvsd', '3');
INSERT INTO `maintain_list` VALUES (6, 202, '3', 'dfsdf', '2');

-- ----------------------------
-- Table structure for menuitem
-- ----------------------------
DROP TABLE IF EXISTS `menuitem`;
CREATE TABLE `menuitem`  (
  `id` int(11) NOT NULL,
  `position_id` int(11) NULL DEFAULT NULL,
  `menuitem` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `urlLink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `success` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descript` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menuitem
-- ----------------------------
INSERT INTO `menuitem` VALUES (1, 1, '新增房间', '房间管理', '/room/viewAddRoom', NULL, NULL);
INSERT INTO `menuitem` VALUES (2, 1, '房间列表', '房间管理', '/room/viewRoomList', NULL, NULL);
INSERT INTO `menuitem` VALUES (3, 1, '新增房间类型', '房间管理', '/roomType/viewAddRoomType', NULL, NULL);
INSERT INTO `menuitem` VALUES (4, 1, '房间类型列表', '房间管理', '/roomType/viewRoomTypeList', NULL, NULL);
INSERT INTO `menuitem` VALUES (5, 1, '新增员工', '员工管理', '/employee/viewAddEmployee', NULL, NULL);
INSERT INTO `menuitem` VALUES (6, 1, '员工列表', '员工管理', '/employee/viewEmployeeList', NULL, NULL);
INSERT INTO `menuitem` VALUES (7, 1, '新增客户', '客户管理', '/client/viewAddClient', NULL, NULL);
INSERT INTO `menuitem` VALUES (8, 1, '客户列表', '客户管理', '/client/viewClientList', NULL, NULL);
INSERT INTO `menuitem` VALUES (9, 1, '房态修改', '房态管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (10, 1, '房态查询', '房态管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (11, 1, '新增维修项目', '维修管理', '/maintainlist/viewAddMaintain', NULL, NULL);
INSERT INTO `menuitem` VALUES (12, 1, '房间维修查询', '维修管理', '/maintainlist/viewMaintainList', NULL, NULL);
INSERT INTO `menuitem` VALUES (14, 1, '预定房间', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (15, 1, '入住', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (16, 1, '退房结账', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (17, 1, '订单查询', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (18, 1, '财务报表', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (19, 2, '房间列表', '房间管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (20, 2, '新增客户', '客户管理', '/client/viewAddClient', NULL, NULL);
INSERT INTO `menuitem` VALUES (21, 2, '客户列表', '客户管理', '/client/viewClientList', NULL, NULL);
INSERT INTO `menuitem` VALUES (22, 2, '新增维修项目', '维修管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (23, 2, '房间维修查询', '维修管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (24, 2, '预定房间', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (25, 2, '入住', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (26, 2, '退房结账', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (27, 2, '订单查询', '订单管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (28, 3, '房间维修查询', '维修管理', NULL, NULL, NULL);
INSERT INTO `menuitem` VALUES (29, 4, '房间维修查询', '维修管理', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `create_employee_id` int(11) NOT NULL,
  `check_employee_id` int(11) NULL DEFAULT NULL,
  `pay_employee_id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total_price` double NULL DEFAULT NULL,
  `date` datetime(0) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `order_client_fk`(`client_id`) USING BTREE,
  INDEX `order_create_fk`(`create_employee_id`) USING BTREE,
  INDEX `order_check_fk`(`check_employee_id`) USING BTREE,
  INDEX `order_pay_fk`(`pay_employee_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `order_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `price` double NULL DEFAULT NULL,
  INDEX `order_detail_room_fk`(`room_id`) USING BTREE,
  INDEX `order_detail_order_fk`(`order_id`) USING BTREE,
  CONSTRAINT `order_detail_order_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detail_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for position_menuitem
-- ----------------------------
DROP TABLE IF EXISTS `position_menuitem`;
CREATE TABLE `position_menuitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) NULL DEFAULT NULL,
  `menuitem_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int(11) NOT NULL,
  `room_status_id` int(11) NOT NULL,
  `room_type_id` int(11) NOT NULL,
  `descriptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE,
  INDEX `room_status_id`(`room_status_id`) USING BTREE,
  INDEX `room_type_id`(`room_type_id`) USING BTREE,
  CONSTRAINT `room_status_id` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`room_status_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `room_type_id` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (201, 3, 2, '201双');
INSERT INTO `room` VALUES (202, 2, 2, 'hhh');
INSERT INTO `room` VALUES (203, 1, 4, '5338');
INSERT INTO `room` VALUES (204, 1, 4, '204高双');
INSERT INTO `room` VALUES (205, 1, 2, '28');
INSERT INTO `room` VALUES (206, 1, 1, '6438');
INSERT INTO `room` VALUES (207, 1, 1, '5254');
INSERT INTO `room` VALUES (210, 1, 1, '563');

-- ----------------------------
-- Table structure for room_status
-- ----------------------------
DROP TABLE IF EXISTS `room_status`;
CREATE TABLE `room_status`  (
  `room_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descriptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_status
-- ----------------------------
INSERT INTO `room_status` VALUES (1, '空闲', '已完成保洁工作，能够正常出租');
INSERT INTO `room_status` VALUES (2, '维修', '房间设备故障，需要维修，暂时不能出租');
INSERT INTO `room_status` VALUES (3, '未清扫', '顾客刚结账退房，未完成保洁工作');
INSERT INTO `room_status` VALUES (4, '入住中', '入住中');

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `room_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `descriptions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES (1, '普通单人房', 99, '单人房吧');
INSERT INTO `room_type` VALUES (2, '普通双人房', 138, '双人房');
INSERT INTO `room_type` VALUES (4, '高级双人房', 298, '高双');

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : hotelmanage

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-10-26 13:03:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `room_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `descriptions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('1', '单人房', '200', null);

/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : hotelmanage

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-10-26 13:04:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_status_id` int(11) NOT NULL,
  `room_type_id` int(11) NOT NULL,
  `descriptions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `room_status_id` (`room_status_id`),
  KEY `room_type_id` (`room_type_id`),
  CONSTRAINT `room_status_id` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`room_status_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `room_type_id` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('101', '1', '1', null);

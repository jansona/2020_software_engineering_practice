/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : material_distribution

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/04/2020 17:33:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `application_id` int(11) NOT NULL AUTO_INCREMENT,
  `application_community` int(11) NOT NULL,
  `application_user` int(11) NOT NULL,
  `application_isPass` tinyint(4) NULL DEFAULT -1,
  `application_time` datetime(0) NOT NULL,
  PRIMARY KEY (`application_id`) USING BTREE,
  INDEX `application_user_id_idx`(`application_user`) USING BTREE,
  INDEX `application_community_id_idx`(`application_community`) USING BTREE,
  CONSTRAINT `application_community_id` FOREIGN KEY (`application_community`) REFERENCES `community` (`community_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `application_user_id` FOREIGN KEY (`application_user`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for arrangement
-- ----------------------------
DROP TABLE IF EXISTS `arrangement`;
CREATE TABLE `arrangement`  (
  `arrangement_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrangement_time` datetime(0) NOT NULL,
  `arrangement_package` int(11) NOT NULL,
  `arrangement_location` int(11) NOT NULL,
  PRIMARY KEY (`arrangement_id`) USING BTREE,
  INDEX `arrangement_package_id_idx`(`arrangement_package`) USING BTREE,
  INDEX `arrangement_location_id_idx`(`arrangement_location`) USING BTREE,
  CONSTRAINT `arrangement_location_id` FOREIGN KEY (`arrangement_location`) REFERENCES `location` (`location_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `arrangement_package_id` FOREIGN KEY (`arrangement_package`) REFERENCES `package` (`package_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community`  (
  `community_id` int(11) NOT NULL AUTO_INCREMENT,
  `community_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `community_password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `community_address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `community_interval` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`community_id`) USING BTREE,
  INDEX `community_client_id_idx`(`community_password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '社区，小区' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for deal
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal`  (
  `deal_id` int(11) NOT NULL AUTO_INCREMENT,
  `deal_package` int(11) NOT NULL,
  `deal_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deal_isPass` tinyint(4) NULL DEFAULT -1,
  `deal_response` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deal_time` datetime(0) NOT NULL,
  `deal_type` tinyint(4) NOT NULL,
  PRIMARY KEY (`deal_id`) USING BTREE,
  INDEX `deal_package_id_idx`(`deal_package`) USING BTREE,
  CONSTRAINT `deal_package_id` FOREIGN KEY (`deal_package`) REFERENCES `package` (`package_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '申请特殊处理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`  (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `location_community` int(11) NOT NULL,
  PRIMARY KEY (`location_id`) USING BTREE,
  INDEX `loacation_community_id_idx`(`location_community`) USING BTREE,
  CONSTRAINT `loacation_community_id` FOREIGN KEY (`location_community`) REFERENCES `community` (`community_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '自提点' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for package
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package`  (
  `package_id` int(11) NOT NULL AUTO_INCREMENT,
  `package_user` int(11) NOT NULL,
  `package_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`package_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 301 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_favorite_starttime` time(0) NULL DEFAULT NULL,
  `user_time_stay` int(11) NULL DEFAULT NULL,
  `user_community` int(11) NULL DEFAULT NULL,
  `user_password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_idcard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_phone_UNIQUE`(`user_phone`) USING BTREE,
  UNIQUE INDEX `user_idcard_UNIQUE`(`user_idcard`) USING BTREE,
  INDEX `user_community_id_idx`(`user_community`) USING BTREE,
  CONSTRAINT `user_community_id` FOREIGN KEY (`user_community`) REFERENCES `community` (`community_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '居民用户' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

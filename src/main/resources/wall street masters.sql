/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : wall street masters

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 18/06/2020 09:52:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dNo` int(4) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `dCount` int(10) NULL DEFAULT NULL COMMENT '部门人数',
  PRIMARY KEY (`dNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '技术部', 30);
INSERT INTO `dept` VALUES (2, '财务部', 25);
INSERT INTO `dept` VALUES (3, '市场部', 52);
INSERT INTO `dept` VALUES (4, '公关部', 10);
INSERT INTO `dept` VALUES (5, '采购部', 33);
INSERT INTO `dept` VALUES (6, '后勤部', 20);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(32) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (4, '布朗', '男', '1998-03-03', 'buran@163.com', '市场部');
INSERT INTO `employee` VALUES (29, '马克', '女', '2019-12-27', '2018@stu.edu.cn', '公关部');
INSERT INTO `employee` VALUES (30, '凌华', '男', '1938-09-10', 'zerohua@163.com', '财务部');
INSERT INTO `employee` VALUES (32, '大傻', '男', '1938-07-06', 'binbin@163.com', '财务部');
INSERT INTO `employee` VALUES (33, '彭呆呆', '男', '1949-09-30', 'daidai@qq.com', '后勤部');
INSERT INTO `employee` VALUES (34, '脚fish', '男', '1998-09-23', 'fish@gmail.com', '技术部');
INSERT INTO `employee` VALUES (35, '弟妹李', '女', '1999-06-10', 'dimei@163.com', '公关部');
INSERT INTO `employee` VALUES (38, '常于琪', '女', '2003-03-03', 'binbinsister@qq.com', '财务部');
INSERT INTO `employee` VALUES (39, '斯蒂芬.库克', '男', '1998-09-23', 'Apple@apple.com', '市场部');
INSERT INTO `employee` VALUES (40, '乔布斯', '男', '1938-09-11', 'busi@gmail.com', '技术部');
INSERT INTO `employee` VALUES (41, '比尔盖茨', '男', '1965-06-22', 'software@outlook.com', '技术部');
INSERT INTO `employee` VALUES (42, '马小云', '男', '1965-11-02', 'jackma@alibaba.com', '技术部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'jack', 'edba8d56a3755fec36b16aa0a9b206505fdccc429d443f3ee84b0988f74ceac6', 'oJDJL/xsoGU+k9LWGJKevA==');
INSERT INTO `user` VALUES (2, 'tom', 'fd1a5500afe636c89116fe60e4c9e7b7d68483078e91adce5f44265ed5e67ac6', 'KxLMqlxbuEOSJtriFKfFwA==');
INSERT INTO `user` VALUES (3, 'Meria', '449d7eff6ad98ca29adb11c0f47955588a4478e06f6c567b3a1584afa9afb957', '8GPVc0uCUYw9p9Eri812wg==');
INSERT INTO `user` VALUES (4, 'hanna', 'ae53ad0dcc8c217d8363c7e9ac2518d0441a87edfbc4df94daa7baa64cba8783', '8Kwit+3PR8Kc1FA1U3fEnQ==');
INSERT INTO `user` VALUES (5, 'admin', '7bfeef823b5a1fabe23627c0dff19bf1615f08d4b51e75f48c8a0c22fd372229', 'veU1zXy0D7DIbtKSAkHFjg==');
INSERT INTO `user` VALUES (6, 'aa', 'd4c086ab0a70254d02deddf7011baf1d9cbd0c83956e2f2e14dc6c96a8bd6dbf', 'elh/OSlH7uil4Y94ShihxA==');
INSERT INTO `user` VALUES (7, 'Admin', '64ab07c9cf39fbf322b800e06fa0cf039aa15a7eaa5d99cb5c35da37dd2ec9de', '5+8g5wo1zq9hJfvT1+bdKw==');
INSERT INTO `user` VALUES (8, 'administrator', '7b886ada91f307ff9014169878f0053ea47e4c0859431e6c3e057575c6ded418', 'sIL+VUfKhZIwnbLV/LcQ3A==');
INSERT INTO `user` VALUES (9, '斌斌', 'bd8a19cca0a9d687a6ea5e2a40e26a663fd35241427d8e935bf9ffba7b8136ed', 'xkPFx6PgpA1PH+2fZma6Kw==');
INSERT INTO `user` VALUES (10, 'Jere', '3d6cd34d20d07b4b142913518a4000f5970b8c096306850e064b3ef1cf15e6bd', 'NRN2cK7qzo7c2jsuUrsRyw==');

SET FOREIGN_KEY_CHECKS = 1;

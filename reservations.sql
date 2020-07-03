/*
 Navicat Premium Data Transfer

 Source Server         : 49.235.43.59
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 49.235.43.59:3306
 Source Schema         : reservations

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 18/02/2020 12:03:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123', '1');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture` varchar(140) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `idcard`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES (1, '张司机', '610102188837442533', '陕aaa', '213412341', '隔壁老王，我喜欢你，就像风走了八万里，', '/picture/610102188837442533.jpg', '123456', '男');
INSERT INTO `coach` VALUES (35, '黎大行', '610102199904337533', '陕H4449', '15829634643', '暂无通知', 'http://49.235.43.59/p/d.jpg', '337533', '男');
INSERT INTO `coach` VALUES (36, '长大行', '610102199904337833', '陕H4449', '15829634643', '暂无通知', '/picture/610102199904337833.jpg', '337833', '女');
INSERT INTO `coach` VALUES (37, '王小崔', '610102144404337833', '陕H4449', '15829634643', '暂无通知', 'http://49.235.43.59/p/d.jpg', '337833', '女');
INSERT INTO `coach` VALUES (45, '张文', '610102199902443566', '陕247821823', '24214123', '暂无通知', '/picture/610102199902443566.jpg', '443566', '女');
INSERT INTO `coach` VALUES (46, '大四', 'dsafafafsdaf', 'dsafafafsdaf', '123456', '暂无通知', 'http://49.235.43.59/p/d.jpg', '', '女');

-- ----------------------------
-- Table structure for coach_1_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_1_reservationcount`;
CREATE TABLE `coach_1_reservationcount`  (
  `id` date NOT NULL,
  `status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time1` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time2` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time3` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time4` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time5` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time6` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time7` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time8` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time9` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time10` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time11` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time12` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time13` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time14` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time15` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time16` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time17` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time18` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time19` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time20` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_1_reservationcount
-- ----------------------------
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-04', '1', '1', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-05', '1', '3', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-06', '1', '0', '1', '2', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-07', '1', '2', '0', '0', '2', '3', '2', '1', '3', '3', '3', '3', '3', '3', '3', '2', '3', '3', '0', '2', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-08', '1', '1', '0', '0', '0', '2', '1', '0', '1', '3', '3', '2', '3', '3', '3', '1', '1', '0', '0', '0', '0');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-09', '1', '1', '0', '0', '0', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-10', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-11', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-12', '1', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-13', '1', '0', '3', '1', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-14', '1', '9', '9', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-15', '1', '9', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '0', '2', '9');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-16', '1', '9', '9', '3', '9', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '2', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-17', '1', '9', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-18', '1', '0', '9', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '9');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-19', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-20', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-21', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-22', '1', '9', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2019-11-24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-25', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-26', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-27', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-28', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-29', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-01-31', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-02-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-02-02', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_1_reservationcount` VALUES ('2020-02-03', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for coach_1_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_1_reservationdetail`;
CREATE TABLE `coach_1_reservationdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 164 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_1_reservationdetail
-- ----------------------------
INSERT INTO `coach_1_reservationdetail` VALUES (40, 'time2', 0, '610102198749228577', '2019-11-05 14:01:26', '2019-11-03', '张安排');
INSERT INTO `coach_1_reservationdetail` VALUES (41, 'time2', 0, '610102198749228577', '2019-11-06 09:21:27', '2019-11-04', '张安排');
INSERT INTO `coach_1_reservationdetail` VALUES (42, 'time2', 1, '610102198749228577', '2019-11-06 09:40:35', '2019-11-05', '张安排');
INSERT INTO `coach_1_reservationdetail` VALUES (51, 'time4', 1, '610102199903554233', '2019-11-06 20:15:49', '2019-11-06', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (117, 'time7', 1, '610102199903554233', '2019-11-07 18:39:37', '2019-11-07', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (123, 'time1', 1, '610102199903554233', '2019-11-08 13:40:13', '2019-11-08', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (129, 'time3', 1, '610102198749228577', '2019-11-13 09:15:13', '2019-11-13', '张安排');
INSERT INTO `coach_1_reservationdetail` VALUES (130, 'time3', 1, '610102199903554233', '2019-11-13 09:18:51', '2019-11-13', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (131, 'time3', 1, '610102199903554233', '2019-11-13 09:21:42', '2019-11-14', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (132, 'time1', 1, '610102399948557244', '2019-11-13 11:04:36', '2019-11-13', '李四宝');
INSERT INTO `coach_1_reservationdetail` VALUES (133, 'time1', 1, '610102399948557244', '2019-11-13 11:08:10', '2019-11-14', '李四宝');
INSERT INTO `coach_1_reservationdetail` VALUES (137, 'time1', 0, '610102198749228577', '2019-11-15 00:00:00', '2019-11-15', '张安排');
INSERT INTO `coach_1_reservationdetail` VALUES (138, 'time1', 0, '610102199903554233', '2019-11-15 00:00:00', '2019-11-15', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (139, 'time4', 1, '610102399948557244', '2019-11-15 11:06:30', '2019-11-16', '李四宝');
INSERT INTO `coach_1_reservationdetail` VALUES (140, 'time1', 1, '610102199903554233', '2019-11-15 11:22:59', '2019-11-16', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (141, 'time18', 0, '610326188816665025', '2019-11-15 11:46:54', '2019-11-15', 'wqeq');
INSERT INTO `coach_1_reservationdetail` VALUES (142, 'time18', 0, '610326188816665024', '2019-11-15 11:47:12', '2019-11-15', 'xxx');
INSERT INTO `coach_1_reservationdetail` VALUES (143, 'time20', 0, '610326188816665024', '2019-11-15 11:51:26', '2019-11-16', 'xxx');
INSERT INTO `coach_1_reservationdetail` VALUES (144, 'time20', 0, '610326188816665025', '2019-11-15 11:51:42', '2019-11-16', 'wqeq');
INSERT INTO `coach_1_reservationdetail` VALUES (145, 'time19', 0, '610326988563214587', '2019-11-15 11:57:42', '2019-11-16', 'weq');
INSERT INTO `coach_1_reservationdetail` VALUES (146, 'time18', 1, '610326188523658521', '2019-11-15 12:03:08', '2019-11-15', 'asdas');
INSERT INTO `coach_1_reservationdetail` VALUES (149, 'time2', 0, '610102199903554233', '2019-11-16 13:19:26', '2019-11-17', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (150, 'time3', 1, '610326188823012654', '2019-11-17 10:51:43', '2019-11-18', '啊实打实');
INSERT INTO `coach_1_reservationdetail` VALUES (151, 'time3', 0, '610326188823012654', '2019-11-17 11:01:12', '2019-11-17', '啊实打实');
INSERT INTO `coach_1_reservationdetail` VALUES (152, 'time4', 0, '610326988563214587', '2019-11-17 12:20:12', '2019-11-17', 'weq');
INSERT INTO `coach_1_reservationdetail` VALUES (153, 'time10', 0, '610102199904335648', '2019-11-17 12:39:58', '2019-11-17', '算法');
INSERT INTO `coach_1_reservationdetail` VALUES (154, 'time6', 0, '610326199911123456', '2019-11-17 12:55:34', '2019-11-17', '星星');
INSERT INTO `coach_1_reservationdetail` VALUES (155, 'time1', 1, '610102199904335648', '2019-11-17 12:57:24', '2019-11-18', '算法');
INSERT INTO `coach_1_reservationdetail` VALUES (156, 'time5', 1, '610102199905446322', '2019-11-17 13:00:44', '2019-11-17', 'pingshi');
INSERT INTO `coach_1_reservationdetail` VALUES (157, 'time7', 0, '610326177765412563', '2019-11-17 13:01:02', '2019-11-17', '老王');
INSERT INTO `coach_1_reservationdetail` VALUES (159, 'time6', 0, '610102199905446322', '2019-11-17 16:56:29', '2019-11-18', 'pingshi');
INSERT INTO `coach_1_reservationdetail` VALUES (161, 'time19', 0, '610102199903554233', '2019-11-17 17:04:26', '2019-11-18', '王家胡');
INSERT INTO `coach_1_reservationdetail` VALUES (162, 'time18', 0, '610328155465235689', '2019-11-17 17:04:38', '2019-11-18', '隔壁老王');
INSERT INTO `coach_1_reservationdetail` VALUES (163, 'time11', 1, '610328155465235689', '2019-11-17 17:04:48', '2019-11-17', '隔壁老王');

-- ----------------------------
-- Table structure for coach_1_scholar
-- ----------------------------
DROP TABLE IF EXISTS `coach_1_scholar`;
CREATE TABLE `coach_1_scholar`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `scholarid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_1_scholar
-- ----------------------------
INSERT INTO `coach_1_scholar` VALUES (1, '610102198749228577');
INSERT INTO `coach_1_scholar` VALUES (2, '610102199903554233');
INSERT INTO `coach_1_scholar` VALUES (3, '610102399948557244');

-- ----------------------------
-- Table structure for coach_2_scholar
-- ----------------------------
DROP TABLE IF EXISTS `coach_2_scholar`;
CREATE TABLE `coach_2_scholar`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `scholarid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_2_scholar
-- ----------------------------
INSERT INTO `coach_2_scholar` VALUES (1, '1234');

-- ----------------------------
-- Table structure for coach_35_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_35_reservationcount`;
CREATE TABLE `coach_35_reservationcount`  (
  `id` date NOT NULL,
  `status` int(1) NOT NULL,
  `time1` int(1) NOT NULL,
  `time2` int(1) NOT NULL,
  `time3` int(1) NOT NULL,
  `time4` int(1) NOT NULL,
  `time5` int(1) NOT NULL,
  `time6` int(1) NOT NULL,
  `time7` int(1) NOT NULL,
  `time8` int(1) NOT NULL,
  `time9` int(1) NOT NULL,
  `time10` int(1) NOT NULL,
  `time11` int(1) NOT NULL,
  `time12` int(1) NOT NULL,
  `time13` int(1) NOT NULL,
  `time14` int(1) NOT NULL,
  `time15` int(1) NOT NULL,
  `time16` int(1) NOT NULL,
  `time17` int(1) NOT NULL,
  `time18` int(1) NOT NULL,
  `time19` int(1) NOT NULL,
  `time20` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_35_reservationcount
-- ----------------------------
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-11', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-15', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-16', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-17', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-18', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-19', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-20', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-21', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-22', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-23', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2019-11-24', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-23', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-24', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-25', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-26', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-27', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-28', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-29', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-30', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-01-31', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-02-01', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-02-02', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_35_reservationcount` VALUES ('2020-02-03', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for coach_35_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_35_reservationdetail`;
CREATE TABLE `coach_35_reservationdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coach_36_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_36_reservationcount`;
CREATE TABLE `coach_36_reservationcount`  (
  `id` date NOT NULL,
  `status` int(1) NOT NULL,
  `time1` int(1) NOT NULL,
  `time2` int(1) NOT NULL,
  `time3` int(1) NOT NULL,
  `time4` int(1) NOT NULL,
  `time5` int(1) NOT NULL,
  `time6` int(1) NOT NULL,
  `time7` int(1) NOT NULL,
  `time8` int(1) NOT NULL,
  `time9` int(1) NOT NULL,
  `time10` int(1) NOT NULL,
  `time11` int(1) NOT NULL,
  `time12` int(1) NOT NULL,
  `time13` int(1) NOT NULL,
  `time14` int(1) NOT NULL,
  `time15` int(1) NOT NULL,
  `time16` int(1) NOT NULL,
  `time17` int(1) NOT NULL,
  `time18` int(1) NOT NULL,
  `time19` int(1) NOT NULL,
  `time20` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_36_reservationcount
-- ----------------------------
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-11', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-15', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-16', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-17', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-18', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-19', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-20', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-21', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-22', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-23', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2019-11-24', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-23', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-24', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-25', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-26', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-27', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-28', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-29', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-30', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-01-31', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-02-01', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-02-02', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_36_reservationcount` VALUES ('2020-02-03', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for coach_36_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_36_reservationdetail`;
CREATE TABLE `coach_36_reservationdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coach_37_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_37_reservationcount`;
CREATE TABLE `coach_37_reservationcount`  (
  `id` date NOT NULL,
  `status` int(1) NOT NULL,
  `time1` int(1) NOT NULL,
  `time2` int(1) NOT NULL,
  `time3` int(1) NOT NULL,
  `time4` int(1) NOT NULL,
  `time5` int(1) NOT NULL,
  `time6` int(1) NOT NULL,
  `time7` int(1) NOT NULL,
  `time8` int(1) NOT NULL,
  `time9` int(1) NOT NULL,
  `time10` int(1) NOT NULL,
  `time11` int(1) NOT NULL,
  `time12` int(1) NOT NULL,
  `time13` int(1) NOT NULL,
  `time14` int(1) NOT NULL,
  `time15` int(1) NOT NULL,
  `time16` int(1) NOT NULL,
  `time17` int(1) NOT NULL,
  `time18` int(1) NOT NULL,
  `time19` int(1) NOT NULL,
  `time20` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_37_reservationcount
-- ----------------------------
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-11', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-13', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-14', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-15', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-16', 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-17', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-18', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-19', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-20', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-21', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-22', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-23', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2019-11-24', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-23', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-24', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-25', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-26', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-27', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-28', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-29', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-30', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-01-31', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-02-01', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-02-02', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `coach_37_reservationcount` VALUES ('2020-02-03', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for coach_37_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_37_reservationdetail`;
CREATE TABLE `coach_37_reservationdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coach_45_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_45_reservationcount`;
CREATE TABLE `coach_45_reservationcount`  (
  `id` date NOT NULL,
  `status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time1` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time2` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time3` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time4` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time5` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time6` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time7` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time8` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time9` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time10` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time11` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time12` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time13` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time14` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time15` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time16` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time17` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time18` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time19` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time20` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_45_reservationcount
-- ----------------------------
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-15', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-16', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-17', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-18', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-19', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-20', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-21', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-22', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2019-11-24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-25', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-26', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-27', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-28', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-29', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-01-31', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-02-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-02-02', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_45_reservationcount` VALUES ('2020-02-03', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for coach_45_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_45_reservationdetail`;
CREATE TABLE `coach_45_reservationdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coach_46_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_46_reservationcount`;
CREATE TABLE `coach_46_reservationcount`  (
  `id` date NOT NULL,
  `status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time1` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time2` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time3` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time4` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time5` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time6` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time7` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time8` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time9` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time10` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time11` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time12` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time13` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time14` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time15` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time16` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time17` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time18` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time19` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time20` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_46_reservationcount
-- ----------------------------
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-17', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-18', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-19', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-20', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-21', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-22', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2019-11-24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-25', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-26', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-27', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-28', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-29', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-01-31', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-02-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-02-02', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `coach_46_reservationcount` VALUES ('2020-02-03', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for coach_46_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_46_reservationdetail`;
CREATE TABLE `coach_46_reservationdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coach_orm_reservationcount
-- ----------------------------
DROP TABLE IF EXISTS `coach_orm_reservationcount`;
CREATE TABLE `coach_orm_reservationcount`  (
  `id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tablename` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_orm_reservationcount
-- ----------------------------
INSERT INTO `coach_orm_reservationcount` VALUES ('610102144404337833', 'coach_37_reservationcount');
INSERT INTO `coach_orm_reservationcount` VALUES ('610102188837442533', 'coach_1_reservationcount');
INSERT INTO `coach_orm_reservationcount` VALUES ('610102199902443566', 'coach_45_reservationcount');
INSERT INTO `coach_orm_reservationcount` VALUES ('610102199904337533', 'coach_35_reservationcount');
INSERT INTO `coach_orm_reservationcount` VALUES ('610102199904337833', 'coach_36_reservationcount');
INSERT INTO `coach_orm_reservationcount` VALUES ('dsafafafsdaf', 'coach_46_reservationcount');

-- ----------------------------
-- Table structure for coach_orm_reservationdetail
-- ----------------------------
DROP TABLE IF EXISTS `coach_orm_reservationdetail`;
CREATE TABLE `coach_orm_reservationdetail`  (
  `id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tablename` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_orm_reservationdetail
-- ----------------------------
INSERT INTO `coach_orm_reservationdetail` VALUES ('610102144404337833', 'coach_37_reservationdetail');
INSERT INTO `coach_orm_reservationdetail` VALUES ('610102188837442533', 'coach_1_reservationdetail');
INSERT INTO `coach_orm_reservationdetail` VALUES ('610102199902443566', 'coach_45_reservationdetail');
INSERT INTO `coach_orm_reservationdetail` VALUES ('610102199904337533', 'coach_35_reservationdetail');
INSERT INTO `coach_orm_reservationdetail` VALUES ('610102199904337833', 'coach_36_reservationdetail');
INSERT INTO `coach_orm_reservationdetail` VALUES ('dsafafafsdaf', 'coach_46_reservationdetail');

-- ----------------------------
-- Table structure for coach_orm_scholar
-- ----------------------------
DROP TABLE IF EXISTS `coach_orm_scholar`;
CREATE TABLE `coach_orm_scholar`  (
  `id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tablename` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach_orm_scholar
-- ----------------------------
INSERT INTO `coach_orm_scholar` VALUES ('610102188837442533', 'coach_1_scholar');
INSERT INTO `coach_orm_scholar` VALUES ('610102938884733284', 'coach_2_scholar');

-- ----------------------------
-- Table structure for rewardinfo
-- ----------------------------
DROP TABLE IF EXISTS `rewardinfo`;
CREATE TABLE `rewardinfo`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reward` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rewardinfo
-- ----------------------------
INSERT INTO `rewardinfo` VALUES ('123', 'macbook pro', '2020-01-21 03:33:22');
INSERT INTO `rewardinfo` VALUES ('123', '驾校报名减免100元优惠卷一张', '2020-01-21 03:34:06');
INSERT INTO `rewardinfo` VALUES ('123', '驾校报名减免100元优惠卷一张', '2020-01-21 03:34:13');
INSERT INTO `rewardinfo` VALUES ('123', 'macbook pro', '2020-01-21 03:34:19');
INSERT INTO `rewardinfo` VALUES ('123', '驾校报名减免100元优惠卷一张', '2020-01-21 03:34:33');
INSERT INTO `rewardinfo` VALUES ('123', '驾校报名减免100元优惠卷一张', '2020-01-21 03:34:38');
INSERT INTO `rewardinfo` VALUES ('123', '驾校报名减免100元优惠卷一张', '2020-01-21 03:34:39');

-- ----------------------------
-- Table structure for scholar
-- ----------------------------
DROP TABLE IF EXISTS `scholar`;
CREATE TABLE `scholar`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cost` int(1) NOT NULL COMMENT '是否可以预约练车',
  `password` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coachid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scholar
-- ----------------------------
INSERT INTO `scholar` VALUES (1, '张安排', '610102198749228577', '15829643892', '女', '陕西省商洛市商州区星都小区', 1, '1', '610102188837442533');
INSERT INTO `scholar` VALUES (2, '王家胡', '610102199903554233', '15829632906', '男', '陕西省商洛市动员北路', 1, '1', '610102188837442533');
INSERT INTO `scholar` VALUES (5, '李二宝', '610102399904558222', '21412341', '男', '陕西省显示新城区', 0, '558222', '610102188837442533');
INSERT INTO `scholar` VALUES (6, '中意你', '610102199902445644', '321412', '男', '陕西省xxx', 1, '445644', '610102199902994855');
INSERT INTO `scholar` VALUES (17, '赵丽宁', '610102199902112455', '34513412', '女', '陕西啊啊', 0, '112455', '610102199902994855');
INSERT INTO `scholar` VALUES (19, '德福', '610102199901223455', '456342', '女', '陕西省西安', 1, '223455', '610326199911182055');
INSERT INTO `scholar` VALUES (20, 'xxx', '610326188816665024', '123456789', '男', 'dsafafafsdaf', 1, '665024', '610102188837442533');
INSERT INTO `scholar` VALUES (21, 'wqeq', '610326188816665025', '2131225', '男', 'dsafafafsdafasd', 1, '665025', '610102188837442533');
INSERT INTO `scholar` VALUES (22, 'weq', '610326988563214587', '123456', '男', 'dsafafafsdaf', 1, '214587', '610102188837442533');
INSERT INTO `scholar` VALUES (26, '啊实打实', '610326188823012654', '123456', '女', 'dsafafafsdaf', 1, '012654', '610102188837442533');
INSERT INTO `scholar` VALUES (27, '算法', '610102199904335648', '24132412', '女', '阿松大', 1, '335648', '610102188837442533');
INSERT INTO `scholar` VALUES (28, '星星', '610326199911123456', '123456789', '女', 'dsafafafsdaf', 1, '123456', '610102188837442533');
INSERT INTO `scholar` VALUES (29, 'pingshi', '610102199905446322', '23114123', '女', 'shanasdf', 1, '446322', '610102188837442533');
INSERT INTO `scholar` VALUES (30, '老王', '610326177765412563', '123456', '男', 'dsafafafsdaf', 1, '412563', '610102188837442533');
INSERT INTO `scholar` VALUES (31, '隔壁老王', '610328155465235689', '123456', '女', 'dsafafafsdaf', 1, '235689', '610102188837442533');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `registertime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '1', '0:0:0:0:0:0:0:1', '2020-01-21 03:31:34');

-- ----------------------------
-- Table structure for user_orm_wechat
-- ----------------------------
DROP TABLE IF EXISTS `user_orm_wechat`;
CREATE TABLE `user_orm_wechat`  (
  `id` int(10) NOT NULL,
  `wechatid` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wechat
-- ----------------------------
DROP TABLE IF EXISTS `wechat`;
CREATE TABLE `wechat`  (
  `id` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zi
-- ----------------------------
DROP TABLE IF EXISTS `zi`;
CREATE TABLE `zi`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ming` int(3) NULL DEFAULT NULL,
  `tian` int(3) NULL DEFAULT NULL,
  `geng` int(3) NULL DEFAULT NULL,
  `hao` int(3) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zi
-- ----------------------------
INSERT INTO `zi` VALUES ('123', 2, 0, 0, 6);

-- ----------------------------
-- Procedure structure for addcoachorm
-- ----------------------------
DROP PROCEDURE IF EXISTS `addcoachorm`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `addcoachorm`(in detail int, in id varchar(18))
begin
DECLARE t_error INTEGER DEFAULT 0;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;
        START TRANSACTION;
set @detialname=concat('coach_',detail,'_reservationdetail');
#插入映射关系coach_10_reservationdetail
set @detail=CONCAT('CREATE TABLE ',@detialname,'  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timepart` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `userid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `timeid` date NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
');
prepare temp from @detail;
execute temp;
set @countname=concat('coach_',detail,'_reservationcount');
set @count=CONCAT('CREATE TABLE ',@countname,'(
  `id` date NOT NULL,
  `status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time1` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time2` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time3` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time4` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time5` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time6` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time7` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time8` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time9` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time10` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time11` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time12` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time13` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time14` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time15` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time16` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time17` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time18` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time19` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time20` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;');
prepare temp from @count;
execute temp;

insert into coach_orm_reservationcount(id,tablename) values(id,@countname);
insert into coach_orm_reservationdetail(id,tablename) values(id,@detialname);

 IF t_error = 1 THEN
            ROLLBACK;
        ELSE
            COMMIT;
        END IF;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for detechoach
-- ----------------------------
DROP PROCEDURE IF EXISTS `detechoach`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `detechoach`(in ids varchar(18))
begin
delete from coach where idcard=ids;
set @detailname=(select tablename from coach_orm_reservationdetail where id=ids);
IF length(@detailname)>0 then
set @sqls=concat('drop table ',@detailname);
prepare temp from @sqls;
execute temp;
delete from coach_orm_reservationdetail where id=ids;
set @countname=(select tablename from coach_orm_reservationcount where id=ids);
IF length(@countname)>0 then
set @sqlq=concat('drop table ',@countname);
prepare temp from @sqlq;
execute temp;
delete from coach_orm_reservationcount where id=ids;
end if;
end if;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for detelcoachorm
-- ----------------------------
DROP PROCEDURE IF EXISTS `detelcoachorm`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `detelcoachorm`(in detail int, in ids varchar(18))
begin

#删除记录
delete from coach where id=detail;
set @detialname=concat('coach_',detail,'_reservationdetail');
#删除detail表
set @detail=CONCAT('drop table ',@detialname);
prepare temp from @detail;
execute temp;
#删除count表
set @countname=concat('coach_',detail,'_reservationcount');
set @count=CONCAT('drop table ',@countname);
prepare temp from @count;
execute temp;
#删除orm表中映射关系
delete from coach_orm_reservationcount  where id=ids;
delete from coach_orm_reservationdetail  where id=ids;

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for detescholar
-- ----------------------------
DROP PROCEDURE IF EXISTS `detescholar`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `detescholar`(in scholar varchar(18))
begin
delete from scholar where idcard=scholar;
set @coachid =(select coachid from scholar where idcard=scholar);
set @detailname=(select tablename from coach_orm_reservationdetail where id=@coachid);
IF length(@detailname)>0 then
set @sqls=concat('delete from ',@detailname,' where userid=scholar;');
prepare temp from @sqls;
execute temp;
end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

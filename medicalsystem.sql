/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : medicalsystem

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-04-07 10:20:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `end_work` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `start_work` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `workload` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------

-- ----------------------------
-- Table structure for `bed`
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bed_id` int(11) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `name` varchar(14) DEFAULT NULL,
  `pathogeny` varchar(120) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES ('1', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('2', null, '2', '程先生', '感冒', '', '17', '1', '10', '1', '1490882530');
INSERT INTO `bed` VALUES ('3', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('4', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('5', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('6', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('7', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('8', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('9', null, null, null, null, null, null, null, null, '0', null);
INSERT INTO `bed` VALUES ('10', null, null, null, null, null, null, null, null, '0', null);

-- ----------------------------
-- Table structure for `cost`
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cost_type` int(11) DEFAULT NULL,
  `create_time` int(11) DEFAULT NULL,
  `delivery` double DEFAULT NULL,
  `is_receivable` tinyint(4) DEFAULT NULL,
  `receivable` double DEFAULT NULL,
  `receivable_project` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES ('17', '1', '1490671082', null, '1', '10', '16', '', '16', '0', '1490671518');
INSERT INTO `cost` VALUES ('18', '3', '1490672337', null, '1', '28', '1', '[{\"id\":\"11\",\"name\":\"感康\",\"price\":\"28.0\",\"total\":\"1\"}]', '16', '1', '1490672403');
INSERT INTO `cost` VALUES ('19', '1', '1490876832', null, '1', '10', '17', '', '17', '0', '1490877654');
INSERT INTO `cost` VALUES ('20', '4', '1490882530', null, '1', '200', '1', null, '1', '1', '1490882840');
INSERT INTO `cost` VALUES ('21', '3', '1491294323', null, '1', '28', '0', '[{\"id\":\"11\",\"name\":\"感康\",\"price\":\"28.0\",\"total\":\"1\"}]', '17', '1', '1491294410');

-- ----------------------------
-- Table structure for `diagnosis`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` int(11) DEFAULT NULL,
  `describes` varchar(255) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `resolvent` tinyint(4) DEFAULT NULL,
  `types` tinyint(4) DEFAULT '1' COMMENT '1 门诊部 ， 2 住院部',
  `rid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnosis
-- ----------------------------
INSERT INTO `diagnosis` VALUES ('1', '{\"id\":\"11\",\"name\":\"感康\",\"price\":\"28.0\",\"total\":\"1\"}', null, '感冒', '', '1', '1', '16', '6', null);
INSERT INTO `diagnosis` VALUES ('2', '', null, '感冒', '', '2', '1', '17', '6', null);
INSERT INTO `diagnosis` VALUES ('3', '{\"id\":\"11\",\"name\":\"感康\",\"price\":\"28.0\",\"total\":\"1\"}', '1491294323', '重感冒', '', '1', '2', '1', '6', '1');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` int(11) DEFAULT NULL,
  `details` varchar(120) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', null, '', '科室', '0', '', '0', '1', null, '2017-03-19');
INSERT INTO `dictionary` VALUES ('2', null, '', '外科', '1', '', '0', '1', null, '');
INSERT INTO `dictionary` VALUES ('3', null, '', '内科', '1', '', '0', '1', null, '');
INSERT INTO `dictionary` VALUES ('4', null, '', '五官科', '1', '', '0', '1', null, '');
INSERT INTO `dictionary` VALUES ('5', null, '', '皮肤科', '1', '', '0', '1', null, '');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('2');

-- ----------------------------
-- Table structure for `hospitalized`
-- ----------------------------
DROP TABLE IF EXISTS `hospitalized`;
CREATE TABLE `hospitalized` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `balance` double DEFAULT '0',
  `bed_id` int(11) DEFAULT NULL,
  `check_time` int(11) DEFAULT NULL,
  `cost_value` double DEFAULT '0',
  `department` int(11) DEFAULT NULL,
  `hospitalized_status` tinyint(4) DEFAULT NULL,
  `pathogeny` varchar(120) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `tuisu_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospitalized
-- ----------------------------
INSERT INTO `hospitalized` VALUES ('1', null, '2', '1490882530', '0', '2', null, '感冒', '', '17', '10', '1', null);

-- ----------------------------
-- Table structure for `inspect`
-- ----------------------------
DROP TABLE IF EXISTS `inspect`;
CREATE TABLE `inspect` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `cost_status` tinyint(4) DEFAULT NULL,
  `inspect_result` varchar(255) DEFAULT NULL,
  `inspect_time` int(11) DEFAULT NULL,
  `inspect_title` varchar(60) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inspect
-- ----------------------------

-- ----------------------------
-- Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(22) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('10', '板蓝根颗粒', '9.8', '', null, '盒');
INSERT INTO `medicine` VALUES ('11', '感康', '28', '', null, '盒');
INSERT INTO `medicine` VALUES ('12', '牛黄解毒片', '5.5', '', null, '盒');
INSERT INTO `medicine` VALUES ('13', '蒲地蓝消炎口服液', '44', '', null, '盒');
INSERT INTO `medicine` VALUES ('14', '急支糖浆', '16.2', '', null, '盒');

-- ----------------------------
-- Table structure for `medicine_use`
-- ----------------------------
DROP TABLE IF EXISTS `medicine_use`;
CREATE TABLE `medicine_use` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bed_id` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `nurse_id` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `take_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine_use
-- ----------------------------

-- ----------------------------
-- Table structure for `prescription`
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `create_time` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('1', '{\"id\":\"11\",\"name\":\"感康\",\"price\":\"28.0\",\"total\":\"1\"}', null, '1490672337', '', '16', '6', null, null);
INSERT INTO `prescription` VALUES ('2', '{\"id\":\"11\",\"name\":\"感康\",\"price\":\"28.0\",\"total\":\"1\"}', null, '1491294323', '', '17', '6', null, null);

-- ----------------------------
-- Table structure for `reservation`
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `reservation_cost` int(11) DEFAULT NULL,
  `reservation_department` int(11) DEFAULT NULL,
  `reservation_doctor` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('16', '1490671511', '', '10', '2', '6', null, '15');
INSERT INTO `reservation` VALUES ('17', '1490877649', '', '10', '2', '6', null, '15');

-- ----------------------------
-- Table structure for `staff_information`
-- ----------------------------
DROP TABLE IF EXISTS `staff_information`;
CREATE TABLE `staff_information` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `departure_time` int(11) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `induction_time` int(11) DEFAULT NULL,
  `job_number` varchar(8) DEFAULT NULL,
  `password` varchar(34) DEFAULT NULL,
  `job_type` int(11) DEFAULT NULL,
  `name` varchar(14) DEFAULT NULL,
  `organization` tinyint(4) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `title` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_information
-- ----------------------------
INSERT INTO `staff_information` VALUES ('6', '', '2', null, '13920826520', '1485907200', 'MWG001', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '李医生', '1', '13920826520', '', '1', null, '');
INSERT INTO `staff_information` VALUES ('7', '', '3', null, '13920826521', '1492214400', 'MNK001', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '王医生', '1', '13920826521', '', '1', null, '');
INSERT INTO `staff_information` VALUES ('8', '', '2', null, '13920826530', null, 'HMWG001', '4QrcOUm6Wau+VuBX8g+IPg==', '2', '王护士', '1', '13920826530', '', '2', null, '');
INSERT INTO `staff_information` VALUES ('9', '', '3', null, '', null, 'HMNK001', '4QrcOUm6Wau+VuBX8g+IPg==', '2', '赵护士', '1', '13920826531', '', '2', null, '');
INSERT INTO `staff_information` VALUES ('10', '', '2', null, '13920826522', null, 'MWG001', '4QrcOUm6Wau+VuBX8g+IPg==', '4', '李医生', '1', '13920826520', '', '1', null, '');
INSERT INTO `staff_information` VALUES ('11', '', '3', null, '13920826523', null, 'MNK001', '4QrcOUm6Wau+VuBX8g+IPg==', '4', '王医生', '1', '13920826521', '', '1', null, '');
INSERT INTO `staff_information` VALUES ('12', '', '2', null, '13920826532', null, 'HMWG001', '4QrcOUm6Wau+VuBX8g+IPg==', '5', '护士1', '1', '13920826530', '', '2', null, '');
INSERT INTO `staff_information` VALUES ('13', '', '3', null, '', null, 'HMNK001', '4QrcOUm6Wau+VuBX8g+IPg==', '5', '护士2', '1', '13920826533', '', '2', null, '');
INSERT INTO `staff_information` VALUES ('14', null, '3', null, '13920826591', null, 'ADMIN', 'Bwe6CS6RJgswXDJuajU1kw==', '6', '管理员', '1', '13920826591', null, '1', null, null);

-- ----------------------------
-- Table structure for `treatment`
-- ----------------------------
DROP TABLE IF EXISTS `treatment`;
CREATE TABLE `treatment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bed_id` int(11) DEFAULT NULL,
  `date` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `dose_time1` int(11) DEFAULT NULL,
  `dose_time2` int(11) DEFAULT NULL,
  `dose_time3` int(11) DEFAULT NULL,
  `dose_time4` int(11) DEFAULT NULL,
  `nurse_id` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `to_improve` tinyint(4) DEFAULT NULL,
  `untoward_effect` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treatment
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `name` varchar(14) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `reg_time` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('15', '', '2017-03-26', '', '程先生', '13920826591', '1490671500', '', '1', '1');

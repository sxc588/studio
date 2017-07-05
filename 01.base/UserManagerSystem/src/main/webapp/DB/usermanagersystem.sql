/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : usermanagersystem

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-04-09 16:23:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk NOT NULL,
  `password` varchar(20) CHARACTER SET gbk NOT NULL,
  `name` varchar(20) CHARACTER SET gbk NOT NULL,
  `nic` varchar(30) CHARACTER SET gbk NOT NULL,
  `sex` char(2) CHARACTER SET gbk NOT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET gbk DEFAULT NULL,
  `selfshow` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('9', 'admin', 'admin', '鸣人', '沙漠狂风', '1', '20', '589563204@qq.com', '13859601450', 'i like shopping', '2');
INSERT INTO `t_users` VALUES ('13', 'dashiwan', 'dsw2012pwd', '大蛇丸', '与蛇共舞', '1', '28', '489642144@qq.com', '1359875210', 'destroy everything', '1');
INSERT INTO `t_users` VALUES ('14', 'paperPlane', 'pp2012pwd', '阿莲', '莫伊', '0', '23', '49502644@qq.com', '13595201245', 'smaile', '1');
INSERT INTO `t_users` VALUES ('29', 'bluedream', 'bd2012pwd', '默默', '蓝色梦', '0', '23', '564662873qq.com', '13598073504', '沉默是金', '0');
INSERT INTO `t_users` VALUES ('30', 'kakaxi', 'kk2012pwd', '卡卡西', '风语者', '1', '23', '564660245qq.com', '13569366417', 'reading and thinking', '1');
INSERT INTO `t_users` VALUES ('31', 'hanhan', 'h811659pwd', 'hanhan', '自由云', '1', '23', '568235740qq.com', '13895201564', 'i like free', '0');
INSERT INTO `t_users` VALUES ('32', 'flowers', 'fd2012pwd', '宋子桥', '落花城主', '1', '22', '876594201qq.com', '13838270564', '莫待无花空折枝', '0');

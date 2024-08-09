/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云Mysql
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : 47.121.187.38:3306
 Source Schema         : GeneralManagementSystem

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 09/08/2024 17:35:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buy
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `todayBuy` int DEFAULT NULL,
  `monthBuy` int DEFAULT NULL,
  `totalBuy` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='购买表';

-- ----------------------------
-- Records of buy
-- ----------------------------
BEGIN;
INSERT INTO `buy` (`id`, `name`, `todayBuy`, `monthBuy`, `totalBuy`) VALUES (1, 'Java', 100, 300, 400);
INSERT INTO `buy` (`id`, `name`, `todayBuy`, `monthBuy`, `totalBuy`) VALUES (2, 'Mysql', 50, 150, 200);
COMMIT;

-- ----------------------------
-- Table structure for children
-- ----------------------------
DROP TABLE IF EXISTS `children`;
CREATE TABLE `children` (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `label` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `children` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of children
-- ----------------------------
BEGIN;
INSERT INTO `children` (`id`, `path`, `name`, `label`, `icon`, `url`, `children`) VALUES (1, 'other1', 'Other1', 'Other1', NULL, NULL, NULL);
INSERT INTO `children` (`id`, `path`, `name`, `label`, `icon`, `url`, `children`) VALUES (2, 'Other2', 'Other2', 'Other2', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for echarts
-- ----------------------------
DROP TABLE IF EXISTS `echarts`;
CREATE TABLE `echarts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_num` date DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int DEFAULT NULL,
  `news` int DEFAULT NULL,
  `active` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of echarts
-- ----------------------------
BEGIN;
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (1, '2024-08-06', '星期二', '小米', 2999, 10, 500);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (2, '2024-08-07', '星期三', '苹果', 5999, 12, 550);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (3, '2024-08-08', '星期四', 'vivo', 1500, 60, 800);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (4, '2024-08-09', '星期五', 'oppo', 1999, 65, 730);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (5, '2024-08-10', '星期六', '魅族', 2200, 53, 770);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (6, '2024-08-11', '星期天', '三星', 4500, 33, 430);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (7, '2024-08-12', '星期一', '华为', 8900, 3, 310);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (8, '2024-08-13', '星期二', '红米', 1700, 45, 200);
INSERT INTO `echarts` (`id`, `date_num`, `date`, `name`, `price`, `news`, `active`) VALUES (9, '2024-08-07', '星期三', '金苹果', 12000, 37, 150);
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `label` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `children` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` (`id`, `path`, `name`, `label`, `icon`, `url`, `children`) VALUES (1, '/home', 'Home', '首页', 'house', 'Home', NULL);
INSERT INTO `menu` (`id`, `path`, `name`, `label`, `icon`, `url`, `children`) VALUES (2, '/mall', 'Mall', '商品管理', 'video-play', 'Mall', NULL);
INSERT INTO `menu` (`id`, `path`, `name`, `label`, `icon`, `url`, `children`) VALUES (3, '/user', 'User', '用户管理', 'user', 'User', NULL);
INSERT INTO `menu` (`id`, `path`, `name`, `label`, `icon`, `url`, `children`) VALUES (4, '/other', 'Other', '其他页面', 'house', 'Other', 1);
COMMIT;

-- ----------------------------
-- Table structure for menu_children
-- ----------------------------
DROP TABLE IF EXISTS `menu_children`;
CREATE TABLE `menu_children` (
  `menu_children_id` int DEFAULT NULL,
  `children_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menu_children
-- ----------------------------
BEGIN;
INSERT INTO `menu_children` (`menu_children_id`, `children_id`) VALUES (1, 1);
INSERT INTO `menu_children` (`menu_children_id`, `children_id`) VALUES (1, 2);
COMMIT;

-- ----------------------------
-- Table structure for order_total
-- ----------------------------
DROP TABLE IF EXISTS `order_total`;
CREATE TABLE `order_total` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_total` int DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order_total
-- ----------------------------
BEGIN;
INSERT INTO `order_total` (`id`, `name`, `order_total`, `icon`, `color`) VALUES (1, '今日支付订单', 123, 'SuccessFilled', '#2ec7c9');
INSERT INTO `order_total` (`id`, `name`, `order_total`, `icon`, `color`) VALUES (2, '今日收藏订单', 520, 'StarFilled', '#ffb980');
INSERT INTO `order_total` (`id`, `name`, `order_total`, `icon`, `color`) VALUES (3, '今日未支付订单', 2, 'GoodsFilled', '#5ablef');
INSERT INTO `order_total` (`id`, `name`, `order_total`, `icon`, `color`) VALUES (4, '本月支付订单', 8000, 'SuccessFilled', '#2ec7c9');
INSERT INTO `order_total` (`id`, `name`, `order_total`, `icon`, `color`) VALUES (5, '本月收藏订单', 39, 'StarFilled', '#ffb980');
INSERT INTO `order_total` (`id`, `name`, `order_total`, `icon`, `color`) VALUES (6, '本月未支付订单', 43, 'GoodsFilled', '#5ablef');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_deleted` int DEFAULT '0',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (1, 'Admin', 23, 1, '2024-07-30', '广东 东莞', 0, 'Admin');
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (2, 'along', 22, 1, '2024-08-02', '广东 东莞', 0, '123456');
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (4, '昆仑山', 31, 1, '2024-08-08', '广东 东莞', 0, '123456');
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (5, '农夫山泉', 31, 1, '2024-08-08', '广东 东莞', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (6, '那天我想了好多', 22, 1, '2024-08-07', '广东 佛山', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (7, '水山少年梦', 22, 0, '2024-08-06', '香港', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (10, '抬头看月思故乡古', 99, 1, '2024-08-22', '江苏 苏州', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (11, '抬头看月思故乡古', 1, 1, '2024-08-22', '江苏 苏州', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (12, '古巨基', 24, 0, '2024-08-01', '北京 海洲区 ', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (13, 'copi', 22, 1, '2024-08-02', '广东 东莞', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (14, '123123', 12, 1, '2024-08-14', '21321312', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (15, '123', 123, 1, '2024-08-09', '123', 0, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `gender`, `birth_date`, `address`, `is_deleted`, `password`) VALUES (16, '11111', 11, 1, '2024-08-09', '南宁', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu` (
  `user_id` int DEFAULT NULL,
  `menu_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
BEGIN;
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (1, 1);
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (1, 2);
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (1, 3);
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (2, 1);
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (2, 2);
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (2, 4);
INSERT INTO `user_menu` (`user_id`, `menu_id`) VALUES (1, 4);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

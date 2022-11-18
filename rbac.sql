/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39)
 Source Host           : localhost:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39)
 File Encoding         : 65001

 Date: 18/11/2022 14:45:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `menu_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` char(16) NOT NULL COMMENT '菜单名',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `role_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` char(16) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for s_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_role_menu`;
CREATE TABLE `s_role_menu` (
  `role_id` int(32) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(32) DEFAULT NULL COMMENT '菜单ID',
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '中间表ID',
  PRIMARY KEY (`id`),
  KEY `role_index` (`role_id`) USING BTREE,
  KEY `menu_index` (`menu_id`) USING BTREE,
  KEY `union_role_menu` (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` char(16) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `user_id` int(32) NOT NULL COMMENT '用户ID',
  `role_id` int(32) NOT NULL COMMENT '角色ID',
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '表ID',
  PRIMARY KEY (`id`),
  KEY `user_index` (`user_id`) USING BTREE,
  KEY `role_index` (`role_id`) USING BTREE,
  KEY `union_user_role_index` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

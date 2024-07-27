/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : ray4j_fast

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 27/07/2024 22:19:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_captcha
-- ----------------------------
DROP TABLE IF EXISTS `app_captcha`;
CREATE TABLE `app_captcha` (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统验证码';

-- ----------------------------
-- Records of app_captcha
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for app_log
-- ----------------------------
DROP TABLE IF EXISTS `app_log`;
CREATE TABLE `app_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统日志';

-- ----------------------------
-- Records of app_log
-- ----------------------------
BEGIN;
INSERT INTO `app_log` (`id`, `username`, `operation`, `method`, `params`, `time`, `ip`, `create_date`) VALUES (1, 'string', '', 'top.ray4j.manage.controller.AppTestController.userInfo()', '[{}]', 1, '0:0:0:0:0:0:0:1', '2024-07-27 22:14:21');
COMMIT;

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_user
-- ----------------------------
BEGIN;
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (1, 'ray', '4297f44b13955235245b2497399d7a93', '2024-06-24 15:29:38', '2024-06-24 15:29:38', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (2, 'admin', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '2024-07-11 18:41:33', '2024-07-11 18:41:33', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (3, '111', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '2024-07-15 10:11:06', '2024-07-15 10:11:06', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (4, '123456', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2024-07-15 10:36:24', '2024-07-15 10:36:23', '123456@11.com');
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (5, 'zhanghao', '998f6debf95e99f139a0a302d3b30e12189d0d0054f8a7a606b330937aa98b01', '2024-07-15 17:04:40', '2024-07-15 17:04:39', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (6, 'zhanghao1', '998f6debf95e99f139a0a302d3b30e12189d0d0054f8a7a606b330937aa98b01', '2024-07-15 17:06:36', '2024-07-15 17:06:35', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (7, 'zhanghao3', '998f6debf95e99f139a0a302d3b30e12189d0d0054f8a7a606b330937aa98b01', '2024-07-15 17:07:37', '2024-07-15 17:07:36', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (8, 'zhanghao9', '998f6debf95e99f139a0a302d3b30e12189d0d0054f8a7a606b330937aa98b01', '2024-07-15 17:32:38', '2024-07-15 17:32:37', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (9, 'zhanghao7', '998f6debf95e99f139a0a302d3b30e12189d0d0054f8a7a606b330937aa98b01', '2024-07-15 17:33:03', '2024-07-15 17:33:03', NULL);
INSERT INTO `app_user` (`id`, `username`, `password`, `create_time`, `update_time`, `email`) VALUES (14, 'string', '473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8', '2024-07-27 21:34:11', '2024-07-27 21:34:11', 'r@ruiyeclub.cn');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 anna-xxgk 的数据库结构
CREATE DATABASE IF NOT EXISTS `anna-xxgk` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `anna-xxgk`;

-- 导出  表 anna-xxgk.t_resources 结构
CREATE TABLE IF NOT EXISTS `t_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `res_url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `type` int(1) DEFAULT '2' COMMENT '资源类型 1-菜单 2-按钮',
  `parent_id` int(11) DEFAULT NULL COMMENT '父id',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- 正在导出表  anna-xxgk.t_resources 的数据：~13 rows (大约)
DELETE FROM `t_resources`;
/*!40000 ALTER TABLE `t_resources` DISABLE KEYS */;
INSERT INTO `t_resources` (`id`, `name`, `res_url`, `type`, `parent_id`, `sort`) VALUES
	(1, '系统设置', '/system', 0, 0, 1),
	(2, '用户管理', '/usersPage', 1, 1, 2),
	(3, '角色管理', '/rolesPage', 1, 1, 3),
	(4, '资源管理', '/resourcesPage', 1, 1, 4),
	(5, '添加用户', '/users/add', 2, 2, 5),
	(6, '删除用户', '/users/delete', 2, 2, 6),
	(7, '添加角色', '/roles/add', 2, 3, 7),
	(8, '删除角色', '/roles/delete', 2, 3, 8),
	(9, '添加资源', '/resources/add', 2, 4, 9),
	(10, '删除资源', '/resources/delete', 2, 4, 10),
	(11, '分配角色', '/users/saveUserRoles', 2, 2, 11),
	(13, '分配权限', '/roles/saveRoleResources', 2, 3, 12);
/*!40000 ALTER TABLE `t_resources` ENABLE KEYS */;

-- 导出  表 anna-xxgk.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 正在导出表  anna-xxgk.t_role 的数据：~4 rows (大约)
DELETE FROM `t_role`;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `role_desc`) VALUES
	(1, '管理员'),
	(2, '普通用户'),
	(3, '超级管理员'),
	(4, '测试用户');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

-- 导出  表 anna-xxgk.t_role_resources 结构
CREATE TABLE IF NOT EXISTS `t_role_resources` (
  `role_id` int(11) DEFAULT NULL,
  `resources_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-资源表';

-- 正在导出表  anna-xxgk.t_role_resources 的数据：~30 rows (大约)
DELETE FROM `t_role_resources`;
/*!40000 ALTER TABLE `t_role_resources` DISABLE KEYS */;
INSERT INTO `t_role_resources` (`role_id`, `resources_id`) VALUES
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8),
	(1, 9),
	(1, 10),
	(1, 11),
	(1, 13),
	(1, 14),
	(2, 2),
	(2, 3),
	(2, 4),
	(2, 9),
	(3, 2),
	(3, 3),
	(3, 4),
	(3, 5),
	(3, 7),
	(3, 8),
	(3, 9),
	(3, 10),
	(4, 2),
	(4, 5),
	(4, 6),
	(4, 11),
	(4, 14),
	(9, 9);
/*!40000 ALTER TABLE `t_role_resources` ENABLE KEYS */;

-- 导出  表 anna-xxgk.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT '0',
  `pass_word` varchar(50) DEFAULT '0',
  `status` int(1) DEFAULT '1' COMMENT '1-启用 2-暂用 3-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  anna-xxgk.t_user 的数据：~3 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `user_name`, `pass_word`, `status`) VALUES
	(1, 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', 1),
	(2, 'rick', 'rick', 1),
	(3, 'anna', 'anna', 2);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 anna-xxgk.t_user_role 结构
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

-- 正在导出表  anna-xxgk.t_user_role 的数据：~6 rows (大约)
DELETE FROM `t_user_role`;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES
	(23, 2),
	(2, 2),
	(1, 1),
	(1, 2),
	(1, 3),
	(22, 4);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

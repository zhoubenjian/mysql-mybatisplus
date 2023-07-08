-- auth.sys_user definition

CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `salt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '盐值',
  `f1` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段1',
  `f2` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段2',
  `f3` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段3',
  `f4` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段4',
  `f5` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段5',
  `f6` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段6',
  `f7` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段7',
  `enable` tinyint NOT NULL DEFAULT '1' COMMENT '是否可用, 0:冻结；1:可用（默认）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_name` (`user_name`),
  KEY `create_time` (`create_time`),
  KEY `update_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户';
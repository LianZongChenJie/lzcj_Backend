-- ========================================
-- 网站内容管理 - 菜单与权限初始化 SQL
-- 依赖: system_menu 表（已有）
-- ========================================

-- 1. 创建"网站内容管理"目录（一级菜单）
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('网站内容管理', 'site', 1, 100, 0, '/site', 'ep:wrench', NULL, NULL, 1, 1, 0, 0, '1', '1', 0);

-- 获取刚插入的目录ID
SET @parent_id = LAST_INSERT_ID();

-- 2. 创建"底部菜单"子菜单
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('底部菜单', 'site:menu', 2, 10, @parent_id, 'menu', 'ep:menu', 'site/menu/index', 'SiteMenuList', 1, 1, 0, 0, '1', '1', 0);

SET @menu_id = LAST_INSERT_ID();

-- 3. 为"底部菜单"创建按钮权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('底部菜单查询', 'site:menu:query', 3, 1, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('底部菜单新增', 'site:menu:create', 3, 2, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('底部菜单修改', 'site:menu:update', 3, 3, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('底部菜单删除', 'site:menu:delete', 3, 4, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

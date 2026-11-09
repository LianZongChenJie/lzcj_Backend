-- ========================================
-- 技术服务 - 菜单与权限初始化 SQL
-- 依赖: system_menu 表（"网站内容管理"目录已存在，permission='site'）
-- 说明:
--   1. 管理端接口统一使用权限 'site:content'（见 site_content_permission.sql），本脚本仅注册模块菜单
--   2. 页面统一在 运营管理 -> 网站内容管理（operations/maintenance）中维护，无需独立页面路由
--   3. 可重复执行（先删后插）
-- ========================================

-- 定位"网站内容管理"目录
SET @parent_id = (SELECT id FROM system_menu WHERE permission = 'site' AND type = 1 LIMIT 1);

-- 清理旧数据（便于重复执行）
DELETE FROM system_menu
WHERE permission IN ('site:tech-service', 'site:tech-service:query',
                    'site:tech-service:create', 'site:tech-service:update', 'site:tech-service:delete');

-- 1. "技术服务管理"菜单
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('技术服务管理', 'site:tech-service', 2, 90, @parent_id, 'tech-service', 'ep:tools', 'site/tech-service/index', 'SiteTechServiceList', 1, 1, 0, 0, '1', '1', 0);

SET @menu_id = LAST_INSERT_ID();

-- 2. 按钮权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('技术服务查询', 'site:tech-service:query', 3, 1, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('技术服务新增', 'site:tech-service:create', 3, 2, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('技术服务修改', 'site:tech-service:update', 3, 3, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('技术服务删除', 'site:tech-service:delete', 3, 4, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

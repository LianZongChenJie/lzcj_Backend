-- ========================================
-- 解决方案 - 菜单与权限初始化 SQL
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
WHERE permission IN ('site:solution', 'site:solution:query',
                    'site:solution:create', 'site:solution:update', 'site:solution:delete');

-- 1. "解决方案管理"菜单
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('解决方案管理', 'site:solution', 2, 80, @parent_id, 'solution', 'ep:tickets', 'site/solution/index', 'SiteSolutionList', 1, 1, 0, 0, '1', '1', 0);

SET @menu_id = LAST_INSERT_ID();

-- 2. 按钮权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('解决方案查询', 'site:solution:query', 3, 1, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('解决方案新增', 'site:solution:create', 3, 2, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('解决方案修改', 'site:solution:update', 3, 3, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('解决方案删除', 'site:solution:delete', 3, 4, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

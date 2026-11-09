-- ========================================
-- 发展历程 - 菜单与权限初始化 SQL
-- 依赖: system_menu 表（"网站内容管理"目录已存在，permission='site'）
-- 说明: 可重复执行（先删后插）
-- ========================================

-- 定位"网站内容管理"目录
SET @parent_id = (SELECT id FROM system_menu WHERE permission = 'site' AND type = 1 LIMIT 1);

-- 清理旧数据（便于重复执行）
DELETE FROM system_menu
WHERE permission IN ('site:company-milestone', 'site:company-milestone:query',
                    'site:company-milestone:create', 'site:company-milestone:update', 'site:company-milestone:delete');

-- 1. "发展历程管理"菜单
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('发展历程管理', 'site:company-milestone', 2, 30, @parent_id, 'company-milestone', 'ep:time', 'site/company-milestone/index', 'SiteCompanyMilestoneList', 1, 1, 0, 0, '1', '1', 0);

SET @menu_id = LAST_INSERT_ID();

-- 2. 按钮权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('发展历程查询', 'site:company-milestone:query', 3, 1, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('发展历程新增', 'site:company-milestone:create', 3, 2, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('发展历程修改', 'site:company-milestone:update', 3, 3, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('发展历程删除', 'site:company-milestone:delete', 3, 4, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

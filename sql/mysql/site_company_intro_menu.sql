-- ========================================
-- 公司介绍 - 菜单与权限初始化 SQL
-- 依赖: system_menu 表（"网站内容管理"目录已存在，permission='site'）
-- 说明: 可重复执行（先删后插）
-- ========================================

-- 定位"网站内容管理"目录
SET @parent_id = (SELECT id FROM system_menu WHERE permission = 'site' AND type = 1 LIMIT 1);

-- 清理旧数据（便于重复执行）
DELETE FROM system_menu
WHERE permission IN ('site:company-intro', 'site:company-intro:query',
                    'site:company-intro:create', 'site:company-intro:update', 'site:company-intro:delete');

-- 1. "公司介绍管理"菜单
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('公司介绍管理', 'site:company-intro', 2, 20, @parent_id, 'company-intro', 'ep:office-building', 'site/company-intro/index', 'SiteCompanyIntroList', 1, 1, 0, 0, '1', '1', 0);

SET @menu_id = LAST_INSERT_ID();

-- 2. 按钮权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('公司介绍查询', 'site:company-intro:query', 3, 1, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('公司介绍新增', 'site:company-intro:create', 3, 2, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('公司介绍修改', 'site:company-intro:update', 3, 3, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('公司介绍删除', 'site:company-intro:delete', 3, 4, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

-- ========================================
-- 资质荣誉 - 菜单与权限初始化 SQL
-- 依赖: system_menu 表（"网站内容管理"目录已存在，permission='site'）
-- 说明: 可重复执行（先删后插）
-- ========================================

-- 定位"网站内容管理"目录
SET @parent_id = (SELECT id FROM system_menu WHERE permission = 'site' AND type = 1 LIMIT 1);

-- 清理旧数据（便于重复执行）
DELETE FROM system_menu
WHERE permission IN ('site:honor', 'site:honor:query',
                    'site:honor:create', 'site:honor:update', 'site:honor:delete');

-- 1. "资质荣誉管理"菜单
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('资质荣誉管理', 'site:honor', 2, 60, @parent_id, 'honor', 'ep:trophy', 'site/honor/index', 'SiteHonorList', 1, 1, 0, 0, '1', '1', 0);

SET @menu_id = LAST_INSERT_ID();

-- 2. 按钮权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('资质荣誉查询', 'site:honor:query', 3, 1, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('资质荣誉新增', 'site:honor:create', 3, 2, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('资质荣誉修改', 'site:honor:update', 3, 3, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('资质荣誉删除', 'site:honor:delete', 3, 4, @menu_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

-- 3. 授权给运营角色（tenant_id=1, role_id=160）
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `tenant_id`, `creator`, `updater`, `deleted`)
SELECT 160, m.id, 1, '1', '1', 0
FROM system_menu m
WHERE m.permission IN ('site:honor', 'site:honor:query', 'site:honor:create', 'site:honor:update', 'site:honor:delete')
  AND NOT EXISTS (
      SELECT 1 FROM system_role_menu rm WHERE rm.role_id = 160 AND rm.menu_id = m.id AND rm.deleted = 0
  );

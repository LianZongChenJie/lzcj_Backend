-- ========================================
-- 网站内容管理 - 统一权限初始化 SQL（一次性执行）
-- 依赖: system_menu / system_role_menu 表
-- 说明:
--   1. site 模块所有管理端接口统一使用权限 'site:content'（类级注解）
--   2. 新增内容模块时【无需】再配置任何按钮权限，只需执行本脚本授权一次
--   3. 可重复执行（幂等）
-- ========================================

-- 定位"网站内容管理"目录
SET @parent_id = (SELECT id FROM system_menu WHERE permission = 'site' AND type = 1 LIMIT 1);

-- 清理旧记录（便于重复执行）
DELETE FROM system_role_menu WHERE menu_id IN (
    SELECT id FROM system_menu WHERE permission = 'site:content'
);
DELETE FROM system_menu WHERE permission = 'site:content';

-- 1. 统一权限："网站内容管理"- 操作权限
INSERT INTO `system_menu` (`name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `updater`, `deleted`)
VALUES ('网站内容管理操作权限', 'site:content', 3, 0, @parent_id, '', '', '', '', 1, 1, 0, 0, '1', '1', 0);

-- 2. 授权给运营角色（role_id=160, tenant_id=1）
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `tenant_id`, `creator`, `updater`, `deleted`)
SELECT 160, m.id, 1, '1', '1', 0
FROM system_menu m
WHERE m.permission = 'site:content'
  AND NOT EXISTS (
      SELECT 1 FROM system_role_menu rm WHERE rm.role_id = 160 AND rm.menu_id = m.id AND rm.deleted = 0
  );

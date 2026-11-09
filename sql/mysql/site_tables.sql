-- ========================================
-- 网站展示内容管理 - site_ 业务表结构
-- 依据《网站展示内容数据库设计文档.md》生成
-- 数据库: MySQL 5.7+（utf8mb4 / InnoDB）
-- 说明:
--   1. 不含 site_banner（已存在，由 site_banner_menu.sql 等维护）
--   2. 统一补齐 BaseDO 审计字段 creator/updater，对齐芋道 BaseDO 映射
--   3. 全部使用 CREATE TABLE IF NOT EXISTS，可重复执行
-- ========================================

-- 2. 公司介绍表（版本管理：status=1 且 version 最大的一条为当前生效版本）
CREATE TABLE IF NOT EXISTS `site_company_intro` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `description` text NOT NULL COMMENT '公司介绍文本',
    `images` json DEFAULT NULL COMMENT '公司风采图片列表（JSON数组）',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司介绍表';

-- 3. 发展历程表
CREATE TABLE IF NOT EXISTS `site_milestone` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `year` smallint(6) NOT NULL COMMENT '年份',
    `title` varchar(200) NOT NULL COMMENT '事件标题',
    `description` text COMMENT '事件描述',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_year` (`year`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发展历程表';

-- 4. 企业文化表（版本管理：status=1 且 version 最大的一条为当前生效版本）
CREATE TABLE IF NOT EXISTS `site_company_culture` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `mission` varchar(500) DEFAULT NULL COMMENT '使命',
    `vision` varchar(500) DEFAULT NULL COMMENT '愿景',
    `core_values` varchar(200) DEFAULT NULL COMMENT '价值观',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='企业文化表';

-- 5. 员工风采表
CREATE TABLE IF NOT EXISTS `site_team_gallery` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `image` varchar(500) NOT NULL COMMENT '图片URL',
    `description` varchar(500) DEFAULT NULL COMMENT '图片描述',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工风采表';

-- 6. 资质荣誉表
CREATE TABLE IF NOT EXISTS `site_honor` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(200) NOT NULL COMMENT '荣誉/资质名称',
    `image` varchar(500) NOT NULL COMMENT '证书图片URL',
    `type` varchar(20) NOT NULL COMMENT '类型：qualification-资质，award-荣誉',
    `date` varchar(10) DEFAULT NULL COMMENT '获得年份',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_type` (`type`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资质荣誉表';

-- 7. 产品表
CREATE TABLE IF NOT EXISTS `site_product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(200) NOT NULL COMMENT '产品名称',
    `image` varchar(500) NOT NULL COMMENT '产品图片URL',
    `type` varchar(20) NOT NULL COMMENT '类型：self-自研，agent-代理',
    `summary` varchar(500) DEFAULT NULL COMMENT '产品摘要',
    `description` text COMMENT '产品详细描述',
    `features` json DEFAULT NULL COMMENT '核心特性列表（JSON数组）',
    `scenarios` json DEFAULT NULL COMMENT '适用场景列表（JSON数组）',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_type` (`type`),
    KEY `idx_status` (`status`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

-- 8. 解决方案表
CREATE TABLE IF NOT EXISTS `site_solution` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(200) NOT NULL COMMENT '方案名称',
    `image` varchar(500) NOT NULL COMMENT '方案图片URL',
    `industry` varchar(50) NOT NULL COMMENT '所属行业',
    `summary` varchar(500) DEFAULT NULL COMMENT '方案摘要',
    `description` text COMMENT '方案详细描述',
    `demand_analysis` text COMMENT '需求分析',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_industry` (`industry`),
    KEY `idx_status` (`status`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='解决方案表';

-- 9. 技术服务表
CREATE TABLE IF NOT EXISTS `site_tech_service` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `industry` varchar(50) NOT NULL COMMENT '服务行业',
    `icon` varchar(50) DEFAULT NULL COMMENT '图标标识（Remix Icon 类名）',
    `description` text COMMENT '服务描述',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_industry` (`industry`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='技术服务表';

-- 10. 新闻表
CREATE TABLE IF NOT EXISTS `site_news` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `title` varchar(200) NOT NULL COMMENT '新闻标题',
    `cover` varchar(500) DEFAULT NULL COMMENT '封面图片URL',
    `summary` varchar(500) DEFAULT NULL COMMENT '新闻摘要',
    `content` longtext COMMENT '新闻正文',
    `author` varchar(50) DEFAULT NULL COMMENT '作者',
    `publish_date` date DEFAULT NULL COMMENT '发布日期',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-草稿，1-已发布',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_publish_date` (`publish_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='新闻表';

-- 11. 公告表
CREATE TABLE IF NOT EXISTS `site_announcement` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `title` varchar(200) NOT NULL COMMENT '公告标题',
    `summary` varchar(500) DEFAULT NULL COMMENT '公告摘要',
    `content` longtext COMMENT '公告正文',
    `important` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否重要：0-否，1-是',
    `publish_date` date DEFAULT NULL COMMENT '发布日期',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-草稿，1-已发布',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_important` (`important`),
    KEY `idx_publish_date` (`publish_date`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公告表';

-- 12. 招聘职位表
CREATE TABLE IF NOT EXISTS `site_job` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `title` varchar(200) NOT NULL COMMENT '职位名称',
    `location` varchar(50) NOT NULL COMMENT '工作地点',
    `department` varchar(50) DEFAULT NULL COMMENT '所属部门',
    `type` varchar(20) NOT NULL COMMENT '工作类型：全职/兼职/实习',
    `urgent` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否急聘：0-否，1-是',
    `responsibilities` json DEFAULT NULL COMMENT '岗位职责列表（JSON数组）',
    `requirements` json DEFAULT NULL COMMENT '任职要求列表（JSON数组）',
    `headcount` int(11) NOT NULL DEFAULT 1 COMMENT '招聘人数',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-关闭，1-招聘中',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_location` (`location`),
    KEY `idx_urgent` (`urgent`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='招聘职位表';

-- 13. 分公司联系方式表
CREATE TABLE IF NOT EXISTS `site_branch_contact` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `city` varchar(50) NOT NULL COMMENT '城市名称（分公司名称）',
    `address` varchar(500) NOT NULL COMMENT '详细地址',
    `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
    `postal_code` varchar(10) DEFAULT NULL COMMENT '邮政编码',
    `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
    `theme_color` varchar(20) DEFAULT NULL COMMENT '主题色（用于前端展示）',
    `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序号',
    `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `creator` varchar(64) DEFAULT '' COMMENT '创建者',
    `updater` varchar(64) DEFAULT '' COMMENT '更新者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_city` (`city`),
    KEY `idx_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分公司联系方式表';

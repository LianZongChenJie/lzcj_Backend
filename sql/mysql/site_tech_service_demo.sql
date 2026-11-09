-- ========================================
-- 技术服务 - 演示数据初始化 SQL
-- 依赖: site_tech_service 表（site_tables.sql）
-- 说明:
--   1. 与展示端 lianzong/src/data/business.json 的 techServices 保持一致
--   2. 展示端优先请求 /cms/api/tech-services 接口，接口异常时降级读取 business.json
--   3. 可重复执行（先删后插）
-- ========================================

DELETE FROM `site_tech_service`;

-- 1. 政务
INSERT INTO `site_tech_service` (`industry`, `icon`, `description`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('政务', 'ri-government-line', '提供政务信息化规划、系统开发、数据整合、运维保障等全流程技术服务。', 1, 1, '1', '1', NOW(), NOW(), 0);

-- 2. 教育
INSERT INTO `site_tech_service` (`industry`, `icon`, `description`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('教育', 'ri-book-read-line', '为教育机构提供智慧校园建设、教学平台开发、在线学习系统部署等服务。', 2, 1, '1', '1', NOW(), NOW(), 0);

-- 3. 医疗
INSERT INTO `site_tech_service` (`industry`, `icon`, `description`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('医疗', 'ri-heart-pulse-line', '面向医疗健康行业的信息系统建设、数据管理、远程医疗等技术服务。', 3, 1, '1', '1', NOW(), NOW(), 0);

-- 4. 金融
INSERT INTO `site_tech_service` (`industry`, `icon`, `description`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('金融', 'ri-bank-line', '为金融机构提供核心系统建设、安全合规、数据风控等专业技术服务。', 4, 1, '1', '1', NOW(), NOW(), 0);

-- 5. 制造业
INSERT INTO `site_tech_service` (`industry`, `icon`, `description`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('制造业', 'ri-settings-3-line', '智能制造领域的系统集成、工业互联网、生产管理平台建设等技术服务。', 5, 1, '1', '1', NOW(), NOW(), 0);

-- 6. 服务业
INSERT INTO `site_tech_service` (`industry`, `icon`, `description`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('服务业', 'ri-service-line', '为企业提供CRM、ERP、供应链管理等系统的咨询、开发和部署服务。', 6, 1, '1', '1', NOW(), NOW(), 0);

-- ========================================
-- 解决方案 - 演示数据初始化 SQL
-- 依赖: site_solution 表（site_tables.sql）
-- 说明:
--   1. 与展示端 lianzong/src/data/business.json 的 solutions 保持一致
--   2. 展示端优先请求 /cms/api/solutions 接口，接口异常时降级读取 business.json
--   3. 可重复执行（先删后插）
-- ========================================

DELETE FROM `site_solution`;

-- 1. 智慧政务解决方案
INSERT INTO `site_solution` (`name`, `image`, `industry`, `summary`, `description`, `demand_analysis`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('智慧政务解决方案', 'https://images.unsplash.com/photo-1454165804606-c3d57bc86b40?w=400&h=300&fit=crop', '政务',
        '面向政府机构的数字化转型方案',
        '以政务服务数字化为核心，打造高效便民的智慧政务管理体系。',
        '政务服务面临效率提升、流程优化、数据互通等核心需求，需要一体化数字平台支撑。',
        1, 1, '1', '1', NOW(), NOW(), 0);

-- 2. 智慧教育解决方案
INSERT INTO `site_solution` (`name`, `image`, `industry`, `summary`, `description`, `demand_analysis`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('智慧教育解决方案', 'https://images.unsplash.com/photo-1503676260728-1c00da094a0b?w=400&h=300&fit=crop', '教育',
        '构建智慧教育生态体系',
        '覆盖教学管理、在线学习、校园管理等教育全场景的综合解决方案。',
        '教育行业面临教学方式变革、管理效率提升、资源共享等挑战，需要数字化手段赋能。',
        2, 1, '1', '1', NOW(), NOW(), 0);

-- 3. 智慧医疗解决方案
INSERT INTO `site_solution` (`name`, `image`, `industry`, `summary`, `description`, `demand_analysis`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('智慧医疗解决方案', 'https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=400&h=300&fit=crop', '医疗',
        '医疗健康数字化升级方案',
        '面向医院、诊所、健康管理机构的信息化整体解决方案。',
        '医疗行业在信息化管理、远程诊疗、健康数据管理等方面存在强烈需求。',
        3, 1, '1', '1', NOW(), NOW(), 0);

-- 4. 智慧金融解决方案
INSERT INTO `site_solution` (`name`, `image`, `industry`, `summary`, `description`, `demand_analysis`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`)
VALUES ('智慧金融解决方案', 'https://images.unsplash.com/photo-1563986768609-322da13575f2?w=400&h=300&fit=crop', '金融',
        '金融行业数字化整体方案',
        '为银行、保险、证券等金融机构提供安全可靠的数字化基础设施和应用方案。',
        '金融行业对数据安全、业务连续性、风控能力有极高要求，需要专业技术支撑。',
        4, 1, '1', '1', NOW(), NOW(), 0);

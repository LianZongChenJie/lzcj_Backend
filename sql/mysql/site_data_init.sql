-- ========================================
-- 网站展示内容 - 全量数据初始化脚本
-- 用途: 清空所有 site_ 业务表，并将展示端 JSON 数据写入数据库
-- 数据源: lianzong/src/data/home.json / business.json / news.json / join.json
-- 数据库: MySQL 5.7+（utf8mb4 / InnoDB）
-- 执行方式:
--   mysql -h 211.149.169.81 -P 3306 -u lzcj_gw -p lzcj_gw < site_data_init.sql
-- 说明:
--   1. 先 DELETE 清空 13 张业务表（含逻辑删除数据一并清除）
--   2. 再按展示端 JSON 内容全量插入
--   3. 脚本可重复执行
-- ========================================

SET NAMES utf8mb4;

-- ---------- 1. 清空所有业务表 ----------
DELETE FROM site_banner;
DELETE FROM site_company_intro;
DELETE FROM site_milestone;
DELETE FROM site_company_culture;
DELETE FROM site_team_gallery;
DELETE FROM site_honor;
DELETE FROM site_product;
DELETE FROM site_solution;
DELETE FROM site_tech_service;
DELETE FROM site_news;
DELETE FROM site_announcement;
DELETE FROM site_job;
DELETE FROM site_branch_contact;

-- ---------- 2. 插入数据 ----------

-- 2.1 Banner 轮播（home.json → banners）
INSERT INTO site_banner (image, title, subtitle, sort, status, creator, updater, create_time, update_time, deleted) VALUES
('https://images.unsplash.com/photo-1497366216548-37526070297c?w=1920&h=800&fit=crop', '北京联纵宸捷科技股份有限公司', '专业 · 创新 · 共赢 — 您值得信赖的技术合作伙伴', 1, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=1920&h=800&fit=crop', '科技创新 驱动未来', '以技术为核心，为企业提供一流的解决方案与服务', 2, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1504384308090-c894fdcc538d?w=1920&h=800&fit=crop', '携手共进 创造价值', '多地域服务网络，北京、天津、成都、云南全覆盖', 3, 1, '1', '1', NOW(), NOW(), 0);

-- 2.2 公司介绍（home.json → companyIntro）
INSERT INTO site_company_intro (description, images, version, status, creator, updater, create_time, update_time, deleted) VALUES
('北京联纵宸捷科技股份有限公司，简称：联纵宸捷，公司致力于通过IT技术服务为更多的金融机构、国有企业、大型互联企业及上市公司及中小型民营企业提供国产化软件的落地，为国内企业的信息化自立、自强和转型升级提供科技力量。公司所提供的服务包括：软件项目外包、软件咨询、软件定制化开发、软件人才服务、IT系统集成、IT系统运维等服务。

公司目前的服务辐射北京、上海、广州、深圳、杭州、辽宁、重庆、成都等相关区域。主要实施的项目包括企业内部管理系统、大数据处理与分析、应用监控系统、电子商务系统、云跨行资金管理系统、元数据管理系统、运营管理平台、移动应用等。

公司拥有软件能力成熟度模型CMMI3的资质以及ISO9001、ISO27001、ISO20000、ISO14001、ISO45001等多项行业标准认证资质和二十多项软件著作权。

公司的经营理念：联合起来更多优秀的IT人才，纵向把行业服务做精、做深；横向把行业客户做宽、做广；做专业服务与企业国产化落地的IT服务提供商。',
 '["/images/gongsi3.jpg","/images/gongsi4.jpg"]',
 1, 1, '1', '1', NOW(), NOW(), 0);

-- 2.3 发展历程（home.json → milestones）
INSERT INTO site_milestone (year, title, description, sort, status, creator, updater, create_time, update_time, deleted) VALUES
(2020, '公司成立', '北京联纵宸捷科技有限公司在北京正式成立', 1, 1, '1', '1', NOW(), NOW(), 0),
(2021, '业务拓展', '天津分公司成立，业务版图扩展至华北区域', 2, 1, '1', '1', NOW(), NOW(), 0),
(2022, '产品自研', '自研产品矩阵初步完成，获得多项自主知识产权', 3, 1, '1', '1', NOW(), NOW(), 0),
(2023, '全国布局', '成都分公司成立，西南地区业务全面启动', 4, 1, '1', '1', NOW(), NOW(), 0),
(2024, '资质升级', '获得行业核心资质证书，服务能力全面升级', 5, 1, '1', '1', NOW(), NOW(), 0),
(2025, '深化发展', '云南分公司成立，服务网络覆盖全国四大区域', 6, 1, '1', '1', NOW(), NOW(), 0),
(2026, '持续创新', '全面推动数字化升级，以创新引领高质量发展', 7, 1, '1', '1', NOW(), NOW(), 0);

-- 2.4 企业文化（home.json → culture）
INSERT INTO site_company_culture (mission, vision, core_values, version, status, creator, updater, create_time, update_time, deleted) VALUES
('以技术创新为客户创造价值，以优质服务推动行业进步',
 '成为行业内领先的科技与解决方案提供商',
 '专业、创新、协作、共赢',
 1, 1, '1', '1', NOW(), NOW(), 0);

-- 2.5 员工风采（home.json → teamGallery.items）
INSERT INTO site_team_gallery (image, description, sort, status, creator, updater, create_time, update_time, deleted) VALUES
('https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=400&h=300&fit=crop', '项目启动会上，团队共同探讨方案架构，集思广益确定技术路线。', 1, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1517245386807-bb43f82c33c4?w=400&h=300&fit=crop', '新老成员结对编程协作，在实际项目中传帮带，促进新人快速成长。', 2, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1553877522-43269d4ea984?w=400&h=300&fit=crop', '团队成员奋战在项目交付一线，用专业和汗水保障每一个里程碑。', 3, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1531482615713-2afd69097998?w=400&h=300&fit=crop', '定期技术分享会，每个人既是讲师也是学生，共同学习进步。', 4, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1497215842964-222b430dc094?w=400&h=300&fit=crop', '团队建设活动增进默契，轻松愉快的氛围让工作更有激情与活力。', 5, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1515187029135-18ee286d815b?w=400&h=300&fit=crop', '产品评审过程中激烈讨论，碰撞出灵感的火花，打磨更优秀的体验。', 6, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1475721027785-f74eccf877e2?w=400&h=300&fit=crop', '每一次头脑风暴，都凝聚着团队智慧，为客户创造更大价值。', 7, 1, '1', '1', NOW(), NOW(), 0),
('https://images.unsplash.com/photo-1552664730-d307ca884978?w=400&h=300&fit=crop', '团队合影记录奋斗时光，携手共进，一起迈向更广阔的未来。', 8, 1, '1', '1', NOW(), NOW(), 0);

-- 2.6 资质荣誉（home.json → honors）
INSERT INTO site_honor (name, image, type, date, sort, status, creator, updater, create_time, update_time, deleted) VALUES
('ISO 9001质量管理体系认证', '/images/001.png', 'qualification', '2023', 1, 1, '1', '1', NOW(), NOW(), 0),
('信息安全等级保护三级认证', '/images/002.png', 'qualification', '2024', 2, 1, '1', '1', NOW(), NOW(), 0),
('高新技术企业认定', '/images/003.png', 'qualification', '2023', 3, 1, '1', '1', NOW(), NOW(), 0),
('行业优秀解决方案奖', '/images/004.png', 'award', '2024', 4, 1, '1', '1', NOW(), NOW(), 0),
('最佳创新奖', '/images/009.png', 'award', '2025', 5, 1, '1', '1', NOW(), NOW(), 0),
('客户满意度标杆企业', '/images/010.png', 'award', '2025', 6, 1, '1', '1', NOW(), NOW(), 0);

-- 2.7 产品（business.json → selfProducts / agentProducts）
INSERT INTO site_product (name, image, type, summary, description, features, scenarios, sort, status, creator, updater, create_time, update_time, deleted) VALUES
-- 自研产品
('联纵智能管理平台',
 'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=400&h=300&fit=crop',
 'self',
 '一站式企业智能化管理平台',
 '联纵智能管理平台是面向企业数字化转型的综合性管理解决方案，涵盖项目管理、流程审批、数据分析等核心功能。',
 '["可视化管理", "流程自动化", "数据驾驶舱", "移动端支持"]',
 '["中大型企业", "政府机构", "事业单位"]',
 1, 1, '1', '1', NOW(), NOW(), 0),
('协同办公系统',
 'https://images.unsplash.com/photo-1553877522-43269d4ea984?w=400&h=300&fit=crop',
 'self',
 '高效协同办公解决方案',
 '提供即时通讯、文档协同、日程管理、会议管理等全方位办公协同能力，让团队协作更高效。',
 '["即时通讯", "文档协同", "视频会议", "日程管理"]',
 '["中小企业", "远程办公团队", "项目协作"]',
 2, 1, '1', '1', NOW(), NOW(), 0),
('数据分析引擎',
 'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=400&h=300&fit=crop',
 'self',
 '智能数据分析与决策支持',
 '基于大数据技术的数据分析引擎，提供数据采集、清洗、分析和可视化一站式服务。',
 '["实时分析", "可视化报表", "预测模型", "自定义仪表盘"]',
 '["数据驱动决策", "业务监控", "市场分析"]',
 3, 1, '1', '1', NOW(), NOW(), 0),
-- 代理产品
('云计算基础设施',
 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=400&h=300&fit=crop',
 'agent',
 '弹性云计算服务',
 '提供稳定可靠的云服务器、云存储、云数据库等基础设施服务，支持弹性扩容。',
 '["弹性扩容", "高可用架构", "安全防护", "7×24监控"]',
 '["企业上云", "互联网应用", "数据备份"]',
 1, 1, '1', '1', NOW(), NOW(), 0),
('网络安全防护套件',
 'https://images.unsplash.com/photo-1555949963-ff9fe0c870eb?w=400&h=300&fit=crop',
 'agent',
 '全方位网络安全解决方案',
 '包含防火墙、入侵检测、安全审计、应急响应等安全能力的一体化防护方案。',
 '["威胁检测", "安全审计", "应急响应", "合规支持"]',
 '["企业安全", "合规等保", "数据保护"]',
 2, 1, '1', '1', NOW(), NOW(), 0),
('AI智能服务平台',
 'https://images.unsplash.com/photo-1677442136019-21780ecad995?w=400&h=300&fit=crop',
 'agent',
 '人工智能赋能平台',
 '提供自然语言处理、图像识别、智能客服等AI能力，帮助企业快速实现智能化升级。',
 '["NLP处理", "图像识别", "智能客服", "知识图谱"]',
 '["智能客服", "文档审核", "图像分析"]',
 3, 1, '1', '1', NOW(), NOW(), 0);

-- 2.8 解决方案（business.json → solutions）
INSERT INTO site_solution (name, image, industry, summary, description, demand_analysis, sort, status, creator, updater, create_time, update_time, deleted) VALUES
('智慧政务解决方案', 'https://images.unsplash.com/photo-1454165804606-c3d57bc86b40?w=400&h=300&fit=crop', '政务',
 '面向政府机构的数字化转型方案',
 '以政务服务数字化为核心，打造高效便民的智慧政务管理体系。',
 '政务服务面临效率提升、流程优化、数据互通等核心需求，需要一体化数字平台支撑。',
 1, 1, '1', '1', NOW(), NOW(), 0),
('智慧教育解决方案', 'https://images.unsplash.com/photo-1503676260728-1c00da094a0b?w=400&h=300&fit=crop', '教育',
 '构建智慧教育生态体系',
 '覆盖教学管理、在线学习、校园管理等教育全场景的综合解决方案。',
 '教育行业面临教学方式变革、管理效率提升、资源共享等挑战，需要数字化手段赋能。',
 2, 1, '1', '1', NOW(), NOW(), 0),
('智慧医疗解决方案', 'https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=400&h=300&fit=crop', '医疗',
 '医疗健康数字化升级方案',
 '面向医院、诊所、健康管理机构的信息化整体解决方案。',
 '医疗行业在信息化管理、远程诊疗、健康数据管理等方面存在强烈需求。',
 3, 1, '1', '1', NOW(), NOW(), 0),
('智慧金融解决方案', 'https://images.unsplash.com/photo-1563986768609-322da13575f2?w=400&h=300&fit=crop', '金融',
 '金融行业数字化整体方案',
 '为银行、保险、证券等金融机构提供安全可靠的数字化基础设施和应用方案。',
 '金融行业对数据安全、业务连续性、风控能力有极高要求，需要专业技术支撑。',
 4, 1, '1', '1', NOW(), NOW(), 0);

-- 2.9 技术服务（business.json → techServices）
INSERT INTO site_tech_service (industry, icon, description, sort, status, creator, updater, create_time, update_time, deleted) VALUES
('政务', 'ri-government-line', '提供政务信息化规划、系统开发、数据整合、运维保障等全流程技术服务。', 1, 1, '1', '1', NOW(), NOW(), 0),
('教育', 'ri-book-read-line', '为教育机构提供智慧校园建设、教学平台开发、在线学习系统部署等服务。', 2, 1, '1', '1', NOW(), NOW(), 0),
('医疗', 'ri-heart-pulse-line', '面向医疗健康行业的信息系统建设、数据管理、远程医疗等技术服务。', 3, 1, '1', '1', NOW(), NOW(), 0),
('金融', 'ri-bank-line', '为金融机构提供核心系统建设、安全合规、数据风控等专业技术服务。', 4, 1, '1', '1', NOW(), NOW(), 0),
('制造业', 'ri-settings-3-line', '智能制造领域的系统集成、工业互联网、生产管理平台建设等技术服务。', 5, 1, '1', '1', NOW(), NOW(), 0),
('服务业', 'ri-service-line', '为企业提供CRM、ERP、供应链管理等系统的咨询、开发和部署服务。', 6, 1, '1', '1', NOW(), NOW(), 0);

-- 2.10 新闻（news.json → news）
INSERT INTO site_news (title, cover, summary, content, author, publish_date, status, creator, updater, create_time, update_time, deleted) VALUES
('公司荣获2025年度行业优秀解决方案奖',
 'https://images.unsplash.com/photo-1557804506-669a67965ba0?w=600&h=400&fit=crop',
 '在2025年度行业评选中，公司凭借智慧政务解决方案荣获优秀解决方案奖。',
 '近日，在2025年度行业科技创新评选活动中，北京联纵宸捷科技有限公司凭借智慧政务解决方案的突出表现，荣获年度优秀解决方案奖。此次评选由行业协会主办，旨在鼓励和表彰在科技创新方面做出突出贡献的企业。公司智慧政务解决方案自推出以来，已服务于多个政府部门和企事业单位，获得客户的一致好评。未来，公司将继续加大研发投入，不断提升产品和服务质量，为客户提供更优质的解决方案。',
 '公司新闻部', '2025-10-15', 1, '1', '1', NOW(), NOW(), 0),
('云南分公司正式成立，全国布局再进一步',
 'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=600&h=400&fit=crop',
 '云南分公司正式成立运营，标志着公司全国服务网络覆盖战略的稳步推进。',
 '2025年8月20日，北京联纵宸捷科技有限公司云南分公司在昆明正式成立。云南分公司的成立是公司全国化战略的重要一步，将进一步增强公司在西南地区的市场覆盖能力和服务响应速度。云南分公司将依托总部的技术优势和资源积累，为当地客户提供全方位的解决方案和技术支持，助力西南地区数字化转型升级。',
 '公司新闻部', '2025-08-20', 1, '1', '1', NOW(), NOW(), 0),
('与某高校签署战略合作协议，深化产学研合作',
 'https://images.unsplash.com/photo-1523050854058-8df90110c9f1?w=600&h=400&fit=crop',
 '公司与知名高校签署战略合作协议，共同推进技术创新和人才培养。',
 '2025年6月10日，北京联纵宸捷科技有限公司与某知名高校正式签署战略合作协议。根据协议，双方将在技术创新、人才培养、成果转化等方面展开深度合作。此次合作将充分发挥企业的实践优势与高校的科研优势，推动产学研深度融合，为公司持续发展提供强有力的技术和人才支撑。',
 '公司新闻部', '2025-06-10', 1, '1', '1', NOW(), NOW(), 0),
('公司成功举办2025年度产品发布会',
 'https://images.unsplash.com/photo-1540575467063-178a50c2df87?w=600&h=400&fit=crop',
 '2025年度产品发布会在北京总部成功举办，多款新品精彩亮相。',
 '2025年4月18日，北京联纵宸捷科技有限公司2025年度产品发布会在北京总部成功举办。本次发布会以"创新引领未来"为主题，公司技术团队向与会嘉宾详细介绍了最新研发的智能管理平台和数据分析引擎等产品。来自行业内的合作伙伴、客户代表及媒体朋友共同见证了这一重要时刻。',
 '公司新闻部', '2025-04-18', 1, '1', '1', NOW(), NOW(), 0);

-- 2.11 公告（news.json → announcements）
INSERT INTO site_announcement (title, summary, content, important, publish_date, status, creator, updater, create_time, update_time, deleted) VALUES
('关于2025年国庆节放假安排的通知',
 '现将2025年国庆节放假安排通知如下。',
 '根据国家关于2025年国庆节放假安排的相关规定，结合公司实际情况，现将放假安排通知如下：10月1日至10月7日放假调休，共7天。9月28日（星期日）、10月11日（星期六）上班。请各部门做好假期期间的安全值班安排，确保联络畅通。',
 1, '2025-09-25', 1, '1', '1', NOW(), NOW(), 0),
('公司办公地址变更公告',
 '因业务发展需要，公司总部办公地址已搬迁至新址。',
 '尊敬的合作伙伴：因公司业务发展需要，自2025年7月15日起，公司北京总部已搬迁至新的办公地址。新地址：北京市朝阳区科技园区XX大厦XX层。联系电话保持不变，欢迎各位合作伙伴莅临指导。',
 1, '2025-07-15', 1, '1', '1', NOW(), NOW(), 0),
('关于开展2025年度员工培训的通知',
 '为提升员工专业技能，公司将开展2025年度系列培训活动。',
 '为提升公司员工的专业技能与综合素质，人力资源部将组织开展2025年度系列培训活动。培训内容包括专业技术提升、管理能力培养、职业素养训练等方面。请各部门按照培训计划安排，组织员工积极参加。',
 0, '2025-05-08', 1, '1', '1', NOW(), NOW(), 0),
('2025年度社会责任报告发布',
 '公司正式发布2025年度社会责任报告，全面回顾公司在履行社会责任方面的成果。',
 '北京联纵宸捷科技有限公司正式发布2025年度社会责任报告。报告全面回顾了公司在环境保护、员工关怀、公益慈善、技术创新等方面的工作成果和未来规划。作为一家有社会责任感的企业，公司将继续秉持可持续发展理念，积极履行社会责任。',
 0, '2025-03-20', 1, '1', '1', NOW(), NOW(), 0);

-- 2.12 招聘职位（join.json → jobs）
INSERT INTO site_job (title, location, department, type, urgent, responsibilities, requirements, headcount, status, creator, updater, create_time, update_time, deleted) VALUES
('高级前端开发工程师', '北京', '技术部', '全职', 1,
 '["负责公司核心产品的前端开发工作","参与产品需求分析和技术方案设计","优化前端性能，提升用户体验","参与团队技术规范制定和代码评审"]',
 '["本科及以上学历，计算机相关专业","5年以上前端开发经验，精通Vue/React等主流框架","熟悉TypeScript、Webpack/Vite等工具","具备良好的代码规范和团队协作能力"]',
 2, 1, '1', '1', NOW(), NOW(), 0),
('产品经理', '北京', '产品部', '全职', 1,
 '["负责产品规划和需求分析","协调研发、设计等团队推进产品落地","跟踪市场动态和用户需求，持续优化产品","制定产品迭代计划和路线图"]',
 '["本科及以上学历，3年以上产品经理经验","具备优秀的沟通协调能力和项目管理能力","熟悉敏捷开发流程","有ToB产品经验者优先"]',
 1, 1, '1', '1', NOW(), NOW(), 0),
('Java后端开发工程师', '天津', '技术部', '全职', 0,
 '["参与系统后端架构设计和开发","负责接口设计和数据库设计","编写高质量、可维护的代码","协助解决生产环境问题"]',
 '["本科及以上学历，计算机相关专业","3年以上Java开发经验","熟悉Spring Boot、MySQL等技术栈","了解分布式系统设计"]',
 3, 1, '1', '1', NOW(), NOW(), 0),
('销售经理', '成都', '销售部', '全职', 0,
 '["开拓和维护客户关系，完成销售目标","了解客户需求，提供解决方案建议","参与商务谈判和合同签订","收集市场信息和竞品动态"]',
 '["大专及以上学历，2年以上销售经验","具备良好的沟通表达能力和客户服务意识","有IT/软件行业销售经验者优先","能适应出差"]',
 2, 1, '1', '1', NOW(), NOW(), 0),
('UI/UX设计师', '北京', '设计部', '全职', 0,
 '["负责产品的界面设计和交互设计","参与产品用户体验优化","输出设计规范和组件库","配合前端开发实现设计还原"]',
 '["本科及以上学历，设计相关专业","熟练使用Figma、Sketch等设计工具","具备良好的审美能力和用户体验意识","有B端产品设计经验者优先"]',
 1, 1, '1', '1', NOW(), NOW(), 0),
('技术支持工程师', '云南', '运维部', '全职', 0,
 '["负责客户技术支持和问题处理","提供产品部署、调试和培训服务","收集和反馈客户问题与需求","编写技术文档和操作手册"]',
 '["大专及以上学历，计算机相关专业","熟悉Linux系统和网络基础知识","具备良好的客户服务意识和沟通能力","能适应短期出差"]',
 2, 1, '1', '1', NOW(), NOW(), 0),
('实习生（技术方向）', '北京', '技术部', '实习', 0,
 '["参与项目开发和测试工作","学习并掌握公司技术栈","协助团队完成日常开发任务","参与团队技术分享和讨论"]',
 '["本科在读，计算机相关专业","熟悉至少一门编程语言","对软件开发有浓厚兴趣","每周出勤4天以上"]',
 3, 1, '1', '1', NOW(), NOW(), 0);

-- 2.13 分公司联系方式（join.json → contacts）
INSERT INTO site_branch_contact (city, address, phone, postal_code, email, theme_color, sort, status, creator, updater, create_time, update_time, deleted) VALUES
('北京', '北京市丰台区西三环南路14号院首科大厦A座6层', '010-52802789', '100073', 'lianzongchenjie@bjlianzong.com', '#409eff', 1, 1, '1', '1', NOW(), NOW(), 0),
('天津', '天津市滨海新区科技园XX号楼XX层', '022-XXXX-XXXX', '300000', NULL, '#06b6d4', 2, 1, '1', '1', NOW(), NOW(), 0),
('成都', '成都市高新区天府大道XX号XX层', '028-XXXX-XXXX', '610000', NULL, '#10b981', 3, 1, '1', '1', NOW(), NOW(), 0),
('云南', '昆明市高新区科新路XX号XX大厦', '0871-XXXX-XXXX', '650000', NULL, '#f59e0b', 4, 1, '1', '1', NOW(), NOW(), 0);

-- ---------- 3. 验证数据 ----------
SELECT 'site_banner' AS tbl, COUNT(*) AS cnt FROM site_banner
UNION ALL SELECT 'site_company_intro', COUNT(*) FROM site_company_intro
UNION ALL SELECT 'site_milestone', COUNT(*) FROM site_milestone
UNION ALL SELECT 'site_company_culture', COUNT(*) FROM site_company_culture
UNION ALL SELECT 'site_team_gallery', COUNT(*) FROM site_team_gallery
UNION ALL SELECT 'site_honor', COUNT(*) FROM site_honor
UNION ALL SELECT 'site_product', COUNT(*) FROM site_product
UNION ALL SELECT 'site_solution', COUNT(*) FROM site_solution
UNION ALL SELECT 'site_tech_service', COUNT(*) FROM site_tech_service
UNION ALL SELECT 'site_news', COUNT(*) FROM site_news
UNION ALL SELECT 'site_announcement', COUNT(*) FROM site_announcement
UNION ALL SELECT 'site_job', COUNT(*) FROM site_job
UNION ALL SELECT 'site_branch_contact', COUNT(*) FROM site_branch_contact;

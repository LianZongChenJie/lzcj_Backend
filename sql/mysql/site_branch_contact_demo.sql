-- 分公司联系方式演示数据（与展示端 join.json 的 contacts 内容对齐）
INSERT INTO `site_branch_contact` (`city`, `address`, `phone`, `postal_code`, `email`, `theme_color`, `sort`, `status`, `creator`, `updater`, `create_time`, `update_time`, `deleted`) VALUES
('北京', '北京市丰台区西三环南路14号院首科大厦A座6层', '010-52802789', '100073', '<_EMAIL>', '#409eff', 1, 1, '1', '1', NOW(), NOW(), 0),
('天津', '天津市滨海新区科技园XX号楼XX层', '022-XXXX-XXXX', '300000', NULL, '#06b6d4', 2, 1, '1', '1', NOW(), NOW(), 0),
('成都', '成都市高新区天府大道XX号XX层', '028-XXXX-XXXX', '610000', NULL, '#10b981', 3, 1, '1', '1', NOW(), NOW(), 0),
('云南', '昆明市高新区科新路XX号XX大厦', '0871-XXXX-XXXX', '650000', NULL, '#f59e0b', 4, 1, '1', '1', NOW(), NOW(), 0);

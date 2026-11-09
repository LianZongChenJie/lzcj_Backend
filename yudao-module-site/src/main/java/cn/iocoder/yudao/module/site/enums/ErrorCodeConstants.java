package cn.iocoder.yudao.module.site.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Site 错误码枚举类
 *
 * site 系统，使用 1-006-000-000 段
 *
 * @author 联纵宸捷
 */
public class ErrorCodeConstants {

    // ========== Banner 轮播 1-006-000-000 ==========
    public static final ErrorCode Banner_NOT_EXISTS = new ErrorCode(1_006_000_000, "Banner不存在");

    // ========== 公司介绍 1-006-001-000 ==========
    public static final ErrorCode CompanyIntro_NOT_EXISTS = new ErrorCode(1_006_001_000, "公司介绍不存在");

    // ========== 发展历程 1-006-002-000 ==========
    public static final ErrorCode Milestone_NOT_EXISTS = new ErrorCode(1_006_002_000, "发展历程不存在");

    // ========== 企业文化 1-006-003-000 ==========
    public static final ErrorCode Culture_NOT_EXISTS = new ErrorCode(1_006_003_000, "企业文化不存在");

    // ========== 员工风采 1-006-004-000 ==========
    public static final ErrorCode TEAM_GALLERY_NOT_EXISTS = new ErrorCode(1_006_004_000, "员工风采不存在");

    // ========== 资质荣誉 1-006-005-000 ==========
    public static final ErrorCode HONOR_NOT_EXISTS = new ErrorCode(1_006_005_000, "资质荣誉不存在");

    // ========== 新闻 1-006-006-000 ==========
    public static final ErrorCode NEWS_NOT_EXISTS = new ErrorCode(1_006_006_000, "新闻不存在");

    // ========== 公告 1-006-007-000 ==========
    public static final ErrorCode ANNOUNCEMENT_NOT_EXISTS = new ErrorCode(1_006_007_000, "公告不存在");

    // ========== 产品 1-006-008-000 ==========
    public static final ErrorCode PRODUCT_NOT_EXISTS = new ErrorCode(1_006_008_000, "产品不存在");

    // ========== 解决方案 1-006-009-000 ==========
    public static final ErrorCode SOLUTION_NOT_EXISTS = new ErrorCode(1_006_009_000, "解决方案不存在");

    // ========== 技术服务 1-006-010-000 ==========
    public static final ErrorCode TECH_SERVICE_NOT_EXISTS = new ErrorCode(1_006_010_000, "技术服务不存在");

    // ========== 招聘信息 1-006-011-000 ==========
    public static final ErrorCode JOB_NOT_EXISTS = new ErrorCode(1_006_011_000, "招聘职位不存在");

    // ========== 分公司联系方式 1-006-012-000 ==========
    public static final ErrorCode BRANCH_CONTACT_NOT_EXISTS = new ErrorCode(1_006_012_000, "分公司联系方式不存在");

}

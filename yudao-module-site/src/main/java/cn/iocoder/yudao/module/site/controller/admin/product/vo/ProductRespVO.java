package cn.iocoder.yudao.module.site.controller.admin.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 产品 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "产品 响应 VO")
public class ProductRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "产品名称", example = "联纵智能管理平台")
    private String name;

    @Schema(description = "产品图片URL", example = "https://example.com/product.jpg")
    private String image;

    @Schema(description = "类型：self-自研，agent-代理", example = "self")
    private String type;

    @Schema(description = "产品摘要", example = "一站式企业智能化管理平台")
    private String summary;

    @Schema(description = "产品详细描述", example = "面向企业数字化转型的综合性管理解决方案...")
    private String description;

    @Schema(description = "核心特性列表")
    private List<String> features;

    @Schema(description = "适用场景列表")
    private List<String> scenarios;

    @Schema(description = "排序号", example = "1")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    private Integer status;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间", example = "2026-11-06 12:00:00")
    private LocalDateTime createTime;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "更新时间", example = "2026-11-06 12:00:00")
    private LocalDateTime updateTime;

}

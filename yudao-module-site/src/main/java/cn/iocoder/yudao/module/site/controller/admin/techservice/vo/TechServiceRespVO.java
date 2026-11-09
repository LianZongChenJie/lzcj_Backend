package cn.iocoder.yudao.module.site.controller.admin.techservice.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 技术服务 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "技术服务 响应 VO")
public class TechServiceRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "服务行业", example = "政务")
    private String industry;

    @Schema(description = "图标标识（Remix Icon 类名）", example = "ri-government-line")
    private String icon;

    @Schema(description = "服务描述", example = "提供政务信息化规划、系统开发、数据整合、运维保障等全流程技术服务。")
    private String description;

    @Schema(description = "排序号", example = "0")
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

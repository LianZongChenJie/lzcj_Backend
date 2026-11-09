package cn.iocoder.yudao.module.site.controller.admin.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 发展历程 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "发展历程 响应 VO")
public class MilestoneRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "年份", example = "2025")
    private Integer year;

    @Schema(description = "事件标题", example = "公司成立")
    private String title;

    @Schema(description = "事件描述", example = "北京联纵宸捷科技有限公司在北京正式成立")
    private String description;

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

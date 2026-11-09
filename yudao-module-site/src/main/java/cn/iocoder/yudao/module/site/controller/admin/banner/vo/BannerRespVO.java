package cn.iocoder.yudao.module.site.controller.admin.banner.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * Banner 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "Banner 响应 VO")
public class BannerRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "图片URL", example = "https://example.com/banner.jpg")
    private String image;

    @Schema(description = "主标题", example = "首页Banner")
    private String title;

    @Schema(description = "副标题", example = "副标题内容")
    private String subtitle;

    @Schema(description = "排序号", example = "1")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    private Integer status;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间", example = "2026-11-05 12:00:00")
    private LocalDateTime createTime;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "更新时间", example = "2026-11-05 12:00:00")
    private LocalDateTime updateTime;

}

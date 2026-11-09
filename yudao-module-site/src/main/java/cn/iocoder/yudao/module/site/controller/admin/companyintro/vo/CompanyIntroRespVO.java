package cn.iocoder.yudao.module.site.controller.admin.companyintro.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 公司介绍 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "公司介绍 响应 VO")
public class CompanyIntroRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "公司介绍文本", example = "北京联纵宸捷科技有限公司...")
    private String description;

    @Schema(description = "公司风采图片列表")
    private List<String> images;

    @Schema(description = "版本号", example = "1")
    private Integer version;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    private Integer status;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间", example = "2026-11-06 12:00:00")
    private LocalDateTime createTime;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "更新时间", example = "2026-11-06 12:00:00")
    private LocalDateTime updateTime;

}

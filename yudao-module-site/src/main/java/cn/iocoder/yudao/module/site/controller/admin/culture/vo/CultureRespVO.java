package cn.iocoder.yudao.module.site.controller.admin.culture.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 企业文化 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "企业文化 响应 VO")
public class CultureRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "使命", example = "以技术创新为客户创造价值，以优质服务推动行业进步")
    private String mission;

    @Schema(description = "愿景", example = "成为行业内领先的科技与解决方案提供商")
    private String vision;

    @Schema(description = "价值观", example = "专业、创新、协作、共赢")
    private String values;

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

package cn.iocoder.yudao.module.site.controller.admin.honor.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 资质荣誉 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "资质荣誉 响应 VO")
public class HonorRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "荣誉/资质名称", example = "ISO9001质量管理体系认证")
    private String name;

    @Schema(description = "证书图片URL", example = "https://cdn.example.com/site/honor/1.jpg")
    private String image;

    @Schema(description = "证书图片URL列表（兼容前端多图组件，实际为单图记录）")
    private List<String> images;

    @Schema(description = "类型：qualification-资质，award-荣誉", example = "qualification")
    private String type;

    @Schema(description = "获得年份", example = "2024")
    private String date;

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

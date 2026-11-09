package cn.iocoder.yudao.module.site.controller.admin.honor.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 资质荣誉 分页查询 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Schema(description = "资质荣誉 分页查询 Request VO")
public class HonorPageReqVO extends PageParam {

    @Schema(description = "荣誉/资质名称", example = "ISO9001质量管理体系认证")
    private String name;

    @Schema(description = "类型：qualification-资质，award-荣誉", example = "qualification")
    private String type;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @Schema(description = "排序号", example = "0")
    private Integer sort;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}

package cn.iocoder.yudao.module.site.controller.admin.solution.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 解决方案 分页查询 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Schema(description = "解决方案 分页查询 Request VO")
public class SolutionPageReqVO extends PageParam {

    @Schema(description = "方案名称", example = "智慧政务解决方案")
    private String name;

    @Schema(description = "所属行业", example = "政务")
    private String industry;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}

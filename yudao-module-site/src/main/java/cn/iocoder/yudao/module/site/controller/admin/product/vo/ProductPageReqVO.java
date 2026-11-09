package cn.iocoder.yudao.module.site.controller.admin.product.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 产品 分页查询 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Schema(description = "产品 分页查询 Request VO")
public class ProductPageReqVO extends PageParam {

    @Schema(description = "产品名称", example = "联纵智能管理平台")
    private String name;

    @Schema(description = "类型：self-自研，agent-代理", example = "self")
    private String type;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}

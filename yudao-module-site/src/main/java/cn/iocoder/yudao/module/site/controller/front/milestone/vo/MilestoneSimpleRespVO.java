package cn.iocoder.yudao.module.site.controller.front.milestone.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 发展历程 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 发展历程 响应 VO")
public class MilestoneSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "年份", example = "2025")
    private Integer year;

    @Schema(description = "事件标题", example = "公司成立")
    private String title;

    @Schema(description = "事件描述", example = "北京联纵宸捷科技有限公司在北京正式成立")
    private String description;

}

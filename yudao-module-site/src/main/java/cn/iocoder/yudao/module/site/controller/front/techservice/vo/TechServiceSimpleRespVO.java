package cn.iocoder.yudao.module.site.controller.front.techservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 技术服务 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 技术服务 响应 VO")
public class TechServiceSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "服务行业", example = "政务")
    private String industry;

    @Schema(description = "图标标识（Remix Icon 类名）", example = "ri-government-line")
    private String icon;

    @Schema(description = "服务描述", example = "提供政务信息化规划、系统开发、数据整合、运维保障等全流程技术服务。")
    private String description;

}

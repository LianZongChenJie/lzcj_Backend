package cn.iocoder.yudao.module.site.controller.admin.techservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 技术服务 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "技术服务 保存/更新 Request VO")
public class TechServiceSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "服务行业", requiredMode = Schema.RequiredMode.REQUIRED, example = "政务")
    @NotBlank(message = "服务行业不能为空")
    private String industry;

    @Schema(description = "图标标识（Remix Icon 类名）", example = "ri-government-line")
    private String icon;

    @Schema(description = "服务描述", example = "提供政务信息化规划、系统开发、数据整合、运维保障等全流程技术服务。")
    private String description;

    @Schema(description = "排序号", example = "0")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

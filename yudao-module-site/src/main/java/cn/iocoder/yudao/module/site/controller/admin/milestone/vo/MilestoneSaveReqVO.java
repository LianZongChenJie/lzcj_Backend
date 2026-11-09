package cn.iocoder.yudao.module.site.controller.admin.milestone.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 发展历程 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "发展历程 保存/更新 Request VO")
public class MilestoneSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "年份", requiredMode = Schema.RequiredMode.REQUIRED, example = "2025")
    @NotNull(message = "年份不能为空")
    private Integer year;

    @Schema(description = "事件标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "公司成立")
    @NotBlank(message = "事件标题不能为空")
    private String title;

    @Schema(description = "事件描述", example = "北京联纵宸捷科技有限公司在北京正式成立")
    private String description;

    @Schema(description = "排序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

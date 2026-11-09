package cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 员工风采 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "员工风采 保存/更新 Request VO")
public class TeamGallerySaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "图片URL", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "图片不能为空")
    private String image;

    @Schema(description = "图片描述", example = "部门团建活动")
    private String description;

    @Schema(description = "排序号", example = "0")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

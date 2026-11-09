package cn.iocoder.yudao.module.site.controller.admin.honor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 资质荣誉 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "资质荣誉 保存/更新 Request VO")
public class HonorSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "荣誉/资质名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "ISO9001质量管理体系认证")
    @NotBlank(message = "名称不能为空")
    private String name;

    @Schema(description = "证书图片URL", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "证书图片不能为空")
    private String image;

    @Schema(description = "类型：qualification-资质，award-荣誉", requiredMode = Schema.RequiredMode.REQUIRED, example = "qualification")
    @NotBlank(message = "类型不能为空")
    private String type;

    @Schema(description = "获得年份", example = "2024")
    private String date;

    @Schema(description = "排序号", example = "0")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

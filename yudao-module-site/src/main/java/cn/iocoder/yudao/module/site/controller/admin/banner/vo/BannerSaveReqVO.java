package cn.iocoder.yudao.module.site.controller.admin.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Banner 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "Banner 保存/更新 Request VO")
public class BannerSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "图片URL", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://example.com/banner.jpg")
    @NotBlank(message = "图片URL不能为空")
    private String image;

    @Schema(description = "主标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "首页Banner")
    @NotBlank(message = "主标题不能为空")
    private String title;

    @Schema(description = "副标题", example = "副标题内容")
    private String subtitle;

    @Schema(description = "排序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

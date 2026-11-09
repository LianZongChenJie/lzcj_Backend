package cn.iocoder.yudao.module.site.controller.admin.culture.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 企业文化 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "企业文化 保存/更新 Request VO")
public class CultureSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "使命", requiredMode = Schema.RequiredMode.REQUIRED, example = "以技术创新为客户创造价值，以优质服务推动行业进步")
    @NotNull(message = "使命不能为空")
    private String mission;

    @Schema(description = "愿景", requiredMode = Schema.RequiredMode.REQUIRED, example = "成为行业内领先的科技与解决方案提供商")
    @NotNull(message = "愿景不能为空")
    private String vision;

    @Schema(description = "价值观", requiredMode = Schema.RequiredMode.REQUIRED, example = "专业、创新、协作、共赢")
    @NotNull(message = "价值观不能为空")
    private String values;

    @Schema(description = "版本号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "版本号不能为空")
    private Integer version;

    @Schema(description = "状态：0-禁用，1-启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

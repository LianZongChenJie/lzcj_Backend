package cn.iocoder.yudao.module.site.controller.admin.companyintro.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 公司介绍 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "公司介绍 保存/更新 Request VO")
public class CompanyIntroSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "公司介绍文本", requiredMode = Schema.RequiredMode.REQUIRED, example = "北京联纵宸捷科技有限公司...")
    @NotBlank(message = "公司介绍不能为空")
    private String description;

    @Schema(description = "公司风采图片列表")
    private List<String> images;

    @Schema(description = "版本号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "版本号不能为空")
    private Integer version;

    @Schema(description = "状态：0-禁用，1-启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

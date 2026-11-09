package cn.iocoder.yudao.module.site.controller.admin.solution.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 解决方案 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "解决方案 保存/更新 Request VO")
public class SolutionSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "智慧政务解决方案")
    @NotBlank(message = "方案名称不能为空")
    private String name;

    @Schema(description = "方案图片URL", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "方案图片不能为空")
    private String image;

    @Schema(description = "所属行业", requiredMode = Schema.RequiredMode.REQUIRED, example = "政务")
    @NotBlank(message = "所属行业不能为空")
    private String industry;

    @Schema(description = "方案摘要", example = "面向政府机构的数字化转型方案")
    private String summary;

    @Schema(description = "方案详细描述", example = "以政务服务数字化为核心，打造高效便民的智慧政务管理体系。")
    private String description;

    @Schema(description = "需求分析", example = "政务服务面临效率提升、流程优化、数据互通等核心需求。")
    private String demandAnalysis;

    @Schema(description = "排序号", example = "0")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

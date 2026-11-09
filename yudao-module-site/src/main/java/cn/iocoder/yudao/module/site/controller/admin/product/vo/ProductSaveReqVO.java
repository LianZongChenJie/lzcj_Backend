package cn.iocoder.yudao.module.site.controller.admin.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 产品 保存/更新 Request VO
 *
 * 说明：管理端使用单图组件维护 image 字段。
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "产品 保存/更新 Request VO")
public class ProductSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "联纵智能管理平台")
    @NotBlank(message = "产品名称不能为空")
    private String name;

    @Schema(description = "产品图片URL（单图）", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://example.com/product.jpg")
    @NotBlank(message = "产品图片不能为空")
    private String image;

    @Schema(description = "类型：self-自研，agent-代理", requiredMode = Schema.RequiredMode.REQUIRED, example = "self")
    @NotBlank(message = "产品类型不能为空")
    private String type;

    @Schema(description = "产品摘要", example = "一站式企业智能化管理平台")
    private String summary;

    @Schema(description = "产品详细描述", example = "面向企业数字化转型的综合性管理解决方案...")
    private String description;

    @Schema(description = "核心特性列表", example = "[\"可视化管理\",\"流程自动化\"]")
    private List<String> features;

    @Schema(description = "适用场景列表", example = "[\"中大型企业\",\"政府机构\"]")
    private List<String> scenarios;

    @Schema(description = "排序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

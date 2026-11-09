package cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 分公司联系方式 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "分公司联系方式 保存/更新 Request VO")
public class BranchContactSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "城市名称（分公司名称）", requiredMode = Schema.RequiredMode.REQUIRED, example = "北京")
    @NotBlank(message = "城市名称不能为空")
    private String city;

    @Schema(description = "详细地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "北京市丰台区西三环南路14号院首科大厦A座6层")
    @NotBlank(message = "详细地址不能为空")
    private String address;

    @Schema(description = "联系电话", example = "010-52802789")
    private String phone;

    @Schema(description = "邮政编码", example = "100073")
    private String postalCode;

    @Schema(description = "电子邮箱", example = "<_EMAIL>")
    private String email;

    @Schema(description = "主题色（用于前端展示）", example = "#409eff")
    private String themeColor;

    @Schema(description = "排序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "排序号不能为空")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

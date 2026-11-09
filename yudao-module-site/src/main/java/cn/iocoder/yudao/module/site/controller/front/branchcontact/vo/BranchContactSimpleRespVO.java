package cn.iocoder.yudao.module.site.controller.front.branchcontact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 分公司联系方式 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 分公司联系方式 响应 VO")
public class BranchContactSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "城市名称（分公司名称）", example = "北京")
    private String city;

    @Schema(description = "详细地址", example = "北京市丰台区西三环南路14号院首科大厦A座6层")
    private String address;

    @Schema(description = "联系电话", example = "010-52802789")
    private String phone;

    @Schema(description = "邮政编码", example = "100073")
    private String postalCode;

    @Schema(description = "电子邮箱", example = "<_EMAIL>")
    private String email;

    @Schema(description = "主题色（用于前端展示）", example = "#409eff")
    private String themeColor;

    @Schema(description = "排序号", example = "0")
    private Integer sort;

}

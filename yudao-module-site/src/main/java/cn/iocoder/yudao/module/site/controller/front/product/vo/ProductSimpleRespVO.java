package cn.iocoder.yudao.module.site.controller.front.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 展示端 - 产品 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 产品 响应 VO")
public class ProductSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "产品名称", example = "联纵智能管理平台")
    private String name;

    @Schema(description = "产品图片URL", example = "https://example.com/product.jpg")
    private String image;

    @Schema(description = "产品摘要", example = "一站式企业智能化管理平台")
    private String summary;

    @Schema(description = "产品详细描述", example = "面向企业数字化转型的综合性管理解决方案...")
    private String description;

    @Schema(description = "核心特性列表")
    private List<String> features;

    @Schema(description = "适用场景列表")
    private List<String> scenarios;

}

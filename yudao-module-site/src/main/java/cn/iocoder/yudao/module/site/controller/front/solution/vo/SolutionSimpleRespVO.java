package cn.iocoder.yudao.module.site.controller.front.solution.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 解决方案 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 解决方案 响应 VO")
public class SolutionSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "方案名称", example = "智慧政务解决方案")
    private String name;

    @Schema(description = "方案图片URL", example = "https://cdn.example.com/site/solution/1.jpg")
    private String image;

    @Schema(description = "所属行业", example = "政务")
    private String industry;

    @Schema(description = "方案摘要", example = "面向政府机构的数字化转型方案")
    private String summary;

    @Schema(description = "方案详细描述", example = "以政务服务数字化为核心，打造高效便民的智慧政务管理体系。")
    private String description;

    @Schema(description = "需求分析", example = "政务服务面临效率提升、流程优化、数据互通等核心需求。")
    private String demandAnalysis;

}

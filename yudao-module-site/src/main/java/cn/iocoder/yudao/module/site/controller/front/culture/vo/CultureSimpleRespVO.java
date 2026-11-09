package cn.iocoder.yudao.module.site.controller.front.culture.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 企业文化 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 企业文化 响应 VO")
public class CultureSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "使命", example = "以技术创新为客户创造价值，以优质服务推动行业进步")
    private String mission;

    @Schema(description = "愿景", example = "成为行业内领先的科技与解决方案提供商")
    private String vision;

    @Schema(description = "价值观", example = "专业、创新、协作、共赢")
    private String values;

}

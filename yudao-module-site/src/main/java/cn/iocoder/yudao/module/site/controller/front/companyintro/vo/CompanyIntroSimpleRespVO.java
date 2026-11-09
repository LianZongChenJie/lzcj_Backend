package cn.iocoder.yudao.module.site.controller.front.companyintro.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 展示端 - 公司介绍 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 公司介绍 响应 VO")
public class CompanyIntroSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "公司介绍文本", example = "北京联纵宸捷科技有限公司...")
    private String description;

    @Schema(description = "公司风采图片列表")
    private List<String> images;

    @Schema(description = "版本号", example = "1")
    private Integer version;

}

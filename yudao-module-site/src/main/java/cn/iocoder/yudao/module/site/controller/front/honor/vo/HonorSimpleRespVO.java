package cn.iocoder.yudao.module.site.controller.front.honor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 资质荣誉 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 资质荣誉 响应 VO")
public class HonorSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "荣誉/资质名称", example = "ISO9001质量管理体系认证")
    private String name;

    @Schema(description = "证书图片URL", example = "https://cdn.example.com/site/honor/1.jpg")
    private String image;

    @Schema(description = "类型：qualification-资质，award-荣誉", example = "qualification")
    private String type;

    @Schema(description = "获得年份", example = "2024")
    private String date;

}

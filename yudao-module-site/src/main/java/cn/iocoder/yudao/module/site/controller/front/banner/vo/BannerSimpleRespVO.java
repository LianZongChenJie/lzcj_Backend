package cn.iocoder.yudao.module.site.controller.front.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - Banner 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - Banner 响应 VO")
public class BannerSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "图片URL", example = "https://example.com/banner.jpg")
    private String image;

    @Schema(description = "主标题", example = "首页Banner")
    private String title;

    @Schema(description = "副标题", example = "副标题内容")
    private String subtitle;

}

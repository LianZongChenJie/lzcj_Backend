package cn.iocoder.yudao.module.site.controller.front.news.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 新闻 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 新闻 响应 VO")
public class NewsSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "新闻标题", example = "公司荣获2025年度行业优秀解决方案奖")
    private String title;

    @Schema(description = "封面图片URL", example = "https://cdn.example.com/site/news/1.jpg")
    private String cover;

    @Schema(description = "新闻摘要", example = "在2025年度行业评选中...")
    private String summary;

    @Schema(description = "新闻正文", example = "近日...")
    private String content;

    @Schema(description = "作者", example = "公司新闻部")
    private String author;

    @Schema(description = "发布日期（yyyy-MM-dd）", example = "2025-10-15")
    private String publishDate;

}

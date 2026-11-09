package cn.iocoder.yudao.module.site.controller.admin.news.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 新闻 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "新闻 保存/更新 Request VO")
public class NewsSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "新闻标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "公司荣获2025年度行业优秀解决方案奖")
    @NotBlank(message = "标题不能为空")
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

    @Schema(description = "状态：0-草稿，1-已发布", example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

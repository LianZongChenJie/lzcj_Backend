package cn.iocoder.yudao.module.site.controller.front.announcement.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 展示端 - 公告 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 公告 响应 VO")
public class AnnouncementSimpleRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "公告标题", example = "关于2025年国庆节放假安排的通知")
    private String title;

    @Schema(description = "公告摘要", example = "现将2025年国庆节放假安排通知如下。")
    private String summary;

    @Schema(description = "公告正文", example = "根据国家关于...")
    private String content;

    @Schema(description = "是否重要：0-否，1-是", example = "0")
    private Integer important;

    @Schema(description = "发布日期（yyyy-MM-dd）", example = "2025-09-25")
    private String publishDate;

}

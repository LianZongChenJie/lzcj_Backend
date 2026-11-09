package cn.iocoder.yudao.module.site.controller.admin.announcement.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 公告 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "公告 保存/更新 Request VO")
public class AnnouncementSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "公告标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "关于2025年国庆节放假安排的通知")
    @NotBlank(message = "标题不能为空")
    private String title;

    @Schema(description = "公告摘要", example = "现将2025年国庆节放假安排通知如下。")
    private String summary;

    @Schema(description = "公告正文", example = "根据国家关于...")
    private String content;

    @Schema(description = "是否重要：0-否，1-是", example = "0")
    @NotNull(message = "重要标记不能为空")
    private Integer important;

    @Schema(description = "发布日期（yyyy-MM-dd）", example = "2025-09-25")
    private String publishDate;

    @Schema(description = "状态：0-草稿，1-已发布", example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

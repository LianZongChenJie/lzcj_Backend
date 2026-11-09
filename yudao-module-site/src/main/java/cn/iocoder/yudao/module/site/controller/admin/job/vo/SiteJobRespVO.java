package cn.iocoder.yudao.module.site.controller.admin.job.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 招聘职位 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "招聘职位 响应 VO")
public class SiteJobRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "职位名称", example = "高级前端开发工程师")
    private String title;

    @Schema(description = "工作地点", example = "北京")
    private String location;

    @Schema(description = "所属部门", example = "技术部")
    private String department;

    @Schema(description = "工作类型：全职/兼职/实习", example = "全职")
    private String type;

    @Schema(description = "是否急聘：0-否，1-是", example = "1")
    private Integer urgent;

    @Schema(description = "岗位职责列表")
    private List<String> responsibilities;

    @Schema(description = "任职要求列表")
    private List<String> requirements;

    @Schema(description = "招聘人数", example = "2")
    private Integer headcount;

    @Schema(description = "状态：0-关闭，1-招聘中", example = "1")
    private Integer status;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间", example = "2026-11-06 12:00:00")
    private LocalDateTime createTime;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "更新时间", example = "2026-11-06 12:00:00")
    private LocalDateTime updateTime;

}

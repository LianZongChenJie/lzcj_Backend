package cn.iocoder.yudao.module.site.controller.admin.job.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 招聘职位 分页查询 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Schema(description = "招聘职位 分页查询 Request VO")
public class SiteJobPageReqVO extends PageParam {

    @Schema(description = "职位名称", example = "高级前端开发工程师")
    private String title;

    @Schema(description = "工作地点", example = "北京")
    private String location;

    @Schema(description = "所属部门", example = "技术部")
    private String department;

    @Schema(description = "工作类型", example = "全职")
    private String type;

    @Schema(description = "是否急聘：0-否，1-是", example = "1")
    private Integer urgent;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}

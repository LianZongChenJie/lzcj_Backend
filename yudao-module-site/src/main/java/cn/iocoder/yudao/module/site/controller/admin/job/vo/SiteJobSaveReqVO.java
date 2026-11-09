package cn.iocoder.yudao.module.site.controller.admin.job.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 招聘职位 保存/更新 Request VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "招聘职位 保存/更新 Request VO")
public class SiteJobSaveReqVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "职位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "高级前端开发工程师")
    @NotBlank(message = "职位名称不能为空")
    private String title;

    @Schema(description = "工作地点", requiredMode = Schema.RequiredMode.REQUIRED, example = "北京")
    @NotBlank(message = "工作地点不能为空")
    private String location;

    @Schema(description = "所属部门", example = "技术部")
    private String department;

    @Schema(description = "工作类型：全职/兼职/实习", requiredMode = Schema.RequiredMode.REQUIRED, example = "全职")
    @NotBlank(message = "工作类型不能为空")
    private String type;

    @Schema(description = "是否急聘：0-否，1-是", example = "1")
    private Integer urgent;

    @Schema(description = "岗位职责列表")
    private List<String> responsibilities;

    @Schema(description = "任职要求列表")
    private List<String> requirements;

    @Schema(description = "招聘人数", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "招聘人数不能为空")
    private Integer headcount;

    @Schema(description = "状态：0-关闭，1-招聘中", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}

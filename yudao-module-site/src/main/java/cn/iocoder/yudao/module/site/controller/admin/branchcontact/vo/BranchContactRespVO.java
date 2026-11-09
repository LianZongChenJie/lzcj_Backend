package cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 分公司联系方式 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "分公司联系方式 响应 VO")
public class BranchContactRespVO {

    @Schema(description = "主键ID", example = "1")
    private Long id;

    @Schema(description = "城市名称（分公司名称）", example = "北京")
    private String city;

    @Schema(description = "详细地址", example = "北京市丰台区西三环南路14号院首科大厦A座6层")
    private String address;

    @Schema(description = "联系电话", example = "010-52802789")
    private String phone;

    @Schema(description = "邮政编码", example = "100073")
    private String postalCode;

    @Schema(description = "电子邮箱", example = "<_EMAIL>")
    private String email;

    @Schema(description = "主题色（用于前端展示）", example = "#409eff")
    private String themeColor;

    @Schema(description = "排序号", example = "0")
    private Integer sort;

    @Schema(description = "状态：0-禁用，1-启用", example = "1")
    private Integer status;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间", example = "2026-11-06 12:00:00")
    private LocalDateTime createTime;

    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "更新时间", example = "2026-11-06 12:00:00")
    private LocalDateTime updateTime;

}

package cn.iocoder.yudao.module.site.dal.dataobject.job;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;

import java.util.List;

/**
 * 招聘职位表
 *
 * @author 联纵宸捷
 */
@TableName(value = "site_job", autoResultMap = true)
@KeySequence("site_job_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class SiteJobDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 职位名称
     */
    private String title;
    /**
     * 工作地点
     */
    private String location;
    /**
     * 所属部门
     */
    private String department;
    /**
     * 工作类型：全职/兼职/实习
     */
    private String type;
    /**
     * 是否急聘：0-否，1-是
     */
    private Integer urgent;
    /**
     * 岗位职责列表
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> responsibilities;
    /**
     * 任职要求列表
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> requirements;
    /**
     * 招聘人数
     */
    private Integer headcount;
    /**
     * 状态：0-关闭，1-招聘中
     */
    private Integer status;

}

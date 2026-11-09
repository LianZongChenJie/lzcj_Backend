package cn.iocoder.yudao.module.site.dal.dataobject.solution;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 解决方案表
 *
 * @author 联纵宸捷
 */
@TableName("site_solution")
@KeySequence("site_solution_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class SolutionDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 方案名称
     */
    private String name;
    /**
     * 方案图片URL
     */
    private String image;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 方案摘要
     */
    private String summary;
    /**
     * 方案详细描述
     */
    private String description;
    /**
     * 需求分析
     */
    private String demandAnalysis;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

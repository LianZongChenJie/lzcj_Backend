package cn.iocoder.yudao.module.site.dal.dataobject.milestone;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 发展历程表
 *
 * @author 联纵宸捷
 */
@TableName("site_milestone")
@KeySequence("site_milestone_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class MilestoneDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 事件标题
     */
    private String title;
    /**
     * 事件描述
     */
    private String description;
    /**
     * 排序号（越小越靠前）
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

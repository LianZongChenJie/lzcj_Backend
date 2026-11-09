package cn.iocoder.yudao.module.site.dal.dataobject.techservice;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 技术服务表
 *
 * @author 联纵宸捷
 */
@TableName("site_tech_service")
@KeySequence("site_tech_service_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class TechServiceDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 服务行业
     */
    private String industry;
    /**
     * 图标标识（Remix Icon 类名）
     */
    private String icon;
    /**
     * 服务描述
     */
    private String description;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

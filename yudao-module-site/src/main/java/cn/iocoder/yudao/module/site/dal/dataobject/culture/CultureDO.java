package cn.iocoder.yudao.module.site.dal.dataobject.culture;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 企业文化表
 *
 * @author 联纵宸捷
 */
@TableName("site_company_culture")
@KeySequence("site_company_culture_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class CultureDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 使命
     */
    private String mission;
    /**
     * 愿景
     */
    private String vision;
    /**
     * 价值观
     *
     * 注意：values 是 MySQL 5.7 的保留字，因此映射为 core_values 列
     */
    @TableField("core_values")
    private String coreValues;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

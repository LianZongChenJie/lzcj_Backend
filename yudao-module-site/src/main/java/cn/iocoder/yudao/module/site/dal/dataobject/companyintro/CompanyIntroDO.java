package cn.iocoder.yudao.module.site.dal.dataobject.companyintro;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;

import java.util.List;

/**
 * 公司介绍表
 *
 * 说明：版本管理模式。status=1 且 version 最大的一条记录为当前生效版本，
 * 展示端（/cms/api/company-intro）只返回该条记录。
 *
 * @author 联纵宸捷
 */
@TableName(value = "site_company_intro", autoResultMap = true)
@KeySequence("site_company_intro_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class CompanyIntroDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 公司介绍文本
     */
    private String description;
    /**
     * 公司风采图片列表（JSON 数组）
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> images;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

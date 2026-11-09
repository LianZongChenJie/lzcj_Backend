package cn.iocoder.yudao.module.site.dal.dataobject.branchcontact;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 分公司联系方式表
 *
 * @author 联纵宸捷
 */
@TableName("site_branch_contact")
@KeySequence("site_branch_contact_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class BranchContactDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 城市名称（分公司名称）
     */
    private String city;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 邮政编码
     */
    private String postalCode;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 主题色（用于前端展示）
     */
    private String themeColor;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

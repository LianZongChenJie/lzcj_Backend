package cn.iocoder.yudao.module.site.dal.dataobject.honor;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 资质荣誉表
 *
 * @author 联纵宸捷
 */
@TableName("site_honor")
@KeySequence("site_honor_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class HonorDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 荣誉/资质名称
     */
    private String name;
    /**
     * 证书图片URL
     */
    private String image;
    /**
     * 类型：qualification-资质，award-荣誉
     */
    private String type;
    /**
     * 获得年份
     */
    private String date;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

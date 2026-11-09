package cn.iocoder.yudao.module.site.dal.dataobject.banner;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * Banner轮播表
 *
 * @author 联纵宸捷
 */
@TableName("site_banner")
@KeySequence("site_banner_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class BannerDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 图片URL
     */
    private String image;
    /**
     * 主标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 排序号（越小越靠前）
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

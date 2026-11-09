package cn.iocoder.yudao.module.site.dal.dataobject.teamgallery;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 员工风采表
 *
 * @author 联纵宸捷
 */
@TableName("site_team_gallery")
@KeySequence("site_team_gallery_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class TeamGalleryDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 图片URL
     */
    private String image;
    /**
     * 图片描述
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

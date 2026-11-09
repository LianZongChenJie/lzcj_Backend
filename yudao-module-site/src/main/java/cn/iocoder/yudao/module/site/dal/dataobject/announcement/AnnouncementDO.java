package cn.iocoder.yudao.module.site.dal.dataobject.announcement;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 公告表
 *
 * @author 联纵宸捷
 */
@TableName("site_announcement")
@KeySequence("site_announcement_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class AnnouncementDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告摘要
     */
    private String summary;
    /**
     * 公告正文
     */
    private String content;
    /**
     * 是否重要：0-否，1-是
     */
    private Integer important;
    /**
     * 发布日期（yyyy-MM-dd）
     */
    private String publishDate;
    /**
     * 状态：0-草稿，1-已发布
     */
    private Integer status;

}

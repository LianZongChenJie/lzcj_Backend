package cn.iocoder.yudao.module.site.dal.dataobject.news;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 新闻表
 *
 * @author 联纵宸捷
 */
@TableName("site_news")
@KeySequence("site_news_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class NewsDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 封面图片URL
     */
    private String cover;
    /**
     * 新闻摘要
     */
    private String summary;
    /**
     * 新闻正文
     */
    private String content;
    /**
     * 作者
     */
    private String author;
    /**
     * 发布日期（yyyy-MM-dd）
     */
    private String publishDate;
    /**
     * 状态：0-草稿，1-已发布
     */
    private Integer status;

}

package cn.iocoder.yudao.module.site.service.news;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.news.NewsDO;

import java.util.List;

/**
 * 新闻 业务接口
 *
 * @author 联纵宸捷
 */
public interface NewsService {

    /**
     * 获取新闻分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 新闻分页结果
     */
    PageResult<NewsDO> getNewsPage(NewsPageReqVO pageReqVO);

    /**
     * 根据ID获取新闻详情
     *
     * @param id 新闻ID
     * @return 新闻详情
     */
    NewsDO getNews(Long id);

    /**
     * 创建新闻
     *
     * @param createReqVO 创建参数
     * @return 新闻ID
     */
    Long createNews(NewsSaveReqVO createReqVO);

    /**
     * 更新新闻
     *
     * @param updateReqVO 更新参数
     */
    void updateNews(NewsSaveReqVO updateReqVO);

    /**
     * 删除新闻
     *
     * @param id 新闻ID
     */
    void deleteNews(Long id);

    /**
     * 获取当前已发布的新闻列表（用于展示端）
     *
     * @return 新闻列表
     */
    List<NewsDO> getNewsListEnabled();

}

package cn.iocoder.yudao.module.site.service.news;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.news.NewsDO;
import cn.iocoder.yudao.module.site.dal.mysql.news.NewsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.NEWS_NOT_EXISTS;

/**
 * 新闻 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public PageResult<NewsDO> getNewsPage(NewsPageReqVO pageReqVO) {
        return newsMapper.selectPage(pageReqVO);
    }

    @Override
    public NewsDO getNews(Long id) {
        return newsMapper.selectById(id);
    }

    @Override
    public Long createNews(NewsSaveReqVO createReqVO) {
        // 插入
        NewsDO news = new NewsDO();
        news.setTitle(createReqVO.getTitle());
        news.setCover(createReqVO.getCover());
        news.setSummary(createReqVO.getSummary());
        news.setContent(createReqVO.getContent());
        news.setAuthor(createReqVO.getAuthor());
        news.setPublishDate(createReqVO.getPublishDate());
        news.setStatus(createReqVO.getStatus());
        newsMapper.insert(news);
        // 返回
        return news.getId();
    }

    @Override
    public void updateNews(NewsSaveReqVO updateReqVO) {
        // 校验存在
        validateNewsExists(updateReqVO.getId());
        // 更新
        NewsDO updateObj = new NewsDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setTitle(updateReqVO.getTitle());
        updateObj.setCover(updateReqVO.getCover());
        updateObj.setSummary(updateReqVO.getSummary());
        updateObj.setContent(updateReqVO.getContent());
        updateObj.setAuthor(updateReqVO.getAuthor());
        updateObj.setPublishDate(updateReqVO.getPublishDate());
        updateObj.setStatus(updateReqVO.getStatus());
        newsMapper.updateById(updateObj);
    }

    @Override
    public void deleteNews(Long id) {
        // 校验存在
        validateNewsExists(id);
        // 删除
        newsMapper.deleteById(id);
    }

    @Override
    public List<NewsDO> getNewsListEnabled() {
        return newsMapper.selectListEnabled();
    }

    private void validateNewsExists(Long id) {
        if (newsMapper.selectById(id) == null) {
            throw exception(NEWS_NOT_EXISTS);
        }
    }

}

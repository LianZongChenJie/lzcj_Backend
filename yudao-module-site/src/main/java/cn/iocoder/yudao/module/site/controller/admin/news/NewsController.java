package cn.iocoder.yudao.module.site.controller.admin.news;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsRespVO;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.news.NewsDO;
import cn.iocoder.yudao.module.site.service.news.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 新闻
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 新闻")
@RestController
@RequestMapping("/site/news")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class NewsController {

    @Resource
    private NewsService newsService;

    @PostMapping("/create")
    @Operation(summary = "创建新闻")
    public CommonResult<Long> createNews(@Valid @RequestBody NewsSaveReqVO createReqVO) {
        return success(newsService.createNews(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新新闻")
    public CommonResult<Boolean> updateNews(@Valid @RequestBody NewsSaveReqVO updateReqVO) {
        newsService.updateNews(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除新闻")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteNews(@RequestParam("id") Long id) {
        newsService.deleteNews(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得新闻")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<NewsRespVO> getNews(@RequestParam("id") Long id) {
        NewsDO news = newsService.getNews(id);
        return success(BeanUtils.toBean(news, NewsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得新闻分页")
    public CommonResult<PageResult<NewsRespVO>> getNewsPage(@Valid NewsPageReqVO pageVO) {
        PageResult<NewsDO> page = newsService.getNewsPage(pageVO);
        return success(BeanUtils.toBean(page, NewsRespVO.class));
    }

}

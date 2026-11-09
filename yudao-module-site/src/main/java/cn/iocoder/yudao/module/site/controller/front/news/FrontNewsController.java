package cn.iocoder.yudao.module.site.controller.front.news;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsPageReqVO;
import cn.iocoder.yudao.module.site.controller.front.news.vo.NewsSimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.news.NewsDO;
import cn.iocoder.yudao.module.site.service.news.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 展示端 - 新闻
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_news 表，取 status=1 按发布日期倒序，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 新闻")
@PermitAll
@RestController
@RequestMapping("/cms/api/news")
@Validated
public class FrontNewsController {

    @Resource
    private NewsService newsService;

    @GetMapping
    @Operation(summary = "获得新闻分页", description = "展示端新闻中心调用，无需登录；取 status=1 按发布日期倒序")
    public CommonResult<PageResult<NewsSimpleRespVO>> getNewsPage(@Valid NewsPageReqVO pageReqVO) {
        PageResult<NewsDO> page = newsService.getNewsPage(buildPageReqVO(pageReqVO));
        return success(BeanUtils.toBean(page, NewsSimpleRespVO.class));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获得新闻详情", description = "展示端新闻中心调用，无需登录；取 status=1 已发布记录")
    public CommonResult<NewsSimpleRespVO> getNews(@PathVariable("id") Long id) {
        NewsDO news = newsService.getNews(id);
        return success(BeanUtils.toBean(news, NewsSimpleRespVO.class));
    }

    /**
     * 构建展示端分页参数：只查询已发布（status=1）的新闻
     */
    private NewsPageReqVO buildPageReqVO(NewsPageReqVO reqVO) {
        NewsPageReqVO pageReqVO = new NewsPageReqVO();
        pageReqVO.setPageNo(reqVO.getPageNo());
        pageReqVO.setPageSize(reqVO.getPageSize());
        pageReqVO.setStatus(1);
        return pageReqVO;
    }

}

package cn.iocoder.yudao.module.site.controller.front.job;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.front.job.vo.SiteJobSimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.job.SiteJobDO;
import cn.iocoder.yudao.module.site.service.job.SiteJobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 展示端 - 招聘职位
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_job 表，取 status=1，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 招聘职位")
@PermitAll
@RestController
@RequestMapping("/cms/api/jobs")
@Validated
public class FrontSiteJobController {

    @Resource
    private SiteJobService siteJobService;

    @GetMapping
    @Operation(summary = "获得招聘职位列表", description = "展示端人才招聘板块调用，无需登录；取 status=1 按 id 升序")
    public CommonResult<List<SiteJobSimpleRespVO>> getJobs() {
        List<SiteJobDO> list = siteJobService.getJobListEnabled();
        return success(list.stream().map(job -> {
            SiteJobSimpleRespVO vo = BeanUtils.toBean(job, SiteJobSimpleRespVO.class);
            // 管理端存储为 0/1，展示端按布尔语义输出
            vo.setUrgent(job.getUrgent() != null && job.getUrgent() == 1);
            return vo;
        }).collect(Collectors.toList()));
    }

}

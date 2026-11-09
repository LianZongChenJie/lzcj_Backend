package cn.iocoder.yudao.module.site.controller.front.milestone;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.front.milestone.vo.MilestoneSimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.milestone.MilestoneDO;
import cn.iocoder.yudao.module.site.service.milestone.MilestoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 展示端 - 发展历程
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_company_milestone 表，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 发展历程")
@PermitAll
@RestController
@RequestMapping("/cms/api/milestones")
@Validated
public class FrontMilestoneController {

    @Resource
    private MilestoneService milestoneService;

    @GetMapping
    @Operation(summary = "获得启用的发展历程列表", description = "展示端首页发展历程调用，无需登录")
    public CommonResult<List<MilestoneSimpleRespVO>> getMilestones() {
        List<MilestoneDO> list = milestoneService.getMilestoneListEnabled();
        return success(BeanUtils.toBean(list, MilestoneSimpleRespVO.class));
    }

}

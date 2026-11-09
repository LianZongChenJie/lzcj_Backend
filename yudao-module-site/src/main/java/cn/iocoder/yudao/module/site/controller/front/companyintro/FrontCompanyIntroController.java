package cn.iocoder.yudao.module.site.controller.front.companyintro;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.front.companyintro.vo.CompanyIntroSimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.companyintro.CompanyIntroDO;
import cn.iocoder.yudao.module.site.service.companyintro.CompanyIntroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 展示端 - 公司介绍
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_company_intro 表，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 公司介绍")
@PermitAll
@RestController
@RequestMapping("/cms/api/company-intro")
@Validated
public class FrontCompanyIntroController {

    @Resource
    private CompanyIntroService companyIntroService;

    @GetMapping
    @Operation(summary = "获得当前生效的公司介绍", description = "展示端首页公司介绍调用，无需登录；"
            + "取 status=1 且版本号最大的一条记录，未配置时 data 为 null")
    public CommonResult<CompanyIntroSimpleRespVO> getCompanyIntro() {
        CompanyIntroDO companyIntro = companyIntroService.getEnabledCompanyIntro();
        return success(BeanUtils.toBean(companyIntro, CompanyIntroSimpleRespVO.class));
    }

}

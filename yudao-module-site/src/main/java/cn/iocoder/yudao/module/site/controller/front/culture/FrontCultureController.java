package cn.iocoder.yudao.module.site.controller.front.culture;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.front.culture.vo.CultureSimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.culture.CultureDO;
import cn.iocoder.yudao.module.site.service.culture.CultureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 展示端 - 企业文化
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_company_culture 表，取 status=1 且 version 最大的一条，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 企业文化")
@PermitAll
@RestController
@RequestMapping("/cms/api/company-culture")
@Validated
public class FrontCultureController {

    @Resource
    private CultureService cultureService;

    @GetMapping
    @Operation(summary = "获得当前生效的企业文化", description = "展示端企业文化板块调用，无需登录；取 status=1 且 version 最大的一条")
    public CommonResult<CultureSimpleRespVO> getCompanyCulture() {
        CultureDO culture = cultureService.getCultureEnabled();
        // 未配置时返回空对象，由展示端兜底本地 JSON
        if (culture == null) {
            return success(null);
        }
        CultureSimpleRespVO vo = BeanUtils.toBean(culture, CultureSimpleRespVO.class);
        // coreValues -> values（数据库列名为 core_values，接口字段保持 values）
        vo.setValues(culture.getCoreValues());
        return success(vo);
    }

}

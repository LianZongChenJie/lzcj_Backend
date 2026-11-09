package cn.iocoder.yudao.module.site.controller.front.teamgallery;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.front.teamgallery.vo.TeamGallerySimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.teamgallery.TeamGalleryDO;
import cn.iocoder.yudao.module.site.service.teamgallery.TeamGalleryService;
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
 * 展示端 - 员工风采
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_team_gallery 表，取 status=1 按 sort 升序，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 员工风采")
@PermitAll
@RestController
@RequestMapping("/cms/api/team-gallery")
@Validated
public class FrontTeamGalleryController {

    @Resource
    private TeamGalleryService teamGalleryService;

    @GetMapping
    @Operation(summary = "获得员工风采列表", description = "展示端员工风采板块调用，无需登录；取 status=1 按 sort 升序")
    public CommonResult<TeamGallerySimpleRespVO> getTeamGallery() {
        List<TeamGalleryDO> list = teamGalleryService.getTeamGalleryListEnabled();
        List<TeamGallerySimpleRespVO.Item> items = BeanUtils.toBean(list, TeamGallerySimpleRespVO.Item.class);
        return success(new TeamGallerySimpleRespVO(items));
    }

}

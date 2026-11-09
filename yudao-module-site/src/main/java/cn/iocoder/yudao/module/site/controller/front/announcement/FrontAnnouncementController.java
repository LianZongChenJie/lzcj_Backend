package cn.iocoder.yudao.module.site.controller.front.announcement;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.front.announcement.vo.AnnouncementSimpleRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.announcement.AnnouncementDO;
import cn.iocoder.yudao.module.site.service.announcement.AnnouncementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 展示端 - 公告
 *
 * 说明：公网展示端接口，统一前缀 /cms/api，匿名免登录访问。
 * 1. 类级 {@link PermitAll} 注解会被 {@code YudaoWebSecurityConfigurerAdapter} 自动扫描，加入放行列表；
 * 2. 路径不在 /admin-api、/app-api 前缀下，天然不经过租户（TenantSecurityWebFilter）与权限过滤；
 * 3. 数据与管理端共用 site_announcement 表，取 status=1 按发布日期倒序，仅免去权限校验。
 *
 * @author 联纵宸捷
 */
@Tag(name = "展示端 - 公告")
@PermitAll
@RestController
@RequestMapping("/cms/api/announcements")
@Validated
public class FrontAnnouncementController {

    @Resource
    private AnnouncementService announcementService;

    @GetMapping
    @Operation(summary = "获得公告列表", description = "展示端公司公告调用，无需登录；取 status=1 按发布日期倒序")
    public CommonResult<List<AnnouncementSimpleRespVO>> getAnnouncements() {
        List<AnnouncementDO> list = announcementService.getAnnouncementListEnabled();
        return success(BeanUtils.toBean(list, AnnouncementSimpleRespVO.class));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获得公告详情", description = "展示端公司公告调用，无需登录")
    public CommonResult<AnnouncementSimpleRespVO> getAnnouncement(@PathVariable("id") Long id) {
        AnnouncementDO announcement = announcementService.getAnnouncement(id);
        return success(BeanUtils.toBean(announcement, AnnouncementSimpleRespVO.class));
    }

}

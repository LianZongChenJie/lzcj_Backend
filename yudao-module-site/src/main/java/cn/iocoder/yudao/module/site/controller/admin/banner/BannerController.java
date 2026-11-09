package cn.iocoder.yudao.module.site.controller.admin.banner;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerRespVO;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.banner.BannerDO;
import cn.iocoder.yudao.module.site.service.banner.BannerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - Banner轮播
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - Banner轮播")
@RestController
@RequestMapping("/site/banner")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class BannerController {

    @Resource
    private BannerService bannerService;

    @PostMapping("/create")
    @Operation(summary = "创建Banner")
    public CommonResult<Long> createBanner(@Valid @RequestBody BannerSaveReqVO createReqVO) {
        return success(bannerService.createBanner(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新Banner")
    public CommonResult<Boolean> updateBanner(@Valid @RequestBody BannerSaveReqVO updateReqVO) {
        bannerService.updateBanner(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除Banner")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteBanner(@RequestParam("id") Long id) {
        bannerService.deleteBanner(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得Banner")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<BannerRespVO> getBanner(@RequestParam("id") Long id) {
        BannerDO banner = bannerService.getBanner(id);
        return success(BeanUtils.toBean(banner, BannerRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得Banner分页")
    public CommonResult<PageResult<BannerRespVO>> getBannerPage(@Valid BannerPageReqVO pageVO) {
        PageResult<BannerDO> page = bannerService.getBannerPage(pageVO);
        return success(BeanUtils.toBean(page, BannerRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "获得启用的Banner列表", description = "用于前端首页展示")
    public CommonResult<List<BannerRespVO>> getBannerListEnabled() {
        List<BannerDO> list = bannerService.getBannerListEnabled();
        return success(BeanUtils.toBean(list, BannerRespVO.class));
    }

}

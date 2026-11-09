package cn.iocoder.yudao.module.site.controller.admin.teamgallery;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGalleryPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGalleryRespVO;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGallerySaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.teamgallery.TeamGalleryDO;
import cn.iocoder.yudao.module.site.service.teamgallery.TeamGalleryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 员工风采
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 员工风采")
@RestController
@RequestMapping("/site/team-gallery")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class TeamGalleryController {

    @Resource
    private TeamGalleryService teamGalleryService;

    @PostMapping("/create")
    @Operation(summary = "创建员工风采")
    public CommonResult<Long> createTeamGallery(@Valid @RequestBody TeamGallerySaveReqVO createReqVO) {
        return success(teamGalleryService.createTeamGallery(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新员工风采")
    public CommonResult<Boolean> updateTeamGallery(@Valid @RequestBody TeamGallerySaveReqVO updateReqVO) {
        teamGalleryService.updateTeamGallery(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除员工风采")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteTeamGallery(@RequestParam("id") Long id) {
        teamGalleryService.deleteTeamGallery(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得员工风采")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<TeamGalleryRespVO> getTeamGallery(@RequestParam("id") Long id) {
        TeamGalleryDO item = teamGalleryService.getTeamGallery(id);
        return success(toRespVO(item));
    }

    @GetMapping("/page")
    @Operation(summary = "获得员工风采分页")
    public CommonResult<PageResult<TeamGalleryRespVO>> getTeamGalleryPage(@Valid TeamGalleryPageReqVO pageVO) {
        PageResult<TeamGalleryDO> page = teamGalleryService.getTeamGalleryPage(pageVO);
        PageResult<TeamGalleryRespVO> result = BeanUtils.toBean(page, TeamGalleryRespVO.class);
        List<TeamGalleryRespVO> list = new ArrayList<>();
        for (TeamGalleryDO item : page.getList()) {
            list.add(toRespVO(item));
        }
        result.setList(list);
        return success(result);
    }

    /**
     * 单条 DO -> VO，并补充 images 数组（前端多图组件使用）
     */
    private TeamGalleryRespVO toRespVO(TeamGalleryDO item) {
        TeamGalleryRespVO vo = BeanUtils.toBean(item, TeamGalleryRespVO.class);
        if (item != null && item.getImage() != null) {
            vo.setImages(List.of(item.getImage()));
        } else {
            vo.setImages(new ArrayList<>());
        }
        return vo;
    }

}

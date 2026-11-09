package cn.iocoder.yudao.module.site.controller.admin.announcement;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementRespVO;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.announcement.AnnouncementDO;
import cn.iocoder.yudao.module.site.service.announcement.AnnouncementService;
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
 * 管理后台 - 公告
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 公告")
@RestController
@RequestMapping("/site/announcement")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class AnnouncementController {

    @Resource
    private AnnouncementService announcementService;

    @PostMapping("/create")
    @Operation(summary = "创建公告")
    public CommonResult<Long> createAnnouncement(@Valid @RequestBody AnnouncementSaveReqVO createReqVO) {
        return success(announcementService.createAnnouncement(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新公告")
    public CommonResult<Boolean> updateAnnouncement(@Valid @RequestBody AnnouncementSaveReqVO updateReqVO) {
        announcementService.updateAnnouncement(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除公告")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteAnnouncement(@RequestParam("id") Long id) {
        announcementService.deleteAnnouncement(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得公告")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<AnnouncementRespVO> getAnnouncement(@RequestParam("id") Long id) {
        AnnouncementDO announcement = announcementService.getAnnouncement(id);
        return success(BeanUtils.toBean(announcement, AnnouncementRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得公告分页")
    public CommonResult<PageResult<AnnouncementRespVO>> getAnnouncementPage(@Valid AnnouncementPageReqVO pageVO) {
        PageResult<AnnouncementDO> page = announcementService.getAnnouncementPage(pageVO);
        return success(BeanUtils.toBean(page, AnnouncementRespVO.class));
    }

}

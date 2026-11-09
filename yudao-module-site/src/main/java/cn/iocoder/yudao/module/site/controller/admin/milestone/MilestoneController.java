package cn.iocoder.yudao.module.site.controller.admin.milestone;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestonePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestoneRespVO;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestoneSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.milestone.MilestoneDO;
import cn.iocoder.yudao.module.site.service.milestone.MilestoneService;
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
 * 管理后台 - 发展历程
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 发展历程")
@RestController
@RequestMapping("/site/company-milestone")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class MilestoneController {

    @Resource
    private MilestoneService milestoneService;

    @PostMapping("/create")
    @Operation(summary = "创建发展历程事件")
    public CommonResult<Long> createMilestone(@Valid @RequestBody MilestoneSaveReqVO createReqVO) {
        return success(milestoneService.createMilestone(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新发展历程")
    public CommonResult<Boolean> updateMilestone(@Valid @RequestBody MilestoneSaveReqVO updateReqVO) {
        milestoneService.updateMilestone(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除发展历程")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteMilestone(@RequestParam("id") Long id) {
        milestoneService.deleteMilestone(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得发展历程")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<MilestoneRespVO> getMilestone(@RequestParam("id") Long id) {
        MilestoneDO milestone = milestoneService.getMilestone(id);
        return success(BeanUtils.toBean(milestone, MilestoneRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得发展历程分页")
    public CommonResult<PageResult<MilestoneRespVO>> getMilestonePage(@Valid MilestonePageReqVO pageVO) {
        PageResult<MilestoneDO> page = milestoneService.getMilestonePage(pageVO);
        return success(BeanUtils.toBean(page, MilestoneRespVO.class));
    }

}

package cn.iocoder.yudao.module.site.controller.admin.job;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobRespVO;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.job.SiteJobDO;
import cn.iocoder.yudao.module.site.service.job.SiteJobService;
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
 * 管理后台 - 招聘职位
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 招聘职位")
@RestController
@RequestMapping("/site/job")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class SiteJobController {

    @Resource
    private SiteJobService siteJobService;

    @PostMapping("/create")
    @Operation(summary = "创建招聘职位")
    public CommonResult<Long> createJob(@Valid @RequestBody SiteJobSaveReqVO createReqVO) {
        return success(siteJobService.createJob(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新招聘职位")
    public CommonResult<Boolean> updateJob(@Valid @RequestBody SiteJobSaveReqVO updateReqVO) {
        siteJobService.updateJob(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除招聘职位")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteJob(@RequestParam("id") Long id) {
        siteJobService.deleteJob(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得招聘职位")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<SiteJobRespVO> getJob(@RequestParam("id") Long id) {
        SiteJobDO job = siteJobService.getJob(id);
        return success(BeanUtils.toBean(job, SiteJobRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得招聘职位分页")
    public CommonResult<PageResult<SiteJobRespVO>> getJobPage(@Valid SiteJobPageReqVO pageVO) {
        PageResult<SiteJobDO> page = siteJobService.getJobPage(pageVO);
        return success(BeanUtils.toBean(page, SiteJobRespVO.class));
    }

}

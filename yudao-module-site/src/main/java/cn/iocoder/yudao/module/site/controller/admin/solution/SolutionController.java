package cn.iocoder.yudao.module.site.controller.admin.solution;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionRespVO;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.solution.SolutionDO;
import cn.iocoder.yudao.module.site.service.solution.SolutionService;
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
 * 管理后台 - 解决方案
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 解决方案")
@RestController
@RequestMapping("/site/solution")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class SolutionController {

    @Resource
    private SolutionService solutionService;

    @PostMapping("/create")
    @Operation(summary = "创建解决方案")
    public CommonResult<Long> createSolution(@Valid @RequestBody SolutionSaveReqVO createReqVO) {
        return success(solutionService.createSolution(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新解决方案")
    public CommonResult<Boolean> updateSolution(@Valid @RequestBody SolutionSaveReqVO updateReqVO) {
        solutionService.updateSolution(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除解决方案")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteSolution(@RequestParam("id") Long id) {
        solutionService.deleteSolution(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得解决方案")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<SolutionRespVO> getSolution(@RequestParam("id") Long id) {
        SolutionDO solution = solutionService.getSolution(id);
        return success(BeanUtils.toBean(solution, SolutionRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得解决方案分页")
    public CommonResult<PageResult<SolutionRespVO>> getSolutionPage(@Valid SolutionPageReqVO pageVO) {
        PageResult<SolutionDO> page = solutionService.getSolutionPage(pageVO);
        return success(BeanUtils.toBean(page, SolutionRespVO.class));
    }

}

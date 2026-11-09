package cn.iocoder.yudao.module.site.controller.admin.techservice;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServicePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServiceRespVO;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServiceSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.techservice.TechServiceDO;
import cn.iocoder.yudao.module.site.service.techservice.TechServiceService;
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
 * 管理后台 - 技术服务
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 技术服务")
@RestController
@RequestMapping("/site/tech-service")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class TechServiceController {

    @Resource
    private TechServiceService techServiceService;

    @PostMapping("/create")
    @Operation(summary = "创建技术服务")
    public CommonResult<Long> createTechService(@Valid @RequestBody TechServiceSaveReqVO createReqVO) {
        return success(techServiceService.createTechService(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新技术服务")
    public CommonResult<Boolean> updateTechService(@Valid @RequestBody TechServiceSaveReqVO updateReqVO) {
        techServiceService.updateTechService(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除技术服务")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteTechService(@RequestParam("id") Long id) {
        techServiceService.deleteTechService(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得技术服务")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<TechServiceRespVO> getTechService(@RequestParam("id") Long id) {
        TechServiceDO techService = techServiceService.getTechService(id);
        return success(BeanUtils.toBean(techService, TechServiceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得技术服务分页")
    public CommonResult<PageResult<TechServiceRespVO>> getTechServicePage(@Valid TechServicePageReqVO pageVO) {
        PageResult<TechServiceDO> page = techServiceService.getTechServicePage(pageVO);
        return success(BeanUtils.toBean(page, TechServiceRespVO.class));
    }

}

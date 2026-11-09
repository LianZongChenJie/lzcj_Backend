package cn.iocoder.yudao.module.site.controller.admin.companyintro;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroRespVO;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.companyintro.CompanyIntroDO;
import cn.iocoder.yudao.module.site.service.companyintro.CompanyIntroService;
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
 * 管理后台 - 公司介绍
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 公司介绍")
@RestController
@RequestMapping("/site/company-intro")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class CompanyIntroController {

    @Resource
    private CompanyIntroService companyIntroService;

    @PostMapping("/create")
    @Operation(summary = "创建公司介绍版本")
    public CommonResult<Long> createCompanyIntro(@Valid @RequestBody CompanyIntroSaveReqVO createReqVO) {
        return success(companyIntroService.createCompanyIntro(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新公司介绍")
    public CommonResult<Boolean> updateCompanyIntro(@Valid @RequestBody CompanyIntroSaveReqVO updateReqVO) {
        companyIntroService.updateCompanyIntro(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除公司介绍版本")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteCompanyIntro(@RequestParam("id") Long id) {
        companyIntroService.deleteCompanyIntro(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得公司介绍")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<CompanyIntroRespVO> getCompanyIntro(@RequestParam("id") Long id) {
        CompanyIntroDO companyIntro = companyIntroService.getCompanyIntro(id);
        return success(BeanUtils.toBean(companyIntro, CompanyIntroRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得公司介绍分页")
    public CommonResult<PageResult<CompanyIntroRespVO>> getCompanyIntroPage(@Valid CompanyIntroPageReqVO pageVO) {
        PageResult<CompanyIntroDO> page = companyIntroService.getCompanyIntroPage(pageVO);
        return success(BeanUtils.toBean(page, CompanyIntroRespVO.class));
    }

}

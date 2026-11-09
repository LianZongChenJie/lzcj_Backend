package cn.iocoder.yudao.module.site.controller.admin.culture;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CulturePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CultureRespVO;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CultureSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.culture.CultureDO;
import cn.iocoder.yudao.module.site.service.culture.CultureService;
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
 * 管理后台 - 企业文化
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 企业文化")
@RestController
@RequestMapping("/site/company-culture")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class CultureController {

    @Resource
    private CultureService cultureService;

    @PostMapping("/create")
    @Operation(summary = "创建企业文化版本")
    public CommonResult<Long> createCulture(@Valid @RequestBody CultureSaveReqVO createReqVO) {
        return success(cultureService.createCulture(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新企业文化")
    public CommonResult<Boolean> updateCulture(@Valid @RequestBody CultureSaveReqVO updateReqVO) {
        cultureService.updateCulture(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除企业文化版本")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteCulture(@RequestParam("id") Long id) {
        cultureService.deleteCulture(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得企业文化")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<CultureRespVO> getCulture(@RequestParam("id") Long id) {
        CultureDO culture = cultureService.getCulture(id);
        CultureRespVO respVO = BeanUtils.toBean(culture, CultureRespVO.class);
        // coreValues -> values（数据库列名为 core_values，接口字段保持 values）
        respVO.setValues(culture.getCoreValues());
        return success(respVO);
    }

    @GetMapping("/page")
    @Operation(summary = "获得企业文化分页")
    public CommonResult<PageResult<CultureRespVO>> getCulturePage(@Valid CulturePageReqVO pageVO) {
        PageResult<CultureDO> page = cultureService.getCulturePage(pageVO);
        PageResult<CultureRespVO> result = BeanUtils.toBean(page, CultureRespVO.class);
        // coreValues -> values（数据库列名为 core_values，接口字段保持 values）
        List<CultureRespVO> list = result.getList();
        List<CultureDO> doList = page.getList();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setValues(doList.get(i).getCoreValues());
        }
        return success(result);
    }

}

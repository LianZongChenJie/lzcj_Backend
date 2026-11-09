package cn.iocoder.yudao.module.site.controller.admin.honor;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorRespVO;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.honor.HonorDO;
import cn.iocoder.yudao.module.site.service.honor.HonorService;
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
 * 管理后台 - 资质荣誉
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 资质荣誉")
@RestController
@RequestMapping("/site/honor")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class HonorController {

    @Resource
    private HonorService honorService;

    @PostMapping("/create")
    @Operation(summary = "创建资质荣誉")
    public CommonResult<Long> createHonor(@Valid @RequestBody HonorSaveReqVO createReqVO) {
        return success(honorService.createHonor(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新资质荣誉")
    public CommonResult<Boolean> updateHonor(@Valid @RequestBody HonorSaveReqVO updateReqVO) {
        honorService.updateHonor(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除资质荣誉")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteHonor(@RequestParam("id") Long id) {
        honorService.deleteHonor(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得资质荣誉")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<HonorRespVO> getHonor(@RequestParam("id") Long id) {
        HonorDO honor = honorService.getHonor(id);
        return success(toRespVO(honor));
    }

    @GetMapping("/page")
    @Operation(summary = "获得资质荣誉分页")
    public CommonResult<PageResult<HonorRespVO>> getHonorPage(@Valid HonorPageReqVO pageVO) {
        PageResult<HonorDO> page = honorService.getHonorPage(pageVO);
        PageResult<HonorRespVO> result = BeanUtils.toBean(page, HonorRespVO.class);
        List<HonorRespVO> list = new ArrayList<>();
        for (HonorDO honor : page.getList()) {
            list.add(toRespVO(honor));
        }
        result.setList(list);
        return success(result);
    }

    /**
     * 单条 DO -> VO，并补充 images 数组（前端多图组件使用）
     */
    private HonorRespVO toRespVO(HonorDO honor) {
        HonorRespVO vo = BeanUtils.toBean(honor, HonorRespVO.class);
        if (honor != null && honor.getImage() != null) {
            vo.setImages(List.of(honor.getImage()));
        } else {
            vo.setImages(new ArrayList<>());
        }
        return vo;
    }

}

package cn.iocoder.yudao.module.site.controller.admin.branchcontact;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactRespVO;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.branchcontact.BranchContactDO;
import cn.iocoder.yudao.module.site.service.branchcontact.BranchContactService;
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
 * 管理后台 - 分公司联系方式
 *
 * @author 联纵宸捷
 */
@Tag(name = "管理后台 - 分公司联系方式")
@RestController
@RequestMapping("/site/branch-contact")
@Validated
@PreAuthorize("@ss.hasPermission('site:content')")
public class BranchContactController {

    @Resource
    private BranchContactService branchContactService;

    @PostMapping("/create")
    @Operation(summary = "创建分公司联系方式")
    public CommonResult<Long> createBranchContact(@Valid @RequestBody BranchContactSaveReqVO createReqVO) {
        return success(branchContactService.createBranchContact(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新分公司联系方式")
    public CommonResult<Boolean> updateBranchContact(@Valid @RequestBody BranchContactSaveReqVO updateReqVO) {
        branchContactService.updateBranchContact(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除分公司联系方式")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteBranchContact(@RequestParam("id") Long id) {
        branchContactService.deleteBranchContact(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得分公司联系方式")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<BranchContactRespVO> getBranchContact(@RequestParam("id") Long id) {
        BranchContactDO branchContact = branchContactService.getBranchContact(id);
        return success(BeanUtils.toBean(branchContact, BranchContactRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得分公司联系方式分页")
    public CommonResult<PageResult<BranchContactRespVO>> getBranchContactPage(@Valid BranchContactPageReqVO pageVO) {
        PageResult<BranchContactDO> page = branchContactService.getBranchContactPage(pageVO);
        return success(BeanUtils.toBean(page, BranchContactRespVO.class));
    }

}

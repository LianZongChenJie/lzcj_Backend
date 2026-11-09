package cn.iocoder.yudao.module.site.service.branchcontact;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.branchcontact.BranchContactDO;

import java.util.List;

/**
 * 分公司联系方式 业务接口
 *
 * @author 联纵宸捷
 */
public interface BranchContactService {

    /**
     * 获取分公司联系方式分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 分公司联系方式分页结果
     */
    PageResult<BranchContactDO> getBranchContactPage(BranchContactPageReqVO pageReqVO);

    /**
     * 根据ID获取分公司联系方式详情
     *
     * @param id 分公司联系方式ID
     * @return 分公司联系方式详情
     */
    BranchContactDO getBranchContact(Long id);

    /**
     * 创建分公司联系方式
     *
     * @param createReqVO 创建参数
     * @return 分公司联系方式ID
     */
    Long createBranchContact(BranchContactSaveReqVO createReqVO);

    /**
     * 更新分公司联系方式
     *
     * @param updateReqVO 更新参数
     */
    void updateBranchContact(BranchContactSaveReqVO updateReqVO);

    /**
     * 删除分公司联系方式
     *
     * @param id 分公司联系方式ID
     */
    void deleteBranchContact(Long id);

    /**
     * 获取当前启用的分公司联系方式列表（用于展示端）
     *
     * @return 分公司联系方式列表
     */
    List<BranchContactDO> getBranchContactListEnabled();

}

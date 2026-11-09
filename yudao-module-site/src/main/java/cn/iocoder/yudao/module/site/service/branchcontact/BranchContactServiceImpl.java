package cn.iocoder.yudao.module.site.service.branchcontact;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.branchcontact.BranchContactDO;
import cn.iocoder.yudao.module.site.dal.mysql.branchcontact.BranchContactMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.BRANCH_CONTACT_NOT_EXISTS;

/**
 * 分公司联系方式 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class BranchContactServiceImpl implements BranchContactService {

    @Resource
    private BranchContactMapper branchContactMapper;

    @Override
    public PageResult<BranchContactDO> getBranchContactPage(BranchContactPageReqVO pageReqVO) {
        return branchContactMapper.selectPage(pageReqVO);
    }

    @Override
    public BranchContactDO getBranchContact(Long id) {
        return branchContactMapper.selectById(id);
    }

    @Override
    public Long createBranchContact(BranchContactSaveReqVO createReqVO) {
        // 插入
        BranchContactDO branchContact = new BranchContactDO();
        branchContact.setCity(createReqVO.getCity());
        branchContact.setAddress(createReqVO.getAddress());
        branchContact.setPhone(createReqVO.getPhone());
        branchContact.setPostalCode(createReqVO.getPostalCode());
        branchContact.setEmail(createReqVO.getEmail());
        branchContact.setThemeColor(createReqVO.getThemeColor());
        branchContact.setSort(createReqVO.getSort());
        branchContact.setStatus(createReqVO.getStatus());
        branchContactMapper.insert(branchContact);
        // 返回
        return branchContact.getId();
    }

    @Override
    public void updateBranchContact(BranchContactSaveReqVO updateReqVO) {
        // 校验存在
        validateBranchContactExists(updateReqVO.getId());
        // 更新
        BranchContactDO updateObj = new BranchContactDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setCity(updateReqVO.getCity());
        updateObj.setAddress(updateReqVO.getAddress());
        updateObj.setPhone(updateReqVO.getPhone());
        updateObj.setPostalCode(updateReqVO.getPostalCode());
        updateObj.setEmail(updateReqVO.getEmail());
        updateObj.setThemeColor(updateReqVO.getThemeColor());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        branchContactMapper.updateById(updateObj);
    }

    @Override
    public void deleteBranchContact(Long id) {
        // 校验存在
        validateBranchContactExists(id);
        // 删除
        branchContactMapper.deleteById(id);
    }

    @Override
    public List<BranchContactDO> getBranchContactListEnabled() {
        return branchContactMapper.selectListEnabled();
    }

    private void validateBranchContactExists(Long id) {
        if (branchContactMapper.selectById(id) == null) {
            throw exception(BRANCH_CONTACT_NOT_EXISTS);
        }
    }

}

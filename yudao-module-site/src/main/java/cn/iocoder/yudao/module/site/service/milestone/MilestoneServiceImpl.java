package cn.iocoder.yudao.module.site.service.milestone;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestonePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestoneSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.milestone.MilestoneDO;
import cn.iocoder.yudao.module.site.dal.mysql.milestone.MilestoneMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.Milestone_NOT_EXISTS;

/**
 * 发展历程 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class MilestoneServiceImpl implements MilestoneService {

    @Resource
    private MilestoneMapper milestoneMapper;

    @Override
    public PageResult<MilestoneDO> getMilestonePage(MilestonePageReqVO pageReqVO) {
        return milestoneMapper.selectPage(pageReqVO);
    }

    @Override
    public MilestoneDO getMilestone(Long id) {
        return milestoneMapper.selectById(id);
    }

    @Override
    public Long createMilestone(MilestoneSaveReqVO createReqVO) {
        // 插入
        MilestoneDO milestone = new MilestoneDO();
        milestone.setYear(createReqVO.getYear());
        milestone.setTitle(createReqVO.getTitle());
        milestone.setDescription(createReqVO.getDescription());
        milestone.setSort(createReqVO.getSort());
        milestone.setStatus(createReqVO.getStatus());
        milestoneMapper.insert(milestone);
        // 返回
        return milestone.getId();
    }

    @Override
    public void updateMilestone(MilestoneSaveReqVO updateReqVO) {
        // 校验存在
        validateMilestoneExists(updateReqVO.getId());
        // 更新
        MilestoneDO updateObj = new MilestoneDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setYear(updateReqVO.getYear());
        updateObj.setTitle(updateReqVO.getTitle());
        updateObj.setDescription(updateReqVO.getDescription());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        milestoneMapper.updateById(updateObj);
    }

    @Override
    public void deleteMilestone(Long id) {
        // 校验存在
        validateMilestoneExists(id);
        // 删除
        milestoneMapper.deleteById(id);
    }

    @Override
    public void deleteMilestoneList(List<Long> ids) {
        // 批量删除
        milestoneMapper.deleteBatchIds(ids);
    }

    @Override
    public List<MilestoneDO> getMilestoneListEnabled() {
        return milestoneMapper.selectListEnabled();
    }

    private void validateMilestoneExists(Long id) {
        if (milestoneMapper.selectById(id) == null) {
            throw exception(Milestone_NOT_EXISTS);
        }
    }

}

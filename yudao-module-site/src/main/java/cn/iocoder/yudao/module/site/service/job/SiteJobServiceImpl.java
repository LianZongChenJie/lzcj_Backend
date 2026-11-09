package cn.iocoder.yudao.module.site.service.job;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.job.SiteJobDO;
import cn.iocoder.yudao.module.site.dal.mysql.job.SiteJobMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.JOB_NOT_EXISTS;

/**
 * 招聘职位 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class SiteJobServiceImpl implements SiteJobService {

    @Resource
    private SiteJobMapper siteJobMapper;

    @Override
    public PageResult<SiteJobDO> getJobPage(SiteJobPageReqVO pageReqVO) {
        return siteJobMapper.selectPage(pageReqVO);
    }

    @Override
    public SiteJobDO getJob(Long id) {
        return siteJobMapper.selectById(id);
    }

    @Override
    public Long createJob(SiteJobSaveReqVO createReqVO) {
        // 插入
        SiteJobDO job = new SiteJobDO();
        job.setTitle(createReqVO.getTitle());
        job.setLocation(createReqVO.getLocation());
        job.setDepartment(createReqVO.getDepartment());
        job.setType(createReqVO.getType());
        job.setUrgent(createReqVO.getUrgent());
        job.setResponsibilities(createReqVO.getResponsibilities());
        job.setRequirements(createReqVO.getRequirements());
        job.setHeadcount(createReqVO.getHeadcount());
        job.setStatus(createReqVO.getStatus());
        siteJobMapper.insert(job);
        // 返回
        return job.getId();
    }

    @Override
    public void updateJob(SiteJobSaveReqVO updateReqVO) {
        // 校验存在
        validateJobExists(updateReqVO.getId());
        // 更新
        SiteJobDO updateObj = new SiteJobDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setTitle(updateReqVO.getTitle());
        updateObj.setLocation(updateReqVO.getLocation());
        updateObj.setDepartment(updateReqVO.getDepartment());
        updateObj.setType(updateReqVO.getType());
        updateObj.setUrgent(updateReqVO.getUrgent());
        updateObj.setResponsibilities(updateReqVO.getResponsibilities());
        updateObj.setRequirements(updateReqVO.getRequirements());
        updateObj.setHeadcount(updateReqVO.getHeadcount());
        updateObj.setStatus(updateReqVO.getStatus());
        siteJobMapper.updateById(updateObj);
    }

    @Override
    public void deleteJob(Long id) {
        // 校验存在
        validateJobExists(id);
        // 删除
        siteJobMapper.deleteById(id);
    }

    @Override
    public List<SiteJobDO> getJobListEnabled() {
        return siteJobMapper.selectListEnabled();
    }

    private void validateJobExists(Long id) {
        if (siteJobMapper.selectById(id) == null) {
            throw exception(JOB_NOT_EXISTS);
        }
    }

}

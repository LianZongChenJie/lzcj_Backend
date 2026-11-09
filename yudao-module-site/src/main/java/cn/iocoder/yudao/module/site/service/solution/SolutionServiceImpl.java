package cn.iocoder.yudao.module.site.service.solution;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.solution.SolutionDO;
import cn.iocoder.yudao.module.site.dal.mysql.solution.SolutionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.SOLUTION_NOT_EXISTS;

/**
 * 解决方案 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class SolutionServiceImpl implements SolutionService {

    @Resource
    private SolutionMapper solutionMapper;

    @Override
    public PageResult<SolutionDO> getSolutionPage(SolutionPageReqVO pageReqVO) {
        return solutionMapper.selectPage(pageReqVO);
    }

    @Override
    public SolutionDO getSolution(Long id) {
        return solutionMapper.selectById(id);
    }

    @Override
    public Long createSolution(SolutionSaveReqVO createReqVO) {
        // 插入
        SolutionDO solution = new SolutionDO();
        solution.setName(createReqVO.getName());
        solution.setImage(createReqVO.getImage());
        solution.setIndustry(createReqVO.getIndustry());
        solution.setSummary(createReqVO.getSummary());
        solution.setDescription(createReqVO.getDescription());
        solution.setDemandAnalysis(createReqVO.getDemandAnalysis());
        solution.setSort(createReqVO.getSort());
        solution.setStatus(createReqVO.getStatus());
        solutionMapper.insert(solution);
        // 返回
        return solution.getId();
    }

    @Override
    public void updateSolution(SolutionSaveReqVO updateReqVO) {
        // 校验存在
        validateSolutionExists(updateReqVO.getId());
        // 更新
        SolutionDO updateObj = new SolutionDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setName(updateReqVO.getName());
        updateObj.setImage(updateReqVO.getImage());
        updateObj.setIndustry(updateReqVO.getIndustry());
        updateObj.setSummary(updateReqVO.getSummary());
        updateObj.setDescription(updateReqVO.getDescription());
        updateObj.setDemandAnalysis(updateReqVO.getDemandAnalysis());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        solutionMapper.updateById(updateObj);
    }

    @Override
    public void deleteSolution(Long id) {
        // 校验存在
        validateSolutionExists(id);
        // 删除
        solutionMapper.deleteById(id);
    }

    @Override
    public List<SolutionDO> getSolutionListEnabled() {
        return solutionMapper.selectListEnabled();
    }

    private void validateSolutionExists(Long id) {
        if (solutionMapper.selectById(id) == null) {
            throw exception(SOLUTION_NOT_EXISTS);
        }
    }

}

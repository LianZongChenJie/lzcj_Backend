package cn.iocoder.yudao.module.site.service.solution;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.solution.SolutionDO;

import java.util.List;

/**
 * 解决方案 业务接口
 *
 * @author 联纵宸捷
 */
public interface SolutionService {

    /**
     * 获取解决方案分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 解决方案分页结果
     */
    PageResult<SolutionDO> getSolutionPage(SolutionPageReqVO pageReqVO);

    /**
     * 根据ID获取解决方案详情
     *
     * @param id 解决方案ID
     * @return 解决方案详情
     */
    SolutionDO getSolution(Long id);

    /**
     * 创建解决方案
     *
     * @param createReqVO 创建参数
     * @return 解决方案ID
     */
    Long createSolution(SolutionSaveReqVO createReqVO);

    /**
     * 更新解决方案
     *
     * @param updateReqVO 更新参数
     */
    void updateSolution(SolutionSaveReqVO updateReqVO);

    /**
     * 删除解决方案
     *
     * @param id 解决方案ID
     */
    void deleteSolution(Long id);

    /**
     * 获取当前启用的解决方案列表（用于展示端）
     *
     * @return 解决方案列表
     */
    List<SolutionDO> getSolutionListEnabled();

}

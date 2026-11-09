package cn.iocoder.yudao.module.site.service.milestone;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestonePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestoneSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.milestone.MilestoneDO;

import java.util.List;

/**
 * 发展历程 业务接口
 *
 * @author 联纵宸捷
 */
public interface MilestoneService {

    /**
     * 获取发展历程分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 发展历程分页结果
     */
    PageResult<MilestoneDO> getMilestonePage(MilestonePageReqVO pageReqVO);

    /**
     * 根据ID获取发展历程详情
     *
     * @param id 发展历程ID
     * @return 发展历程详情
     */
    MilestoneDO getMilestone(Long id);

    /**
     * 创建发展历程事件
     *
     * @param createReqVO 创建参数
     * @return 发展历程ID
     */
    Long createMilestone(MilestoneSaveReqVO createReqVO);

    /**
     * 更新发展历程
     *
     * @param updateReqVO 更新参数
     */
    void updateMilestone(MilestoneSaveReqVO updateReqVO);

    /**
     * 删除发展历程
     *
     * @param id 发展历程ID
     */
    void deleteMilestone(Long id);

    /**
     * 批量删除发展历程
     *
     * @param ids 发展历程ID列表
     */
    void deleteMilestoneList(List<Long> ids);

    /**
     * 获取启用的发展历程列表（用于展示端）
     *
     * @return 发展历程列表
     */
    List<MilestoneDO> getMilestoneListEnabled();

}

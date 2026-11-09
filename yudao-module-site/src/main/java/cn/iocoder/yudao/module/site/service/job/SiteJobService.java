package cn.iocoder.yudao.module.site.service.job;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.job.SiteJobDO;

import java.util.List;

/**
 * 招聘职位 业务接口
 *
 * @author 联纵宸捷
 */
public interface SiteJobService {

    /**
     * 获取招聘职位分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 招聘职位分页结果
     */
    PageResult<SiteJobDO> getJobPage(SiteJobPageReqVO pageReqVO);

    /**
     * 根据ID获取招聘职位详情
     *
     * @param id 招聘职位ID
     * @return 招聘职位详情
     */
    SiteJobDO getJob(Long id);

    /**
     * 创建招聘职位
     *
     * @param createReqVO 创建参数
     * @return 招聘职位ID
     */
    Long createJob(SiteJobSaveReqVO createReqVO);

    /**
     * 更新招聘职位
     *
     * @param updateReqVO 更新参数
     */
    void updateJob(SiteJobSaveReqVO updateReqVO);

    /**
     * 删除招聘职位
     *
     * @param id 招聘职位ID
     */
    void deleteJob(Long id);

    /**
     * 获取当前招聘中的职位列表（用于展示端）
     *
     * @return 招聘职位列表
     */
    List<SiteJobDO> getJobListEnabled();

}

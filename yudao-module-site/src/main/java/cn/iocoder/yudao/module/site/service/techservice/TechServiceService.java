package cn.iocoder.yudao.module.site.service.techservice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServicePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServiceSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.techservice.TechServiceDO;

import java.util.List;

/**
 * 技术服务 业务接口
 *
 * @author 联纵宸捷
 */
public interface TechServiceService {

    /**
     * 获取技术服务分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 技术服务分页结果
     */
    PageResult<TechServiceDO> getTechServicePage(TechServicePageReqVO pageReqVO);

    /**
     * 根据ID获取技术服务详情
     *
     * @param id 技术服务ID
     * @return 技术服务详情
     */
    TechServiceDO getTechService(Long id);

    /**
     * 创建技术服务
     *
     * @param createReqVO 创建参数
     * @return 技术服务ID
     */
    Long createTechService(TechServiceSaveReqVO createReqVO);

    /**
     * 更新技术服务
     *
     * @param updateReqVO 更新参数
     */
    void updateTechService(TechServiceSaveReqVO updateReqVO);

    /**
     * 删除技术服务
     *
     * @param id 技术服务ID
     */
    void deleteTechService(Long id);

    /**
     * 获取当前启用的技术服务列表（用于展示端）
     *
     * @return 技术服务列表
     */
    List<TechServiceDO> getTechServiceListEnabled();

}

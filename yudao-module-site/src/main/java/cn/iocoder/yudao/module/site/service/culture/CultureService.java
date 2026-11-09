package cn.iocoder.yudao.module.site.service.culture;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CulturePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CultureSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.culture.CultureDO;

/**
 * 企业文化 业务接口
 *
 * @author 联纵宸捷
 */
public interface CultureService {

    /**
     * 获取企业文化分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 企业文化分页结果
     */
    PageResult<CultureDO> getCulturePage(CulturePageReqVO pageReqVO);

    /**
     * 根据ID获取企业文化详情
     *
     * @param id 企业文化ID
     * @return 企业文化详情
     */
    CultureDO getCulture(Long id);

    /**
     * 创建企业文化版本
     *
     * @param createReqVO 创建参数
     * @return 企业文化ID
     */
    Long createCulture(CultureSaveReqVO createReqVO);

    /**
     * 更新企业文化
     *
     * @param updateReqVO 更新参数
     */
    void updateCulture(CultureSaveReqVO updateReqVO);

    /**
     * 删除企业文化
     *
     * @param id 企业文化ID
     */
    void deleteCulture(Long id);

    /**
     * 获取当前生效的企业文化（用于展示端）
     *
     * @return 企业文化详情，不存在时返回 null
     */
    CultureDO getCultureEnabled();

}

package cn.iocoder.yudao.module.site.service.honor;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.honor.HonorDO;

import java.util.List;

/**
 * 资质荣誉 业务接口
 *
 * @author 联纵宸捷
 */
public interface HonorService {

    /**
     * 获取资质荣誉分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 资质荣誉分页结果
     */
    PageResult<HonorDO> getHonorPage(HonorPageReqVO pageReqVO);

    /**
     * 根据ID获取资质荣誉详情
     *
     * @param id 资质荣誉ID
     * @return 资质荣誉详情
     */
    HonorDO getHonor(Long id);

    /**
     * 创建资质荣誉
     *
     * @param createReqVO 创建参数
     * @return 资质荣誉ID
     */
    Long createHonor(HonorSaveReqVO createReqVO);

    /**
     * 更新资质荣誉
     *
     * @param updateReqVO 更新参数
     */
    void updateHonor(HonorSaveReqVO updateReqVO);

    /**
     * 删除资质荣誉
     *
     * @param id 资质荣誉ID
     */
    void deleteHonor(Long id);

    /**
     * 获取当前启用的资质荣誉列表（用于展示端）
     *
     * @return 资质荣誉列表
     */
    List<HonorDO> getHonorListEnabled();

}

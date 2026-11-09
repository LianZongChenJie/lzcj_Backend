package cn.iocoder.yudao.module.site.service.banner;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.banner.BannerDO;

import java.util.List;

/**
 * Banner 业务接口
 *
 * @author 联纵宸捷
 */
public interface BannerService {

    /**
     * 获取 Banner 分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return Banner 分页结果
     */
    PageResult<BannerDO> getBannerPage(BannerPageReqVO pageReqVO);

    /**
     * 根据ID获取 Banner 详情
     *
     * @param id Banner ID
     * @return Banner 详情
     */
    BannerDO getBanner(Long id);

    /**
     * 创建 Banner
     *
     * @param createReqVO 创建参数
     * @return Banner ID
     */
    Long createBanner(BannerSaveReqVO createReqVO);

    /**
     * 更新 Banner
     *
     * @param updateReqVO 更新参数
     */
    void updateBanner(BannerSaveReqVO updateReqVO);

    /**
     * 删除 Banner
     *
     * @param id Banner ID
     */
    void deleteBanner(Long id);

    /**
     * 批量删除 Banner
     *
     * @param ids Banner ID列表
     */
    void deleteBannerList(List<Long> ids);

    /**
     * 获取启用的 Banner 列表（用于前端展示）
     *
     * @return Banner 列表
     */
    List<BannerDO> getBannerListEnabled();

}

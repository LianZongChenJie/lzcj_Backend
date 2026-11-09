package cn.iocoder.yudao.module.site.service.teamgallery;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGalleryPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGallerySaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.teamgallery.TeamGalleryDO;

import java.util.List;

/**
 * 员工风采 业务接口
 *
 * @author 联纵宸捷
 */
public interface TeamGalleryService {

    /**
     * 获取员工风采分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 员工风采分页结果
     */
    PageResult<TeamGalleryDO> getTeamGalleryPage(TeamGalleryPageReqVO pageReqVO);

    /**
     * 根据ID获取员工风采详情
     *
     * @param id 员工风采ID
     * @return 员工风采详情
     */
    TeamGalleryDO getTeamGallery(Long id);

    /**
     * 创建员工风采
     *
     * @param createReqVO 创建参数
     * @return 员工风采ID
     */
    Long createTeamGallery(TeamGallerySaveReqVO createReqVO);

    /**
     * 更新员工风采
     *
     * @param updateReqVO 更新参数
     */
    void updateTeamGallery(TeamGallerySaveReqVO updateReqVO);

    /**
     * 删除员工风采
     *
     * @param id 员工风采ID
     */
    void deleteTeamGallery(Long id);

    /**
     * 获取当前启用的员工风采列表（用于展示端）
     *
     * @return 员工风采列表
     */
    List<TeamGalleryDO> getTeamGalleryListEnabled();

}

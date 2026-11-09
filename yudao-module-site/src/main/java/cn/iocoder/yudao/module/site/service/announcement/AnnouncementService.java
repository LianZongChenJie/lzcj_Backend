package cn.iocoder.yudao.module.site.service.announcement;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.announcement.AnnouncementDO;

import java.util.List;

/**
 * 公告 业务接口
 *
 * @author 联纵宸捷
 */
public interface AnnouncementService {

    /**
     * 获取公告分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 公告分页结果
     */
    PageResult<AnnouncementDO> getAnnouncementPage(AnnouncementPageReqVO pageReqVO);

    /**
     * 根据ID获取公告详情
     *
     * @param id 公告ID
     * @return 公告详情
     */
    AnnouncementDO getAnnouncement(Long id);

    /**
     * 创建公告
     *
     * @param createReqVO 创建参数
     * @return 公告ID
     */
    Long createAnnouncement(AnnouncementSaveReqVO createReqVO);

    /**
     * 更新公告
     *
     * @param updateReqVO 更新参数
     */
    void updateAnnouncement(AnnouncementSaveReqVO updateReqVO);

    /**
     * 删除公告
     *
     * @param id 公告ID
     */
    void deleteAnnouncement(Long id);

    /**
     * 获取当前已发布的公告列表（用于展示端）
     *
     * @return 公告列表
     */
    List<AnnouncementDO> getAnnouncementListEnabled();

}

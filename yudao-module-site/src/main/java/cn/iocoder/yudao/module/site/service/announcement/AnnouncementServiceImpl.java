package cn.iocoder.yudao.module.site.service.announcement;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.announcement.AnnouncementDO;
import cn.iocoder.yudao.module.site.dal.mysql.announcement.AnnouncementMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.ANNOUNCEMENT_NOT_EXISTS;

/**
 * 公告 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private AnnouncementMapper announcementMapper;

    @Override
    public PageResult<AnnouncementDO> getAnnouncementPage(AnnouncementPageReqVO pageReqVO) {
        return announcementMapper.selectPage(pageReqVO);
    }

    @Override
    public AnnouncementDO getAnnouncement(Long id) {
        return announcementMapper.selectById(id);
    }

    @Override
    public Long createAnnouncement(AnnouncementSaveReqVO createReqVO) {
        // 插入
        AnnouncementDO announcement = new AnnouncementDO();
        announcement.setTitle(createReqVO.getTitle());
        announcement.setSummary(createReqVO.getSummary());
        announcement.setContent(createReqVO.getContent());
        announcement.setImportant(createReqVO.getImportant());
        announcement.setPublishDate(createReqVO.getPublishDate());
        announcement.setStatus(createReqVO.getStatus());
        announcementMapper.insert(announcement);
        // 返回
        return announcement.getId();
    }

    @Override
    public void updateAnnouncement(AnnouncementSaveReqVO updateReqVO) {
        // 校验存在
        validateAnnouncementExists(updateReqVO.getId());
        // 更新
        AnnouncementDO updateObj = new AnnouncementDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setTitle(updateReqVO.getTitle());
        updateObj.setSummary(updateReqVO.getSummary());
        updateObj.setContent(updateReqVO.getContent());
        updateObj.setImportant(updateReqVO.getImportant());
        updateObj.setPublishDate(updateReqVO.getPublishDate());
        updateObj.setStatus(updateReqVO.getStatus());
        announcementMapper.updateById(updateObj);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        // 校验存在
        validateAnnouncementExists(id);
        // 删除
        announcementMapper.deleteById(id);
    }

    @Override
    public List<AnnouncementDO> getAnnouncementListEnabled() {
        return announcementMapper.selectListEnabled();
    }

    private void validateAnnouncementExists(Long id) {
        if (announcementMapper.selectById(id) == null) {
            throw exception(ANNOUNCEMENT_NOT_EXISTS);
        }
    }

}

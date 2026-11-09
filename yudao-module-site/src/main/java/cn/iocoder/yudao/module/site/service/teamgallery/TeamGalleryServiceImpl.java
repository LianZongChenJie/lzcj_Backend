package cn.iocoder.yudao.module.site.service.teamgallery;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGalleryPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGallerySaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.teamgallery.TeamGalleryDO;
import cn.iocoder.yudao.module.site.dal.mysql.teamgallery.TeamGalleryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.TEAM_GALLERY_NOT_EXISTS;

/**
 * 员工风采 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class TeamGalleryServiceImpl implements TeamGalleryService {

    @Resource
    private TeamGalleryMapper teamGalleryMapper;

    @Override
    public PageResult<TeamGalleryDO> getTeamGalleryPage(TeamGalleryPageReqVO pageReqVO) {
        return teamGalleryMapper.selectPage(pageReqVO);
    }

    @Override
    public TeamGalleryDO getTeamGallery(Long id) {
        return teamGalleryMapper.selectById(id);
    }

    @Override
    public Long createTeamGallery(TeamGallerySaveReqVO createReqVO) {
        // 插入
        TeamGalleryDO item = new TeamGalleryDO();
        item.setImage(createReqVO.getImage());
        item.setDescription(createReqVO.getDescription());
        item.setSort(createReqVO.getSort());
        item.setStatus(createReqVO.getStatus());
        teamGalleryMapper.insert(item);
        // 返回
        return item.getId();
    }

    @Override
    public void updateTeamGallery(TeamGallerySaveReqVO updateReqVO) {
        // 校验存在
        validateTeamGalleryExists(updateReqVO.getId());
        // 更新
        TeamGalleryDO updateObj = new TeamGalleryDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setImage(updateReqVO.getImage());
        updateObj.setDescription(updateReqVO.getDescription());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        teamGalleryMapper.updateById(updateObj);
    }

    @Override
    public void deleteTeamGallery(Long id) {
        // 校验存在
        validateTeamGalleryExists(id);
        // 删除
        teamGalleryMapper.deleteById(id);
    }

    @Override
    public java.util.List<TeamGalleryDO> getTeamGalleryListEnabled() {
        return teamGalleryMapper.selectListEnabled();
    }

    private void validateTeamGalleryExists(Long id) {
        if (teamGalleryMapper.selectById(id) == null) {
            throw exception(TEAM_GALLERY_NOT_EXISTS);
        }
    }

}

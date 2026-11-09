package cn.iocoder.yudao.module.site.dal.mysql.announcement;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.announcement.vo.AnnouncementPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.announcement.AnnouncementDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公告 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface AnnouncementMapper extends BaseMapperX<AnnouncementDO> {

    default PageResult<AnnouncementDO> selectPage(AnnouncementPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AnnouncementDO>()
                .likeIfPresent(AnnouncementDO::getTitle, reqVO.getTitle())
                .eqIfPresent(AnnouncementDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AnnouncementDO::getImportant, reqVO.getImportant())
                .orderByDesc(AnnouncementDO::getPublishDate)
                .orderByDesc(AnnouncementDO::getId));
    }

    /**
     * 查询当前已发布的公告列表（status=1，按发布日期倒序）
     */
    default List<AnnouncementDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<AnnouncementDO>()
                .eq(AnnouncementDO::getStatus, 1)
                .orderByDesc(AnnouncementDO::getPublishDate)
                .orderByDesc(AnnouncementDO::getId));
    }

}

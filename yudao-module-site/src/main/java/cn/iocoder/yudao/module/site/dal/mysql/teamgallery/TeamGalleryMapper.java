package cn.iocoder.yudao.module.site.dal.mysql.teamgallery;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.teamgallery.vo.TeamGalleryPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.teamgallery.TeamGalleryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工风采 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface TeamGalleryMapper extends BaseMapperX<TeamGalleryDO> {

    default PageResult<TeamGalleryDO> selectPage(TeamGalleryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TeamGalleryDO>()
                .eqIfPresent(TeamGalleryDO::getSort, reqVO.getSort())
                .eqIfPresent(TeamGalleryDO::getStatus, reqVO.getStatus())
                .orderByDesc(TeamGalleryDO::getId));
    }

    /**
     * 查询当前启用的员工风采列表（status=1，按 sort 升序）
     */
    default List<TeamGalleryDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<TeamGalleryDO>()
                .eq(TeamGalleryDO::getStatus, 1)
                .orderByAsc(TeamGalleryDO::getSort)
                .orderByDesc(TeamGalleryDO::getId));
    }

}

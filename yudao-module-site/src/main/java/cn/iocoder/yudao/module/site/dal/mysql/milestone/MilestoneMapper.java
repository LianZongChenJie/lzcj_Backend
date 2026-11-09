package cn.iocoder.yudao.module.site.dal.mysql.milestone;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.milestone.vo.MilestonePageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.milestone.MilestoneDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 发展历程 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface MilestoneMapper extends BaseMapperX<MilestoneDO> {

    default PageResult<MilestoneDO> selectPage(MilestonePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MilestoneDO>()
                .eqIfPresent(MilestoneDO::getYear, reqVO.getYear())
                .eqIfPresent(MilestoneDO::getStatus, reqVO.getStatus())
                .orderByAsc(MilestoneDO::getSort)
                .orderByDesc(MilestoneDO::getId));
    }

    /**
     * 查询启用的发展历程列表（按排序号升序，用于展示端）
     */
    default List<MilestoneDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<MilestoneDO>()
                .eq(MilestoneDO::getStatus, 1)
                .orderByAsc(MilestoneDO::getSort));
    }

}

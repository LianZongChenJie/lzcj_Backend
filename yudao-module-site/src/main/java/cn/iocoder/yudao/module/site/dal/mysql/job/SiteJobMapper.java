package cn.iocoder.yudao.module.site.dal.mysql.job;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.job.vo.SiteJobPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.job.SiteJobDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 招聘职位 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface SiteJobMapper extends BaseMapperX<SiteJobDO> {

    default PageResult<SiteJobDO> selectPage(SiteJobPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SiteJobDO>()
                .likeIfPresent(SiteJobDO::getTitle, reqVO.getTitle())
                .eqIfPresent(SiteJobDO::getLocation, reqVO.getLocation())
                .eqIfPresent(SiteJobDO::getDepartment, reqVO.getDepartment())
                .eqIfPresent(SiteJobDO::getType, reqVO.getType())
                .eqIfPresent(SiteJobDO::getUrgent, reqVO.getUrgent())
                .eqIfPresent(SiteJobDO::getStatus, reqVO.getStatus())
                .orderByDesc(SiteJobDO::getId));
    }

    /**
     * 查询当前招聘中的职位列表（status=1，按 id 升序）
     */
    default List<SiteJobDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<SiteJobDO>()
                .eq(SiteJobDO::getStatus, 1)
                .orderByAsc(SiteJobDO::getId));
    }

}

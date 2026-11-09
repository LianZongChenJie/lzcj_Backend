package cn.iocoder.yudao.module.site.dal.mysql.solution;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.solution.vo.SolutionPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.solution.SolutionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 解决方案 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface SolutionMapper extends BaseMapperX<SolutionDO> {

    default PageResult<SolutionDO> selectPage(SolutionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SolutionDO>()
                .likeIfPresent(SolutionDO::getName, reqVO.getName())
                .eqIfPresent(SolutionDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(SolutionDO::getStatus, reqVO.getStatus())
                .orderByAsc(SolutionDO::getSort)
                .orderByDesc(SolutionDO::getId));
    }

    /**
     * 查询当前启用的解决方案列表（status=1，按 sort 升序）
     */
    default List<SolutionDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<SolutionDO>()
                .eq(SolutionDO::getStatus, 1)
                .orderByAsc(SolutionDO::getSort)
                .orderByDesc(SolutionDO::getId));
    }

}

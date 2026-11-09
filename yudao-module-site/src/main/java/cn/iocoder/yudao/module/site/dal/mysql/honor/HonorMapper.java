package cn.iocoder.yudao.module.site.dal.mysql.honor;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.honor.HonorDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资质荣誉 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface HonorMapper extends BaseMapperX<HonorDO> {

    default PageResult<HonorDO> selectPage(HonorPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HonorDO>()
                .eqIfPresent(HonorDO::getType, reqVO.getType())
                .eqIfPresent(HonorDO::getStatus, reqVO.getStatus())
                .eqIfPresent(HonorDO::getSort, reqVO.getSort())
                .likeIfPresent(HonorDO::getName, reqVO.getName())
                .orderByDesc(HonorDO::getId));
    }

    /**
     * 查询当前启用的资质荣誉列表（status=1，按 sort 升序）
     */
    default List<HonorDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<HonorDO>()
                .eq(HonorDO::getStatus, 1)
                .orderByAsc(HonorDO::getSort)
                .orderByDesc(HonorDO::getId));
    }

}

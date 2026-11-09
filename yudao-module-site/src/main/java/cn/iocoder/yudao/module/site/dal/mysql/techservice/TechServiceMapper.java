package cn.iocoder.yudao.module.site.dal.mysql.techservice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServicePageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.techservice.TechServiceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 技术服务 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface TechServiceMapper extends BaseMapperX<TechServiceDO> {

    default PageResult<TechServiceDO> selectPage(TechServicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TechServiceDO>()
                .eqIfPresent(TechServiceDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(TechServiceDO::getStatus, reqVO.getStatus())
                .orderByAsc(TechServiceDO::getSort)
                .orderByDesc(TechServiceDO::getId));
    }

    /**
     * 查询当前启用的技术服务列表（status=1，按 sort 升序）
     */
    default List<TechServiceDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<TechServiceDO>()
                .eq(TechServiceDO::getStatus, 1)
                .orderByAsc(TechServiceDO::getSort)
                .orderByDesc(TechServiceDO::getId));
    }

}

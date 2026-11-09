package cn.iocoder.yudao.module.site.dal.mysql.culture;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CulturePageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.culture.CultureDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企业文化 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface CultureMapper extends BaseMapperX<CultureDO> {

    default PageResult<CultureDO> selectPage(CulturePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CultureDO>()
                .eqIfPresent(CultureDO::getVersion, reqVO.getVersion())
                .eqIfPresent(CultureDO::getStatus, reqVO.getStatus())
                .orderByDesc(CultureDO::getVersion)
                .orderByDesc(CultureDO::getId));
    }

    /**
     * 查询当前生效的企业文化（status=1，版本号最大的一条）
     */
    default CultureDO selectEnabled() {
        return selectOne(new LambdaQueryWrapperX<CultureDO>()
                .eq(CultureDO::getStatus, 1)
                .orderByDesc(CultureDO::getVersion)
                .orderByDesc(CultureDO::getId)
                .last("limit 1"));
    }

}

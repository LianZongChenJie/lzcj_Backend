package cn.iocoder.yudao.module.site.dal.mysql.companyintro;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.companyintro.CompanyIntroDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公司介绍 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface CompanyIntroMapper extends BaseMapperX<CompanyIntroDO> {

    default PageResult<CompanyIntroDO> selectPage(CompanyIntroPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CompanyIntroDO>()
                .eqIfPresent(CompanyIntroDO::getVersion, reqVO.getVersion())
                .eqIfPresent(CompanyIntroDO::getStatus, reqVO.getStatus())
                .orderByDesc(CompanyIntroDO::getVersion)
                .orderByDesc(CompanyIntroDO::getId));
    }

    /**
     * 查询当前生效的公司介绍（status=1，版本号最大的一条）
     */
    default CompanyIntroDO selectEnabled() {
        return selectOne(new LambdaQueryWrapperX<CompanyIntroDO>()
                .eq(CompanyIntroDO::getStatus, 1)
                .orderByDesc(CompanyIntroDO::getVersion)
                .orderByDesc(CompanyIntroDO::getId)
                .last("limit 1"));
    }

}

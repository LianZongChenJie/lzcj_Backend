package cn.iocoder.yudao.module.site.dal.mysql.branchcontact;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.branchcontact.vo.BranchContactPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.branchcontact.BranchContactDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分公司联系方式 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface BranchContactMapper extends BaseMapperX<BranchContactDO> {

    default PageResult<BranchContactDO> selectPage(BranchContactPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BranchContactDO>()
                .likeIfPresent(BranchContactDO::getCity, reqVO.getCity())
                .eqIfPresent(BranchContactDO::getStatus, reqVO.getStatus())
                .orderByAsc(BranchContactDO::getSort)
                .orderByDesc(BranchContactDO::getId));
    }

    /**
     * 查询当前启用的分公司联系方式列表（status=1，按 sort 升序）
     */
    default List<BranchContactDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<BranchContactDO>()
                .eq(BranchContactDO::getStatus, 1)
                .orderByAsc(BranchContactDO::getSort)
                .orderByAsc(BranchContactDO::getId));
    }

}

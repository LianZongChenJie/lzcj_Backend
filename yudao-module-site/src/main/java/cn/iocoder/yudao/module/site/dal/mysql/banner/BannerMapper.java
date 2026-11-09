package cn.iocoder.yudao.module.site.dal.mysql.banner;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerRespVO;
import cn.iocoder.yudao.module.site.dal.dataobject.banner.BannerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Banner轮播 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface BannerMapper extends BaseMapperX<BannerDO> {

    default PageResult<BannerDO> selectPage(BannerPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BannerDO>()
                .likeIfPresent(BannerDO::getTitle, reqVO.getTitle())
                .eqIfPresent(BannerDO::getStatus, reqVO.getStatus())
                .orderByAsc(BannerDO::getSort)
                .orderByDesc(BannerDO::getId));
    }

    /**
     * 查询启用的 Banner 列表（按排序号升序）
     */
    default List<BannerDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<BannerDO>()
                .eq(BannerDO::getStatus, 1)
                .orderByAsc(BannerDO::getSort));
    }

}

package cn.iocoder.yudao.module.site.dal.mysql.news;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.news.vo.NewsPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.news.NewsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 新闻 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface NewsMapper extends BaseMapperX<NewsDO> {

    default PageResult<NewsDO> selectPage(NewsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NewsDO>()
                .likeIfPresent(NewsDO::getTitle, reqVO.getTitle())
                .eqIfPresent(NewsDO::getStatus, reqVO.getStatus())
                .eqIfPresent(NewsDO::getAuthor, reqVO.getAuthor())
                .orderByDesc(NewsDO::getPublishDate)
                .orderByDesc(NewsDO::getId));
    }

    /**
     * 查询当前已发布的新闻列表（status=1，按发布日期倒序）
     */
    default List<NewsDO> selectListEnabled() {
        return selectList(new LambdaQueryWrapperX<NewsDO>()
                .eq(NewsDO::getStatus, 1)
                .orderByDesc(NewsDO::getPublishDate)
                .orderByDesc(NewsDO::getId));
    }

}

package cn.iocoder.yudao.module.site.dal.mysql.product;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.site.controller.admin.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.product.ProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 产品 Mapper
 *
 * @author 联纵宸捷
 */
@Mapper
public interface ProductMapper extends BaseMapperX<ProductDO> {

    default PageResult<ProductDO> selectPage(ProductPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductDO>()
                .likeIfPresent(ProductDO::getName, reqVO.getName())
                .eqIfPresent(ProductDO::getType, reqVO.getType())
                .eqIfPresent(ProductDO::getStatus, reqVO.getStatus())
                .orderByAsc(ProductDO::getSort)
                .orderByDesc(ProductDO::getId));
    }

    /**
     * 查询指定类型的启用产品列表（按排序号升序）
     *
     * @param type 产品类型：self-自研，agent-代理
     * @return 产品列表
     */
    default List<ProductDO> selectListEnabledByType(String type) {
        return selectList(new LambdaQueryWrapperX<ProductDO>()
                .eq(ProductDO::getStatus, 1)
                .eq(ProductDO::getType, type)
                .orderByAsc(ProductDO::getSort)
                .orderByDesc(ProductDO::getId));
    }

}

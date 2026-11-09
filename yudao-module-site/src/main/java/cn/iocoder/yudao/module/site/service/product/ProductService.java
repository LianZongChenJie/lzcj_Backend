package cn.iocoder.yudao.module.site.service.product;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.product.ProductDO;

import java.util.List;

/**
 * 产品 业务接口
 *
 * @author 联纵宸捷
 */
public interface ProductService {

    /**
     * 获取产品分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 产品分页结果
     */
    PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO);

    /**
     * 根据ID获取产品详情
     *
     * @param id 产品ID
     * @return 产品详情
     */
    ProductDO getProduct(Long id);

    /**
     * 创建产品
     *
     * @param createReqVO 创建参数
     * @return 产品ID
     */
    Long createProduct(ProductSaveReqVO createReqVO);

    /**
     * 更新产品
     *
     * @param updateReqVO 更新参数
     */
    void updateProduct(ProductSaveReqVO updateReqVO);

    /**
     * 删除产品
     *
     * @param id 产品ID
     */
    void deleteProduct(Long id);

    /**
     * 批量删除产品
     *
     * @param ids 产品ID列表
     */
    void deleteProductList(List<Long> ids);

    /**
     * 获取指定类型的启用产品列表（用于展示端）
     *
     * @param type 产品类型：self-自研，agent-代理
     * @return 产品列表
     */
    List<ProductDO> getProductListEnabled(String type);

}

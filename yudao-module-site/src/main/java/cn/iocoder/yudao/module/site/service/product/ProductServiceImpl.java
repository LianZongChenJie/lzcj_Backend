package cn.iocoder.yudao.module.site.service.product;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.module.site.dal.mysql.product.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.PRODUCT_NOT_EXISTS;

/**
 * 产品 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO) {
        return productMapper.selectPage(pageReqVO);
    }

    @Override
    public ProductDO getProduct(Long id) {
        return productMapper.selectById(id);
    }

    @Override
    public Long createProduct(ProductSaveReqVO createReqVO) {
        // 插入
        ProductDO product = new ProductDO();
        product.setName(createReqVO.getName());
        product.setImage(createReqVO.getImage());
        product.setType(createReqVO.getType());
        product.setSummary(createReqVO.getSummary());
        product.setDescription(createReqVO.getDescription());
        product.setFeatures(createReqVO.getFeatures());
        product.setScenarios(createReqVO.getScenarios());
        product.setSort(createReqVO.getSort());
        product.setStatus(createReqVO.getStatus());
        productMapper.insert(product);
        // 返回
        return product.getId();
    }

    @Override
    public void updateProduct(ProductSaveReqVO updateReqVO) {
        // 校验存在
        validateProductExists(updateReqVO.getId());
        // 更新
        ProductDO updateObj = new ProductDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setName(updateReqVO.getName());
        updateObj.setImage(updateReqVO.getImage());
        updateObj.setType(updateReqVO.getType());
        updateObj.setSummary(updateReqVO.getSummary());
        updateObj.setDescription(updateReqVO.getDescription());
        updateObj.setFeatures(updateReqVO.getFeatures());
        updateObj.setScenarios(updateReqVO.getScenarios());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        productMapper.updateById(updateObj);
    }

    @Override
    public void deleteProduct(Long id) {
        // 校验存在
        validateProductExists(id);
        // 删除
        productMapper.deleteById(id);
    }

    @Override
    public void deleteProductList(List<Long> ids) {
        // 批量删除
        productMapper.deleteBatchIds(ids);
    }

    @Override
    public List<ProductDO> getProductListEnabled(String type) {
        return productMapper.selectListEnabledByType(type);
    }

    private void validateProductExists(Long id) {
        if (productMapper.selectById(id) == null) {
            throw exception(PRODUCT_NOT_EXISTS);
        }
    }

}

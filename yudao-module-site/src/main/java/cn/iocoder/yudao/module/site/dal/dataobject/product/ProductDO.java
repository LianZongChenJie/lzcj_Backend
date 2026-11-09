package cn.iocoder.yudao.module.site.dal.dataobject.product;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.tenant.core.aop.TenantIgnore;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;

import java.util.List;

/**
 * 产品表
 *
 * 说明：type 区分自研（self）/Agent（agent）两类产品，管理端统一维护，
 * 展示端按类型分别对外提供 /cms/api/self-products、/cms/api/agent-products 接口。
 *
 * @author 联纵宸捷
 */
@TableName(value = "site_product", autoResultMap = true)
@KeySequence("site_product_seq")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TenantIgnore
public class ProductDO extends BaseDO {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 产品图片URL
     */
    private String image;
    /**
     * 类型：self-自研，agent-代理
     */
    private String type;
    /**
     * 产品摘要
     */
    private String summary;
    /**
     * 产品详细描述
     */
    private String description;
    /**
     * 核心特性列表（JSON 数组）
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> features;
    /**
     * 适用场景列表（JSON 数组）
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> scenarios;
    /**
     * 排序号（越小越靠前）
     */
    private Integer sort;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

}

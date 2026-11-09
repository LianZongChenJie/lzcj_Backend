package cn.iocoder.yudao.module.site.service.companyintro;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.companyintro.CompanyIntroDO;

import java.util.List;

/**
 * 公司介绍 业务接口
 *
 * @author 联纵宸捷
 */
public interface CompanyIntroService {

    /**
     * 获取公司介绍分页列表
     *
     * @param pageReqVO 分页查询参数
     * @return 公司介绍分页结果
     */
    PageResult<CompanyIntroDO> getCompanyIntroPage(CompanyIntroPageReqVO pageReqVO);

    /**
     * 根据ID获取公司介绍详情
     *
     * @param id 公司介绍ID
     * @return 公司介绍详情
     */
    CompanyIntroDO getCompanyIntro(Long id);

    /**
     * 创建公司介绍版本
     *
     * @param createReqVO 创建参数
     * @return 公司介绍ID
     */
    Long createCompanyIntro(CompanyIntroSaveReqVO createReqVO);

    /**
     * 更新公司介绍
     *
     * @param updateReqVO 更新参数
     */
    void updateCompanyIntro(CompanyIntroSaveReqVO updateReqVO);

    /**
     * 删除公司介绍版本
     *
     * @param id 公司介绍ID
     */
    void deleteCompanyIntro(Long id);

    /**
     * 批量删除公司介绍版本
     *
     * @param ids 公司介绍ID列表
     */
    void deleteCompanyIntroList(List<Long> ids);

    /**
     * 获取当前生效的公司介绍（用于展示端）
     *
     * @return 生效的公司介绍，可能为 null（未配置）
     */
    CompanyIntroDO getEnabledCompanyIntro();

}

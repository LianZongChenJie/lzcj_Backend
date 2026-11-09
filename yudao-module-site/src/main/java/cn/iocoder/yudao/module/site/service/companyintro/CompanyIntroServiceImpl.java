package cn.iocoder.yudao.module.site.service.companyintro;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.companyintro.vo.CompanyIntroSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.companyintro.CompanyIntroDO;
import cn.iocoder.yudao.module.site.dal.mysql.companyintro.CompanyIntroMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.CompanyIntro_NOT_EXISTS;

/**
 * 公司介绍 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class CompanyIntroServiceImpl implements CompanyIntroService {

    @Resource
    private CompanyIntroMapper companyIntroMapper;

    @Override
    public PageResult<CompanyIntroDO> getCompanyIntroPage(CompanyIntroPageReqVO pageReqVO) {
        return companyIntroMapper.selectPage(pageReqVO);
    }

    @Override
    public CompanyIntroDO getCompanyIntro(Long id) {
        return companyIntroMapper.selectById(id);
    }

    @Override
    public Long createCompanyIntro(CompanyIntroSaveReqVO createReqVO) {
        // 插入
        CompanyIntroDO companyIntro = new CompanyIntroDO();
        companyIntro.setDescription(createReqVO.getDescription());
        companyIntro.setImages(createReqVO.getImages());
        companyIntro.setVersion(createReqVO.getVersion());
        companyIntro.setStatus(createReqVO.getStatus());
        companyIntroMapper.insert(companyIntro);
        // 返回
        return companyIntro.getId();
    }

    @Override
    public void updateCompanyIntro(CompanyIntroSaveReqVO updateReqVO) {
        // 校验存在
        validateCompanyIntroExists(updateReqVO.getId());
        // 更新
        CompanyIntroDO updateObj = new CompanyIntroDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setDescription(updateReqVO.getDescription());
        updateObj.setImages(updateReqVO.getImages());
        updateObj.setVersion(updateReqVO.getVersion());
        updateObj.setStatus(updateReqVO.getStatus());
        companyIntroMapper.updateById(updateObj);
    }

    @Override
    public void deleteCompanyIntro(Long id) {
        // 校验存在
        validateCompanyIntroExists(id);
        // 删除
        companyIntroMapper.deleteById(id);
    }

    @Override
    public void deleteCompanyIntroList(List<Long> ids) {
        // 批量删除
        companyIntroMapper.deleteBatchIds(ids);
    }

    @Override
    public CompanyIntroDO getEnabledCompanyIntro() {
        return companyIntroMapper.selectEnabled();
    }

    private void validateCompanyIntroExists(Long id) {
        if (companyIntroMapper.selectById(id) == null) {
            throw exception(CompanyIntro_NOT_EXISTS);
        }
    }

}

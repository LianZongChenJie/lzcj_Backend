package cn.iocoder.yudao.module.site.service.culture;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CulturePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.culture.vo.CultureSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.culture.CultureDO;
import cn.iocoder.yudao.module.site.dal.mysql.culture.CultureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.Culture_NOT_EXISTS;

/**
 * 企业文化 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class CultureServiceImpl implements CultureService {

    @Resource
    private CultureMapper cultureMapper;

    @Override
    public PageResult<CultureDO> getCulturePage(CulturePageReqVO pageReqVO) {
        return cultureMapper.selectPage(pageReqVO);
    }

    @Override
    public CultureDO getCulture(Long id) {
        return cultureMapper.selectById(id);
    }

    @Override
    public Long createCulture(CultureSaveReqVO createReqVO) {
        // 插入
        CultureDO culture = new CultureDO();
        culture.setMission(createReqVO.getMission());
        culture.setVision(createReqVO.getVision());
        culture.setCoreValues(createReqVO.getValues());
        culture.setVersion(createReqVO.getVersion());
        culture.setStatus(createReqVO.getStatus());
        cultureMapper.insert(culture);
        // 返回
        return culture.getId();
    }

    @Override
    public void updateCulture(CultureSaveReqVO updateReqVO) {
        // 校验存在
        validateCultureExists(updateReqVO.getId());
        // 更新
        CultureDO updateObj = new CultureDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setMission(updateReqVO.getMission());
        updateObj.setVision(updateReqVO.getVision());
        updateObj.setCoreValues(updateReqVO.getValues());
        updateObj.setVersion(updateReqVO.getVersion());
        updateObj.setStatus(updateReqVO.getStatus());
        cultureMapper.updateById(updateObj);
    }

    @Override
    public void deleteCulture(Long id) {
        // 校验存在
        validateCultureExists(id);
        // 删除
        cultureMapper.deleteById(id);
    }

    @Override
    public CultureDO getCultureEnabled() {
        return cultureMapper.selectEnabled();
    }

    private void validateCultureExists(Long id) {
        if (cultureMapper.selectById(id) == null) {
            throw exception(Culture_NOT_EXISTS);
        }
    }

}

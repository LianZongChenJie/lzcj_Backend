package cn.iocoder.yudao.module.site.service.techservice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServicePageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.techservice.vo.TechServiceSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.techservice.TechServiceDO;
import cn.iocoder.yudao.module.site.dal.mysql.techservice.TechServiceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.TECH_SERVICE_NOT_EXISTS;

/**
 * 技术服务 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class TechServiceServiceImpl implements TechServiceService {

    @Resource
    private TechServiceMapper techServiceMapper;

    @Override
    public PageResult<TechServiceDO> getTechServicePage(TechServicePageReqVO pageReqVO) {
        return techServiceMapper.selectPage(pageReqVO);
    }

    @Override
    public TechServiceDO getTechService(Long id) {
        return techServiceMapper.selectById(id);
    }

    @Override
    public Long createTechService(TechServiceSaveReqVO createReqVO) {
        // 插入
        TechServiceDO techService = new TechServiceDO();
        techService.setIndustry(createReqVO.getIndustry());
        techService.setIcon(createReqVO.getIcon());
        techService.setDescription(createReqVO.getDescription());
        techService.setSort(createReqVO.getSort());
        techService.setStatus(createReqVO.getStatus());
        techServiceMapper.insert(techService);
        // 返回
        return techService.getId();
    }

    @Override
    public void updateTechService(TechServiceSaveReqVO updateReqVO) {
        // 校验存在
        validateTechServiceExists(updateReqVO.getId());
        // 更新
        TechServiceDO updateObj = new TechServiceDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setIndustry(updateReqVO.getIndustry());
        updateObj.setIcon(updateReqVO.getIcon());
        updateObj.setDescription(updateReqVO.getDescription());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        techServiceMapper.updateById(updateObj);
    }

    @Override
    public void deleteTechService(Long id) {
        // 校验存在
        validateTechServiceExists(id);
        // 删除
        techServiceMapper.deleteById(id);
    }

    @Override
    public List<TechServiceDO> getTechServiceListEnabled() {
        return techServiceMapper.selectListEnabled();
    }

    private void validateTechServiceExists(Long id) {
        if (techServiceMapper.selectById(id) == null) {
            throw exception(TECH_SERVICE_NOT_EXISTS);
        }
    }

}

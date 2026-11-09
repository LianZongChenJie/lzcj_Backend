package cn.iocoder.yudao.module.site.service.honor;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.honor.vo.HonorSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.honor.HonorDO;
import cn.iocoder.yudao.module.site.dal.mysql.honor.HonorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.HONOR_NOT_EXISTS;

/**
 * 资质荣誉 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class HonorServiceImpl implements HonorService {

    @Resource
    private HonorMapper honorMapper;

    @Override
    public PageResult<HonorDO> getHonorPage(HonorPageReqVO pageReqVO) {
        return honorMapper.selectPage(pageReqVO);
    }

    @Override
    public HonorDO getHonor(Long id) {
        return honorMapper.selectById(id);
    }

    @Override
    public Long createHonor(HonorSaveReqVO createReqVO) {
        // 插入
        HonorDO honor = new HonorDO();
        honor.setName(createReqVO.getName());
        honor.setImage(createReqVO.getImage());
        honor.setType(createReqVO.getType());
        honor.setDate(createReqVO.getDate());
        honor.setSort(createReqVO.getSort());
        honor.setStatus(createReqVO.getStatus());
        honorMapper.insert(honor);
        // 返回
        return honor.getId();
    }

    @Override
    public void updateHonor(HonorSaveReqVO updateReqVO) {
        // 校验存在
        validateHonorExists(updateReqVO.getId());
        // 更新
        HonorDO updateObj = new HonorDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setName(updateReqVO.getName());
        updateObj.setImage(updateReqVO.getImage());
        updateObj.setType(updateReqVO.getType());
        updateObj.setDate(updateReqVO.getDate());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        honorMapper.updateById(updateObj);
    }

    @Override
    public void deleteHonor(Long id) {
        // 校验存在
        validateHonorExists(id);
        // 删除
        honorMapper.deleteById(id);
    }

    @Override
    public List<HonorDO> getHonorListEnabled() {
        return honorMapper.selectListEnabled();
    }

    private void validateHonorExists(Long id) {
        if (honorMapper.selectById(id) == null) {
            throw exception(HONOR_NOT_EXISTS);
        }
    }

}

package cn.iocoder.yudao.module.site.service.banner;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerPageReqVO;
import cn.iocoder.yudao.module.site.controller.admin.banner.vo.BannerSaveReqVO;
import cn.iocoder.yudao.module.site.dal.dataobject.banner.BannerDO;
import cn.iocoder.yudao.module.site.dal.mysql.banner.BannerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.site.enums.ErrorCodeConstants.Banner_NOT_EXISTS;

/**
 * Banner 业务实现类
 *
 * @author 联纵宸捷
 */
@Service
@Validated
@Slf4j
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public PageResult<BannerDO> getBannerPage(BannerPageReqVO pageReqVO) {
        return bannerMapper.selectPage(pageReqVO);
    }

    @Override
    public BannerDO getBanner(Long id) {
        return bannerMapper.selectById(id);
    }

    @Override
    public Long createBanner(BannerSaveReqVO createReqVO) {
        // 插入
        BannerDO banner = new BannerDO();
        banner.setImage(createReqVO.getImage());
        banner.setTitle(createReqVO.getTitle());
        banner.setSubtitle(createReqVO.getSubtitle());
        banner.setSort(createReqVO.getSort());
        banner.setStatus(createReqVO.getStatus());
        bannerMapper.insert(banner);
        // 返回
        return banner.getId();
    }

    @Override
    public void updateBanner(BannerSaveReqVO updateReqVO) {
        // 校验存在
        validateBannerExists(updateReqVO.getId());
        // 更新
        BannerDO updateObj = new BannerDO();
        updateObj.setId(updateReqVO.getId());
        updateObj.setImage(updateReqVO.getImage());
        updateObj.setTitle(updateReqVO.getTitle());
        updateObj.setSubtitle(updateReqVO.getSubtitle());
        updateObj.setSort(updateReqVO.getSort());
        updateObj.setStatus(updateReqVO.getStatus());
        bannerMapper.updateById(updateObj);
    }

    @Override
    public void deleteBanner(Long id) {
        // 校验存在
        validateBannerExists(id);
        // 删除
        bannerMapper.deleteById(id);
    }

    @Override
    public void deleteBannerList(List<Long> ids) {
        // 批量删除
        bannerMapper.deleteBatchIds(ids);
    }

    @Override
    public List<BannerDO> getBannerListEnabled() {
        return bannerMapper.selectListEnabled();
    }

    private void validateBannerExists(Long id) {
        if (bannerMapper.selectById(id) == null) {
            throw exception(Banner_NOT_EXISTS);
        }
    }

}

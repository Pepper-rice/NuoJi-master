package com.ruoyi.store.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.StorePhoneMapper;
import com.ruoyi.store.domain.StorePhone;
import com.ruoyi.store.service.IStorePhoneService;

/**
 * 手机Service业务层处理
 * @date 2023-03-31
 */
@Service
public class StorePhoneServiceImpl implements IStorePhoneService
{
    @Autowired
    private StorePhoneMapper storePhoneMapper;

    /**
     * 查询手机
     *
     * @param phoneId 手机主键
     * @return 手机
     */
    @Override
    public StorePhone selectStorePhoneByPhoneId(Long phoneId)
    {
        return storePhoneMapper.selectStorePhoneByPhoneId(phoneId);
    }

    /**
     * 查询手机列表
     *
     * @param storePhone 手机
     * @return 手机
     */
    @Override
    public List<StorePhone> selectStorePhoneList(StorePhone storePhone)
    {
        return storePhoneMapper.selectStorePhoneList(storePhone);
    }

    /**
     * 新增手机
     *
     * @param storePhone 手机
     * @return 结果
     */
    @Override
    public int insertStorePhone(StorePhone storePhone)
    {
        storePhone.setCreateTime(DateUtils.getNowDate());
        return storePhoneMapper.insertStorePhone(storePhone);
    }

    /**
     * 修改手机
     *
     * @param storePhone 手机
     * @return 结果
     */
    @Override
    public int updateStorePhone(StorePhone storePhone)
    {
        storePhone.setUpdateTime(DateUtils.getNowDate());
        return storePhoneMapper.updateStorePhone(storePhone);
    }

    /**
     * 批量删除手机
     *
     * @param phoneIds 需要删除的手机主键
     * @return 结果
     */
    @Override
    public int deleteStorePhoneByPhoneIds(Long[] phoneIds)
    {
        return storePhoneMapper.deleteStorePhoneByPhoneIds(phoneIds);
    }

    /**
     * 删除手机信息
     *
     * @param phoneId 手机主键
     * @return 结果
     */
    @Override
    public int deleteStorePhoneByPhoneId(Long phoneId)
    {
        return storePhoneMapper.deleteStorePhoneByPhoneId(phoneId);
    }
}

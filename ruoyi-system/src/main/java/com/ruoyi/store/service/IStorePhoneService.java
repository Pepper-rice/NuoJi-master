package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.StorePhone;

/**
 * 手机Service接口
 * @date 2023-03-31
 */
public interface IStorePhoneService
{
    /**
     * 查询手机
     *
     * @param phoneId 手机主键
     * @return 手机
     */
    public StorePhone selectStorePhoneByPhoneId(Long phoneId);

    /**
     * 查询手机列表
     *
     * @param storePhone 手机
     * @return 手机集合
     */
    public List<StorePhone> selectStorePhoneList(StorePhone storePhone);

    /**
     * 新增手机
     *
     * @param storePhone 手机
     * @return 结果
     */
    public int insertStorePhone(StorePhone storePhone);

    /**
     * 修改手机
     *
     * @param storePhone 手机
     * @return 结果
     */
    public int updateStorePhone(StorePhone storePhone);

    /**
     * 批量删除手机
     *
     * @param phoneIds 需要删除的手机主键集合
     * @return 结果
     */
    public int deleteStorePhoneByPhoneIds(Long[] phoneIds);

    /**
     * 删除手机信息
     *
     * @param phoneId 手机主键
     * @return 结果
     */
    public int deleteStorePhoneByPhoneId(Long phoneId);
}

package com.ruoyi.store.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.store.mapper.StoreSaleMapper;
import com.ruoyi.store.domain.StoreSale;
import com.ruoyi.store.service.IStoreSaleService;

/**
 * 销售Service业务层处理
 * @date 2023-04-02
 */
@Service
public class StoreSaleServiceImpl implements IStoreSaleService
{
    @Autowired
    private StoreSaleMapper storeSaleMapper;

    /**
     * 查询销售
     *
     * @param saleId 销售主键
     * @return 销售
     */
    @Override
    public StoreSale selectStoreSaleBySaleId(Long saleId)
    {
        return storeSaleMapper.selectStoreSaleBySaleId(saleId);
    }

    /**
     * 查询销售列表
     *
     * @param storeSale 销售
     * @return 销售
     */
    @Override
    public List<StoreSale> selectStoreSaleList(StoreSale storeSale)
    {
        return storeSaleMapper.selectStoreSaleList(storeSale);
    }

    /**
     * 新增销售
     *
     * @param storeSale 销售
     * @return 结果
     */
    @Override
    public int insertStoreSale(StoreSale storeSale)
    {
        storeSale.setCreateTime(DateUtils.getNowDate());
        return storeSaleMapper.insertStoreSale(storeSale);
    }

    /**
     * 修改销售
     *
     * @param storeSale 销售
     * @return 结果
     */
    @Override
    public int updateStoreSale(StoreSale storeSale)
    {
        storeSale.setUpdateTime(DateUtils.getNowDate());
        return storeSaleMapper.updateStoreSale(storeSale);
    }

    /**
     * 批量删除销售
     *
     * @param saleIds 需要删除的销售主键
     * @return 结果
     */
    @Override
    public int deleteStoreSaleBySaleIds(Long[] saleIds)
    {
        return storeSaleMapper.deleteStoreSaleBySaleIds(saleIds);
    }

    /**
     * 删除销售信息
     *
     * @param saleId 销售主键
     * @return 结果
     */
    @Override
    public int deleteStoreSaleBySaleId(Long saleId)
    {
        return storeSaleMapper.deleteStoreSaleBySaleId(saleId);
    }
}

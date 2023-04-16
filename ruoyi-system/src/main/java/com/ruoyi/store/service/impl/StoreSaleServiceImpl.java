package com.ruoyi.store.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.convert.ISaleConverter;
import com.ruoyi.store.domain.dto.StoreSaleDTO;
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

    @Autowired
    private ISaleConverter saleConverter;

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
     * @param storeSaleDTO 销售
     * @return 销售
     */
    @Override
    public List<StoreSale> selectStoreSaleList(StoreSaleDTO storeSaleDTO)
    {
        StoreSale storeSale = saleConverter.dto2po(storeSaleDTO);
        return storeSaleMapper.selectStoreSaleList(storeSale);
    }

    /**
     * 新增销售
     *
     * @param storeSaleDTO 销售
     * @return 结果
     */
    @Override
    public int insertStoreSale(StoreSaleDTO storeSaleDTO)
    {
        StoreSale storeSale = saleConverter.dto2po(storeSaleDTO);
        return storeSaleMapper.insertStoreSale(storeSale);
    }

    /**
     * 修改销售
     *
     * @param storeSaleDTO 销售
     * @return 结果
     */
    @Override
    public int updateStoreSale(StoreSaleDTO storeSaleDTO)
    {
        StoreSale storeSale = saleConverter.dto2po(storeSaleDTO);
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

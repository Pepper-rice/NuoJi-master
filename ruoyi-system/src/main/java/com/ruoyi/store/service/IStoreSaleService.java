package com.ruoyi.store.service;

import java.util.List;
import com.ruoyi.store.domain.StoreSale;
import com.ruoyi.store.domain.dto.StoreSaleDTO;

/**
 * 销售Service接口
 * @date 2023-04-02
 */
public interface IStoreSaleService
{
    /**
     * 查询销售
     *
     * @param saleId 销售主键
     * @return 销售
     */
    public StoreSale selectStoreSaleBySaleId(Long saleId);

    /**
     * 查询销售列表
     *
     * @param storeSaleDTO 销售
     * @return 销售集合
     */
    public List<StoreSale> selectStoreSaleList(StoreSaleDTO storeSaleDTO);

    /**
     * 新增销售
     *
     * @param storeSaleDTO 销售
     * @return 结果
     */
    public int insertStoreSale(StoreSaleDTO storeSaleDTO);

    /**
     * 修改销售
     *
     * @param storeSaleDTO 销售
     * @return 结果
     */
    public int updateStoreSale(StoreSaleDTO storeSaleDTO);

    /**
     * 批量删除销售
     *
     * @param saleIds 需要删除的销售主键集合
     * @return 结果
     */
    public int deleteStoreSaleBySaleIds(Long[] saleIds);

    /**
     * 删除销售信息
     *
     * @param saleId 销售主键
     * @return 结果
     */
    public int deleteStoreSaleBySaleId(Long saleId);
}

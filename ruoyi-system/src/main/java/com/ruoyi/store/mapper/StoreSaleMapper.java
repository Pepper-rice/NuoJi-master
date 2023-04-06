package com.ruoyi.store.mapper;

import java.util.List;
import com.ruoyi.store.domain.StoreSale;

/**
 * 销售Mapper接口
 * @date 2023-04-02
 */
public interface StoreSaleMapper
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
     * @param storeSale 销售
     * @return 销售集合
     */
    public List<StoreSale> selectStoreSaleList(StoreSale storeSale);

    /**
     * 新增销售
     *
     * @param storeSale 销售
     * @return 结果
     */
    public int insertStoreSale(StoreSale storeSale);

    /**
     * 修改销售
     *
     * @param storeSale 销售
     * @return 结果
     */
    public int updateStoreSale(StoreSale storeSale);

    /**
     * 删除销售
     *
     * @param saleId 销售主键
     * @return 结果
     */
    public int deleteStoreSaleBySaleId(Long saleId);

    /**
     * 批量删除销售
     *
     * @param saleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoreSaleBySaleIds(Long[] saleIds);
}

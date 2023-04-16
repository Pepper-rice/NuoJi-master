package com.ruoyi.store.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 手机对象 store_phone
 * @date 2023-03-31
 */
@Data
public class StorePhoneVO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 手机id */
    private Long phoneId;

    /** 手机名称 */
    @Excel(name = "手机名称")
    private String phoneName;

    /** 手机品牌 */
    @Excel(name = "手机品牌")
    private String phoneBrand;

    /** 存储容量 */
    @Excel(name = "存储容量")
    private String phoneStorage;

    /** 价格 */
    @Excel(name = "价格")
    private Integer price;

    /** 手机库存 */
    @Excel(name = "手机库存")
    private Integer phoneQuantity;

    /** 手机状态（0正常 1停用） */
    @Excel(name = "手机状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

}

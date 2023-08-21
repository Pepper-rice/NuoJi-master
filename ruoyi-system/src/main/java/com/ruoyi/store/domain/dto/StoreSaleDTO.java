package com.ruoyi.store.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 销售对象 store_sale
 * @date 2023-04-02
 */
@Data
public class StoreSaleDTO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售id */
    private Long saleId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 手机id */
    @Excel(name = "手机id")
    private Long phoneId;

    /** 销售时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saleDate;

    /** 销售数量 */
    @Excel(name = "销售数量")
    private Integer saleQuantity;

    /** 销售总价 */
    @Excel(name = "销售总价")
    private Integer salePrice;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

}

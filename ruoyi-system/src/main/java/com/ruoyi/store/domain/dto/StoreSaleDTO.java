package com.ruoyi.store.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 销售对象 store_sale
 * @date 2023-04-02
 */
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

    public void setSaleId(Long saleId)
    {
        this.saleId = saleId;
    }

    public Long getSaleId()
    {
        return saleId;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setPhoneId(Long phoneId)
    {
        this.phoneId = phoneId;
    }

    public Long getPhoneId()
    {
        return phoneId;
    }
    public void setSaleDate(Date saleDate)
    {
        this.saleDate = saleDate;
    }

    public Date getSaleDate()
    {
        return saleDate;
    }
    public void setSaleQuantity(Integer saleQuantity)
    {
        this.saleQuantity = saleQuantity;
    }

    public Integer getSaleQuantity()
    {
        return saleQuantity;
    }
    public void setSalePrice(Integer salePrice)
    {
        this.salePrice = salePrice;
    }

    public Integer getSalePrice()
    {
        return salePrice;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("saleId", getSaleId())
            .append("customerName", getCustomerName())
            .append("phoneId", getPhoneId())
            .append("saleDate", getSaleDate())
            .append("saleQuantity", getSaleQuantity())
            .append("salePrice", getSalePrice())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.store.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 手机对象 store_phone
 * @date 2023-03-31
 */
public class StorePhone extends BaseEntity
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

    /** 手机状态（0正常 1停用） */
    @Excel(name = "手机状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setPhoneId(Long phoneId)
    {
        this.phoneId = phoneId;
    }

    public Long getPhoneId()
    {
        return phoneId;
    }
    public void setPhoneName(String phoneName)
    {
        this.phoneName = phoneName;
    }

    public String getPhoneName()
    {
        return phoneName;
    }
    public void setPhoneBrand(String phoneBrand)
    {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneBrand()
    {
        return phoneBrand;
    }
    public void setPhoneStorage(String phoneStorage)
    {
        this.phoneStorage = phoneStorage;
    }

    public String getPhoneStorage()
    {
        return phoneStorage;
    }
    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Integer getPrice()
    {
        return price;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
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
            .append("phoneId", getPhoneId())
            .append("phoneName", getPhoneName())
            .append("phoneBrand", getPhoneBrand())
            .append("phoneStorage", getPhoneStorage())
            .append("price", getPrice())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

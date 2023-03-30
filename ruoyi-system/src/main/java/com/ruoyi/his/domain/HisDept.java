package com.ruoyi.his.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科室对象 his_dept
 *
 * @date 2023-03-27
 */
public class HisDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 科室id */
    private Long deptId;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String deptName;

    /** 科室编码 */
    @Excel(name = "科室编码")
    private String deptCode;

    /** 当前挂号量 */
    @Excel(name = "当前挂号量")
    private Long deptNum;

    /** 负责人 */
    @Excel(name = "负责人")
    private String deptLeader;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String deptPhone;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptCode()
    {
        return deptCode;
    }
    public void setDeptNum(Long deptNum)
    {
        this.deptNum = deptNum;
    }

    public Long getDeptNum()
    {
        return deptNum;
    }
    public void setDeptLeader(String deptLeader)
    {
        this.deptLeader = deptLeader;
    }

    public String getDeptLeader()
    {
        return deptLeader;
    }
    public void setDeptPhone(String deptPhone)
    {
        this.deptPhone = deptPhone;
    }

    public String getDeptPhone()
    {
        return deptPhone;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("deptCode", getDeptCode())
            .append("deptNum", getDeptNum())
            .append("deptLeader", getDeptLeader())
            .append("deptPhone", getDeptPhone())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

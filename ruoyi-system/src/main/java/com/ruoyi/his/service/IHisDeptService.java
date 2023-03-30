package com.ruoyi.his.service;

import java.util.List;
import com.ruoyi.his.domain.HisDept;

/**
 * 科室Service接口
 *
 * @date 2023-03-27
 */
public interface IHisDeptService
{
    /**
     * 查询科室
     *
     * @param deptId 科室主键
     * @return 科室
     */
    public HisDept selectHisDeptByDeptId(Long deptId);

    /**
     * 查询科室列表
     *
     * @param hisDept 科室
     * @return 科室集合
     */
    public List<HisDept> selectHisDeptList(HisDept hisDept);

    /**
     * 新增科室
     *
     * @param hisDept 科室
     * @return 结果
     */
    public int insertHisDept(HisDept hisDept);

    /**
     * 修改科室
     *
     * @param hisDept 科室
     * @return 结果
     */
    public int updateHisDept(HisDept hisDept);

    /**
     * 批量删除科室
     *
     * @param deptIds 需要删除的科室主键集合
     * @return 结果
     */
    public int deleteHisDeptByDeptIds(Long[] deptIds);

    /**
     * 删除科室信息
     *
     * @param deptId 科室主键
     * @return 结果
     */
    public int deleteHisDeptByDeptId(Long deptId);
}

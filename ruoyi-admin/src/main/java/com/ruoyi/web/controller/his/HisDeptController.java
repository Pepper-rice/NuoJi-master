package com.ruoyi.web.controller.his;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.his.domain.HisDept;
import com.ruoyi.his.service.IHisDeptService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室Controller
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/his/dept")
public class HisDeptController extends BaseController
{
    @Autowired
    private IHisDeptService hisDeptService;

    /**
     * 查询科室列表
     */
    @PreAuthorize("@ss.hasPermi('his:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisDept hisDept)
    {
        startPage();
        List<HisDept> list = hisDeptService.selectHisDeptList(hisDept);
        return getDataTable(list);
    }

    /**
     * 导出科室列表
     */
    @PreAuthorize("@ss.hasPermi('his:dept:export')")
    @Log(title = "科室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisDept hisDept)
    {
        List<HisDept> list = hisDeptService.selectHisDeptList(hisDept);
        ExcelUtil<HisDept> util = new ExcelUtil<HisDept>(HisDept.class);
        util.exportExcel(response, list, "科室数据");
    }

    /**
     * 获取科室详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return success(hisDeptService.selectHisDeptByDeptId(deptId));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('his:dept:add')")
    @Log(title = "科室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisDept hisDept)
    {
        return toAjax(hisDeptService.insertHisDept(hisDept));
    }

    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('his:dept:edit')")
    @Log(title = "科室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisDept hisDept)
    {
        return toAjax(hisDeptService.updateHisDept(hisDept));
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('his:dept:remove')")
    @Log(title = "科室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(hisDeptService.deleteHisDeptByDeptIds(deptIds));
    }
}

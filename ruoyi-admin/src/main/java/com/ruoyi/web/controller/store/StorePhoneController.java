package com.ruoyi.web.controller.store;

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
import com.ruoyi.store.domain.StorePhone;
import com.ruoyi.store.service.IStorePhoneService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 手机Controller
 *
 * @date 2023-03-31
 */
@RestController
@RequestMapping("/store/phone")
public class StorePhoneController extends BaseController
{
    @Autowired
    private IStorePhoneService storePhoneService;

    /**
     * 查询手机列表
     */
    @PreAuthorize("@ss.hasPermi('store:phone:list')")
    @GetMapping("/list")
    public TableDataInfo list(StorePhone storePhone)
    {
        startPage();
        List<StorePhone> list = storePhoneService.selectStorePhoneList(storePhone);
        return getDataTable(list);
    }

    /**
     * 导出手机列表
     */
    @PreAuthorize("@ss.hasPermi('store:phone:export')")
    @Log(title = "手机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StorePhone storePhone)
    {
        List<StorePhone> list = storePhoneService.selectStorePhoneList(storePhone);
        ExcelUtil<StorePhone> util = new ExcelUtil<StorePhone>(StorePhone.class);
        util.exportExcel(response, list, "手机数据");
    }

    /**
     * 获取手机详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:phone:query')")
    @GetMapping(value = "/{phoneId}")
    public AjaxResult getInfo(@PathVariable("phoneId") Long phoneId)
    {
        return success(storePhoneService.selectStorePhoneByPhoneId(phoneId));
    }

    /**
     * 新增手机
     */
    @PreAuthorize("@ss.hasPermi('store:phone:add')")
    @Log(title = "手机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StorePhone storePhone)
    {
        return toAjax(storePhoneService.insertStorePhone(storePhone));
    }

    /**
     * 修改手机
     */
    @PreAuthorize("@ss.hasPermi('store:phone:edit')")
    @Log(title = "手机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StorePhone storePhone)
    {
        return toAjax(storePhoneService.updateStorePhone(storePhone));
    }

    /**
     * 删除手机
     */
    @PreAuthorize("@ss.hasPermi('store:phone:remove')")
    @Log(title = "手机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{phoneIds}")
    public AjaxResult remove(@PathVariable Long[] phoneIds)
    {
        return toAjax(storePhoneService.deleteStorePhoneByPhoneIds(phoneIds));
    }
}

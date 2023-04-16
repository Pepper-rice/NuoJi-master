package com.ruoyi.web.controller.store;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.convert.IPhoneConverter;
import com.ruoyi.store.domain.StorePhone;
import com.ruoyi.store.domain.dto.StorePhoneDTO;
import com.ruoyi.store.service.IStorePhoneService;
import com.ruoyi.store.domain.vo.StorePhoneVO;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 手机Controller
 * @date 2023-03-31
 */
@Mapper
@RestController
@RequestMapping("/store/phone")
public class StorePhoneController extends BaseController
{
    @Autowired
    private IStorePhoneService storePhoneService;

    @Autowired
    private IPhoneConverter phoneConverter;

    /**
     * 查询手机列表
     */
    @PreAuthorize("@ss.hasPermi('store:phone:list')")
    @GetMapping("/list")
    public TableDataInfo list(StorePhoneVO storePhoneVO)
    {
        StorePhoneDTO storePhoneDTO = phoneConverter.vo2dto(storePhoneVO);
        startPage();
        List<StorePhone> list = storePhoneService.selectStorePhoneList(storePhoneDTO);
        return getDataTable(list);
    }

    /**
     * 导出手机列表
     */
    @PreAuthorize("@ss.hasPermi('store:phone:export')")
    @Log(title = "手机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StorePhoneVO storePhoneVO)
    {
        StorePhoneDTO storePhoneDTO = phoneConverter.vo2dto(storePhoneVO);
        List<StorePhone> list = storePhoneService.selectStorePhoneList(storePhoneDTO);
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
    public AjaxResult add(@RequestBody StorePhoneVO storePhoneVO)
    {
        StorePhoneDTO storePhoneDTO = phoneConverter.vo2dto(storePhoneVO);
        return toAjax(storePhoneService.insertStorePhone(storePhoneDTO));
    }

    /**
     * 修改手机
     */
    @PreAuthorize("@ss.hasPermi('store:phone:edit')")
    @Log(title = "手机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StorePhoneVO storePhoneVO)
    {
        StorePhoneDTO storePhoneDTO = phoneConverter.vo2dto(storePhoneVO);
        return toAjax(storePhoneService.updateStorePhone(storePhoneDTO));
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

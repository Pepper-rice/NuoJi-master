package com.ruoyi.web.controller.store;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.convert.ISaleConverter;
import com.ruoyi.store.domain.dto.StoreSaleDTO;
import com.ruoyi.store.domain.vo.StoreSaleVO;
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
import com.ruoyi.store.domain.StoreSale;
import com.ruoyi.store.service.IStoreSaleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售Controller
 * @date 2023-04-02
 */
@RestController
@RequestMapping("/store/sale")
public class StoreSaleController extends BaseController
{
    @Autowired
    private IStoreSaleService storeSaleService;

    @Autowired
    private ISaleConverter saleConverter;

    /**
     * 查询销售列表
     */
    @PreAuthorize("@ss.hasPermi('store:sale:list')")
    @GetMapping("/list")
    public TableDataInfo list(StoreSaleVO storeSaleVO)
    {
        StoreSaleDTO storeSaleDTO = saleConverter.vo2dto(storeSaleVO);
        startPage();
        List<StoreSale> list = storeSaleService.selectStoreSaleList(storeSaleDTO);
        return getDataTable(list);
    }

    /**
     * 导出销售列表
     */
    @PreAuthorize("@ss.hasPermi('store:sale:export')")
    @Log(title = "销售", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StoreSaleVO storeSaleVO)
    {
        StoreSaleDTO storeSaleDTO = saleConverter.vo2dto(storeSaleVO);
        List<StoreSale> list = storeSaleService.selectStoreSaleList(storeSaleDTO);
        ExcelUtil<StoreSale> util = new ExcelUtil<StoreSale>(StoreSale.class);
        util.exportExcel(response, list, "销售数据");
    }

    /**
     * 获取销售详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:sale:query')")
    @GetMapping(value = "/{saleId}")
    public AjaxResult getInfo(@PathVariable("saleId") Long saleId)
    {
        return success(storeSaleService.selectStoreSaleBySaleId(saleId));
    }

    /**
     * 新增销售
     */
    @PreAuthorize("@ss.hasPermi('store:sale:add')")
    @Log(title = "销售", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StoreSaleVO storeSaleVO)
    {
        StoreSaleDTO storeSaleDTO = saleConverter.vo2dto(storeSaleVO);
        return toAjax(storeSaleService.insertStoreSale(storeSaleDTO));
    }

    /**
     * 修改销售
     */
    @PreAuthorize("@ss.hasPermi('store:sale:edit')")
    @Log(title = "销售", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StoreSaleVO storeSaleVO)
    {
        StoreSaleDTO storeSaleDTO = saleConverter.vo2dto(storeSaleVO);
        return toAjax(storeSaleService.updateStoreSale(storeSaleDTO));
    }

    /**
     * 删除销售
     */
    @PreAuthorize("@ss.hasPermi('store:sale:remove')")
    @Log(title = "销售", businessType = BusinessType.DELETE)
	@DeleteMapping("/{saleIds}")
    public AjaxResult remove(@PathVariable Long[] saleIds)
    {
        return toAjax(storeSaleService.deleteStoreSaleBySaleIds(saleIds));
    }
}

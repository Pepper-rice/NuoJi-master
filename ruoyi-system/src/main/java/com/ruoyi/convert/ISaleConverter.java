package com.ruoyi.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.store.domain.StoreSale;
import com.ruoyi.store.domain.dto.StoreSaleDTO;
import com.ruoyi.store.domain.vo.StoreSaleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @Author Yin Y
 * @create 2023/4/13
 */
@Mapper(componentModel = "spring", imports = {DateUtils.class})
public interface ISaleConverter {
    StoreSaleDTO vo2dto(StoreSaleVO storeSaleVO);

    @Mapping(target = "createTime", expression = "java(DateUtils.getNowDate())")
    StoreSale dto2po(StoreSaleDTO SaleDTO);
}

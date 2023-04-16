package com.ruoyi.convert;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.store.domain.StorePhone;
import com.ruoyi.store.domain.dto.StorePhoneDTO;
import com.ruoyi.store.domain.vo.StorePhoneVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Yin.Y
 * @since 2023/4/13
 * @description 手机对象转换
 */
@Mapper(componentModel = "spring", imports = {DateUtils.class})
public interface IPhoneConverter {
    StorePhoneDTO vo2dto(StorePhoneVO storePhoneVO);

    @Mapping(target = "createTime", expression = "java(DateUtils.getNowDate())")
    StorePhone dto2po(StorePhoneDTO PhoneDTO);
}

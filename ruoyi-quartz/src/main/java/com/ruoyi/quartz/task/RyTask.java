package com.ruoyi.quartz.task;

import cn.hutool.core.util.RandomUtil;
import com.ruoyi.convert.IPhoneConverter;
import com.ruoyi.store.domain.StorePhone;
import com.ruoyi.store.domain.StoreSale;
import com.ruoyi.store.domain.dto.StorePhoneDTO;
import com.ruoyi.store.service.IStorePhoneService;
import com.ruoyi.store.service.impl.StorePhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.util.List;

/**
 * 定时任务调度
 *
 */
@Component("ryTask")
public class RyTask {
    @Autowired
    IStorePhoneService storePhoneService;

    @Autowired
    IPhoneConverter phoneConverter;

//    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
//    {
//        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
//    }
//
//    public void ryParams(String params)
//    {
//        System.out.println("执行有参方法：" + params);
//    }
//
//    public void ryNoParams()
//    {
//        System.out.println("执行无参方法");
//    }

    public void Random() throws InterruptedException {
        while (true) {
            Thread.sleep(RandomUtil.randomInt(5000));
            //选择要消费的手机对象
            StorePhoneDTO storePhoneDTO = new StorePhoneDTO();
            List<StorePhone> phoneList = storePhoneService.selectStorePhoneList(storePhoneDTO);
            int RandomPhone = RandomUtil.randomInt(phoneList.size());
            StorePhone storePhone = phoneList.get(RandomPhone);
            //选择要消费的用户ID

            //随机销售
//          Long phoneId = RandomUtil.randomLong(storePhone.getPhoneId());
//          storePhone.setPhoneId(phoneId);
            //更新手机随机价格
            storePhone.setPrice(RandomUtil.randomInt(1,10000));
            StorePhoneDTO PhoneDTO = phoneConverter.po2dto(storePhone);
            storePhoneService.updateStorePhone(PhoneDTO);
//            // Check if stock is empty, restock if needed
//            if (stockQuantity == 0) {
//                stockQuantity = random.nextInt(50) + 1;
//                System.out.println("Restocked " + stockQuantity + " phones.");
//            }
//
//            // Simulate a sale
//            String customerName = "Customer " + random.nextInt(1000);
//            LocalDateTime saleDate = LocalDateTime.now();
//            int saleQuantity = random.nextInt(Math.min(stockQuantity, 10)) + 1;
//            double salePrice = saleQuantity * price;
//            stockQuantity -= saleQuantity;
        }
    }
}


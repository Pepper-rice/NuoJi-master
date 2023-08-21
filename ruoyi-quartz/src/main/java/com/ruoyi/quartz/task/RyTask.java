package com.ruoyi.quartz.task;

import cn.hutool.core.util.RandomUtil;
import com.ruoyi.convert.IPhoneConverter;
import com.ruoyi.convert.ISaleConverter;
import com.ruoyi.store.domain.StorePhone;
import com.ruoyi.store.domain.StoreSale;
import com.ruoyi.store.domain.dto.StorePhoneDTO;
import com.ruoyi.store.domain.dto.StoreSaleDTO;
import com.ruoyi.store.service.IStorePhoneService;
import com.ruoyi.store.service.IStoreSaleService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    IStoreSaleService storeSaleService;

    @Autowired
    ISaleConverter saleConverter;

    @Autowired
    ISysUserService sysUserService;

    public void test() {
        System.out.println("test1");
    }

    public synchronized void RandomSale() throws InterruptedException {
        //线程进入阻塞状态，随机等待1-3秒（不会占用CPU资源）
        Thread.sleep(RandomUtil.randomInt(1000, 3000));

        //选择要消费的手机对象RstorePhone
        StorePhoneDTO storePhoneDTO = new StorePhoneDTO();
        List<StorePhone> phoneList = storePhoneService.selectStorePhoneList(storePhoneDTO);
        int RandomPhone = RandomUtil.randomInt(phoneList.size());
        StorePhone RstorePhone = phoneList.get(RandomPhone);

        //选择要消费的消费对象RstoreSale
        StoreSaleDTO storeSaleDTO = new StoreSaleDTO();
        List<StoreSale> saleList = storeSaleService.selectStoreSaleList(storeSaleDTO);
        int RandomSale = RandomUtil.randomInt(saleList.size());
        StoreSale RstoreSale = saleList.get(RandomSale);
        RstoreSale.setSaleQuantity(RandomUtil.randomInt(10,100));

        //选择要消费的用户对象RsysUser
        StoreSaleDTO storeSale = new StoreSaleDTO();
        List<StoreSale> salelist = storeSaleService.selectStoreSaleList(storeSale);
        int Randomsale = RandomUtil.randomInt(salelist.size());
        StoreSale Rstoresale = saleList.get(Randomsale);

        //判断无库存随机补货，否则设置随机销售数量
        if (RstorePhone.getPhoneQuantity() == 0) {
            RstorePhone.setPhoneQuantity(RandomUtil.randomInt(10, 100));
            StorePhoneDTO PhoneDTO = phoneConverter.po2dto(RstorePhone);
            storePhoneService.updateStorePhone(PhoneDTO);
        }else {
            RstoreSale.setPhoneId(RstorePhone.getPhoneId());
            RstoreSale.setCustomerName(Rstoresale.getCustomerName());
            RstoreSale.setSalePrice(RstoreSale.getSaleQuantity() * RstorePhone.getPrice());
            //修改手机价格
            RstorePhone.setPhoneQuantity(RandomUtil.randomInt(100,500));
            RstorePhone.setPrice(RandomUtil.randomInt(1, 10000));
            StorePhoneDTO PhoneDTO = phoneConverter.po2dto(RstorePhone);
            storePhoneService.updateStorePhone(PhoneDTO);
            //插入销售订单
            StoreSaleDTO SaleDTO = saleConverter.po2dto(RstoreSale);
            storeSaleService.insertStoreSale(SaleDTO);
        }
    }
}



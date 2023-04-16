//package com.ruoyi.quartz.task;
//
//import cn.hutool.core.util.RandomUtil;
//import com.ruoyi.store.service.IStorePhoneService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import com.ruoyi.common.utils.StringUtils;
//
///**
// * 定时任务调度
// *
// */
//@Component("ryTask")
//public class RyTask {
//    @Autowired
//    private IStorePhoneService storePhoneService;
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
//
//    public void Random() throws InterruptedException {
//        while (true) {
//            Thread.sleep(RandomUtil.randomInt(5000));
//            // 更新价格
//            storePhoneService.
//            price += RandomUtil.randomDouble() * 10 - 5;
//
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
//
//            System.out.println("Sale ID: " + random.nextInt(10000)
//                    + ", Customer Name: " + customerName
//                    + ", Sale Date: " + saleDate
//                    + ", Phone ID: " + phoneId
//                    + ", Phone Name: " + phoneName
//                    + ", Phone Brand: " + phoneBrand
//                    + ", Phone Storage: " + phoneStorage
//                    + ", Sale Quantity: " + saleQuantity
//                    + ", Price: " + price
//                    + ", Sale Price: " + salePrice);
//
//            stockQuantity -= saleQuantity;
//        }
//    }
//}
//    }
//}

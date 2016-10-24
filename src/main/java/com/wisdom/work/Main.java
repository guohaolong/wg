package main.java.com.wisdom.work;

import main.java.com.wisdom.work.service.ShoppingCartService;

/**
 * Created by guohaolong on 16/10/13.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("系统正在初始化...");
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        //初始化数据
        shoppingCartService.init();
        System.out.println("系统初始化完成");
        //设置促销信息
        shoppingCartService.setPromotionInfo("");
        //设置购物车信息
        shoppingCartService.setProductInfo();
        //设置结算日期
        shoppingCartService.setDate("");
        //设置优惠券信息
        shoppingCartService.setCoupon("");
        //计算需要支付的实际金额
        shoppingCartService.count();
    }
}

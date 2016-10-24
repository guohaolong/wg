package main.java.com.wisdom.work.service;

import main.java.com.wisdom.work.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by guohaolong on 16/10/16.
 */
public class ShoppingCartService {

    //促销信息
    public static PromotionInfo promotionInfo = new PromotionInfo();
    //商品列表main
    public static Map<String, ProductInfo> productInfoMap = new HashMap<>();
    //商品类别
    public static Map<String, ProductCategory> categoryMap = new HashMap<>();
    //购物车
    public static List<ShoppingCart> shoppingCartList = new ArrayList<>();
    //结算日期
    public static String date;
    //优惠券信息
    public static CouponInfo couponInfo = new CouponInfo();

    /**
     * 初始化
     */
    public static void init() {
        //产品类别
        categoryMap.put("电子", initProductCategory(1l, "电子"));
        categoryMap.put("食品", initProductCategory(2l, "食品"));
        categoryMap.put("日用品", initProductCategory(3l, "日用品"));
        categoryMap.put("酒类", initProductCategory(4l, "酒类"));
        //产品明细
        productInfoMap.put("ipad", initProductInfo(1l, 1l, "ipad"));
        productInfoMap.put("iphone", initProductInfo(2l, 1l, "iphone"));
        productInfoMap.put("显示器", initProductInfo(3l, 1l, "显示器"));
        productInfoMap.put("笔记本电脑", initProductInfo(4l, 1l, "笔记本电脑"));
        productInfoMap.put("键盘", initProductInfo(5l, 1l, "键盘"));
        productInfoMap.put("面包", initProductInfo(6l, 2l, "面包"));
        productInfoMap.put("饼干", initProductInfo(7l, 2l, "饼干"));
        productInfoMap.put("蛋糕", initProductInfo(8l, 2l, "蛋糕"));
        productInfoMap.put("牛肉", initProductInfo(9l, 2l, "牛肉"));
        productInfoMap.put("鱼", initProductInfo(10l, 2l, "鱼"));
        productInfoMap.put("蔬菜", initProductInfo(11l, 2l, "蔬菜"));
        productInfoMap.put("餐巾纸", initProductInfo(12l, 3l, "餐巾纸"));
        productInfoMap.put("收纳箱", initProductInfo(13l, 3l, "收纳箱"));
        productInfoMap.put("咖啡杯", initProductInfo(14l, 3l, "咖啡杯"));
        productInfoMap.put("雨伞", initProductInfo(15l, 2l, "雨伞"));
        productInfoMap.put("啤酒", initProductInfo(16l, 4l, "啤酒"));
        productInfoMap.put("白酒", initProductInfo(17l, 4l, "白酒"));
        productInfoMap.put("伏特加", initProductInfo(17l, 4l, "伏特加"));
    }

    /**
     * 初始化产品分类
     *
     * @param id
     * @param name
     * @return
     */
    private static ProductCategory initProductCategory(Long id, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(id);
        productCategory.setCategoryName(name);
        return productCategory;
    }
    /**
     * 初始化产品明细
     *
     * @param id
     * @param categoryId
     * @param name
     * @return
     */
    private static ProductInfo initProductInfo(Long id, Long categoryId, String name) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setCategoryId(categoryId);
        productInfo.setProductId(id);
        productInfo.setProductName(name);
        return productInfo;
    }

    /**
     * 设置促销信息
     */
    public static void setPromotionInfo(String info) {
        if("".equals(info)){
            System.out.println("请输入促销信息,若没有促销信息,请按回车键继续");
            info = readInfo();
            if ("".equals(info)) {
                return;
            }
        }
        String[] detail = info.split("\\|");
        for (int i = 0; i < detail.length; i++) {
            detail[i] = detail[i].trim();
        }
        if (detail.length < 3) {
            System.out.println("您输入的促销信息格式有误,正确格式为:2013.11.11 | 0.7 | 电子");
            setPromotionInfo("");
        }
        //查找该类别是否存在
        Long categoryId = 0l;
        if (categoryMap.get(detail[2]) == null) {
            System.out.println("您输入的促销信息中的商品类别不存在,当前存在的商品类别有:电子,食品,日用品,酒类");
            setPromotionInfo("");
        } else {
            ProductCategory productCategory = categoryMap.get(detail[2]);
            categoryId = productCategory.getCategoryId();
        }
        promotionInfo.setDate(detail[0]);
        promotionInfo.setDiscount(Float.parseFloat(detail[1]));
        promotionInfo.setCategoryId(categoryId);
    }

    /**
     * 设置购物车信息
     */
    public static void setProductInfo() {
        System.out.println("请输入购物车中商品详细信息,若添加结束,请按回车键继续:");
        String info = readInfo();
        if ("".equals(info.trim())) {
            return;
        }
        String[] detail = info.split("\\*");
        if (detail.length < 2) {
            System.out.println("您输入的商品详细信息格式有误,正确格式为:1 * 显示器: 1799.00");
            setPromotionInfo("");
        }
        for (int i = 0; i < detail.length; i++) {
            detail[i] = detail[i].trim();
        }
        //商品数量
        int productNum = 0;
        try {
            productNum = Integer.parseInt(detail[0]);
        } catch (NumberFormatException e) {
            System.out.println("您输入的商品数量格式有误,应为整数");
            setProductInfo();
        }
        String[] detailRight = detail[1].split(":");
        if (detail.length < 2) {
            System.out.println("您输入的商品详细信息格式有误,正确格式为:1 * 显示器: 1799.00");
            setPromotionInfo("");
        }
        for (int i = 0; i < detailRight.length; i++) {
            detailRight[i] = detailRight[i].trim();
        }
        //商品名称
        String productName = detailRight[0];
        //查找商品是否存在
        ProductInfo productInfo = new ProductInfo();
        if (productInfoMap.get(productName) == null) {
            System.out.println("您输入的商品不存在");
            setProductInfo();
        } else {
            productInfo = productInfoMap.get(productName);
        }
        //商品价格
        float productPrice = 0f;
        try {
            productPrice = Float.parseFloat(detailRight[1]);
        } catch (NumberFormatException e) {
            System.out.println("您输入的商品价格格式有误,应为浮点数");
            setProductInfo();
        }
        //写入购物车
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductId(productInfo.getProductId());
        shoppingCart.setProductName(productName);
        shoppingCart.setCategoryId(productInfo.getCategoryId());
        shoppingCart.setProductPrice(productPrice);
        shoppingCart.setProductNum(productNum);
        shoppingCartList.add(shoppingCart);
        setProductInfo();
    }

    /**
     * 设置结算日期
     */
    public static void setDate(String info) {
        if("".equals(info)){
            System.out.println("请输入结算日期");
            info = readInfo();
            if ("".equals(info.trim())) {
                return;
            }
        }
        String[] detail = info.split("\\.");
        for (int i = 0; i < detail.length; i++) {
            detail[i] = detail[i].trim();
        }
        if (detail.length != 3) {
            System.out.println("您输入的结算日期格式有误,正确格式为:2013.11.11");
            setDate("");
        }else{
            date = detail[0] + "." + detail[1] + "." + detail[2];
        }
    }

    /**
     * 设置优惠券信息
     */
    public static void setCoupon(String info) {
        if("".equals(info)){
            System.out.println("请输入优惠券信息,若没有优惠券信息,请按回车键继续");
            info = readInfo();
            if ("".equals(info.trim())) {
                return;
            }
        }
        String[] detail = info.split(" ");
        for (int i = 0; i < detail.length; i++) {
            detail[i] = detail[i].trim();
        }
        if (detail.length != 3) {
            System.out.println("您输入的优惠券信息格式有误,正确格式为:2014.3.2 1000 200");
            setCoupon("");
        }
        couponInfo.setTotal(Float.parseFloat(detail[1]));
        couponInfo.setRelief(Float.parseFloat(detail[2]));
        couponInfo.setDeadline(detail[0]);
    }

    /**
     * 计算需要支付的实际金额
     */
    public static void count() {
        float actual = 0.0f;
        for (ShoppingCart shoppingCart : shoppingCartList) {
            //查询促销信息
            if (promotionInfo.getCategoryId() != null && Long.compare(promotionInfo.getCategoryId(), shoppingCart.getCategoryId()) == 0) {
                actual += shoppingCart.getProductPrice() * shoppingCart.getProductNum() * promotionInfo.getDiscount();
            } else {
                actual += shoppingCart.getProductPrice() * shoppingCart.getProductNum();
            }
        }
        if(couponInfo.getDeadline() != null){
            //查询优惠券信息   比较优惠券截至日期和结算日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dealDate = sdf.parse(date.replace(".", "-"));
                Date deadline = sdf.parse(couponInfo.getDeadline().replace(".", "-"));
                //如果结算时间在优惠券截至日期之前,并且金额大于等于优惠券中的金额
                if (deadline.after(dealDate) && actual >= couponInfo.getTotal()) {
                    actual -= couponInfo.getRelief();
                }
            } catch (ParseException e) {
                System.out.println("优惠券信息有误");
            }
        }
        //两位小数
        DecimalFormat df = new DecimalFormat("0.00");
        String proportionStr = df.format(actual);
        System.out.println("合计总金额为:" + proportionStr);

    }

    /**
     * 获取用户输入信息
     *
     * @return
     */
    private static String readInfo() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String info = null;
        try {
            info = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }
}

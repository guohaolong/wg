package main.java.com.wisdom.work.domain;

/**
 * Created by guohaolong on 16/10/13.
 * 商品购物车
 */
public class ShoppingCart extends ProductInfo {

    /**
     * 商品数量
     */
    private Integer productNum;

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
}

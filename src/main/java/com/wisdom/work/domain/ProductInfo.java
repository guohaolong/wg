package main.java.com.wisdom.work.domain;

/**
 * Created by guohaolong on 16/10/13.
 * 商品详细信息
 */
public class ProductInfo {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 类别Id
     */
    private Long categoryId;
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private Float productPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }
}

package main.java.com.wisdom.work.domain;

/**
 * Created by guohaolong on 16/10/13.
 * 促销信息
 */
public class PromotionInfo {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 促销类别Id
     */
    private Long categoryId;
    /**
     * 促销日期
     */
    private String date;
    /**
     * 促销折扣
     */
    private Float discount;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}

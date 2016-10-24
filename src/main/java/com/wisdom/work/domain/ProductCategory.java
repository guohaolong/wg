package main.java.com.wisdom.work.domain;

/**
 * Created by guohaolong on 16/10/13.
 * 商品类别
 */
public class ProductCategory {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 类别Id
     */
    private Long categoryId;
    /**
     * 类别名称
     */
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

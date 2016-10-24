package main.java.com.wisdom.work.domain;

/**
 * Created by guohaolong on 16/10/13.
 * 优惠券
 */
public class CouponInfo {

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 截至日期
     */
    private String deadline;
    /**
     * 总金额
     */
    private Float total;
    /**
     * 减免金额
     */
    private Float relief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getRelief() {
        return relief;
    }

    public void setRelief(Float relief) {
        this.relief = relief;
    }
}

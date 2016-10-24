package test;

import main.java.com.wisdom.work.service.ShoppingCartService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by guohaolong on 16/10/16.
 */
public class ShoppingCartServiceTest {

    @Test
    public void init() throws Exception {
        ShoppingCartService.init();
        Assert.assertTrue(true);
    }

    @Test
    public void setPromotionInfo() throws Exception {
        ShoppingCartService.setPromotionInfo("2013.11.11 | 0.7 | 电子");
        Assert.assertTrue(true);
    }

    @Test
    public void setDate() throws Exception {
        ShoppingCartService.setDate("2013.11.11");
        Assert.assertTrue(true);
    }

    @Test
    public void setCoupon() throws Exception {
        ShoppingCartService.setCoupon("2014.3.2 1000 200");
        Assert.assertTrue(true);
    }

    @Test
    public void count() throws Exception {
        ShoppingCartService.count();
        Assert.assertTrue(true);
    }
}
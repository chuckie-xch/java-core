package com.bestcode.mr.product.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import com.bestcode.mr.product.ProductApplicationTest;
import com.bestcode.mr.product.model.dto.CartDTO;
import com.bestcode.mr.product.model.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceTest extends ProductApplicationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfo> list = productService.findList(Arrays.asList("157875227953464068"));
        System.out.println(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO("157875196366160022", 2);
        productService.decreaseStock(Arrays.asList(cartDTO));

    }
}
package com.bestcode.mr.product.service;

import static org.junit.Assert.*;

import java.util.List;

import com.bestcode.mr.product.ProductApplicationTest;
import com.bestcode.mr.product.model.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceTest extends ProductApplicationTest{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
}
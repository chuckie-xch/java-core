package com.bestcode.mr.product.repo;


import java.util.List;

import com.bestcode.mr.product.model.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(list.size()>0);
    }
}
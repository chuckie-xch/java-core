package com.bestcode.mr.product.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import com.bestcode.mr.product.ProductApplicationTest;
import com.bestcode.mr.product.model.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceTest extends ProductApplicationTest{

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}
package com.bestcode.mr.product.service.impl;

import java.util.List;

import com.bestcode.mr.product.model.entity.ProductCategory;
import com.bestcode.mr.product.repo.ProductCategoryRepository;
import com.bestcode.mr.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xch
 * @create 2018-06-07 22:15
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}

package com.bestcode.product.server.service.impl;

import java.util.List;


import com.bestcode.product.server.model.entity.ProductCategory;
import com.bestcode.product.server.repo.ProductCategoryRepository;
import com.bestcode.product.server.service.CategoryService;
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

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}

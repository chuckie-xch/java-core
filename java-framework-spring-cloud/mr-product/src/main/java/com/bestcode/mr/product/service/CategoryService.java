package com.bestcode.mr.product.service;

import java.util.List;

import com.bestcode.mr.product.model.entity.ProductCategory;

/**
 * @author xch
 * @create 2018-06-07 22:15
 **/
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

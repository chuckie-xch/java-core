package com.bestcode.product.server.service;

import java.util.List;

import com.bestcode.product.server.model.entity.ProductCategory;


/**
 * @author xch
 * @create 2018-06-07 22:15
 **/
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

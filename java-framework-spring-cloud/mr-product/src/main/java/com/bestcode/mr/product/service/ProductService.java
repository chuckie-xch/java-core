package com.bestcode.mr.product.service;

import java.util.List;

import com.bestcode.mr.product.model.entity.ProductInfo;

/**
 * @author xch
 * @create 2018-06-07 22:03
 **/
public interface ProductService {

    List<ProductInfo> findUpAll();
}

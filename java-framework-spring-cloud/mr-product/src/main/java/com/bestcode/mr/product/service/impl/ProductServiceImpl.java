package com.bestcode.mr.product.service.impl;

import java.util.List;

import com.bestcode.mr.product.enums.ProductStatusEnum;
import com.bestcode.mr.product.model.entity.ProductInfo;
import com.bestcode.mr.product.repo.ProductInfoRepository;
import com.bestcode.mr.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xch
 * @create 2018-06-07 22:07
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}

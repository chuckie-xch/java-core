package com.bestcode.mr.product.service;

import java.util.List;

import com.bestcode.mr.product.model.dto.CartDTO;
import com.bestcode.mr.product.model.entity.ProductInfo;

/**
 * @author xch
 * @create 2018-06-07 22:03
 **/
public interface ProductService {

    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}

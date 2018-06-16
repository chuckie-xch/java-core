package com.bestcode.product.server.service;

import java.util.List;

import com.bestcode.product.common.DecreaseStockInput;
import com.bestcode.product.common.ProductInfoOutput;
import com.bestcode.product.server.model.dto.CartDTO;
import com.bestcode.product.server.model.entity.ProductInfo;


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
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}

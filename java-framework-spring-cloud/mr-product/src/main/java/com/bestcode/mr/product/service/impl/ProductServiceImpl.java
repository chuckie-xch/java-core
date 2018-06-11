package com.bestcode.mr.product.service.impl;

import java.util.List;
import java.util.Optional;

import com.bestcode.mr.product.enums.ProductStatusEnum;
import com.bestcode.mr.product.enums.ResultEnum;
import com.bestcode.mr.product.exception.ProductException;
import com.bestcode.mr.product.model.dto.CartDTO;
import com.bestcode.mr.product.model.entity.ProductInfo;
import com.bestcode.mr.product.repo.ProductInfoRepository;
import com.bestcode.mr.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xch
 * @create 2018-06-07 22:07
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            // 商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            // 库存是否够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}

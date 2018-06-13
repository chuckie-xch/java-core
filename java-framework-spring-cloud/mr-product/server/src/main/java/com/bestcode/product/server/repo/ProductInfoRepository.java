package com.bestcode.product.server.repo;

import java.util.List;

import com.bestcode.mr.product.model.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xch
 * @create 2018-06-06 23:02
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}

package com.bestcode.product.server.repo;

import java.util.List;

import com.bestcode.product.server.model.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xch
 * @create 2018-06-06 23:17
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}

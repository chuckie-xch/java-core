package com.bestcode.mr.product.repo;

import java.util.List;

import com.bestcode.mr.product.model.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xch
 * @create 2018-06-06 23:17
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}

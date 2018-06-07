package com.bestcode.mr.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bestcode.mr.product.model.ResultVO;
import com.bestcode.mr.product.model.entity.ProductCategory;
import com.bestcode.mr.product.model.entity.ProductInfo;
import com.bestcode.mr.product.model.vo.ProductInfoVO;
import com.bestcode.mr.product.model.vo.ProductVO;
import com.bestcode.mr.product.service.CategoryService;
import com.bestcode.mr.product.service.ProductService;
import com.bestcode.mr.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-06-06 22:43
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        List<ProductInfo> productInfos = productService.findUpAll();
        List<Integer> categoryTypeList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors
                .toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList= new ArrayList<ProductVO>();
        for (ProductCategory productCategory: categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOS= new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo: productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOS);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}

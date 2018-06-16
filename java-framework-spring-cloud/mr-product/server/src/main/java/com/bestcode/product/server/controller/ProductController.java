package com.bestcode.product.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.bestcode.product.common.DecreaseStockInput;
import com.bestcode.product.common.ProductInfoOutput;
import com.bestcode.product.server.model.ResultVO;
import com.bestcode.product.server.model.dto.CartDTO;
import com.bestcode.product.server.model.entity.ProductCategory;
import com.bestcode.product.server.model.entity.ProductInfo;
import com.bestcode.product.server.model.vo.ProductInfoVO;
import com.bestcode.product.server.model.vo.ProductVO;
import com.bestcode.product.server.service.CategoryService;
import com.bestcode.product.server.service.ProductService;
import com.bestcode.product.server.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xch
 * @create 2018-06-06 22:43
 **/
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOS = new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo : productInfos) {
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

    /**
     * 获取商品列表（给订单服务用）
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }
}

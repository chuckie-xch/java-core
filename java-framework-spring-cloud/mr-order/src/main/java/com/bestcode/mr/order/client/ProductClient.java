package com.bestcode.mr.order.client;

import java.util.List;

import com.bestcode.mr.order.model.dto.CartDTO;
import com.bestcode.mr.order.model.entity.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xch
 * @create 2018-06-11 21:41
 **/
@FeignClient(name = "mr-product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}

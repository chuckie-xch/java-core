package com.bestcode.mr.order.message;

import java.util.List;

import com.bestcode.mr.order.utils.JsonUtil;
import com.bestcode.product.common.ProductInfoOutput;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xch
 * @create 2018-06-25 21:28
 **/
@Component
@Slf4j
public class ProductInfoReceiver {

    private static String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private RedisTemplate redisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(message, new
                TypeReference<List<ProductInfoOutput>>() {
                });
        log.info("从队列【{}】接收到消息{}", "productInfo", productInfoOutputList);
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            redisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}

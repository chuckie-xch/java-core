package com.bestcode.mr.order.message;

import com.bestcode.mr.order.utils.JsonUtil;
import com.bestcode.product.common.ProductInfoOutput;
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
        ProductInfoOutput productInfoOutput = (ProductInfoOutput) JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("从队列【{}】接收到消息{}", "productInfo", productInfoOutput);
        redisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                String.valueOf(productInfoOutput.getProductStock()));
    }
}

package com.bestcode.mr.order.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import com.bestcode.mr.order.converter.OrderForm2OrderDTOConverter;
import com.bestcode.mr.order.enums.ResultEnum;
import com.bestcode.mr.order.exception.OrderException;
import com.bestcode.mr.order.model.ResultVO;
import com.bestcode.mr.order.model.dto.OrderDTO;
import com.bestcode.mr.order.model.form.OrderForm;
import com.bestcode.mr.order.service.OrderService;
import com.bestcode.mr.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-06-07 23:58
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1.参数校验
     * 2. 查询商品信息
     * 3. 计算总价
     * 4. 扣库存
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError()
                    .getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }
}

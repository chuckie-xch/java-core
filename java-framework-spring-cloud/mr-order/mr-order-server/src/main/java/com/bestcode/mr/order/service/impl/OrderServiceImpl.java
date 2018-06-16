package com.bestcode.mr.order.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bestcode.mr.order.enums.OrderStatusEnum;
import com.bestcode.mr.order.enums.PayStatusEnum;
import com.bestcode.mr.order.model.dto.CartDTO;
import com.bestcode.mr.order.model.dto.OrderDTO;
import com.bestcode.mr.order.model.entity.OrderDetail;
import com.bestcode.mr.order.model.entity.OrderMaster;
import com.bestcode.mr.order.model.entity.ProductInfo;
import com.bestcode.mr.order.repo.OrderDetailRepository;
import com.bestcode.mr.order.repo.OrderMasterRepository;
import com.bestcode.mr.order.service.OrderService;
import com.bestcode.mr.order.utils.KeyUtil;
import com.bestcode.product.client.ProductClient;
import com.bestcode.product.common.DecreaseStockInput;
import com.bestcode.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xch
 * @create 2018-06-08 0:00
 **/
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.uuid();
        // 查询商品信息
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect
                (Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        // 计算总价
        BigDecimal orderAmount = BigDecimal.ZERO;
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail
                            .getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.uuid());
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        // 扣库存
        List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream().map(e -> new DecreaseStockInput
                (e.getProductId(), e
                .getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}

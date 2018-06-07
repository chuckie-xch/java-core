package com.bestcode.mr.order.repo;

import com.bestcode.mr.order.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xch
 * @create 2018-06-07 23:39
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}

package com.bestcode.mr.order.repo;

import com.bestcode.mr.order.model.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xch
 * @create 2018-06-07 23:38
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}

package com.business.manager.service;

import com.business.manager.OrderForm;
import com.business.manager.entity.OrderAddress;
import com.business.manager.entity.OrderBean;
import com.business.manager.entity.UserOrderDetail;
import com.business.manager.util.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity createOrder(OrderForm orderForm);
    ResponseEntity<OrderBean> getOrderInfo(Integer orderId);
    ResponseEntity<Object> getOrderList(Integer userId, Integer page, Integer pageSize);

    ResponseEntity<Object> deleteById(Integer orderId);
}

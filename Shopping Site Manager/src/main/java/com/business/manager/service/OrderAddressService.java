package com.business.manager.service;

import com.business.manager.entity.OrderAddress;
import com.business.manager.util.ResponseEntity;

public interface OrderAddressService {
    ResponseEntity insert(OrderAddress record);
    ResponseEntity<OrderAddress> addressInfo(Integer orderAddrId);
    ResponseEntity<Object> update(OrderAddress record);
    ResponseEntity<Object> deleteById(Integer orderAddrId);
    ResponseEntity<Object> getAddressList(Integer userId, Integer page, Integer pageSize);
}

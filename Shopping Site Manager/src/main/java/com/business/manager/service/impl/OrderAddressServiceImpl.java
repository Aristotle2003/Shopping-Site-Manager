package com.business.manager.service.impl;

import com.business.manager.dao.OrderAddressDao;
import com.business.manager.entity.OrderAddress;
import com.business.manager.service.OrderAddressService;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderAddressServiceImpl implements OrderAddressService {
    @Resource
    private OrderAddressDao orderAddressDao;
    @Override
    public ResponseEntity<Object> insert(OrderAddress record) {
        int insert = orderAddressDao.insert(record);
        Map<String, Object> result = new HashMap<>();
        result.put("order_addr_id",record.getOrderAddrId());
        return insert == 1 ? ResponseEntity.SUCCESS(result,"订单地址创建成功") : ResponseEntity.ERROR("订单地址创建失败");
    }

    @Override
    public ResponseEntity<OrderAddress> addressInfo(Integer orderAddrId) {
        return ResponseEntity.SUCCESS(orderAddressDao.selectById(orderAddrId));
    }

    @Override
    public ResponseEntity<Object> update(OrderAddress record) {
        int insert = orderAddressDao.update(record);
        Map<String, Object> result = new HashMap<>();
        result.put("order_addr_id",record.getOrderAddrId());
        return insert == 1 ? ResponseEntity.SUCCESS(result,"订单地址更新成功") : ResponseEntity.ERROR("订单地址更新失败");
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer orderAddrId) {
        int deleteResult = orderAddressDao.deleteById(orderAddrId);
        return deleteResult == 1 ? ResponseEntity.SUCCESS(null,"请求成功") : ResponseEntity.ERROR("删除失败");
    }

    @Override
    public ResponseEntity<Object> getAddressList(Integer userId, Integer page, Integer pageSize) {
        Integer startIndex = (page -1)*pageSize;
        List<OrderAddress> addressList = orderAddressDao.getAddressList(userId, startIndex, pageSize);
        int total = orderAddressDao.getAddressListCount(userId);

        int totalPage = total/pageSize;
        if(total%pageSize !=0){
            totalPage +=1;
        }

        Map<String,Object> result = new HashMap<>();
        result.put("total_pages",totalPage);
        result.put("current_page",page);
        result.put("addresses",addressList);


        return ResponseEntity.SUCCESS(result);
    }
}

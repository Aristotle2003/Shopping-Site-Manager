package com.business.manager.controller;

import com.business.manager.entity.OrderAddress;
import com.business.manager.service.OrderAddressService;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderAddressController {

    @Resource
    private OrderAddressService orderAddressService;

    /**
     * 创建订单地址
     * @param orderAddress 订单地址请求参数
     * @return
     */
    @PostMapping("/order-address")
    public ResponseEntity addOrderAddress(@RequestBody OrderAddress orderAddress) {
        return orderAddressService.insert(orderAddress);
    }
    /**
     *  获取订单地址
     * @param orderAddrId 订单地址ID
     * @return
     */
    @GetMapping("/order-address/{orderAddrId}")
    public ResponseEntity<OrderAddress> addressInfo(@PathVariable Integer orderAddrId) {
        return orderAddressService.addressInfo(orderAddrId);
    }

    /**
     *  更新订单地址
     * @param orderAddrId 订单地址ID
     * @param orderAddress 订单地址参数
     * @return
     */
    @PutMapping("/order-address/{orderAddrId}")
    public ResponseEntity<Object> updateOrderAddress(@PathVariable Integer orderAddrId,@RequestBody OrderAddress orderAddress) {
        orderAddress.setOrderAddrId(orderAddrId);
        return orderAddressService.update(orderAddress);
    }

    /**
     *  删除订单地址
     * @param orderAddrId 订单地址ID
     * @return
     */
    @DeleteMapping("/order-address/{orderAddrId}")
    public ResponseEntity<Object> deleteOrderAddress(@PathVariable Integer orderAddrId) {
        return orderAddressService.deleteById(orderAddrId);
    }


    /**
     *  获取用户收货地址列表
     * @return
     */
    @GetMapping("/order-address")
    public ResponseEntity<Object> getUserAddressList(@RequestParam(name = "user_id") Integer userId,
                                                     @RequestParam(required = false,defaultValue = "1") Integer page,
                                                     @RequestParam(required = false,defaultValue = "10") Integer limit) {
        return orderAddressService.getAddressList(userId,page,limit);
    }

}

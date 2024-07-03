package com.business.manager.controller;

import com.business.manager.OrderForm;
import com.business.manager.entity.OrderAddress;
import com.business.manager.entity.OrderBean;
import com.business.manager.entity.UserOrderDetail;
import com.business.manager.service.OrderAddressService;
import com.business.manager.service.OrderService;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm 下单参数
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity addOrder(@RequestBody OrderForm orderForm) {
        return orderService.createOrder(orderForm);
    }
    /**
     *  获取订单详情
     * @param orderId 订单ID
     * @return
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderBean> addressInfo(@PathVariable Integer orderId) {
        return orderService.getOrderInfo(orderId);
    }

    /**
     *  删除订单
     * @param orderId 订单ID
     * @return
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteById(orderId);
    }


    /**
     *  获取获取订单列表
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Object> getOrderList(@RequestParam(name = "user_id") Integer userId,
                                                     @RequestParam(required = false,defaultValue = "1") Integer page,
                                                     @RequestParam(required = false,defaultValue = "10") Integer limit) {
        return orderService.getOrderList(userId,page,limit);
    }

}

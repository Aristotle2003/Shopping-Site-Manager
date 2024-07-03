package com.business.manager.service.impl;

import com.business.manager.OrderForm;
import com.business.manager.dao.OrderAddressDao;
import com.business.manager.dao.OrderDao;
import com.business.manager.dao.OrderDetailDao;
import com.business.manager.entity.OrderAddress;
import com.business.manager.entity.OrderBean;
import com.business.manager.entity.UserOrder;
import com.business.manager.entity.UserOrderDetail;
import com.business.manager.service.OrderService;
import com.business.manager.util.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private OrderDetailDao orderDetailDao;
    @Resource
    private OrderAddressDao orderAddressDao;
    @Override
    public ResponseEntity createOrder(OrderForm orderForm) {
        if(orderForm == null){
            return ResponseEntity.ERROR("请填写参数");
        }
        Integer orderAddressId = orderForm.getOrderAddressId();
        if(orderAddressId == null){
            return ResponseEntity.ERROR("请填写收货地址");
        }
        OrderAddress orderAddress = orderAddressDao.selectById(orderAddressId);
        if(orderAddress == null){
            return ResponseEntity.ERROR("未查询到收货信息");
        }
        if(CollectionUtils.isEmpty(orderForm.getOrderDetails())){
            return ResponseEntity.ERROR("请选择商品");
        }

        UserOrder userOrder = new UserOrder();
        int total = orderForm.getOrderDetails().size();
        userOrder.setShopId(orderForm.getShopId());
        userOrder.setShopName(orderForm.getShopName());
        userOrder.setDeliveryType(orderForm.getDeliveryType());
        userOrder.setUserId(orderForm.getUserId());
        userOrder.setOrderAddrId(orderForm.getOrderAddressId());
        userOrder.setIsPayed(0);
        userOrder.setStatus(0);
        userOrder.setAllCount(total);
        BigDecimal totalPrice = new BigDecimal("0");
        //计算总价
        for (UserOrderDetail orderDetail : orderForm.getOrderDetails()) {
            orderDetail.setUserId(orderForm.getUserId());
            orderDetail.setDeliveryType(userOrder.getDeliveryType());
            orderDetail.setShopId(userOrder.getShopId());
            orderDetail.setUserId(userOrder.getUserId());
            orderDetail.setShopCartTime(new Date());
            totalPrice = totalPrice.add(BigDecimal.valueOf(orderDetail.getPrice()).multiply(BigDecimal.valueOf(orderDetail.getCount())));
        }
        userOrder.setTotal(totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        //保存
        orderDao.insert(userOrder);
        for (UserOrderDetail orderDetail : orderForm.getOrderDetails()) {
            orderDetail.setOrderId(userOrder.getOrderId());
            orderDetailDao.insert(orderDetail);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("order_id",userOrder.getOrderId());
        return ResponseEntity.SUCCESS(result,"创建订单成功");
    }

    @Override
    public ResponseEntity<OrderBean> getOrderInfo(Integer orderId) {
        UserOrder userOrder = orderDao.selectById(orderId);
        OrderBean orderBean = new OrderBean();
        orderBean.setUserOrder(userOrder);
        orderBean.setOrderDetails(orderDetailDao.getOrderList(userOrder.getOrderId()));
        return ResponseEntity.SUCCESS(orderBean,"获取详情成功");
    }

    @Override
    public ResponseEntity<Object> getOrderList(Integer userId, Integer page, Integer pageSize) {
        Integer startIndex = (page -1)*pageSize;
        List<UserOrder> userOrders = orderDao.getOrderList(userId, startIndex, pageSize);
        int total = orderDao.getOrderCount(userId);

        int totalPage = total/pageSize;
        if(total%pageSize !=0){
            totalPage +=1;
        }
        List<OrderBean> orderBeans = new ArrayList<>();
        for (UserOrder userOrder : userOrders) {
            OrderBean orderBean = new OrderBean();
            orderBean.setUserOrder(userOrder);
            orderBean.setOrderDetails(orderDetailDao.getOrderList(userOrder.getOrderId()));
            orderBeans.add(orderBean);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("total_pages",totalPage);
        result.put("current_page",page);
        result.put("orders",orderBeans);
        return ResponseEntity.SUCCESS(result,"获取列表成功");
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer orderId) {
        int deleteResult = orderDao.deleteById(orderId);
        orderDetailDao.deleteById(orderId);
        return deleteResult == 1 ? ResponseEntity.SUCCESS(null,"请求成功") : ResponseEntity.ERROR("删除失败");
    }
}

package com.business.manager.dao;

import com.business.manager.entity.OrderAddress;
import com.business.manager.entity.UserOrder;
import com.business.manager.entity.UserOrderDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDetailDao {
    @Insert({"insert into user_order_details(shop_id,order_id,category_id,spu_id,user_id,count,spu_name,sku_name,pic,delivery_type,shop_cart_time,price,spu_total_amount) " +
            "values(#{shopId}, #{orderId}, #{categoryId}, #{skuId}, #{userId}, #{count}, #{spuName}, #{skuName}, #{pic}, #{deliveryType}, #{shopCartTime}, #{price}, #{spuTotalAmount})" })
    @Options(useGeneratedKeys = true, keyProperty = "orderItemId",keyColumn = "order_item_id")
    int insert(UserOrderDetail userOrderDetail);

    @Select(
            "select order_item_id as orderItemId,shop_id as shopId,order_id as orderId,category_id as categoryId,spu_id as spuId,user_id as userId,count,spu_name as spuName,sku_name as skuName,pic," +
                    "delivery_type as deliveryType,shop_cart_time as shopCartTime,price,spu_total_amount as spuTotalAmount,create_time as createTime,update_time as updateTime" +
                    " from user_order_details where order_id = #{orderId}"
    )
    @ResultType(UserOrderDetail.class)
    List<UserOrderDetail> getOrderList(@Param("orderId") Integer orderId);


    @Delete(
            "delete from user_order_details where order_id = #{orderId}"
    )
    @ResultType(Integer.class)
    int deleteById(Integer orderId);
}

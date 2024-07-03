package com.business.manager.dao;

import com.business.manager.entity.UserOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    @Insert({"insert into user_orders(shop_id,user_id,delivery_type,shop_name,total,status,all_count,pay_time,delivery_time,finally_time,settled_time,cancel_time,is_payed,close_type,delete_status,version,order_addr_id) " +
            "values(#{shopId}, #{userId}, #{deliveryType}, #{shopName}, #{total}, #{status}, #{allCount}, #{payTime}, #{deliveryTime}, #{finallyTime}, #{settledTime}, #{cancelTime}, #{isPayed}, #{closeType}, #{deleteStatus}, #{version}, #{orderAddrId})" })
    @Options(useGeneratedKeys = true, keyProperty = "orderId",keyColumn = "order_id")
    int insert(UserOrder userOrder);

    @Select(
            "select order_id as orderId,shop_id as shopId,user_id as userId,delivery_type as deliveryType,shop_name as shopName,total,status,all_count as allCount,pay_time as payTime," +
                    "delivery_time as deliveryTime,finally_time as finallyTime,settled_time as settledTime,cancel_time as cancelTime,is_payed as isPayed,close_type as closeType," +
                    "delete_status as deleteStatus,version,order_addr_id as orderAddrId,create_time as createTime,update_time as updateTime" +
                    " from user_orders where user_id = #{userId} limit #{pageStartIndex},#{pageSize}"
    )
    @ResultType(UserOrder.class)
    List<UserOrder> getOrderList(@Param("userId") Integer userId, @Param("pageStartIndex") Integer pageStartIndex, @Param("pageSize") Integer pageSize);


    @Select(
            "select order_id as orderId,shop_id as shopId,user_id as userId,delivery_type as deliveryType,shop_name as shopName,total,status,all_count as allCount,pay_time as payTime," +
                    "delivery_time as deliveryTime,finally_time as finallyTime,settled_time as settledTime,cancel_time as cancelTime,is_payed as isPayed,close_type as closeType," +
                    "delete_status as deleteStatus,version,order_addr_id as orderAddrId,create_time as createTime,update_time as updateTime" +
                    " from user_orders where order_id = #{orderId}"
    )
    @ResultType(UserOrder.class)
    UserOrder selectById(@Param("orderId") Integer orderId);


    @Select(
            "select count(*) from user_orders where user_id = #{userId}"
    )
    @ResultType(Integer.class)
    int getOrderCount(Integer userId);

    @Delete(
            "delete from user_orders where order_id = #{orderId}"
    )
    @ResultType(Integer.class)
    int deleteById(Integer orderId);
}

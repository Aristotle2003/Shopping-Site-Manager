package com.business.manager.dao;

import com.business.manager.entity.OrderAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderAddressDao {

    @Insert(
            "insert into order_address(user_id,consignee,province_id,province,city_id,city,area_id,area,addr,post_code,mobile,lng,lat) values(#{userId} , #{consignee},#{provinceId},#{province}," +
                    "#{cityId},#{city},#{areaId},#{area},#{addr},#{postCode},#{mobile},#{lng},#{lat})"
    )
    @Options(useGeneratedKeys = true,keyProperty = "orderAddrId",keyColumn = "order_addr_id")
    int insert(OrderAddress record);

    @Select(
            "select order_addr_id as orderAddrId,user_id as userId,consignee,province_id as provinceId,province,city_id as cityId,city,area_id as areaId,area,addr,post_code as postCode," +
                    "mobile,lng,lat,create_time as createTime,update_time as updateTime from order_address where order_addr_id = #{orderAddrId}"
    )
    @ResultType(OrderAddress.class)
    OrderAddress selectById(Integer orderAddrId);

    @Update(
            "update order_address set user_id = #{userId} ,consignee = #{consignee},province_id = #{provinceId},province = #{province},city_id  = #{cityId},city = #{city}," +
                    "area_id  = #{areaId},area = #{area},addr = #{addr},post_code = #{postCode},mobile = #{mobile},lng = #{lng},lat = #{lat}" +
                    " where order_addr_id = #{orderAddrId}"
    )
    int update(OrderAddress record);

    @Delete("delete from order_address where order_addr_id = #{orderAddrId}")
    int deleteById(Integer orderAddrId);

    @Select(
            "select order_addr_id as orderAddrId,user_id as userId,consignee,province_id as provinceId,province,city_id as cityId,city,area_id as areaId,area,addr,post_code as postCode," +
                    "mobile,lng,lat,create_time as createTime,update_time as updateTime from order_address where user_id = #{userId} limit #{pageStartIndex},#{pageSize}"
    )
    @ResultType(OrderAddress.class)
    List<OrderAddress> getAddressList(@Param("userId") Integer userId,@Param("pageStartIndex") Integer pageStartIndex,@Param("pageSize") Integer pageSize);

    @Select(
            "select count(*) from order_address where user_id = #{userId}"
    )
    @ResultType(Integer.class)
    int getAddressListCount(Integer userId);
}

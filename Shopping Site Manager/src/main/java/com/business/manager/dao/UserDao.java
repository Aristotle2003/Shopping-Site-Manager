package com.business.manager.dao;

import com.business.manager.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    @Select("select uid,create_time as creatTime,update_time as updateTime,username,password," +
            "create_ip as createIp,status,sys_type as sysType,tenant_id as tenantId from users where uid= #{userId}")
    @ResultType(User.class)
    User getUserById(Integer userId);
    @Select("select uid,create_time as creatTime,update_time as updateTime,username,password," +
            "create_ip as createIp,status,sys_type as sysType,tenant_id as tenantId from users where username= #{username} limit 1")
    @ResultType(User.class)
    User getUserByUsername(String username);


    @Select("select count(*) from users where username= #{username} and uid != #{uid}")
    @ResultType(Integer.class)
    int usernameCount(Integer uid,String username);

    @Update(
            "update users set username = #{username},password = #{password} where uid= #{uid}"
    )
    int update(String username,String password,Integer uid);

    @Insert({"insert into users(username, password,create_ip,status,sys_type,tenant_id) values(#{username}, #{password}, #{createIp}, #{status}, #{sysType}, #{tenantId})" })
    @Options(useGeneratedKeys = true, keyProperty = "uid",keyColumn = "uid")
    int insertUser(User user);
}

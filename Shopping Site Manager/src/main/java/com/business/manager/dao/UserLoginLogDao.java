package com.business.manager.dao;

import com.business.manager.entity.User;
import com.business.manager.entity.UserLoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserLoginLogDao {
    @Insert({"insert into user_login_log(uid,ip_address,device) values(#{uid}, #{ipAddress}, #{device})" })
    @Options(useGeneratedKeys = true, keyProperty = "logId",keyColumn = "log_id")
    int insert(UserLoginLog user);
}

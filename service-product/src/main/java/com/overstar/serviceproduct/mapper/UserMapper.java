package com.overstar.serviceproduct.mapper;

import com.overstar.serviceproduct.dto.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
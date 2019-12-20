package com.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boot.model.Manager;

@Mapper
public interface ManagerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String id);
    
    Manager selectByUsernamePassword(@Param("username")String username,@Param("password")String password);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}
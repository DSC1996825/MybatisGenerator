package com.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.model.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);
    
    List<User> getUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
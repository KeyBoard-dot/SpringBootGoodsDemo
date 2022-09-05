package com.example.springbootgoodsdemo.mapper;

import java.util.List;

import com.example.springbootgoodsdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    User selectByPrimaryKey(Integer uid);

    @Select("select * from user where account = #{uname}")
    User selectUserByName(String uname);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
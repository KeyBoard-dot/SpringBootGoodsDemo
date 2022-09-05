package com.example.springbootgoodsdemo.mapper;

import com.example.springbootgoodsdemo.entity.UAccount;

import java.util.List;


public interface UAccountMapper {
    int deleteByPrimaryKey(Integer accid);

    int insert(UAccount record);

    UAccount selectByPrimaryKey(Integer accid);

    List<UAccount> selectAll();

    int updateByPrimaryKey(UAccount record);
}
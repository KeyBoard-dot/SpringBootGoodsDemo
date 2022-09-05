package com.example.springbootgoodsdemo.mapper;

import com.example.springbootgoodsdemo.entity.TIntegral;

import java.util.List;


public interface TIntegralMapper {
    int deleteByPrimaryKey(Integer itid);

    int insert(TIntegral record);

    TIntegral selectByPrimaryKey(Integer itid);

    List<TIntegral> selectAll();

    int updateByPrimaryKey(TIntegral record);
}
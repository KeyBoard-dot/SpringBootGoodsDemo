package com.example.springbootgoodsdemo.mapper;

import com.example.springbootgoodsdemo.entity.Goods;
import com.example.springbootgoodsdemo.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);

    List<Goods> findGoodsByParam(SearchVo searchVo);
}
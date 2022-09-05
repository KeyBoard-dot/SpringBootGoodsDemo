package com.example.springbootgoodsdemo.service;


import com.example.springbootgoodsdemo.entity.Goods;
import com.example.springbootgoodsdemo.vo.PageVo;
import com.example.springbootgoodsdemo.vo.SearchVo;


public interface GoodsService {

    PageVo<Goods> findGoodsByParam(SearchVo searchVo, Integer pageNum, Integer limit);

    boolean addGoods(Goods goods);

    boolean deleteGoods(Integer[] gids);

    boolean updateGoodsByPrimaryKey(Goods goods);
}

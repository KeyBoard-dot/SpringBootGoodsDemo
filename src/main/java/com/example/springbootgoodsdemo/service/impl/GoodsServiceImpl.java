package com.example.springbootgoodsdemo.service.impl;

import com.example.springbootgoodsdemo.entity.Goods;
import com.example.springbootgoodsdemo.mapper.GoodsMapper;
import com.example.springbootgoodsdemo.service.GoodsService;
import com.example.springbootgoodsdemo.vo.PageVo;
import com.example.springbootgoodsdemo.vo.SearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageVo<Goods> findGoodsByParam(SearchVo searchVo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Goods> goods = goodsMapper.findGoodsByParam(searchVo);
        System.out.println("goods = " + goods.size());
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        PageVo<Goods> pageVo = new PageVo<Goods>()
                .setPageTotal(pageInfo.getPages())
                .setGoodsList(goods)
                .setCount(pageInfo.getTotal())
                .setCurrentPage(pageNum)
                .setSearchVo(searchVo)
                .setIsFirstPage(pageInfo.isIsFirstPage())
                .setIsLastPage(pageInfo.isIsLastPage());

        return pageVo;
    }

    @Override
    public boolean addGoods(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }

    @Override
    public boolean deleteGoods(Integer[] gids) {
        for (Integer gid : gids) {
            if(goodsMapper.deleteByPrimaryKey(gid) <= 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateGoodsByPrimaryKey(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods) > 0;
    }
}

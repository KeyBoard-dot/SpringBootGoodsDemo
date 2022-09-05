package com.example.springbootgoodsdemo.controller;

import com.example.springbootgoodsdemo.entity.Goods;
import com.example.springbootgoodsdemo.service.GoodsService;
import com.example.springbootgoodsdemo.vo.PageVo;
import com.example.springbootgoodsdemo.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/dataList.html")
    public String getAll(SearchVo searchVo,
                    @RequestParam(defaultValue = "1") Integer pageNum,
                    @RequestParam(defaultValue = "5") Integer limit,
                    Model model){
        System.out.println("searchVo = " + searchVo);
        PageVo<Goods> goodsBySearchVo = goodsService.findGoodsByParam(searchVo, pageNum, limit);
        model.addAttribute("pageVo", goodsBySearchVo);
        return "dataList";
    }

    @PostMapping("/goods")
    public String addGoods(@RequestBody Goods goods){
        if(goodsService.addGoods(goods)) return "redirect: dataList";
        return null;
    }

    @DeleteMapping
    public String deleteGoods(@RequestParam Integer[] gids){
        if(goodsService.deleteGoods(gids)) return "redirect: dataList";
        return null;
    }

    @PutMapping
    public String updateGoods(@RequestParam Goods goods){
        if(goodsService.updateGoodsByPrimaryKey(goods)) return "redirect: dataList";
        return null;
    }
}

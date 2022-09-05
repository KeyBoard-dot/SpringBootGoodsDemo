package com.example.springbootgoodsdemo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageVo<T> {
    private List<T> goodsList;
    private Integer pageTotal;
    private Long count;
    private SearchVo searchVo;
    private Integer currentPage;
    private Boolean isFirstPage;
    private Boolean isLastPage;
}

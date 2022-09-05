package com.example.springbootgoodsdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Goods {
    private Integer gid;
    private String gname;
    private String gimg;
    private BigDecimal gprice;
    private Integer gstock;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime maintaindate;
    private String classify;
    private String gdescribe;

}
package com.example.springbootgoodsdemo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UAccount {

    private Integer accid;

    private Double money;

    private Integer uid;

    private LocalDateTime createdate;

    private LocalDateTime updatedate;

}
package com.example.springbootgoodsdemo.vo;

import lombok.Data;

@Data
public class UserVo {
    private String account;
    private String password;
    private String checkCode;
    private boolean saveMe;
}

package com.example.springbootgoodsdemo.controller;

import com.example.springbootgoodsdemo.entity.User;
import com.example.springbootgoodsdemo.service.UserService;
import com.example.springbootgoodsdemo.vo.UserVo;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"/", "/login.html"})
    public String login() {
        return "login";
    }

    @GetMapping({"/index", "index.html"})
    public String index() {
        return "index";
    }

    @PostMapping("/user")
    public String login(UserVo userVo, HttpServletRequest request, Model model, HttpSession session){
        String errInfo = "";
        CaptchaUtil captcha = new CaptchaUtil();
        if (captcha == null || !captcha.ver(userVo.getCheckCode(), request)) {
            errInfo = "验证码错误";
        }

        User user = userService.selectUserByName(userVo.getAccount());

        if(user == null || !user.getPassword().equals(userVo.getPassword())){
            errInfo = "账号或密码错误";
        }

        if(userVo.isSaveMe()){
            Cookie cookie = new Cookie("JSESSIONID", session.toString());
            cookie.setMaxAge(5*24*60*60);
        }
        model.addAttribute("errInfo", errInfo);
        session.setAttribute("user", user);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }


    @RequestMapping("/images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        CaptchaUtil captcha = new CaptchaUtil();
        try {
            captcha.out(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

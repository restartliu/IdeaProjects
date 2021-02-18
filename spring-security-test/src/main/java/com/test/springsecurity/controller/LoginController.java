package com.test.springsecurity.controller;

import org.apache.catalina.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class LoginController {

    @RequestMapping("/toMain")
    public String toMain(HttpServletRequest request){
        return "redirect:/demo/main.html";
    }

    @RequestMapping("/toError")
    public String toError(){
        return "redirect:/demo/error.html";
    }

    @RequestMapping("/access")
    @ResponseBody
    public String accessControlTest(){
        return "access control test";
    }

    @RequestMapping("/fuck")
    @ResponseBody
    public String fuck(){
        return "life is a fucking movie";
    }
}

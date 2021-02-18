package com.test.springsecurity.controller;

import org.apache.catalina.Session;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class LoginController {

    // request having the roles(support roles only, this stage) of parameter of secured annotation can access this API
    @Secured("ROLE_abc")
    @RequestMapping("/toMain")
    public String toMain(HttpServletRequest request){
        return "redirect:/demo/main.html";
    }

    @RequestMapping("/toError")
    public String toError(){
        return "redirect:/demo/error.html";
    }

    // this annotation requires an authority expression as parameter as same as access method of SecurityConfig class
    // allowed roles start with ROLE_, this is not allowed in methods of authorities of SecurityConfig class
    @PreAuthorize("hasAnyAuthority('fail, ROLE_abc')")
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

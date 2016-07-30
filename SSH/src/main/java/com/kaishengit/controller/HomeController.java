package com.kaishengit.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    /**
     * login页面
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "login";
    }


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String index(String account , String password,
                       RedirectAttributes redirectAttributes, HttpServletRequest request){

      Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account,password);
        subject.login(usernamePasswordToken);

        return "redirect:/home";

    }

    @RequestMapping(value = "/home")
    public String home(){

        return "home";
    }
}


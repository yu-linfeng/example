package com.coderbuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cdyulinfeng
 * @date 2019/8/30
 **/
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}

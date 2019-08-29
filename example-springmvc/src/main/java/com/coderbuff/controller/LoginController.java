package com.coderbuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by OKevin On 2019/8/28
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}

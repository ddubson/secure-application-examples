package com.ddubson.poc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}

package com.wildcodeschool.sharemybrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        Boolean logged;
        logged = false;
        model.addAttribute("logged", logged);
        return "index";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

}

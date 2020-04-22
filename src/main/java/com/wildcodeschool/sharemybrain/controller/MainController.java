package com.wildcodeschool.sharemybrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        Boolean logged;
        logged = true;
        model.addAttribute("logged", logged);
        return "index";
    }
}

package com.wildcodeschool.sharemybrain.controller;

import com.wildcodeschool.sharemybrain.entity.Avatar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        Boolean logged;
        logged = false;
        model.addAttribute("logged", logged);
        return "index";
    }




}

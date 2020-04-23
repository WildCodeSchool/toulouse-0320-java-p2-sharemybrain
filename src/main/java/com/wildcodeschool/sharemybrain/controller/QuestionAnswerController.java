package com.wildcodeschool.sharemybrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionAnswerController {

    @GetMapping("/question")
    public String ask() {

        return "/question";
    }


    @GetMapping("/answer")
    public String answer() {

        return "/answer";
    }
}

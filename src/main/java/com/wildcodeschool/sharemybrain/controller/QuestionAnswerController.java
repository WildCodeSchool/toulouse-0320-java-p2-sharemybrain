package com.wildcodeschool.sharemybrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionAnswerController {

    @GetMapping("/profile")
    public String showQuestions(Model model) {
        String activityType;
        if (activityType.equals("questions")) {
            model.addAttribute("questions, ")
        }

    }


}

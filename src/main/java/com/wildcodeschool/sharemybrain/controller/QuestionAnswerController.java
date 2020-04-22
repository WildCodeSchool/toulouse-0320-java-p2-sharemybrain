package com.wildcodeschool.sharemybrain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionAnswerController {

    @GetMapping("/profile")
    public String profileDisplay(Model model) {
        String activityType;
        activityType = "questions"; // or "answers" to display answers
        model.addAttribute("questions", activityType);
        if (activityType.equals("answers")) {
            return "/answers"; // TODO create answers fragment
        }
        return "/questions"; // TODO create questions fragment

    }
}

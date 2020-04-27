package com.wildcodeschool.sharemybrain.controller;

import com.wildcodeschool.sharemybrain.entity.Question;
import com.wildcodeschool.sharemybrain.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionAnswerController {
    private QuestionRepository questionRepository = new QuestionRepository();

    @GetMapping("/questions")
    public String share(Model model, @RequestParam(required = false, defaultValue = "1") int page) {
        int question_offset, limit;
        limit = 3;
        question_offset = (page * limit) - limit;
        int qtyQuestions = questionRepository.totalLines();
        int numPages = (int) Math.ceil((double) qtyQuestions / limit);
        if (question_offset + limit > qtyQuestions) {
            limit = qtyQuestions - question_offset;
        }
        model.addAttribute("questions", questionRepository.findWithLimit(limit, question_offset));
        model.addAttribute("page", page);
        model.addAttribute("numPages", numPages);
        return "/questions";
    }

    @GetMapping("/ask")
    public String ask() {

        return "/askquestion";
    }

    @GetMapping("/answer")
    public String answer() {

        return "/answerquestion";
    }
}

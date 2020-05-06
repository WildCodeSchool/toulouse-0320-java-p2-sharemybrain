package com.wildcodeschool.sharemybrain.controller;

import com.wildcodeschool.sharemybrain.repository.QuestionRepository;
import com.wildcodeschool.sharemybrain.repository.SkillRepository;
import com.wildcodeschool.sharemybrain.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionAnswerController {

    private final QuestionRepository questionRepository = new QuestionRepository();
    private final SkillRepository skillRepository = new SkillRepository();
    private final UserRepository userRepository = new UserRepository();


    @GetMapping("/questions")
    public String share(Model model, @RequestParam(required = false, defaultValue = "1") int page,
                        @CookieValue(value = "username", defaultValue = "Atta") String username) {
        int question_offset, limit;
        limit = 3;
        question_offset = (page * limit) - limit;
        int idSkill = userRepository.findSkill(username);
        int qtyQuestions = questionRepository.totalLines(idSkill);
        int numPages = (int) Math.ceil((double) qtyQuestions / limit);
        if (question_offset + limit > qtyQuestions) {
            limit = qtyQuestions - question_offset;
        }

        model.addAttribute("page", page);
        model.addAttribute("numPages", numPages);
        if (idSkill == -1) {

            model.addAttribute("questions", questionRepository.findWithLimit(limit, question_offset));
        } else {
            model.addAttribute("questions", questionRepository.findWithSkill(limit, question_offset, idSkill));

        }

        return "/questions";
    }


    @GetMapping("/ask")
    public String ask(Model model) {
        model.addAttribute("skills", skillRepository.findAllSkills());
        return "/askquestion";
    }

    @GetMapping("/answer/{question}")
    public String answer(Model model, @PathVariable int question) {

        model.addAttribute("question",questionRepository.findQuestion(question));
        return "answerquestion";
    }
}

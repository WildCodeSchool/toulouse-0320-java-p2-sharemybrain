package com.wildcodeschool.sharemybrain.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.sharemybrain.entity.Avatar;
import com.wildcodeschool.sharemybrain.entity.Question;
import com.wildcodeschool.sharemybrain.entity.Skill;
import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AvatarRepository avatarRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(Model model, @RequestParam(defaultValue = "", required = false) String username,
                             @RequestParam(defaultValue = "", required = false) String password,
                             HttpServletResponse response) {
        if (username.equals("") || password.equals("")) {
            return "redirect:/login";
        }
        String hash = crypt(password);
        if (userRepository.findAnyUsername(username)) {
            if (userRepository.findUsernamePsw(hash, username)) {
                // initialisation des cookies
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(1 * 24 * 60 * 60); // expires in 7 days
                /* cookie.setSecure(true); */
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
                return "redirect:/profile";
            }
            model.addAttribute("nopsw", true);
            return "login";
        }
        model.addAttribute("noUser", true);
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("avatars", avatarRepository.findAllAvatars());
        model.addAttribute("skills", skillRepository.findAllSkills());
        return "register";
    }

    @PostMapping("/register")
    public String registration(Model model, @ModelAttribute User user) {
        model.addAttribute("avatars", avatarRepository.findAllAvatars());
        model.addAttribute("skills", skillRepository.findAllSkills());
        if (userRepository.findAnyUsername(user.getUserName())) {
            model.addAttribute("userExists", true);
            return "register";
        } else if (userRepository.findAnyEmail(user.getMail())) {
            model.addAttribute("emailExists", true);
            return "register";
        } else if (!user.getPwd().equals(user.getPwd2())) {
            model.addAttribute("noPswConfirmed", true);
            return "register";
        } else if (user.getIdSkill() == 0) {
            model.addAttribute("noSkill", true);
            return "register";
        }

        user.setPwd(crypt(user.getPwd()));
        userRepository.insertNewUser(user);
        return "redirect:/login";

    }

    @GetMapping("/profile")
    public String showProfile(Model model,
                              @CookieValue(value = "username", defaultValue = "Atta") String username,
                              @RequestParam(defaultValue = "Questions", required = false) String currentTab) {

        if (username.equals("Atta")) {
            return "error";
        }
        // Skill and username for header
        model.addAttribute("username", username);
        int idAvatar = userRepository.findAvatar(username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());

        int idSkill = userRepository.findSkill(username);
        model.addAttribute("skill", skillRepository.findSkillById(idSkill).getName());

        // Questions asked by user
        int idUser = userRepository.findUserId(username);
        List<Question> questions = questionRepository.findWithUserId(idUser);
        Map<Question, Skill> mapQuestion = new LinkedHashMap<>();
        for (Question question : questions) {
            question.setAnswers(answerRepository.findAnswerWithId(question.getIdQuestion()));
            mapQuestion.put(question, skillRepository.findSkillById(question.getIdSkill()));
        }
        model.addAttribute("mapQuestion", mapQuestion);

        // Questions answered by user
        List<Question> questionsAnswered = questionRepository.findQuestionsAnsweredByUserId(idUser);
        Map<Question, Avatar> avatarQuestMap = new LinkedHashMap<>();
        int avatarId;
        for (Question question : questionsAnswered) {
            avatarId = userRepository.findAvatarById(question.getIdUser());
            avatarQuestMap.put(question, avatarRepository.findAvatar(avatarId));
            question.setCountAnswers(answerRepository.countAnswersByQuestion(question.getIdQuestion()));
        }
        model.addAttribute("avatarQuestMap", avatarQuestMap);
        model.addAttribute("tab", currentTab);

        return "profile";
    }

    @GetMapping("/changepassword")
    public String changePassword(Model model,
                                 @CookieValue(value = "username", defaultValue = "Atta") String username) {
        // Skill and username for header
        model.addAttribute("username", username);
        int idAvatar = userRepository.findAvatar(username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());


        if (username.equals("Atta")) {
            return "error";
        }
        return "changePsw";
    }
    @PostMapping("/changepassword")
    public String postchangePassword(Model model,
                                     @CookieValue(value = "username", defaultValue = "Atta") String username,
                                     @RequestParam String oldpsw,
                                     @RequestParam String newpsw,
                                     @RequestParam String newpswConf,
                                     HttpServletResponse response) {
        String hash = crypt(oldpsw);
        if (!userRepository.findUsernamePsw(hash, username)) {
            model.addAttribute("nopsw", true);
            return "changePsw";
        }
        if (!newpsw.equals(newpswConf)) {
            model.addAttribute("noPswConfirmed", true);
            return "changePsw";
        }
        int update = userRepository.updatePsw(username, crypt(newpsw));
        if (update != 0) {
            return "error";
        }
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        //add cookie to response
        response.addCookie(cookie);
        return "redirect:/login";
    }

    public String crypt(String psw) {
        String sha256hex = Hashing.sha256()
                .hashString(psw, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

}


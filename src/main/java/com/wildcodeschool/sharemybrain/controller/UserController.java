package com.wildcodeschool.sharemybrain.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.sharemybrain.entity.Avatar;
import com.wildcodeschool.sharemybrain.entity.Question;
import com.wildcodeschool.sharemybrain.entity.Skill;
import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.repository.*;
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
    private UserRepository repository = new UserRepository();
    private AvatarRepository avatarRepository = new AvatarRepository();
    private SkillRepository skillRepository = new SkillRepository();
    private QuestionRepository questionRepository = new QuestionRepository();
    private AnswerRepository answerRepository = new AnswerRepository();

    @GetMapping("/login")
    public String showLoginPage() {
        return "/login";
    }

    @PostMapping("/login")
    public String checkLogin(Model model, @RequestParam(defaultValue = "", required = false) String username,
                             @RequestParam(defaultValue = "", required = false) String password,
                             HttpServletResponse response) {
        if (username == "" || password == "") {
            return "redirect:/login";
        }
        String hash = crypt(password);
        if (repository.findAnyUsername(username)) {
            if (repository.findUsernamePsw(hash, username)) {
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
            return "/login";
        }
        model.addAttribute("noUser", true);
        return "/login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("avatars", avatarRepository.findAllAvatars());
        model.addAttribute("skills", skillRepository.findAllSkills());
        return "/register";
    }

    @PostMapping("/register")
    public String registration(Model model, @ModelAttribute User user) {

        if (repository.findAnyUsername(user.getUserName())) {
            model.addAttribute("userExists", true);
            return "/register";
        } else if (repository.findAnyEmail(user.getMail())) {
            model.addAttribute("emailExists", true);
            return "/register";
        } else if (!user.getPwd().equals(user.getPwd2())) {
            model.addAttribute("noPswConfirmed", true);
            return "/register";
        } else if (user.getIdSkill() == 0) {
            model.addAttribute("noSkill", true);
            return "/register";
        }
        int aa = user.getIdAvatar();
        user.setPwd(crypt(user.getPwd()));
        repository.insertNewUser(user);
        return "redirect:/login";

    }

    @GetMapping("/questionProfile")
    public String questionProfile(Model model, @CookieValue(value = "username", defaultValue = "Atta") String username) {
        int idUser = repository.findUserId(username);
        List<Question> questions = questionRepository.findWithUserId(idUser);
        Map<Question, Skill> mapQuestion = new LinkedHashMap<>();
        for (Question question : questions) {
            question.setAnswers(answerRepository.findAnswerWithId(question.getIdQuestion()));
            mapQuestion.put(question, skillRepository.findSkillById(question.getIdSkill()));
        }
        model.addAttribute("mapQuestion", mapQuestion);
        int idAvatar = repository.findAvatar(username);
        model.addAttribute("username", username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());

        return "questionProfile";
    }

    @GetMapping("/AnswerProfile")
    public String AnswerProfile(Model model,
                                @CookieValue(value = "username", defaultValue = "Atta") String username) {
        int userId = repository.findUserId(username);
        List<Question> questions = questionRepository.findQuestionsAnsweredByUserId(userId);
        Map<Question, Avatar> avatarQuestMap = new LinkedHashMap<>();
        int avatarId;
        for (Question question : questions) {
            avatarId = repository.findAvatarById(question.getIdUser());
            avatarQuestMap.put(question, avatarRepository.findAvatar(avatarId));
            question.setCountAnswers(answerRepository.countAnswersByQuestion(question.getIdQuestion()));
        }
        model.addAttribute("avatarQuestMap", avatarQuestMap);
        int idAvatar = repository.findAvatar(username);
        model.addAttribute("username", username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());

        return "answerProfile";
    }

    @GetMapping("/profile")
    public String showProfile(Model model,
                              @CookieValue(value = "username", defaultValue = "Atta") String username) {
        int userId = repository.findUserId(username);
        model.addAttribute("username", username);
        int idAvatar = repository.findAvatar(username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());
        int idSkill = repository.findSkill(username);
        model.addAttribute("skill", skillRepository.findSkillById(idSkill).getName());

        return "profile";
    }

    public String crypt(String psw) {
        String sha256hex = Hashing.sha256()
                .hashString(psw, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

}


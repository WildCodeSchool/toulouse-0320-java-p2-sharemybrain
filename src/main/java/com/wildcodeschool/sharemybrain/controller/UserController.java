package com.wildcodeschool.sharemybrain.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.sharemybrain.repository.QuestionRepository;
import com.wildcodeschool.sharemybrain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;


@Controller
public class UserController {
    private UserRepository repository = new UserRepository();
    @GetMapping("/register")
    public String showRegisterPage() {

        return "/register";
    }

    @GetMapping("/login")
    public String showLoginPage() {

        return "/login";
    }

    @PostMapping("/register")
    public String registration(Model model,
                               @RequestParam String userName,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String pswConfirmation,
                               @RequestParam(required = false, defaultValue = "1") int avatar,
                               @RequestParam(required = false, defaultValue = "") int skill) {

        if (repository.findAnyUsername(userName)) {
            model.addAttribute("userExists", true);
            return "/register";
        } else if (repository.findAnyEmail(email)) {
            model.addAttribute("emailExists", true);
            return  "/register";
        } else if (!password.equals(pswConfirmation)) {
            model.addAttribute("noPswConfirmed", true);
            return "/register";
        } else if (skill == 0) {
            // TODO IF NO AVATAR CHOSEN -> WORKS AND ANYTHING HAPPENS
            model.addAttribute("noSkill", true);
            return "/register";
        }

        repository.insertNewUser(userName, email, crypt(password), avatar, skill);
        return "redirect:/login";

    }

    public String crypt(String psw) {
        String sha256hex = Hashing.sha256()
                .hashString(psw, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

}


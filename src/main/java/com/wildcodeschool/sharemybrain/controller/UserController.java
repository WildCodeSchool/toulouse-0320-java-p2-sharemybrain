package com.wildcodeschool.sharemybrain.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;


@Controller
public class UserController {
    private UserRepository repository = new UserRepository();

    @GetMapping("/login")
    public String showLoginPage() {

        return "/login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
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
            // TODO IF NO AVATAR CHOSEN -> WORKS AND ANYTHING HAPPENS
            model.addAttribute("noSkill", true);
            return "/register";
        }
        user.setPwd(crypt(user.getPwd()));
        repository.insertNewUser(user);
        return "redirect:/login";

    }

    public String crypt(String psw) {
        String sha256hex = Hashing.sha256()
                .hashString(psw, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

}


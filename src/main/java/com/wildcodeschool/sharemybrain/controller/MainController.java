package com.wildcodeschool.sharemybrain.controller;

import com.wildcodeschool.sharemybrain.repository.AvatarRepository;
import com.wildcodeschool.sharemybrain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    UserRepository userRepository = new UserRepository();
    AvatarRepository avatarRepository = new AvatarRepository();

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {

        return "Hello World";
    }

    @GetMapping("/")
    public String index(Model model, @CookieValue(value = "username", defaultValue = "Atta") String username) {
        Boolean logged;
        if (username.equals("Atta")) {
            logged = false;
            model.addAttribute("username", "");
            model.addAttribute("avatar", "");
        } else {
            logged = true;
            int idAvatar = userRepository.findAvatar(username);
            model.addAttribute("username", username);
            model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());
        }
        model.addAttribute("logged", logged);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        //add cookie to response
        response.addCookie(cookie);
        return "redirect:/";
    }
}

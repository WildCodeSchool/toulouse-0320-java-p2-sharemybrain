package com.wildcodeschool.sharemybrain.controller;

import com.google.common.hash.Hashing;
import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.repository.AvatarRepository;
import com.wildcodeschool.sharemybrain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;


@Controller
public class UserController {
    private UserRepository repository = new UserRepository();
    private AvatarRepository avatarRepository = new AvatarRepository();

    @GetMapping("/login")
    public String showLoginPage() {
        return "/login";
    }

    @PostMapping("/login")
    public String checkLogin(Model model, @RequestParam(defaultValue = "", required = false) String username,
                             @RequestParam(defaultValue = "", required = false) String password, HttpServletResponse response) {
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
                return "redirect:/questions";
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
            // TODO IF NO SKILL CHOSEN -> WORKS AND ANYTHING HAPPENS
            model.addAttribute("noSkill", true);
            return "/register";
        }
        int aa = user.getIdAvatar();
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


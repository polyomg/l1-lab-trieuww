package com.example.lab5.controller;

import com.example.lab5.service.CookieService;
import com.example.lab5.service.ParamService;
import com.example.lab5.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    private final CookieService cookieService;
    private final ParamService paramService;
    private final SessionService sessionService;

    public AccountController(CookieService cookieService, ParamService paramService, SessionService sessionService) {
        this.cookieService = cookieService;
        this.paramService = paramService;
        this.sessionService = sessionService;
    }

    @GetMapping("/account/login")
    public String login1() {
        return "account/login";
    }

    @PostMapping("/account/login")
    public String login2() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if ("poly".equals(username) && "123".equals(password)) {
            sessionService.set("username", username);
            if (remember) {
                cookieService.add("user", username, 24 * 10);
            } else {
                cookieService.remove("user");
            }
            return "redirect:/item/index";
        }
        return "account/login";
    }
}

package com.example.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ctrl")
public class OkController {

    // Render the page
    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    // OK 1: POST /ctrl/ok
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("called", "m1");
        return "ok";
    }

    // OK 2: GET /ctrl/ok with a marker parameter
    @GetMapping(path = "/ok", params = "from=get")
    public String m2WithParam(Model model) {
        model.addAttribute("called", "m2");
        return "ok";
    }

    // OK 3: POST /ctrl/ok?x
    @PostMapping(path = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("called", "m3");
        return "ok";
    }
}

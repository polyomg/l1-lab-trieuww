package com.example.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "a";
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        // ?1: forward để giữ Model, hiển thị tại /a
        return "forward:/a";
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        // ?2: redirect để chuyển hướng kèm tham số
        return "redirect:/a";
    }

    // ?3: trả về nội dung trực tiếp
    @RequestMapping("/d")
    @ResponseBody
    public String m4() {
        return "I come from d";
    }
}

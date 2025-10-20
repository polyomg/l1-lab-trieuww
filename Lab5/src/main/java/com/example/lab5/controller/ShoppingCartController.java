package com.example.lab5.controller;

import com.example.lab5.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShoppingCartController {
    private final ShoppingCartService cart;

    public ShoppingCartController(ShoppingCartService cart) {
        this.cart = cart;
    }

    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @RequestMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    @PostMapping("/cart/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
        cart.update(id, qty);
        return "redirect:/cart/view";
    }

    @RequestMapping("/cart/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
}

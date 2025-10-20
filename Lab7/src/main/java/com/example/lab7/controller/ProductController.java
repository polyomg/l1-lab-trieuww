package com.example.lab7.controller;

import com.example.lab7.entity.Product;
import com.example.lab7.repository.ProductDAO;
import com.example.lab7.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private SessionService session;

    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("items", dao.findAll()); // load tất cả mặc định
        return "product/search";
    }

    @RequestMapping("/search/by-price")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }

    @GetMapping("/search-and-page/search")
    public String searchAndPageByKeyword(Model model,
                                         @RequestParam("keywords") Optional<String> kw,
                                         @RequestParam("p") Optional<Integer> p) {
        String keywords = kw.orElse("");
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findByKeywords("%" + keywords + "%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("keywords", keywords);
        return "product/search-and-page";
    }

    @RequestMapping("/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse("");
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        Page<Product> page;
        if (kwords.isEmpty()) {
            page = dao.findAll(pageable);
        } else {
            page = dao.findAllByNameLike("%" + kwords + "%", pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page";
    }
}

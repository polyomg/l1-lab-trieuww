package com.example.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/form")
    public String form(Model model) {
        // Khởi tạo sản phẩm mẫu và chia sẻ với view qua Model
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p", p);
        return "product/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("p") Product p, Model model) {
        // Dữ liệu name, price được binding vào model attribute "p"
        model.addAttribute("p", p);
        return "product/form";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0),
                new Product("C", 23.5)
        );
    }
}

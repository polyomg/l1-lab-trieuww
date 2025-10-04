package poly.edu.lab3.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.lab3.model.Staff;

import java.util.List;

@Controller
public class StatusController {
    @RequestMapping("/staff/status")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder().email("user1@gmail.com").fullname("nguyễn văn user1").level(0).photo("photo.jpg").salary(12345.68).build(),
                Staff.builder().email("user2@gmail.com").fullname("nguyễn văn user2").level(1).photo("photo.jpg").salary(12345.68).build(),
                Staff.builder().email("user3@gmail.com").fullname("nguyễn văn user3").level(2).photo("photo.jpg").salary(12345.68).build(),
                Staff.builder().email("user4@gmail.com").fullname("nguyễn văn user4").level(1).photo("photo.jpg").salary(12345.68).build(),
                Staff.builder().email("user5@gmail.com").fullname("nguyễn văn user5").level(0).photo("photo.jpg").salary(12345.68).build(),
                Staff.builder().email("user6@gmail.com").fullname("nguyễn văn user6").level(2).photo("photo.jpg").salary(12345.68).build()
        );
        model.addAttribute("list", list);
        return "staff-status"; // trỏ ra file staff-status.html
    }
}

package poly.edu.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import poly.edu.lab3.model.Staff;

import java.util.List;

@Controller
public class StaffBoxController {
    @RequestMapping("/staff/listBox")
    public String listBox(Model model) {
        List<Staff> list = List.of(
                Staff.builder().email("user1@gmail.com").fullname("nguyễn văn user1").build(),
                Staff.builder().email("user2@gmail.com").fullname("nguyễn văn user2").build(),
                Staff.builder().email("user3@gmail.com").fullname("nguyễn văn user3").build(),
                Staff.builder().email("user4@gmail.com").fullname("nguyễn văn user4").build(),
                Staff.builder().email("user5@gmail.com").fullname("nguyễn văn user5").build(),
                Staff.builder().email("user6@gmail.com").fullname("nguyễn văn user6").build()
        );
        model.addAttribute("list", list);
        return "list-controls";
    }
}

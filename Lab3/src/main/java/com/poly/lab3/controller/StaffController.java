package poly.edu.lab3.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.lab3.model.Staff;

import java.util.Date;

@Controller
public class StaffController {
    @RequestMapping("/staff/detail")
    public String staffDetail(Model model) {
        Staff staff = Staff.builder()
                .email("user@gmail.com")
                .fullname("Nguyễn Văn User")
                .birthday(new Date())
                .salary(512345.68)
                .gender(true)  // true = Nam
                .level(1)      // 0=Trưởng, 1=Phó, 2=Nhân viên
                .build();
        model.addAttribute("staff", staff);
        return "staff-detail";

    }
}

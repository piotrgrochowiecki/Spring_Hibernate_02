package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

@Slf4j
@Controller
public class StudentController {

    @GetMapping("student")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("student")
    @ResponseBody
    public String handleStudentForm(@ModelAttribute("student") Student student) {
        log.info("New student {}", student);
        return "ok";
    }

}

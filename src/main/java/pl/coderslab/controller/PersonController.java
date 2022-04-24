package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Person;

@Slf4j
@Controller
public class PersonController {

    @GetMapping("person")
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("person")
    @ResponseBody
    public String handlePersonForm(@ModelAttribute("person") Person person) {
        log.info("New person {}", person);
        return "ok";
    }

}
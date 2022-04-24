package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Person;

@Slf4j
@Controller
public class PersonController {

    @GetMapping("person")
    public String personForm() {
        return "personForm";
    }

    @PostMapping("person")
    @ResponseBody
    public String handlePersonForm(@RequestParam("login") String login,
                                   @RequestParam("password") String password,
                                   @RequestParam("email") String email) { //tutaj dobra praktyka programistyczna, aby od
        // razu nazwać javowy parametr

        Person person = new Person();
        person.setEmail(email);
        person.setLogin(login);
        person.setPassword(password);
        log.info("New person {}", person); //dodane dependency do mavena i adnotacja @Slf4j
        //zapisujemy do DB - > dodanie do personDao i użycie metody save
        return "ok";

    }

}
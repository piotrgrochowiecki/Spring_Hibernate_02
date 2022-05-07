package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

import javax.validation.Valid;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/author/add")
    @ResponseBody
    public String saveAuthor(@Valid Author author, BindingResult result) {
        author = new Author();
        author.setFirstName("Some first name");
        author.setLastName("Some last name");
        if (result.hasErrors()) {
            return "/author/add";
        }
        authorDao.save(author);
        return "id of added author: " + author.getId();
    }

    @GetMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id, @Valid Author author, BindingResult result) {
        author = authorDao.findById(id);
        if (result.hasErrors()) {
            return "/author/get/{id}";
        }
        return author.toString();
    }

    @GetMapping("/author/update/{id}/{firstName}+{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName,
                               @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/author/update/{id}/{firstName}+{lastName}";
        }
        author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

    @GetMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id, @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/author/delete/{id}";
        }
        author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }
}

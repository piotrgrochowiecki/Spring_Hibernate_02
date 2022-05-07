package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("bookForm")
@RequiredArgsConstructor
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    @GetMapping("add")
    public String addNewBook(Model model) {
    model.addAttribute("book", new Book());
    return "bookForm-add";
    }

    @PostMapping("add")
    public String saveNewBook(@ModelAttribute("book") @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookForm-add";
        }

    bookDao.save(book);
    return "redirect:/bookForm/all";
    }

    @GetMapping("all")
    public String showAllBooks(Model model) {
        model.addAttribute("book", bookDao.findAll());
        return "bookForm-all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getAllPublishers() {
        return publisherDao.findAll();
    }



}

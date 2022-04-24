package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

@Controller
public class BookController {

    private  final BookDao bookDao;
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/book/add")
    @ResponseBody
    public String saveBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookDao.save(book);
        return "id of added book: " + book.getId();
    }

    @GetMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

//    @GetMapping("/book/update/{id}/{title}")
    @GetMapping(value = "/book/update/{id}/{title}", produces = "text/plain")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @GetMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }
}

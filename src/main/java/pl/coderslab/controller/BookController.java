package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

public class BookController {

    private  final BookDao bookDao;
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookDao.saveBook(book);
        return "Id dodanej książki to " + book.getId();
    }
}

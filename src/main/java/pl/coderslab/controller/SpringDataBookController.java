package pl.coderslab.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("spring-data/book")
@RequiredArgsConstructor
public class SpringDataBookController {

    private final BookRepository bookRepository;

    @GetMapping("all")
    public void findAll(){
        List<Book> all = bookRepository.findAll();
        all.forEach(b -> log.info("{}", b.getId())); //pobrać Java 11 i zobaczyć co z tym loggerem
    }
}

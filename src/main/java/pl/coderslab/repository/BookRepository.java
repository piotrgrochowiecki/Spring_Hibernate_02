package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //metoda wyszukująca książki po tytule
    Optional<Book> findByTitle(String title);

    //metoda wyszukująca książki dla danej kategorii
    List<Book> findByCategory(Category category);

    //metoda wyszukująca książki dla danego id kategorii
    List<Book> findByCategoryId(Long categoryId); //nie używamy findById (niezalecane?)
}

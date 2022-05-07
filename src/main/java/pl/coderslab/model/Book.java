package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //używamy prymitywnego typu, a nie objektu, bo typ prymitywny nie może być null

    @Column(name = "title")
    @Size(min = 5)
    private String title;
    //przy pozostałych atrybutach nie dodajemy adnotacji @Column, bo domyślne nazwa i wartości są dobre w tym przypadku,
    //tutaj dodaliśmy, żeby tylko pokazać

    @Range(min = 1, max = 10)
    private int rating;

    @Size(max = 600)
    private String description;

    @NotNull
    private String author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull
    private Publisher publisher; //czytamy: Wiele Książek (nazwa klasy) do jednego wydawcy

    @Min(2) //musi być większe od 1
    private int pages;

    @NotEmpty //nie jest nullem oraz rozmiar jest większy od 1(?)
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @ManyToOne //wiele książek może być dodanych do jednej kategorii, ale książka może mieć jedną kategorię
    @JoinColumn(name = "category_id")
    private Category category;
}

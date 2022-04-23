package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //używamy prymitywnego typu, a nie objektu, bo typ prymitywny nie może być null

    @Column(name = "title")
    private String title;
    //przy pozostałych atrybutach nie dodajemy adnotacji @Column, bo domyślne nazwa i wartości są dobre w tym przypadku,
    //tutaj dodaliśmy, żeby tylko pokazać

    private int rating;

    private String description;

    private String author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher; //czytamy: Wiele Książek (nazwa klasy) do jednego wydawcy
}

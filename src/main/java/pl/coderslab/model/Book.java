package pl.coderslab.model;

import javax.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

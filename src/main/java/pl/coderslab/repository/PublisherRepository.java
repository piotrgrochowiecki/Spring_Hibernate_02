package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

//    //wydawca dla zadanego numeru nip
//    Publisher findByNip(String nip);
//
//    //wydawca dla zadanego numeru regon
//    Publisher findByRegon(String regon);
}

package Sem4.TravelTour.repository.BookRepository;

import Sem4.TravelTour.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
    List<Book> findAllByOrOrderByBookIdDesc();
    Optional<Book> findById(Long id);
}

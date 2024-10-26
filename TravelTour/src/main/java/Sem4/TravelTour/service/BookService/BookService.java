package Sem4.TravelTour.service.BookService;

import Sem4.TravelTour.entity.Book;
import Sem4.TravelTour.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    boolean existsById(Long id);
    Optional<Book> findById(Long id);
}

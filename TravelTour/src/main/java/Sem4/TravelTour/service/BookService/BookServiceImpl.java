package Sem4.TravelTour.service.BookService;

import Sem4.TravelTour.entity.Book;
import Sem4.TravelTour.entity.Tour;
import Sem4.TravelTour.repository.BookRepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAllByOrOrderByBookIdDesc();
    }
    @Override
    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }
    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}


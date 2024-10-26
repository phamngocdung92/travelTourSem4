package Sem4.TravelTour.api;

import Sem4.TravelTour.entity.Book;
import Sem4.TravelTour.service.BookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/books")
public class BookApi {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity <List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") Long id) {
        if (!bookService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.findById(id).get());
    }
}

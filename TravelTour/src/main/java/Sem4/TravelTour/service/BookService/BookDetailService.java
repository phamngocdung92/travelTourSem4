package Sem4.TravelTour.service.BookService;

import Sem4.TravelTour.entity.Book;
import Sem4.TravelTour.entity.BookDetail;

import java.util.List;

public interface BookDetailService {
    BookDetail save(BookDetail bookDetail);
    List<BookDetail> findByBook(Book book);
}

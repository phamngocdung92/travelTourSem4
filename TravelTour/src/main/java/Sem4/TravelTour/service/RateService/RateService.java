package Sem4.TravelTour.service.RateService;

import Sem4.TravelTour.entity.BookDetail;
import Sem4.TravelTour.entity.Rate;
import Sem4.TravelTour.entity.Tours;

import java.util.List;

public interface RateService {
    List<Rate> findAllByOrderByIdDesc();
    Rate findByBookDetail(BookDetail bookDetail);
    List<Rate> findByToursOrderByIdDesc(Tours tours);
    Rate save(Rate rate);
}

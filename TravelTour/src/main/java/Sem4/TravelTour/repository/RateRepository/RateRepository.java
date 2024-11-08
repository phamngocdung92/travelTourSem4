package Sem4.TravelTour.repository.RateRepository;

import Sem4.TravelTour.entity.BookDetail;
import Sem4.TravelTour.entity.Rate;
import Sem4.TravelTour.entity.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    List<Rate> findAllByOrderByIdDesc();
    Rate findByBookDetail(BookDetail bookDetail);
    List<Rate> findByToursOrderByIdDesc(Tours tours);
    Rate save(Rate rate);
}
//findByToursOrderByIdDesc
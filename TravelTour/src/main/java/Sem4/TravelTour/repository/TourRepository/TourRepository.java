package Sem4.TravelTour.repository.TourRepository;

import Sem4.TravelTour.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, Long>
{
    List<Tour> findByStatusTrue();
    @Query(value = "Select t.* From tour t \r\n"
            + "left join rates r on t.tour_id = r.tour_id\r\n"
            + "group by t.tour_id , t.name\r\n"
            + "Order by  avg(r.rating) desc, RAND()", nativeQuery = true)
    List<Tour> findTourRated();
    Tour save(Tour tour);
    List<Tour> findByStatusTrueOrderBySoldDesc();
    Optional<Tour> findById(Long id);
}

package Sem4.TravelTour.repository.TourRepository;

import Sem4.TravelTour.entity.Category;
import Sem4.TravelTour.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour, Long>
{
    List<Tour> findByStatusTrue();
    @Query(value = "Select t.* From tours t \r\n"
            + "left join rates r on t.tour_id = r.tour_id\r\n"
            + "group by t.tour_id , t.name\r\n"
            + "Order by  avg(r.rating) desc, RAND()", nativeQuery = true)
    List<Tour> findTourRated();
    Tour save(Tour tour);
    List<Tour> findByStatusTrueOrderBySoldDesc();
    Optional<Tour> findById(Long id);
    Tour findByTourIdAndStatusTrue(Long id);
    List<Tour> findByStatusTrueOrderByQuantityDesc();//findByStatusTrueOrderByQuantityDesc()
    Tour getById(Long id);
    @Query("SELECT t FROM Tour t WHERE t.name LIKE %:name% AND t.duration = :duration")
    List<Tour> findByNameAndDuration(@Param("name") String name, @Param("duration") int duration);
    List<Tour> findByCategory(Category category);
    List<Tour> findByStatusTrueOrderByEnteredDateDesc();

}

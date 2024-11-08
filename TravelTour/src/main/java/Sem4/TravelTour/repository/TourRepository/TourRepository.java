package Sem4.TravelTour.repository.TourRepository;

import Sem4.TravelTour.entity.Category;
import Sem4.TravelTour.entity.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<Tours, Long>
{
    List<Tours> findByStatusTrue();
    @Query(value = "Select t.* From tours t \r\n"
            + "left join rates r on t.tour_id = r.tour_id\r\n"
            + "group by t.tour_id , t.name\r\n"
            + "Order by  avg(r.rating) desc, RAND()", nativeQuery = true)
    List<Tours> findTourRated();
    Tours save(Tours tours);
    List<Tours> findByStatusTrueOrderBySoldDesc();
    Optional<Tours> findById(Long id);
    Tours findByTourIdAndStatusTrue(Long id);
//    TourIdAndStatusTrue(Long id)
    List<Tours> findByStatusTrueOrderByQuantityDesc();//findByStatusTrueOrderByQuantityDesc()
    Tours getById(Long id);
    @Query("SELECT t FROM Tours t WHERE t.name LIKE %:name% AND t.duration = :duration")
    List<Tours> findByNameAndDuration(@Param("name") String name, @Param("duration") int duration);
    List<Tours> findByCategory(Category category);
    List<Tours> findByStatusTrueOrderByEnteredDateDesc();
    @Query(value = "(Select t.*, avg(r.rating) Rate From tours t\r\n"
            + "left join rates r on t.tour_id = r.tour_id\r\n"
            + "Where (t.category_id = ?) and (t.tour_id != ?)\r\n"
            + "group by t.tour_id , t.name)\r\n"
            + "union\r\n"
            + "(Select p.*, avg(r.rating) Rate From tours t \r\n"
            + "left join rates r on t.tour_id = r.tour_id\r\n"
            + "Where t.category_id != ?\r\n"
            + "group by t.tour_id , t.name)\r\n"
            + "Order by category_id = ? desc, Rate desc", nativeQuery = true)
    List<Tours> findProductSuggest(Long id, Long id2, Long id3, Long id4);

}

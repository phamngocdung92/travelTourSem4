package Sem4.TravelTour.service.TourService;

import Sem4.TravelTour.entity.Category;
import Sem4.TravelTour.entity.Tours;

import java.util.List;
import java.util.Optional;

public interface TourService {

    boolean existsById(Long id);
    List<Tours> getAll();
    Tours save(Tours tours);
    List<Tours> getBestSeller();
    List<Tours> getRate();
    Optional<Tours> findById(Long id);
    List<Tours> findByStatusTrue();
    Tours findByTourIdAndStatusTrue(Long id);
    List<Tours> findByStatusTrueOrderByQuantityDesc();
    Tours getById(Long id);
    List<Tours> findByNameAndDuration(String name,int duration);
    List<Tours> findByCategory(Category category);
    List<Tours> findByStatusTrueOrderByEnteredDateDesc();
    List<Tours> findProductSuggest(Long id, Long id2, Long id3, Long id4);
}

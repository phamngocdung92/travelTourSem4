package Sem4.TravelTour.service.TourService;

import Sem4.TravelTour.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {

    boolean existsById(Long id);
    List<Tour> getAll();
    Tour save(Tour tour);
    List<Tour> getBestSeller();
    List<Tour> getRate();
    Optional<Tour> findById(Long id);
    //tesst
}

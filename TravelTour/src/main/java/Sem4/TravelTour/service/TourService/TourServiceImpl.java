package Sem4.TravelTour.service.TourService;

import Sem4.TravelTour.entity.Tour;
import Sem4.TravelTour.repository.TourRepository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;


    @Override
    public boolean existsById(Long id) {
        return tourRepository.existsById(id);
    }
    @Override
    public List<Tour> getAll() {
        return tourRepository.findByStatusTrue();
    }
    @Override
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }
    @Override
    public List<Tour>  getBestSeller() {
        return tourRepository.findByStatusTrueOrderBySoldDesc();
    }
    @Override
    public List<Tour> getRate() {
        return tourRepository.findTourRated();
    }
    @Override
    public Optional<Tour> findById(Long id) {
        return tourRepository.findById(id);
    }
    @Override
    public List<Tour> findByStatusTrue() {
        return tourRepository.findByStatusTrue();
    }
    @Override
    public Tour findByTourIdAndStatusTrue(Long id) {return  tourRepository.findByTourIdAndStatusTrue(id);}
    @Override
    public List<Tour> findByStatusTrueOrderByQuantityDesc() {return tourRepository.findByStatusTrueOrderByQuantityDesc();}


}

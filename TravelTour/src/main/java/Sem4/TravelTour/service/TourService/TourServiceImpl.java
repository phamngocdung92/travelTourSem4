package Sem4.TravelTour.service.TourService;

import Sem4.TravelTour.entity.Category;
import Sem4.TravelTour.entity.Tours;
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
    public List<Tours> getAll() {
        return tourRepository.findByStatusTrue();
    }
    @Override
    public Tours save(Tours tours) {
        return tourRepository.save(tours);
    }
    @Override
    public List<Tours>  getBestSeller() {
        return tourRepository.findByStatusTrueOrderBySoldDesc();
    }
    @Override
    public List<Tours> getRate() {
        return tourRepository.findTourRated();
    }
    @Override
    public Optional<Tours> findById(Long id) {
        return tourRepository.findById(id);
    }
    @Override
    public List<Tours> findByStatusTrue() {
        return tourRepository.findByStatusTrue();
    }
    @Override
    public Tours findByTourIdAndStatusTrue(Long id) {return  tourRepository.findByTourIdAndStatusTrue(id);}
    @Override
    public List<Tours> findByStatusTrueOrderByQuantityDesc() {return tourRepository.findByStatusTrueOrderByQuantityDesc();}
    @Override
    public Tours getById(Long id) {
        return tourRepository.getById(id);
    }
    @Override
    public List<Tours> findByNameAndDuration(String name, int duration) {
        return tourRepository.findByNameAndDuration(name,duration);
    }
    @Override
    public List<Tours> findByCategory(Category category) {
        return tourRepository.findByCategory(category);
    }
    @Override
    public List<Tours> findByStatusTrueOrderByEnteredDateDesc() {
        return tourRepository.findByStatusTrueOrderByEnteredDateDesc();
    }
    @Override
    public  List<Tours> findProductSuggest(Long id, Long id2, Long id3, Long id4){
        return tourRepository.findProductSuggest(id,id2,id3,id4);
    }
}

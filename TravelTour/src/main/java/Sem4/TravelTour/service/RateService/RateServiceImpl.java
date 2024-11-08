package Sem4.TravelTour.service.RateService;

import Sem4.TravelTour.entity.BookDetail;
import Sem4.TravelTour.entity.Rate;
import Sem4.TravelTour.entity.Tours;
import Sem4.TravelTour.repository.RateRepository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateRepository rateRepository;
    @Override
    public List<Rate> findAllByOrderByIdDesc() {
        return rateRepository.findAllByOrderByIdDesc();
    }
    @Override
    public Rate findByBookDetail(BookDetail bookDetail){return rateRepository.findByBookDetail(bookDetail);}
    @Override
    public List<Rate> findByToursOrderByIdDesc(Tours tours){
        return rateRepository.findByToursOrderByIdDesc(tours);
    }
    @Override
    public Rate save(Rate rate) {return rateRepository.save(rate);}
}

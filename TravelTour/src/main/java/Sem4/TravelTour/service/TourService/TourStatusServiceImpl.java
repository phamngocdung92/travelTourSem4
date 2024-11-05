package Sem4.TravelTour.service.TourService;

import Sem4.TravelTour.entity.TourStatus;
import Sem4.TravelTour.repository.TourRepository.TourStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourStatusServiceImpl implements TourStatusService {
    @Autowired
    TourStatusRepository tourStatusRepository;

    @Override
    public TourStatus save (TourStatus tourStatus)
    {
        return tourStatusRepository.save(tourStatus);
    }
}

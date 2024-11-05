package Sem4.TravelTour.repository.TourRepository;

import Sem4.TravelTour.entity.TourStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourStatusRepository extends JpaRepository<TourStatus, Long> {
    TourStatus save (TourStatus tourStatus);
}

package Sem4.TravelTour.repository.CartRepository;

import Sem4.TravelTour.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    CartDetail save (CartDetail cartDetail);
}

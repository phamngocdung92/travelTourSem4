package Sem4.TravelTour.repository.CartRepository;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    CartDetail save (CartDetail cartDetail);
    List<CartDetail> findByCart(Cart cart);
}

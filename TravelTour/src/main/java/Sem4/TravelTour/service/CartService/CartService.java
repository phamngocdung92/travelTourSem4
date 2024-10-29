package Sem4.TravelTour.service.CartService;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.CartDetail;

import java.util.List;

public interface CartService {
    Cart save(Cart cart);
    boolean existsById(Long id);
    List<CartDetail> findByCart(Cart cart);
}

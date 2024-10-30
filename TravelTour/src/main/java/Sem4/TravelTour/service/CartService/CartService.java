package Sem4.TravelTour.service.CartService;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.Tour;
import Sem4.TravelTour.entity.User;

import java.util.Optional;

public interface CartService {
    Cart save(Cart cart);
    Cart findByUser(User user);
    boolean existsById(Long id);
    Optional<Cart> findById(Long id);
}

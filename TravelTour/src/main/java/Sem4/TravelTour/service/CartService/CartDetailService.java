package Sem4.TravelTour.service.CartService;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.CartDetail;

import java.util.List;

public interface CartDetailService {
    void delete (CartDetail cartDetail);
    List<CartDetail> findByCart(Cart cart);
}

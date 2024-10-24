package Sem4.TravelTour.service.CartService;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.repository.CartRepository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}

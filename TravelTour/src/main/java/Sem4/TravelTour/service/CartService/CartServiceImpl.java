package Sem4.TravelTour.service.CartService;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.CartDetail;
import Sem4.TravelTour.repository.CartRepository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public boolean existsById(Long id) {
        return cartRepository.existsById(id);
    }
    @Override
    public List<CartDetail> findByCart(Cart cart) {
        return cartRepository.findByCart(cart);
    }
}

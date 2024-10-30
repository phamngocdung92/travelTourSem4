package Sem4.TravelTour.service.CartService;

import Sem4.TravelTour.entity.Cart;
import Sem4.TravelTour.entity.Tour;
import Sem4.TravelTour.entity.User;
import Sem4.TravelTour.repository.CartRepository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Cart findByUser(User user) {return  cartRepository.findByUser(user);}
    @Override
    public boolean existsById(Long id) {
        return cartRepository.existsById(id);
    }
    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }
}


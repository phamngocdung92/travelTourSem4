package Sem4.TravelTour.service.CartDetailService;

import Sem4.TravelTour.repository.CartDetailRepository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDetailServiceImpl implements CartDetailService {
@Autowired
private CartDetailRepository cartDetailRepository;
    @Override
    public boolean existsById(Long id) {
        return cartDetailRepository.existsById(id);
    }
}

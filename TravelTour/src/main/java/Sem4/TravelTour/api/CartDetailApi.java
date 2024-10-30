package Sem4.TravelTour.api;

import Sem4.TravelTour.entity.CartDetail;
import Sem4.TravelTour.service.CartDetailService.CartDetailService;
import Sem4.TravelTour.service.CartService.CartService;
import Sem4.TravelTour.service.CartService.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/cartDetail")
public class CartDetailApi {
    @Autowired
    CartService cartService;

   @Autowired
   CartDetailService cartDetailService;

    @GetMapping("cart/{id}")
    public ResponseEntity<List<CartDetail>> getByCartId(@PathVariable("id") Long id) {
        if (!cartService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartDetailService.findByCart(cartService.findById(id).get()));
    }
}

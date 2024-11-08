package Sem4.TravelTour.api;

import Sem4.TravelTour.entity.Favorite;
import Sem4.TravelTour.entity.Tours;
import Sem4.TravelTour.entity.User;
import Sem4.TravelTour.service.FavoriteService.FavoriteService;
import Sem4.TravelTour.service.TourService.TourService;
import Sem4.TravelTour.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/favorites")
public class FavoriteApi {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private UserService userService;
    @Autowired
    private TourService tourService;

    @GetMapping("email/{email}")
    public ResponseEntity<List<Favorite>> findByEmail(@PathVariable("email") String email){
        if(userService.exsitsByEmail(email)){
            return ResponseEntity.ok(favoriteService.findByUser(userService.findByEmail(email).get()));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("tour/{id}")
    public ResponseEntity<Integer> findByTour(@PathVariable("id") Long id){
        if(tourService.existsById(id)){
            return ResponseEntity.ok(favoriteService.countByTours(tourService.getById(id).getTourId()));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("{tourId}/{email}")
    public ResponseEntity<Favorite> findByTourAndUser(@PathVariable("tourId") Long tourId, @PathVariable("email") String email){
        if(userService.exsitsByEmail(email)){
            if(tourService.existsById(tourId)){
                Tours tours = tourService.findById(tourId).get();
                User user = userService.findByEmail(email).get();
                return ResponseEntity.ok(favoriteService.findByTourAndUser(tours, user));
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("email")
    public ResponseEntity<Favorite> post (@RequestBody Favorite favorite){
        return ResponseEntity.ok(favoriteService.save(favorite));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        if(favoriteService.existsById(id)){
            favoriteService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

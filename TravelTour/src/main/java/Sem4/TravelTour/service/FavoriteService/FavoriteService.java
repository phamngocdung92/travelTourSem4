package Sem4.TravelTour.service.FavoriteService;

import Sem4.TravelTour.entity.Favorite;
import Sem4.TravelTour.entity.Tours;
import Sem4.TravelTour.entity.User;

import java.util.List;

public interface FavoriteService {
    List<Favorite> findByUser(User user);
    Integer countByTours(Long id);
    Favorite findByTourAndUser(Tours tours, User user);
    Favorite save(Favorite favorite);
    boolean existsById(Long id);
    void deleteById(Long id);
}

package Sem4.TravelTour.repository.FavoriteRepository;

import Sem4.TravelTour.entity.Favorite;
import Sem4.TravelTour.entity.Tours;
import Sem4.TravelTour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
    Integer countByTours(Long id);
    Favorite findByToursAndUser(Tours tours, User user);
    Favorite save(Favorite favorite);
    boolean existsById(Long id);
    void deleteById(Long id);
}

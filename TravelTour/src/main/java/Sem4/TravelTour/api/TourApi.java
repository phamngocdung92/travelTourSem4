package Sem4.TravelTour.api;

import Sem4.TravelTour.entity.Tour;
import Sem4.TravelTour.service.TourService.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/tours")
public class TourApi {
    @Autowired
    private TourService tourService;
    @GetMapping
    public ResponseEntity<List<Tour>> getAll() {
        return ResponseEntity.ok(tourService.getAll());
    }
    @GetMapping("bestseller")
    public ResponseEntity<List<Tour>> getBestSeller() {
        return ResponseEntity.ok(tourService.getBestSeller());
    }
    @GetMapping("rated")
    public ResponseEntity<List<Tour>> getRated() {
        return ResponseEntity.ok(tourService.getRate());
    }
    @GetMapping("{id}")
    public ResponseEntity<Tour> getById(@PathVariable("id") Long id) {
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tourService.findById(id).get());
    }
    @PostMapping
    public ResponseEntity<Tour> post(@RequestBody Tour tour) {
//        if (tourService.existsById(tour.getTourId())) {
//            return ResponseEntity.badRequest().build();
//        }
        return ResponseEntity.ok(tourService.save(tour));
    }
    @PutMapping("{id}")
    public ResponseEntity<Tour> put(@PathVariable("id") Long id, @RequestBody Tour tour) {
        if (!id.equals(tour.getTourId())) {
            return ResponseEntity.badRequest().build();
        }
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tourService.save(tour));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Tour t = tourService.findById(id).get();
        t.setStatus(false);
        tourService.save(t);
        return ResponseEntity.ok().build();
    }
    //find tour by name and duration
    @GetMapping("search")
    public ResponseEntity<List<Tour>> search(@RequestParam("name") String name, @RequestParam("duration") int duration) {
        return ResponseEntity.ok(tourService.findByNameAndDuration(name, duration));
    }
}

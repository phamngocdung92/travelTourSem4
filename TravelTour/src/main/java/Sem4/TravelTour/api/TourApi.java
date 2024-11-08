package Sem4.TravelTour.api;

import Sem4.TravelTour.dto.CloseTourDto;
import Sem4.TravelTour.entity.Category;
import Sem4.TravelTour.entity.Image;
import Sem4.TravelTour.entity.TourStatus;
import Sem4.TravelTour.entity.Tours;
import Sem4.TravelTour.service.CategoryService.CategoryService;
import Sem4.TravelTour.service.ImageService.ImageService;
import Sem4.TravelTour.service.TourService.TourService;
import Sem4.TravelTour.service.TourService.TourStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("api/tours")
public class TourApi {
    @Autowired
    private TourService tourService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TourStatusService tourStatusService;
    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<List<Tours>> getAll() {
        return ResponseEntity.ok(tourService.getAll());
    }
    @GetMapping("bestseller")
    public ResponseEntity<List<Tours>> getBestSeller() {
        return ResponseEntity.ok(tourService.getBestSeller());
    }
    @GetMapping("rated")
    public ResponseEntity<List<Tours>> getRated() {
        return ResponseEntity.ok(tourService.getRate());
    }
    @GetMapping("{id}")
    public ResponseEntity<Tours> getById(@PathVariable("id") Long id) {
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tourService.findById(id).get());
    }
    @GetMapping("suggest/{categoryId}/{productId}")
    public ResponseEntity<List<Tours>> suggest(@PathVariable("categoryId") Long categoryId,
                                                 @PathVariable("productId") Long productId) {
        return ResponseEntity.ok(tourService.findProductSuggest(categoryId, productId, categoryId, categoryId));
    }
    @PostMapping
    public ResponseEntity<Tours> post(@RequestBody Tours tours) {
//        if (tourService.existsById(tour.getTourId())) {
//            return ResponseEntity.badRequest().build();
//        }
        return ResponseEntity.ok(tourService.save(tours));
    }
    @PutMapping("{id}")
    public ResponseEntity<Tours> put(@PathVariable("id") Long id, @RequestBody Tours tours    ) {
        if (!id.equals(tours.getTourId())){
            return ResponseEntity.notFound().build();
        }
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tourService.save(tours));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Tours t = tourService.findById(id).get();
        t.setStatus(true);
        tourService.save(t);
        return ResponseEntity.ok().build();
    }
    //find tour by name and duration
    @GetMapping("search")
    public ResponseEntity<List<Tours>> search(@RequestParam("name") String name, @RequestParam("duration") int duration) {
        return ResponseEntity.ok(tourService.findByNameAndDuration(name, duration));
    }
    @GetMapping("category/{id}")
    public ResponseEntity<List<Tours>> getByCategory(@PathVariable("id") Long id) {
        if(!categoryService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Category c = categoryService.findById(id).get();
        return ResponseEntity.ok(tourService.findByCategory(c));
    }
    @GetMapping("latest")
    public ResponseEntity<List<Tours>> getLatest() {
        return ResponseEntity.ok(tourService.findByStatusTrueOrderByEnteredDateDesc());
    }
    @PostMapping("closeTour")
    public ResponseEntity<TourStatus> closeTour(@RequestBody CloseTourDto closeTourDto){
        Long tourIdInput = closeTourDto.getTourId();
        if (!tourService.existsById(tourIdInput)) {
            return ResponseEntity.notFound().build();
        }
        TourStatus ts = new TourStatus();
        ts.setTourId(tourIdInput);
        ts.setFromDate(closeTourDto.getFromDate());
        ts.setToDate(closeTourDto.getToDate());
        ts.setStatus(false);

        return ResponseEntity.ok(tourStatusService.save(ts));
    }
    @GetMapping("getClosedTourById/{id}")
    public ResponseEntity<List<TourStatus>> getClosedTourById(@PathVariable("id") Long id){
        if(!tourStatusService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        List<TourStatus> ts = tourStatusService.findBytourIdAndStatusFalse(id);
        return ResponseEntity.ok(ts);
    }
    @GetMapping("getTourImages/{id}")
    public ResponseEntity<List<String>> getTourImages(@PathVariable("id") Long id) {
        if (!tourService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        List<Image> images = imageService.findByTour_TourId(id);
        List<String> imageUrls = images.stream().map(Image::getImageUrl).collect(Collectors.toList());
        return ResponseEntity.ok(imageUrls);
    }

}

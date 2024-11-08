package Sem4.TravelTour.service.ImageService;

import Sem4.TravelTour.entity.Image;
import Sem4.TravelTour.repository.ImageRepository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> findByTour_TourId(Long tourId) {
        List<Image> images = imageRepository.findByTours_TourId(tourId);
        return images;
    }
}

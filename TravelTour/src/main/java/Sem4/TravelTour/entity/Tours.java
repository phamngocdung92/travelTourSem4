package Sem4.TravelTour.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tours")
public class Tours  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourId;
    private String name;
    private int quantity;
    private Double price;
    private int discount;
    private String image;
    private String description;
    private LocalDate enteredDate;
    private Boolean status;
    private int duration;
    private int sold;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

//    @OneToMany(mappedBy = "tour")
//    private Set<Location> locations;
//
//    @OneToMany(mappedBy = "tour")
//    private Set<TourStatus> tourStatuses;
//
//    @OneToMany(mappedBy = "tour")
//    private Set<BookDetail> bookDetails;
//
//    @OneToMany(mappedBy = "tour")
//    private Set<CartDetail> cartDetails;
//
//    @OneToMany(mappedBy = "tour")
//    private Set<Favorite> favorites;
//
//    @OneToMany(mappedBy = "tour")
//    private Set<Rate> rates;

    @Override
    public String toString() {
        return "Tours{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", enteredDate=" + enteredDate +
                ", status=" + status +
                ", duration=" + duration +
                ", sold=" + sold +
                ", category=" + category +
                '}';
    }

}

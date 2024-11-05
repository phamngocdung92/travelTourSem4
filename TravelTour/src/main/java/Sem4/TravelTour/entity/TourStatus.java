package Sem4.TravelTour.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tourstatus")
public class TourStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;
    private Long tour_id;

    private LocalDate fromDate;
    private LocalDate toDate;
    private Boolean status;

    // Getters and Setters

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TourStatus{" +
                "statusId=" + statusId +
                ", tour_id=" + tour_id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", status=" + status +
                '}';
    }
}

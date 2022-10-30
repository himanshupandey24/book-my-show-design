package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;
    private int capacity;

    //To add mapping of enum
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;

    @ManyToOne
    private Theatre theatre;
}

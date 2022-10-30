package com.scaler.bookmyshow.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
    @OneToMany(mappedBy = "show")
    private List<ShowSeatType> showSeatTypes;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;
    @Enumerated(EnumType.STRING)
    private Language language;
}

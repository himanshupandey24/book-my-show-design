package com.scaler.bookmyshow.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private Double totalAmount;

}

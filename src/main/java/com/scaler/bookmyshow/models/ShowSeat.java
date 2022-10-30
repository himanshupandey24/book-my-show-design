package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatState showSeatState;

}

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
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private Double price;
}

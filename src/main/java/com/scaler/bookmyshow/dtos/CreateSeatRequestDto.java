package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter

public class CreateSeatRequestDto {
    private Map<SeatType, Integer> seatCount;
    private Long audiId;
}

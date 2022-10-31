package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAudiRequestDto {
    private String name;
    private int capacity;
    private Long theatreID;
}

package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTheatreRequestDto {
    private String name;
    private String address;
    private Long cityID;
}

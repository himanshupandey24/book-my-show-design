package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Show;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShowResponseDto {
    private Show show;
}

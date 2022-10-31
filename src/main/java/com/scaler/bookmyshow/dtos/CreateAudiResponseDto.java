package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Auditorium;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAudiResponseDto {
    private Auditorium auditorium;
}

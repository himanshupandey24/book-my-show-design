package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTicketResponseDto {
    private Ticket ticket;
}

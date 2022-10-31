package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.*;
import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheatreController {
    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }

    public CreateTheatreResponseDto createTheatre(CreateTheatreRequestDto request) throws CityNotFoundException {
        Theatre savedTheatre = theatreService.createTheatre(
                request.getName(),
                request.getAddress(),
                request.getCityID());
        CreateTheatreResponseDto response = new CreateTheatreResponseDto();
        response.setTheatre(savedTheatre);
        return response;
    }

    public CreateTheatreResponseDto addAuditorium(CreateAudiRequestDto request){
        Theatre savedAuditorium = theatreService.addAuditorium(
                request.getName(),
                request.getCapacity(),
                request.getTheatreID());

        CreateTheatreResponseDto response = new CreateTheatreResponseDto();
        response.setTheatre(savedAuditorium);
        return response;
    }

    public void addSeats(CreateSeatRequestDto request){
        theatreService.addSeats(request.getSeatCount(), request.getAudiId());
    }

}

package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateCityRequestDto;
import com.scaler.bookmyshow.dtos.CreateCityResponseDto;
import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    public CreateCityResponseDto createCity(CreateCityRequestDto request){
        City savedCity = cityService.createCity(request.getName());
        CreateCityResponseDto response = new CreateCityResponseDto();
        response.setCity(savedCity);
        return response;
    }
}

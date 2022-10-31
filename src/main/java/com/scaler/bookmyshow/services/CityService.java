package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public City createCity(String name){
        City city = new City();
        city.setName(name);
        City savedCity = cityRepository.save(city);
        return savedCity;
    }
}

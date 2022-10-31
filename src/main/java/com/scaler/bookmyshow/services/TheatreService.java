package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.repositories.CityRepository;
import com.scaler.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    public TheatreService(TheatreRepository theatreRepository,
                          CityRepository cityRepository){
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityID) throws CityNotFoundException {

        Optional<City> cityOptional = cityRepository.findById(cityID);
        if(cityOptional.isEmpty())
            throw new CityNotFoundException();


        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        City city = cityOptional.get();
        if(city.getTheatres() == null)
            city.setTheatres(new ArrayList<>());

        city.getTheatres().add(savedTheatre);
        this.cityRepository.save(city);

        return savedTheatre;
    }
}

package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.AuditoriumRepository;
import com.scaler.bookmyshow.repositories.CityRepository;
import com.scaler.bookmyshow.repositories.SeatRepository;
import com.scaler.bookmyshow.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;

    private SeatRepository seatRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository,
                          CityRepository cityRepository,
                          AuditoriumRepository auditoriumRepository,
                          SeatRepository seatRepository){
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.seatRepository = seatRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityID) throws CityNotFoundException {

        Optional<City> cityOptional = cityRepository.findById(cityID);
        if(cityOptional.isEmpty())
            throw new CityNotFoundException("City Not Found");


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

    public Theatre addAuditorium(String name, int capacity, Long theatreID) {

        Theatre theatre = theatreRepository.findById(theatreID).get();

        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setCapacity(capacity);
        auditorium.setTheatre(theatre);

        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);

        theatre.getAuditoriums().add(savedAuditorium);

        return theatreRepository.save(theatre);
    }

    public void addSeats(Map<SeatType, Integer> seatCount, Long audiId) {
        Auditorium auditorium = auditoriumRepository.findById(audiId).get();
        List<Seat> seats = new ArrayList<>();
        for(Map.Entry<SeatType, Integer> entry : seatCount.entrySet()){
            for(int i = 0; i < entry.getValue(); ++i){
                Seat seat = new Seat();
                seat.setSeatType(entry.getKey());
                seat.setSeatNumber(entry.getKey().toString() + (i + 1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = seatRepository.saveAll(seats);
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);
    }
}

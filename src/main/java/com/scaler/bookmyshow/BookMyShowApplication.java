package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.CityController;
import com.scaler.bookmyshow.controllers.TheatreController;
import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.dtos.*;
import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private UserController userController;
    private CityController cityController;
    private TheatreController theatreController;

    @Autowired
    public BookMyShowApplication(UserController userController,
                                 CityController cityController,
                                 TheatreController theatreController){
        //System.out.println("BookMyShowApplication constructor");
        this.userController = userController;
        this.cityController = cityController;
        this.theatreController = theatreController;
    }
    public static void main(String[] args) {
        //System.out.println("Main method of Spring Boot Application");
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Run method of Spring Boot Application");
        CreateUserRequestDto requestUser = new CreateUserRequestDto();
        requestUser.setEmail("abc@gmail.com");

        this.userController.createUser(requestUser);

        CreateCityRequestDto requestCity = new CreateCityRequestDto();
        requestCity.setName("Lucknow");

        this.cityController.createCity(requestCity);

        CreateTheatreRequestDto requestTheatre = new CreateTheatreRequestDto();

        requestTheatre.setName("PVR");
        requestTheatre.setAddress("Phoenix United Mall Kanpur Road");
        requestTheatre.setCityID(1L);

        try {
            this.theatreController.createTheatre(requestTheatre);
        } catch (CityNotFoundException e) {
            System.out.println("City not found");
        }

        requestTheatre.setName("Inox");
        requestTheatre.setAddress("River Side Mall Gomti Nagar");
        requestTheatre.setCityID(1L);

        try {
            this.theatreController.createTheatre(requestTheatre);
        } catch (CityNotFoundException e) {
            System.out.println(e.getMessage());
        }

        CreateAudiRequestDto requestAudi = new CreateAudiRequestDto();
        requestAudi.setName("Auditorium 1");
        requestAudi.setCapacity(200);
        requestAudi.setTheatreID(1L);

        this.theatreController.addAuditorium(requestAudi);
        
        Map<SeatType, Integer> seatCount = new HashMap<>();
        seatCount.put(SeatType.SILVER, 50);
        seatCount.put(SeatType.GOLD, 30);
        seatCount.put(SeatType.PLATINUM,20);
        seatCount.put(SeatType.VIP,10);

        CreateSeatRequestDto requestSeat = new CreateSeatRequestDto();
        requestSeat.setAudiId(1L);
        requestSeat.setSeatCount(seatCount);

        this.theatreController.addSeats(requestSeat);
        
    }
}
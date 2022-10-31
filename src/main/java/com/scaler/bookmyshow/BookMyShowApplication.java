package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.dtos.CreateUserRequestDto;
import com.scaler.bookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private UserController userController;

    @Autowired
    public BookMyShowApplication(UserController userController){
        //System.out.println("BookMyShowApplication constructor");
        this.userController = userController;
    }
    public static void main(String[] args) {
        //System.out.println("Main method of Spring Boot Application");
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Run method of Spring Boot Application");
        CreateUserRequestDto requestDto = new CreateUserRequestDto();
        requestDto.setEmail("abc@gmail.com");
        this.userController.createUser(requestDto);
    }
}
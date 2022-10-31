package com.scaler.bookmyshow.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityNotFoundException extends Exception {
    String message;
    public CityNotFoundException(String message){
        super(message);
        this.message = message;
    }
}

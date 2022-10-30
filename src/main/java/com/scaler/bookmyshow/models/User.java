package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name ="users")
public class User extends BaseModel{
    private String email;

}

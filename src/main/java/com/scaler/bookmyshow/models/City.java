package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatres;
}

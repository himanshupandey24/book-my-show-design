package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    private String address;
    @OneToMany(mappedBy = "theatre", fetch = FetchType.EAGER)
    private List<Auditorium> auditoriums;
    @OneToMany
    private List<Show> upcomingShows;
}

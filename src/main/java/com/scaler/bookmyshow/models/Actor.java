package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Actor extends BaseModel{
    private String name;
    @ManyToMany(mappedBy = "actors") // so that spring will not create two mapping tables as relationships are same.
    private List<Movie> movies;
}

//Actor : Movie
//  1   :   M
//  M   :   1
// So cardinality is M : M


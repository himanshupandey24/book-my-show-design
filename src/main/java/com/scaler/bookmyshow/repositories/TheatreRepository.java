package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Override
    //<S extends Theatre> S save(S entity);
    Theatre save(Theatre theatre);
}

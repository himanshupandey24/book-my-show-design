package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Override
    Seat save(Seat seat);

    @Override
    <S extends Seat> List<S> saveAll(Iterable<S> entities);
}

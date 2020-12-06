package com.project.travelplanner.repository;

import com.project.travelplanner.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Override
    List<Flight> findAll();

    @Override
    Flight save(Flight flight);

    @Override
    Optional<Flight> findById (Long id);

    @Override
    void deleteById(Long id);
}

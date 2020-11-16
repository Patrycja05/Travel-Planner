package com.project.travelplanner.repository;

import com.project.travelplanner.domain.Accommodation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccommodationRepository extends CrudRepository<Accommodation, Long> {

    @Override
    List<Accommodation> findAll();

    @Override
    Accommodation save(Accommodation accommodation);

    @Override
    Optional<Accommodation> findById (Long id);

    @Override
    void deleteById(Long id);
}

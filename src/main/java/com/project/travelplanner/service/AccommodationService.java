package com.project.travelplanner.service;

import com.project.travelplanner.domain.Accommodation;
import com.project.travelplanner.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    public Optional<Accommodation> getAccommodation(final Long id) {
        return accommodationRepository.findById(id);
    }

    public Accommodation saveAccommodation(final Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    public void deleteAccommodation(final Long id) {
        accommodationRepository.deleteById(id);
    }
}

package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.Accommodation;
import com.project.travelplanner.dto.AccommodationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccommodationMapper {

    public Accommodation mapToAccommodation(final AccommodationDto accommodationDto) {
        return new Accommodation(
                accommodationDto.getAccommodationId(),
                accommodationDto.getName(),
                accommodationDto.getLocation(),
                accommodationDto.getPrice(),
                accommodationDto.isAvailability());
    }

    public AccommodationDto mapToAccommodationDto(final Accommodation accommodation) {
        return new AccommodationDto(
                accommodation.getAccommodationId(),
                accommodation.getName(),
                accommodation.getLocation(),
                accommodation.getPrice(),
                accommodation.isAvailability());
    }

    public List<AccommodationDto> mapToAccommodationDtoList(final List<Accommodation> accommodationList) {
        return accommodationList.stream()
                .map(p -> mapToAccommodationDto(p))
                .collect(Collectors.toList());
    }
}

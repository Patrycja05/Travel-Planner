package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.Flight;
import com.project.travelplanner.dto.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public Flight mapToFlight(final FlightDto flightDto) {
        return new Flight(
                flightDto.getFlightId(),
                flightDto.getFlightDirection(),
                flightDto.getFlightDate(),
                flightDto.getFlightTime());
    }

    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(
                flight.getFlightId(),
                flight.getFlightDirection(),
                flight.getFlightDate(),
                flight.getFlightTime(),
                flight.getFlightStartingPoint());
    }

    public List<FlightDto> mapToFlightDtoList(final List<Flight> flightList) {
        return flightList.stream()
                .map(p -> mapToFlightDto(p))
                .collect(Collectors.toList());
    }
}

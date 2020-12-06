package com.project.travelplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long flightId;
    private String flightDirection;
    private LocalDate flightDate;
    private LocalTime flightTime;
    private String flightStartingPoint;
}

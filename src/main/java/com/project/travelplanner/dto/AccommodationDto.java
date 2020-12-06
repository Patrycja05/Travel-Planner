package com.project.travelplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationDto {
    private Long accommodationId;
    private String name;
    private String location;
    private double price;
    private boolean availability;
    private LocalDate accommodationDate;
    private int numberOfPeople;
}

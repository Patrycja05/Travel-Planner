package com.project.travelplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationDto {
    private Long accommodationId;
    private String name;
    private String location;
    private double price;
    private boolean availability;
}

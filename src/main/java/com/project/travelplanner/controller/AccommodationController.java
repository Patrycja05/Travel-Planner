package com.project.travelplanner.controller;

import com.project.travelplanner.dto.AccommodationDto;
import com.project.travelplanner.mapper.AccommodationMapper;
import com.project.travelplanner.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accommodation")
public class AccommodationController {

    @Autowired
    private AccommodationMapper accommodationMapper;

    @Autowired
    private AccommodationService accommodationService;

    @GetMapping(value = "/getAccommodations")
    public List<AccommodationDto> getAccommodations(){
        return accommodationMapper.mapToAccommodationDtoList(accommodationService.getAllAccommodations());
    }

    @GetMapping(value = "/getAccommodation")
    public AccommodationDto getAccommodation (@RequestParam Long AccommodationId) throws AccommodationNotFoundException {
        return accommodationMapper.mapToAccommodationDto(accommodationService.getAccommodation(AccommodationId).orElseThrow(AccommodationNotFoundException::new));
    }

    @PutMapping(value = "addAccommodation")
    public void addAccommodation(@RequestBody AccommodationDto accommodationDto){
        accommodationService.saveAccommodation(accommodationMapper.mapToAccommodation(accommodationDto));
    }

    @DeleteMapping(value = "deleteAccommodation")
    public void deleteAccommodation(@RequestParam Long accommodationId) {
        accommodationService.deleteAccommodation(accommodationId);
    }
}

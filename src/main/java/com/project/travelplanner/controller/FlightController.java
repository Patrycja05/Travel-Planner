package com.project.travelplanner.controller;

import com.project.travelplanner.dto.FlightDto;
import com.project.travelplanner.mapper.FlightMapper;
import com.project.travelplanner.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flight")
public class FlightController {

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/getFlights")
    public List<FlightDto> getFlights(){
        return flightMapper.mapToFlightDtoList(flightService.getAllFlights());
    }

    @GetMapping(value = "/getFlight")
    public FlightDto getFlight (@RequestParam Long flightId) throws FlightNotFoundException {
        return flightMapper.mapToFlightDto(flightService.getFlight(flightId).orElseThrow(FlightNotFoundException::new));
    }

    @PutMapping(value = "/addFlight")
    public void addFlight(@RequestBody FlightDto flightDto){
        flightService.saveFlight(flightMapper.mapToFlight(flightDto));
    }

    @DeleteMapping(value = "/deleteFlight")
    public void deleteFlight(@RequestParam Long flightId) {
        flightService.deleteFlight(flightId);
    }
}

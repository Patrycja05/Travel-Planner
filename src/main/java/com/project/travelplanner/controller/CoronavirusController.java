package com.project.travelplanner.controller;

import com.project.travelplanner.dto.CoronavirusDto;
import com.project.travelplanner.service.CoronavirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/coronavirus")
public class CoronavirusController {

    @Autowired
    private CoronavirusService coronavirusService;

    @GetMapping(value = "/getCoronavirusInformation")
    public void getWeather() {
        List<CoronavirusDto> coronavirusInformation = coronavirusService.getCoronavirusInformation();
        coronavirusInformation.forEach(coronavirusDto -> System.out.println(coronavirusDto.getNewConfirmed() + coronavirusDto.getNewDeaths() + coronavirusDto.getNewRecovered() + coronavirusDto.getNewDeaths()));
    }
}

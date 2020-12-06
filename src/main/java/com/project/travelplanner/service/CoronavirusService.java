package com.project.travelplanner.service;

import com.project.travelplanner.dto.CoronavirusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CoronavirusService {

    @Autowired
    private RestTemplate restTemplate;

    public List<CoronavirusDto> getCoronavirusInformation() {

        CoronavirusDto[] coronavirusResponse = restTemplate.getForObject( "https://api.covid19api.com/summary", CoronavirusDto[].class);

        if (coronavirusResponse != null) {
            return Arrays.asList(coronavirusResponse);
        }
        return new ArrayList<>();
    }
}

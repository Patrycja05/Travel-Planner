package com.project.travelplanner.service;

import com.project.travelplanner.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherDto weatherDto;

    @Value("44c31f4e6b4c725fa86ce10dd21a2266")
    private String apiKey;

    public List<WeatherDto> getWeather() {

        WeatherDto[] weatherResponse = restTemplate.getForObject( "api.openweathermap.org/data/2.5/weather?q=" + weatherDto.getCityName() + "&appid=" + apiKey, WeatherDto[].class);

        if (weatherResponse != null) {
            return Arrays.asList(weatherResponse);
        }
        return new ArrayList<>();
    }
}

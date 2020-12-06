package com.project.travelplanner.controller;

import com.project.travelplanner.dto.WeatherDto;
import com.project.travelplanner.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

        @Autowired
        private WeatherService weatherService;

        @GetMapping(value = "/getWeather")
        public void getWeather() {
                List<WeatherDto> weather = weatherService.getWeather();
                weather.forEach(weatherDto -> System.out.println(weatherDto.getCityName() + weatherDto.getTemp()));
        }
}

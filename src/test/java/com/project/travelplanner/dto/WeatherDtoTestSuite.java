package com.project.travelplanner.dto;

import com.project.travelplanner.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherDtoTestSuite {

    @Test
    public void weatherDtoTest() {
        //Given
        WeatherDto weatherDto = new WeatherDto("Kraków", 3.0);

        //When

        //Then
        assertEquals("Kraków", weatherDto.getCityName());
        assertEquals(3.0, weatherDto.getTemp(), 0);
    }
}

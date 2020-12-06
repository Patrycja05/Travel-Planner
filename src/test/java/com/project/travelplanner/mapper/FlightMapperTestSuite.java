package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.Flight;
import com.project.travelplanner.dto.FlightDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightMapperTestSuite {

    @Autowired
    private FlightMapper flightMapper;

    @Test
    public void mapToFlightTest() {
        //Given
        FlightDto flightDto = new FlightDto(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00), "Kraków");

        //When
        Flight flight = flightMapper.mapToFlight(flightDto);

        //Then
        assertEquals(1L, flight.getFlightId().longValue());
        assertEquals("Warszawa", flight.getFlightDirection());
    }

    @Test
    public void mapToFlightDtoTest() {
        //Given
        Flight flight = new Flight(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00));

        //When
        FlightDto flightDto = flightMapper.mapToFlightDto(flight);

        //Then
        assertEquals(1L, flightDto.getFlightId().longValue());
        assertEquals("Warszawa", flightDto.getFlightDirection());
    }

    @Test
    public void testMapToFlightDtoList(){
        //Given
        Flight flight1 = new Flight(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00));
        Flight flight2 = new Flight(2L, "Kraków", LocalDate.of(2020, 12, 12) ,  LocalTime.of(14, 20, 00));

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

        //When
        List<FlightDto> flightDtoList = flightMapper.mapToFlightDtoList(flightList);

        //Then
        assertEquals(2, flightDtoList.size());
        assertEquals(1L, flightDtoList.get(0).getFlightId().longValue());
        assertEquals(2L, flightDtoList.get(1).getFlightId().longValue());
        assertEquals("Warszawa", flightDtoList.get(0).getFlightDirection());
        assertEquals("Kraków", flightDtoList.get(1).getFlightDirection());
    }
}

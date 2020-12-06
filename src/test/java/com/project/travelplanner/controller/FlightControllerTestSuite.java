package com.project.travelplanner.controller;

import com.project.travelplanner.domain.Flight;
import com.project.travelplanner.dto.FlightDto;
import com.project.travelplanner.mapper.FlightMapper;
import com.project.travelplanner.service.FlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightMapper flightMapper;

    @MockBean
    private FlightService flightService;

    @Test
    public void getFlightsTest() throws Exception {
        //Given
        List<FlightDto> flightDtoList = new ArrayList<>();
        when(flightMapper.mapToFlightDtoList(flightService.getAllFlights())).thenReturn(flightDtoList);

        // When & Then
        mockMvc.perform(get("/v1/flight/getFlights").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getFlightTest() throws Exception {
        //Given
        FlightDto flightDto = new FlightDto(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00), "Kraków");
        Flight flight = new Flight(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00));

        when(flightMapper.mapToFlightDto(any(Flight.class))).thenReturn(flightDto);
        when(flightService.getFlight(flightDto.getFlightId())).thenReturn(Optional.of(flight));

        // When & Then
        mockMvc.perform(get("/v1/flight/getFlight?flightId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.flightId", is(1)))
                .andExpect(jsonPath("$.flightDirection", is("Warszawa")));


    }

    @Test
    public void deleteFlightTest() throws Exception {
        //Given

        //Whem & Then
        mockMvc.perform(delete("/v1/flight/deleteFlight?flightId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

    }

//    @Test
//    public void addFlightTest() throws Exception {
//        //Given
//        FlightDto flightDto = new FlightDto(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00));
//        Flight flight = new Flight(1L, "Warszawa", LocalDate.of(2020, 12, 10) ,  LocalTime.of(14, 30, 00));
//
//
//        when(flightMapper.mapToFlightDto(any(Flight.class))).thenReturn(flightDto);
//        when(flightService.saveFlight(any(Flight.class))).thenReturn(flight);
//
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(flightDto);
//
//        //Whem & Then
//        mockMvc.perform(put("/v1/flight/addFlight").contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(jsonContent))
//                .andExpect(status().is(200));
//    }
}

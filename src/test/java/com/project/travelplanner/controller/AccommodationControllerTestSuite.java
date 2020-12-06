package com.project.travelplanner.controller;

import com.google.gson.Gson;
import com.project.travelplanner.domain.Accommodation;
import com.project.travelplanner.dto.AccommodationDto;
import com.project.travelplanner.mapper.AccommodationMapper;
import com.project.travelplanner.service.AccommodationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
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
@WebMvcTest(AccommodationController.class)
public class AccommodationControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccommodationMapper accommodationMapper;

    @MockBean
    private AccommodationService accommodationService;

    @Test
    public void getAccommodationsTest() throws Exception {
        //Given
        List<AccommodationDto> accommodationDtoList = new ArrayList<>();
        when(accommodationMapper.mapToAccommodationDtoList(accommodationService.getAllAccommodations())).thenReturn(accommodationDtoList);

        // When & Then
        mockMvc.perform(get("/v1/accommodation/getAccommodations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getAccommodationTest() throws Exception {
        //Given
        AccommodationDto accommodationDto = new AccommodationDto(1L, "Marriott", "Warszawa", 300.00, true, LocalDate.of(2020, 11, 10), 1);
        Accommodation accommodation = new Accommodation(1L, "Marriott", "Warszawa", 300.00, true);

        when(accommodationMapper.mapToAccommodationDto(any(Accommodation.class))).thenReturn(accommodationDto);
        when(accommodationService.getAccommodation(accommodationDto.getAccommodationId())).thenReturn(Optional.of(accommodation));

        // When & Then
        mockMvc.perform(get("/v1/accommodation/getAccommodation?accommodationId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.accommodationId", is(1)))
                .andExpect(jsonPath("$.name", is("Marriott")))
                .andExpect(jsonPath("$.location", is("Warszawa")));


    }

    @Test
    public void deleteAccommodationTest() throws Exception {
        //Given

        //Whem & Then
        mockMvc.perform(delete("/v1/accommodation/deleteAccommodation?accommodationId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

    }

    @Test
    public void addAccommodationTest() throws Exception {
        //Given
        AccommodationDto accommodationDto = new AccommodationDto(1L, "Marriott", "Warszawa", 300.00, true, LocalDate.of(2020, 12, 10), 2);
        Accommodation accommodation = new Accommodation(1L, "Marriott", "Warszawa", 300.00, true);

        when(accommodationMapper.mapToAccommodationDto(any(Accommodation.class))).thenReturn(accommodationDto);
        when(accommodationService.saveAccommodation(any(Accommodation.class))).thenReturn(accommodation);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(accommodationDto);

        //Whem & Then
        mockMvc.perform(put("/v1/accommodation/addAccommodation").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }
}

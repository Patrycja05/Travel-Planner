package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.Accommodation;
import com.project.travelplanner.dto.AccommodationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccommodationMapperTestSuite {

    @Autowired
    private AccommodationMapper accommodationMapper;

    @Test
    public void mapToAccommodationTest() {
        //Given
        AccommodationDto accommodationDto = new AccommodationDto(1L, "Marriott", "Warszawa", 300.00, true, LocalDate.of(2020, 12, 10), 2);

        //When
        Accommodation accommodation = accommodationMapper.mapToAccommodation(accommodationDto);

        //Then
        assertEquals(1L, accommodation.getAccommodationId().longValue());
        assertEquals("Marriott", accommodation.getName());
        assertEquals("Warszawa", accommodation.getLocation());
        assertEquals(true, accommodation.isAvailability());
    }

    @Test
    public void mapToAccommodationDtoTest() {
        //Given
        Accommodation accommodation = new Accommodation(1L, "Marriott", "Warszawa", 300.00, true);

        //When
        AccommodationDto accommodationDto = accommodationMapper.mapToAccommodationDto(accommodation);

        //Then
        assertEquals(1L, accommodationDto.getAccommodationId().longValue());
        assertEquals("Marriott", accommodationDto.getName());
        assertEquals("Warszawa", accommodationDto.getLocation());
        assertEquals(true, accommodationDto.isAvailability());
    }

    @Test
    public void testMapToAccommodationDtoList(){
        //Given
        Accommodation accommodation1 = new Accommodation(1L, "Marriott", "Warszawa", 300.00, true);
        Accommodation accommodation2 = new Accommodation(2L, "Novotel", "Kraków", 150.00, false);

        List<Accommodation> accommodationList = new ArrayList<>();
        accommodationList.add(accommodation1);
        accommodationList.add(accommodation2);

        //When
        List<AccommodationDto> accommodationDtoList = accommodationMapper.mapToAccommodationDtoList(accommodationList);

        //Then
        assertEquals(2, accommodationDtoList.size());
        assertEquals(1L, accommodationDtoList.get(0).getAccommodationId().longValue());
        assertEquals(2L, accommodationDtoList.get(1).getAccommodationId().longValue());
        assertEquals("Marriott", accommodationDtoList.get(0).getName());
        assertEquals("Kraków", accommodationDtoList.get(1).getLocation());
    }
}

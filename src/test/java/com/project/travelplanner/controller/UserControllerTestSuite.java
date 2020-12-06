package com.project.travelplanner.controller;

import com.google.gson.Gson;
import com.project.travelplanner.domain.User;
import com.project.travelplanner.dto.UserDto;
import com.project.travelplanner.mapper.UserMapper;
import com.project.travelplanner.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestSuite {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserService userService;

    @Test
    public void getUsersTest() throws Exception {
        //Given
        List<UserDto> userDtoList = new ArrayList<>();
        when(userMapper.mapToUserDtoList(userService.getAllUsers())).thenReturn(userDtoList);

        // When & Then
        mockMvc.perform(get("/v1/user/getUsers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getUserTest() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "John Smith", 123456789);

        when(userMapper.mapToUserDto(userService.getUser(1L))).thenReturn(userDto);

        // When & Then
        mockMvc.perform(get("/v1/user/getUser?userId=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("John Smith")));


    }

    @Test
    public void deleteUserTest() throws Exception {
        //Given

        //Whem & Then
        mockMvc.perform(delete("/v1/user/deleteUser?userId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

    }

    @Test
    public void createUserTest() throws Exception {
        //Given
        UserDto userDto = new UserDto(1L, "John Smith", 123456789);
        User user= new User(1L, "John Smith", 123456789);

        when(userMapper.mapToUserDto(any(User.class))).thenReturn(userDto);
        when(userService.getUser(userDto.getId())).thenReturn(user);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //Whem & Then
        mockMvc.perform(post("/v1/user/createUser").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }
}

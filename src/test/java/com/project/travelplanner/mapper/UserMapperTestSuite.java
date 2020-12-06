package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.User;
import com.project.travelplanner.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestSuite {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapToUserTest() {
        //Given
        UserDto userDto = new UserDto(1L, "John Kowalski", 123456789);

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        assertEquals(1L, user.getId().longValue());
        assertEquals("John Kowalski", user.getName());
        assertEquals(123456789, user.getPhoneNumber());
    }

    @Test
    public void mapToUserDtoTest() {
        //Given
        User user = new User(1L, "John Kowalski", 123456789);

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        assertEquals(1L, user.getId().longValue());
        assertEquals("John Kowalski", user.getName());
        assertEquals(123456789, user.getPhoneNumber());
    }

    @Test
    public void testMapToTaskDtoList(){
        //Given
        User user1 = new User(1L, "John Kowalski", 123456789);
        User user2 = new User(2L, "Margaret Fox", 987654321);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        //When
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userList);

        //Then
        assertEquals(2, userList.size());
        assertEquals("John Kowalski", userDtoList.get(0).getName());
        assertEquals("Margaret Fox", userDtoList.get(1).getName());
    }
}

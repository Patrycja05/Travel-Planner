package com.project.travelplanner.service;

import com.project.travelplanner.domain.User;
import com.project.travelplanner.exception.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestSuite {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() throws UserNotFoundException {
        //Given
        User user = new User(1L, "John Kowalski", 123456789);

        //When
        userService.saveUser(user);
        User savedUser = userService.getUser(user.getId());

        //Then
        assertEquals(1L, savedUser.getId().longValue());
        assertEquals("John Kowalski", savedUser.getName());
        assertEquals(123456789, savedUser.getPhoneNumber());

        //Cleanup
        userService.deleteUser(user.getId());
    }

    @Test
    public void getUsersList() {
        //Given
        User user1 = new User(1L, "John Kowalski", 123456789);
        User user2 = new User(2L, "Margaret Fox", 987654321);

        //When
        userService.saveUser(user1);
        userService.saveUser(user2);
        List<User> userList = userService.getAllUsers();

        //Then
        assertEquals(2, userList.size());
        assertEquals("Margaret Fox", userList.get(1).getName());
        assertEquals("John Kowalski", userList.get(0).getName());

        //Cleanup
        userService.deleteUser(user1.getId());
        userService.deleteUser(user2.getId());
    }
}

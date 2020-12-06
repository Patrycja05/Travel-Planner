package com.project.travelplanner.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTestSuite {

    @Test
    public void mailTest() {
        //Given
        Mail mail = new Mail("testUser@gmail.com", "Test Subject", "Test Content");

        //When

        //Then
        assertEquals("testUser@gmail.com", mail.getMailTo());
        assertEquals("Test Subject", mail.getSubject());
        assertEquals("Test Content", mail.getMessage());
    }
}

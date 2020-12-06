package com.project.travelplanner.controller;

import com.project.travelplanner.dto.OrderDto;
import com.project.travelplanner.facade.OrderFacade;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderFacade orderFacade;

    @Test
    public void getOrdersTest() throws Exception {
        //Given
        List<OrderDto> orderDtoList = new ArrayList<>();
        when(orderFacade.getOrders()).thenReturn(orderDtoList);

        // When & Then
        mockMvc.perform(get("/v1/order/getOrders").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }



    @Test
    public void deleteOrderTest() throws Exception {
        //Given

        //Whem & Then
        mockMvc.perform(delete("/v1/order/deleteOrder?orderId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

    }
}

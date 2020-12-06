package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.Order;
import com.project.travelplanner.dto.OrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestSuite {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void mapToOrderTest() {
        //Given
        OrderDto orderDto = new OrderDto(1L, 1L, 2L, 5L);

        //When
        Order order = orderMapper.mapToOrder(orderDto);

        //Then
        assertEquals(1L, order.getOrderId().longValue());
        assertEquals(1L, order.getUserId().longValue());
        assertEquals(2L, order.getAccommodationId().longValue());
        assertEquals(5L, order.getFlightId().longValue());
    }

    @Test
    public void mapToOrderDtoTest() {
        //Given
        Order order = new Order(1L, 1L, 2L, 5L);

        //When
        OrderDto orderDto = orderMapper.mapToOrderDto(order);

        //Then
        assertEquals(1L, orderDto.getOrderId().longValue());
        assertEquals(1L, orderDto.getUserId().longValue());
        assertEquals(2L, orderDto.getAccommodationId().longValue());
        assertEquals(5L, orderDto.getFlightId().longValue());
    }

    @Test
    public void testMapToOrderDtoList(){
        //Given
        Order order1 = new Order(1L, 1L, 2L, 5L);
        Order order2 = new Order(2L, 2L, 1L, 6L);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        //When
        List<OrderDto> orderDtoList = orderMapper.mapToOrderDtoList(orderList);

        //Then
        assertEquals(2, orderDtoList.size());
        assertEquals(1L, orderDtoList.get(0).getOrderId().longValue());
        assertEquals(2L, orderDtoList.get(0).getAccommodationId().longValue());
        assertEquals(6L, orderDtoList.get(1).getFlightId().longValue());
        assertEquals(2L, orderDtoList.get(1).getUserId().longValue());
    }
}

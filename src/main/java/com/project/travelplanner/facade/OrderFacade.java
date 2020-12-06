package com.project.travelplanner.facade;

import com.project.travelplanner.dto.OrderDto;
import com.project.travelplanner.exception.OrderNotFoundException;
import com.project.travelplanner.mapper.OrderMapper;
import com.project.travelplanner.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getOrders(){
        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
    }

    public OrderDto getOrder(Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    public OrderDto createOrder (OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    public OrderDto updateUser(OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }

}

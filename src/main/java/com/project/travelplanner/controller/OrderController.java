package com.project.travelplanner.controller;

import com.project.travelplanner.dto.OrderDto;
import com.project.travelplanner.dto.UserDto;
import com.project.travelplanner.exception.OrderNotFoundException;
import com.project.travelplanner.facade.OrderFacade;
import com.project.travelplanner.mapper.OrderMapper;
import com.project.travelplanner.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @GetMapping(value = "/getOrders")
    public List<OrderDto> getOrders(){
        return orderFacade.getOrders();
    }

    @GetMapping(value = "/getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderFacade.getOrder(orderId);
    }

    @PostMapping(value = "/createOrder")
    public OrderDto createOrder (@RequestBody OrderDto orderDto) {
        return orderFacade.createOrder(orderDto);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateUser(@RequestBody OrderDto orderDto) {
        return orderFacade.updateUser(orderDto);
    }

    @DeleteMapping(value = "/deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        orderFacade.deleteOrder(orderId);
    }

}

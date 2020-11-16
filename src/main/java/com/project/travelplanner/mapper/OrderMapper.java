package com.project.travelplanner.mapper;

import com.project.travelplanner.domain.Order;
import com.project.travelplanner.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getUserId(),
                orderDto.getAccommodationId(),
                orderDto.getFlightId());
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getAccommodationId(),
                order.getFlightId());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(p -> mapToOrderDto(p))
                .collect(Collectors.toList());
    }
}

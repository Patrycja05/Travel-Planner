package com.project.travelplanner.repository;

import com.project.travelplanner.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    List<Order> findAll();

    @Override
    Order save(Order order);

    @Override
    Optional<Order> findById (Long id);

    @Override
    void deleteById(Long id);
}

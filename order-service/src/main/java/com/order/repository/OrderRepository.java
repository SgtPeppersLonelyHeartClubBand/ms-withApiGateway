package com.order.repository;

import com.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    @Query(value = "SELECT * FROM orders WHERE customer_id = ?1", nativeQuery = true)
    List<Order> findByCustomerId(Long customerId);
}

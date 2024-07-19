package com.order;

import com.order.model.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class OrderServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);

    @Mock
    private OrderRepository orderRepo;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrder() {
        logger.info("Running testSaveOrder");
        Order order = new Order();
        order.setId(1L);
        order.setCustomerId(1L);

        when(orderRepo.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.saveOrder(order);

        assertNotNull(savedOrder);
        assertEquals(1L, savedOrder.getCustomerId());
        verify(orderRepo, times(1)).save(any(Order.class));
    }

    @Test
    void testGetOrderById() {
        logger.info("Running testGetOrderById");
        Order order = new Order();
        order.setId(1L);
        order.setCustomerId(1L);

        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(1L);

        assertNotNull(foundOrder);
        assertEquals(1L, foundOrder.getCustomerId());
        verify(orderRepo, times(1)).findById(1L);
    }

}

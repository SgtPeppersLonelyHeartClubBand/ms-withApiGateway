package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.model.Order;
import com.order.repository.OrderRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public boolean checkCustomerExists(Long customerId) {
        String url = customerServiceUrl + "/exists/" + customerId;
        return restTemplate.getForObject(url, Boolean.class);
    }
}

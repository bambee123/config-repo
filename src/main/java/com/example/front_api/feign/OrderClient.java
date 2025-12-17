package com.example.front_api.feign;

import com.example.front_api.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/orders")
    List<OrderDTO> getAllOrders();

    @GetMapping("/orders/{id}")
    OrderDTO getOrderById(@PathVariable("id") Long id);
}
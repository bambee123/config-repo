package com.example.front_api.controller;

import com.example.front_api.dto.OrderDTO;
import com.example.front_api.dto.ProductDTO;
import com.example.front_api.service.FrontApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FrontApiController {

    @Autowired
    private FrontApiService frontApiService;

    @GetMapping("/catalog")
    public List<ProductDTO> getCatalog() {
        return frontApiService.getCatalog();
    }

    @GetMapping("/orders")
    public List<OrderDTO> getOrdersWithProductDetails() {
        return frontApiService.getOrdersWithProductDetails();
    }
}
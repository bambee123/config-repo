package com.example.front_api.service;

import com.example.front_api.dto.OrderDTO;
import com.example.front_api.dto.ProductDTO;
import com.example.front_api.feign.OrderClient;
import com.example.front_api.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FrontApiService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderClient orderClient;

    public List<ProductDTO> getCatalog() {
        return productClient.getAllProducts();
    }

    public List<OrderDTO> getOrdersWithProductDetails() {
        List<OrderDTO> orders = orderClient.getAllOrders();

        // For each order, fetch product details
        return orders.stream().map(order -> {
            ProductDTO product = productClient.getProductById(order.getProductId());
            order.setProduct(product);
            return order;
        }).collect(Collectors.toList());
    }
}
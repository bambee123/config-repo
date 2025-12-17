package com.example.front_api.feign;

import com.example.front_api.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDTO> getAllProducts();

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}
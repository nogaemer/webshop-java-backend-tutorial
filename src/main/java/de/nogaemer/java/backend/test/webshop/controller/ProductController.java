package de.nogaemer.java.backend.test.webshop.controller;

import de.nogaemer.java.backend.test.webshop.model.ProductResponse;
import de.nogaemer.java.backend.test.webshop.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductController {

    ProductRepository productRepository = new ProductRepository();
    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(@RequestParam(value = "tag", required = false) List<String> tags) {
        return productRepository.findAll(tags);
    }

}

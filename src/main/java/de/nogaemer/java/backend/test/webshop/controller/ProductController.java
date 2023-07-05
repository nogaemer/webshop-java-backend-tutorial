package de.nogaemer.java.backend.test.webshop.controller;

import de.nogaemer.java.backend.test.webshop.model.ProductResponse;
import de.nogaemer.java.backend.test.webshop.repository.ProductRepository;
import de.nogaemer.java.backend.test.webshop.utils.ListUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class ProductController {

    ProductRepository productRepository = new ProductRepository();
    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(@RequestParam(value = "tag", required = false) List<String> tags) {
        return productRepository.findAll(tags);
    }

}

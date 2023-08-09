package de.nogaemer.java.backend.test.webshop.controller;

import de.nogaemer.java.backend.test.webshop.model.ProductCreateRequest;
import de.nogaemer.java.backend.test.webshop.model.ProductResponse;
import de.nogaemer.java.backend.test.webshop.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(@RequestParam(value = "tag", required = false) List<String> tags) {
        return productRepository.findAll(tags);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        ProductResponse product = productRepository.findById(id);

        if (product != null)
            return ResponseEntity.ok(product);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/products")
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        return productRepository.save(
                request
        );
    }


}

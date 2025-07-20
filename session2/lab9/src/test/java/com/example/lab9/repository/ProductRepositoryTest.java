package com.example.lab9.repository;

import com.example.lab9.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository productRepository;

    @BeforeEach
    void setup(){
        productRepository = new ProductRepository();
    }

    @Test
    void shouldFindAllProducts() {
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void shouldReturnOptionalIfFindingExistingId() {
        Optional<Product> result = productRepository.findById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void shouldReturnEmptyIfFindingNonExistentId() {
        Optional<Product> result = productRepository.findById(4L);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldSaveNewProductIfProductHasNoId() {
        Product newProduct = new Product(null, "Monitor", 100.00);
        Product savedProduct = productRepository.save(newProduct);

        assertNotNull(savedProduct.getId());
        assertEquals("Monitor", savedProduct.getName());
    }

    @Test
    void shouldUpdateProductIfProductHasAnId() {
        Product updatedProduct = new Product(2L, "Wireless Mouse", 30.00);
        Product savedProduct = productRepository.save(updatedProduct);

        assertEquals(2L, savedProduct.getId());
    }
}
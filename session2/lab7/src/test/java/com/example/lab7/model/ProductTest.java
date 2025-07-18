package com.example.lab7.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(12345678L, "Blanket", 100.00);

    @Test
    void getId() {
        Long id = product.getId();
        assertEquals(12345678L, id);
    }

    @Test
    void getName() {
        String name = product.getName();
        assertEquals("Blanket", name);
    }

    @Test
    void getPrice() {
        double price = product.getPrice();
        assertEquals(100.00, price);
    }

    @Test
    void setId() {
        product.setId(123456789L);
        assertEquals(123456789L, product.getId());

    }

    @Test
    void setName() {
        product.setName("Pillow");
        assertEquals("Pillow", product.getName());
    }

    @Test
    void setPrice() {
        product.setPrice(50.00);
        assertEquals(50.00, product.getPrice());
    }

    @Test
    void testToString() {
        String item = product.toString();
        assertEquals("Product{" +
                "id=" + product.getId() +
                ", name='" + product.getName() + '\'' +
                ", price=" + product.getPrice() +
                '}', item);

    }

    @Test
    void testEqualsMethodIfProductIsObject() {
        assertTrue(product.equals(product));
    }

    @Test
    void testEqualsMethodIfProductIfNull(){
        assertFalse(product.equals(null));
    }

    @Test
    void testEquals(){
        Product product = new Product(123456L, "Bedsheets", 250.00);
        assertTrue(product.equals(product));
    }

    @Test
    void testHashCode() {
        int hash1 = product.hashCode();
        int hash2 = product.hashCode();
        assertEquals(hash1, hash2);
    }
}
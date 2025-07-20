package com.example.lab9.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(12345678L, "Blanket", 100.00);

    // getters
    @Test
    void shouldGetId() {
        Long id = product.getId();
        assertEquals(12345678L, id);
    }

    @Test
    void shouldGetName() {
        String name = product.getName();
        assertEquals("Blanket", name);
    }

    @Test
    void shouldGetPrice() {
        double price = product.getPrice();
        assertEquals(100.00, price);
    }

    // setters
    @Test
    void shouldSetId() {
        product.setId(123456789L);
        assertEquals(123456789L, product.getId());

    }

    @Test
    void shouldSetName() {
        product.setName("Pillow");
        assertEquals("Pillow", product.getName());
    }

    @Test
    void shouldSetPrice() {
        product.setPrice(50.00);
        assertEquals(50.00, product.getPrice());
    }

    // toString()
    @Test
    void shouldReturnProductAsString() {
        String item = product.toString();
        assertEquals("Product{" +
                "id=" + product.getId() +
                ", name='" + product.getName() + '\'' +
                ", price=" + product.getPrice() +
                '}', item);
    }

    // equals
    @Test
    void shouldBeEquals() {
        Product product = new Product(123L, "Pillow", 50.00);
        assertTrue(product.equals(product));
    }

    @Test
    void shouldBeEqualsIfAllFieldsAreTheSame() {
        Product product1 = new Product(123L, "Pillow", 50.00);
        Product product2 = new Product(123L, "Pillow", 50.00);
        assertTrue(product1.equals(product2));
    }

    @Test
    void shouldNotBeEqualsIfNull(){
        assertFalse(product.equals(null));
    }

    @Test
    void shouldNotBeEqualsIfDifferentId(){
        Product product1 = new Product(123L, "Pillow", 50.00);
        Product product2 = new Product(1234L, "Pillow", 50.00);
        assertFalse(product1.equals(product2));
    }

    @Test
    void shouldNotBeEqualsIfDifferentName(){
        Product product1 = new Product(123L, "Pillow", 50.00);
        Product product2 = new Product(123L, "Bedsheets", 50.00);
        assertFalse(product1.equals(product2));
    }

    @Test
    void shouldNotBeEqualsIfDifferentPrice(){
        Product product1 = new Product(123L, "Pillow", 50.00);
        Product product2 = new Product(123L, "Pillow", 150.00);
        assertFalse(product1.equals(product2));
    }

    // hashcode
    @Test
    void shouldHaveConsistentHashCode() {
        int hash1 = product.hashCode();
        int hash2 = product.hashCode();
        assertEquals(hash1, hash2);
    }

    @Test
    void shouldHaveSameHashCodeIfSameObject() {
        Product product1 = new Product(123L, "Plush Toy", 30.00);
        Product product2 = new Product(123L, "Plush Toy", 30.00);
        assertTrue(product1.equals(product2));
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void shouldNotHaveSameHashCodeIfNotSameObject() {
        Product product1 = new Product(123L, "Plush Toy", 30.00);
        Product product2 = new Product(123L, "Pillowcase", 30.00);
        assertNotEquals(product1, product2);
        assertNotEquals(product1.hashCode(), product2.hashCode());
    }
}
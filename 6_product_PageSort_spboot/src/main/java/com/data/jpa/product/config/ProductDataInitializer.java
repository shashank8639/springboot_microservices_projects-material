package com.data.jpa.product.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.data.jpa.product.model.Category;
import com.data.jpa.product.model.Product;
import com.data.jpa.product.repository.ProductRepository;

@Component
public class ProductDataInitializer
        implements CommandLineRunner {

    private final ProductRepository repository;

    public ProductDataInitializer(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() == 0) {

            repository.saveAll(List.of(

                product("Laptop", Category.ELECTRONICS,
                        "65000", "4.5", 20),

                product("Mobile", Category.ELECTRONICS,
                        "25000", "4.3", 30),

                product("Headphones", Category.ELECTRONICS,
                        "2500", "4.1", 50),

                product("Keyboard", Category.ELECTRONICS,
                        "1200", "4.0", 40),

                product("Monitor", Category.ELECTRONICS,
                        "15000", "4.6", 15),

                product("T-Shirt", Category.CLOTHING,
                        "799", "4.2", 100),

                product("Jeans", Category.CLOTHING,
                        "1499", "4.4", 60),

                product("Jacket", Category.CLOTHING,
                        "2499", "4.5", 25),

                product("Formal Shirt", Category.CLOTHING,
                        "999", "4.1", 70),

                product("Sweater", Category.CLOTHING,
                        "1799", "4.3", 35),

                product("Core Java", Category.BOOKS,
                        "650", "4.8", 30),

                product("Spring Boot", Category.BOOKS,
                        "850", "4.7", 25),

                product("SQL Fundamentals", Category.BOOKS,
                        "450", "4.4", 40),

                product("System Design", Category.BOOKS,
                        "1200", "4.9", 20),

                product("Python Programming", Category.BOOKS,
                        "750", "4.6", 35),

                product("Rice Bag", Category.FOOD,
                        "1500", "4.5", 100),

                product("Almonds", Category.FOOD,
                        "900", "4.7", 45),

                product("Honey", Category.FOOD,
                        "350", "4.3", 60),

                product("Oats", Category.FOOD,
                        "250", "4.2", 80),

                product("Peanut Butter", Category.FOOD,
                        "400", "4.4", 50),

                product("Cricket Bat", Category.SPORTS,
                        "3500", "4.6", 20),

                product("Football", Category.SPORTS,
                        "1100", "4.3", 30),

                product("Badminton Racket", Category.SPORTS,
                        "1800", "4.5", 25),

                product("Dumbbells", Category.SPORTS,
                        "2200", "4.7", 15),

                product("Yoga Mat", Category.SPORTS,
                        "600", "4.2", 0)

            ));

            System.out.println("25 products inserted successfully");
        }
    }

    private Product product(
            String name,
            Category category,
            String price,
            String rating,
            int stock) {

        return new Product(
                null,
                name,
                category,
                new BigDecimal(price),
                new BigDecimal(rating),
                stock);
    }
}

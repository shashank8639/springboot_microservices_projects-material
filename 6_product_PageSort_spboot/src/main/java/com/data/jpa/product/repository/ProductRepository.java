package com.data.jpa.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.jpa.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

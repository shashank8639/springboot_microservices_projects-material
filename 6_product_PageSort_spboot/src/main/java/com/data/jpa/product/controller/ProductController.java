package com.data.jpa.product.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.data.jpa.product.model.Product;
import com.data.jpa.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
	@GetMapping("/all")
    public List<Product> getAllProducts() {

        return service.getAllProducts();
    }
	
	@GetMapping("/sorted")
	public List<Product> getSortedProducts(
			@RequestParam(defaultValue="price") String sortBy,
			@RequestParam(defaultValue="asc") String direction) {

		return service.getSortedProducts(sortBy, direction);
	}
	
	@GetMapping("/paginated")
	public Page<Product> getPaginatedProducts(
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") int size) {

		return service.getPaginatedProducts(page, size);
	}
	
	
}

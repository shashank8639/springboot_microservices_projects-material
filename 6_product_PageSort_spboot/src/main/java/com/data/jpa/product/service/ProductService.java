package com.data.jpa.product.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.data.jpa.product.model.Product;
import com.data.jpa.product.repository.ProductRepository;

@Service
public class ProductService {

	  private final ProductRepository repository;

	    public ProductService(ProductRepository repository) {
	        this.repository = repository;
	    }

	    // 1. Retrieve all products

	    public List<Product> getAllProducts() {

	        return repository.findAll();
	    }
	    
	    
	    
	    
	    private Sort createSort(
	            String sortBy, String direction) {

	        Set<String> allowedFields = Set.of(
	                "id", "name", "price",
	                "rating", "stock", "category");

	        if (!allowedFields.contains(sortBy)) {
	            throw new ResponseStatusException(
	                    HttpStatus.BAD_REQUEST,
	                    "Invalid sorting property");
	        }

	        if (!direction.equalsIgnoreCase("asc")
	                && !direction.equalsIgnoreCase("desc")) {

	            throw new ResponseStatusException(
	                    HttpStatus.BAD_REQUEST,
	                    "Direction must be asc or desc");
	        }

	        Sort sort = Sort.by(
	                Sort.Direction.fromString(direction),
	                sortBy);

	        if (!sortBy.equals("id")) {
	            sort = sort.and(Sort.by("id"));
	        }

	        return sort;
	    }

		public List<Product> getSortedProducts(String sortBy, String direction) {

			Sort sort = createSort(sortBy, direction);
			
			return repository.findAll(sort);
		}

		public Page<Product> getPaginatedProducts(int page, int size) {

			Sort sort = createSort("id", "asc");
			Pageable pageable = PageRequest.of(page, size, sort);
			
			
			return repository.findAll(pageable);
		}
}

package com.leon.stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leon.stock.model.Product;
import com.leon.stock.repository.ProductRepository;

import lombok.Data;

@Data
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> getProduct(final int id) {
		return productRepository.findById(id);
	}

	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public void deleteProduct(final int id) {
		productRepository.deleteById(id);
	}

	public Product saveProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}
	

}

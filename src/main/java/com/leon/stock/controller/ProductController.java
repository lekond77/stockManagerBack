package com.leon.stock.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leon.stock.model.Product;
import com.leon.stock.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/produits")
	public Iterable<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping("/produit")
	public Product addProduct(@RequestBody Product product) {
		System.out.println("Is here");
		return productService.saveProduct(product);
	}

	@PutMapping("/produit/{id}")
	public Product updateProduct(@PathVariable("id") final int id, @RequestBody Product product) {

		Optional<Product> prod = productService.getProduct(id);
		if (prod.isPresent()) {
			Product currentProduct = prod.get();

			String reference = product.getReference();
			if (reference != null) {
				currentProduct.setReference(reference);
			}

			int quantity = product.getQuantity();
			if (quantity > 0) {
				currentProduct.setQuantity(quantity);
			}

			float price = product.getUnitPrice();
			if (price > 0) {
				currentProduct.setUnitPrice(price);
			}

		}
		
		return productService.saveProduct(product);
	}
}
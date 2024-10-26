package com.leon.stock.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leon.stock.model.Product;
import com.leon.stock.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public Iterator<Product> getProducts(){
		return productService.getProducts();
	}
	
}

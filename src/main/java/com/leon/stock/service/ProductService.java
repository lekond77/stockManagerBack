package com.leon.stock.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leon.stock.model.Product;

import lombok.Data;

@Data
@Service
public class ProductService {

	private List<Product> products;
	
	public ProductService() {
		products = new ArrayList<Product>();
		
		products.add(new Product("bic", 1, 100 ));
		products.add(new Product("crayon", 1, 50 ));
		products.add(new Product("cahier", 2, 400 ));
	}
	
	
//	public List<Product> getPs(){
//		return products;
//	}
//	
	public Iterator<Product> getProducts(){
		return products.iterator();
	}
}

package com.leon.stock.repository;

import org.springframework.data.repository.CrudRepository;

import com.leon.stock.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}

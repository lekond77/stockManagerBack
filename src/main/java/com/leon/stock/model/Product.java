package com.leon.stock.model;

import lombok.Data;

@Data
public class Product {

	private String reference;
	private float unitPrice;
	private int quantity;
	
	public Product(String reference, float unitPrice, int quantity) {
		super();
		this.reference = reference;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}

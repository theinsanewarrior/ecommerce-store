package com.store.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(generator = "product_seq")
	@SequenceGenerator(name = "product_seq",sequenceName = "PRODUCT_SEQ",initialValue = 1111)
	private int pid;
	private String name;
	private String brand;
	private String category;
	private int stock;
	private int price;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

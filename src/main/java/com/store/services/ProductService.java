package com.store.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.models.Product;
import com.store.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public Page<Product> getProductList(int pn) 
	{
		Pageable p=PageRequest.of(pn,3);
		return repo.findAll(p);
	}
	public void saveProduct(Product product) 
	{
		repo.save(product);
	}
	public void removeProduct(int pid)
	{
		repo.deleteById(pid);
	}
	public Product getProduct(int pid) 
	{
		return repo.findById(pid).orElse(null);
	}
	public void updateProduct(Product product) 
	{
		repo.save(product);
	}
	public List<Product> getOutOfStockList() 
	{
		return repo.getOutOfStock();
	}
	public List<Product> getProductListByBrand(String brand)
	{
		return repo.findByBrand(brand);
	}
	public List<Product> getProductListByName(String name)
	{
		return repo.findByName(name);
	}
	public List<Product> getProductListByCategory(String category) 
	{
		return repo.findByCategory(category);
	}
	public List<Product> getProductListById(int pid) 
	{
		return repo.findByPid(pid);
	}
}

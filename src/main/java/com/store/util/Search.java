package com.store.util;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.store.services.ProductService;
import com.store.models.Product;
@Component
public class Search {
	@Autowired
	private ProductService pservice;
	public void getProductListByProductid(Model model,int pid)
	{
		List<Product> list=pservice.getProductListById(pid);
		model.addAttribute("by","product id");
		model.addAttribute("list",list);
	}
	public void getProductListByBrand(Model model,String brand)
	{
		List<Product> list=pservice.getProductListByBrand(brand);
		model.addAttribute("brand",brand);
		model.addAttribute("by","Brand");
		model.addAttribute("list",list);
	}
	public void getProductListByName(Model model,String name)
	{
		List<Product> list=pservice.getProductListByName(name);
		model.addAttribute("by","Name");
		model.addAttribute("list",list);
	}
	public void getProductListByCategory(Model model,String category)
	{
		List<Product> list=pservice.getProductListByCategory(category);
		model.addAttribute("by","Category");
		model.addAttribute("list",list);
	}
	
}

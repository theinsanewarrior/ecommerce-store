package com.store.controllers.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.models.Product;
import com.store.services.ProductService;
import com.store.util.Search;

@Controller
@RequestMapping("searchby")
public class SearchByUserController {
	@Autowired private ProductService pservice;
	@Autowired private Search search;
	
	@RequestMapping("productid/user")
	public String searchByProductid(Model model,int pid,HttpSession ses,HttpServletRequest req) 
	{
		search.getProductListByProductid(model,pid);
		setUrl(ses,req);
		return "user/search/search-product-list";
	}
	@RequestMapping("brand/user")
	public String searchByBrand(Model model,String brand,HttpSession ses,HttpServletRequest req) 
	{
		search.getProductListByBrand(model,brand);
		setUrl(ses,req);
		return "user/search/search-product-list";
	}
	@RequestMapping("name/user")
	public String searchByName(Model model,String name,HttpServletRequest req,HttpSession ses) 
	{
		search.getProductListByName(model,name);
		setUrl(ses,req);
		return "user/search/search-product-list";
	}
	@RequestMapping("category/user")
	public String searchByCategory(Model model,String category,HttpServletRequest req,HttpSession ses) 
	{
		search.getProductListByCategory(model,category);
		setUrl(ses,req);
		return "user/search/search-product-list";
	}
	@RequestMapping("user/buyproduct")
	public String getBuyProduct(int pid,Model model) 
	{
		Product product=pservice.getProduct(pid);
		model.addAttribute("product", product);
		return "user/search/buy-product";
	}
	private void setUrl(HttpSession ses,HttpServletRequest req)
	{
		ses.setAttribute("url",req.getRequestURI()+"?"+req.getQueryString());
	}
}

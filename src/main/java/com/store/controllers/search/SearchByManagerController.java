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
import com.store.util.Utility;

@Controller
@RequestMapping("searchby")
public class SearchByManagerController {
	@Autowired private Search search;
	@Autowired private ProductService pservice;
	
	@RequestMapping("productid/manager")
	public String searchByProductid(Model model,int pid,HttpSession ses,HttpServletRequest req) 
	{
		search.getProductListByProductid(model,pid);
		Utility.setUrl(ses,req);
		return "manager/search/search-product-list";
	}
	@RequestMapping("brand/manager")
	public String searchByBrand(Model model,String brand,HttpSession ses,HttpServletRequest req) 
	{
		Utility.setUrl(ses,req);
		search.getProductListByBrand(model,brand);
		return "manager/search/search-product-list";
	}
	@RequestMapping("name/manager")
	public String searchByName(Model model,String name,HttpServletRequest req,HttpSession ses) 
	{
		Utility.setUrl(ses,req);
		search.getProductListByName(model,name);
		return "manager/search/search-product-list";
	}
	@RequestMapping("category/manager")
	public String searchByCategory(Model model,String category,HttpServletRequest req,HttpSession ses) 
	{
		Utility.setUrl(ses,req);
		search.getProductListByCategory(model,category);
		return "manager/search/search-product-list";
	}
	@RequestMapping("product/edit")
	public String getEditForm(int pid,Model model,HttpSession ses,HttpServletRequest req) 
	{
		Product product=pservice.getProduct(pid);
		model.addAttribute("product", product);
		return "manager/search/edit-product";
	}
	@RequestMapping("product/editsave")
	public String updateProduct(Product product,HttpSession ses) 
	{
		pservice.updateProduct(product);
		return "redirect:"+ses.getAttribute("url");
	}
	@RequestMapping("product/remove")
	public String removeProduct(int pid,HttpSession ses)
	{
		pservice.removeProduct(pid);
		return "redirect:"+ses.getAttribute("url");
	}
}

package com.store.controllers.manager;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.repositories.CategoryRepository;
import com.store.services.ProductService;
import com.store.util.Utility;
import com.store.models.Product;
import com.store.models.ProductCategory;

@Controller
@RequestMapping("manager")
public class StoreManagerController {
	@Autowired private ProductService service;
	@Autowired private CategoryRepository crepo;
	
	@RequestMapping("home")
	public String adminHome() 
	{
		return "manager/home/home";
	}
	@RequestMapping("manageproducts")
	public String manageProduct()
	{
		return "manager/manage/manage-products";
	}
	@RequestMapping("logout")
	public String managerLogout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/productstore";
	}
	@RequestMapping("outofstock")
	public String outOfStock(Model model,HttpSession ses,HttpServletRequest req) 
	{
		Utility.setUrl(ses, req);
		List<Product> list=service.getOutOfStockList();
		model.addAttribute("list",list);
		return "manager/stock/outofstock";
	}
	@RequestMapping("findall")
	public String findAll(HttpSession ses)
	{
		ses.setAttribute("brand", null);
		return "redirect:/manager/productlist?pn=1";
	}
	@RequestMapping("searchproducts")
	public String searchProducts(Model model) 
	{
		List<ProductCategory> clist=crepo.findAll();
		model.addAttribute("clist",clist);
		return "manager/search/search-products";
	}
}

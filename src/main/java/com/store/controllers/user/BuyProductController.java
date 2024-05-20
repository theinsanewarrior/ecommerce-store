package com.store.controllers.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.models.Product;
import com.store.services.ProductService;
import com.store.util.Utility;

@Controller
@RequestMapping("purchase")
public class BuyProductController {
	@Autowired ProductService pservice;
	
	@RequestMapping("productlist")
	public String userHome(Model model,HttpSession ses,int pn,HttpServletRequest req) 
	{
		Utility.setUrl(ses, req);
		Page<Product> plist=pservice.getProductList(pn-1);
		List<Product> list=plist.toList();
		model.addAttribute("tp",plist.getTotalPages());
		model.addAttribute("pn",pn);
		ses.setAttribute("pn",pn);
		model.addAttribute("list",list);
		model.addAttribute("username",ses.getAttribute("name"));
		return "user/purchase/product-list";
	}
	@RequestMapping("buyproduct")
	public String getBuyProduct(int pid,Model model) 
	{
		Product product=pservice.getProduct(pid);
		model.addAttribute("product", product);
		return "user/purchase/buy-now";
	}
	@RequestMapping("buyproducts")
	public String getBuyAllProduct(Model model,HttpSession ses) 
	{
		model.addAttribute("blist",ses.getAttribute("blist"));
		return "/user/purchase/order-now";
	}
	@RequestMapping("productdetails")
	public String getProductDetails(int pid,Model model) 
	{
		Product product=pservice.getProduct(pid);
		model.addAttribute("product", product);
		return "user/purchase/product-details";
	}
	@RequestMapping("findall")
	public String findAll()
	{
		return "redirect:/purchase/productlist?pn=1";
	}
}

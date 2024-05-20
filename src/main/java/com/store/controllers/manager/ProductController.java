package com.store.controllers.manager;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.store.models.Product;
import com.store.models.ProductCategory;
import com.store.repositories.CategoryRepository;
import com.store.services.ProductService;
import com.store.util.Utility;	

@Controller
@RequestMapping("manager/product")
public class ProductController {
	@Autowired
	private ProductService service;
	@Autowired private CategoryRepository crepo;  
	
	@RequestMapping("update")
	public String getProductList(Model model,int pn,HttpSession ses,HttpServletRequest req) 
	{
		Utility.setUrl(ses,req);
		Page<Product> plist=service.getProductList(pn-1);
		List<Product> list=plist.toList();
		model.addAttribute("tp",plist.getTotalPages());
		model.addAttribute("pn",pn);
		ses.setAttribute("pn",pn);
		model.addAttribute("list",list);
		return "manager/manage/product-list";
	}
	@RequestMapping("add")
	public String addProductForm(Model model) 
	{
		List<ProductCategory> clist=crepo.findAll();
		model.addAttribute("clist",clist);
		return "manager/manage/add-product";
	}
	@RequestMapping("save")
	public String addProduct(Product product) 
	{
		service.saveProduct(product);
		return "redirect:/manager/product/update?pn=1";
	}
	@RequestMapping("remove")
	public String removeProduct(int pid,HttpSession ses)
	{
		service.removeProduct(pid);
		return "redirect:update?pn="+ses.getAttribute("pn");
	}
	@RequestMapping("edit")
	public String getEditForm(int pid,Model model) 
	{
		Product product=service.getProduct(pid);
		model.addAttribute("product", product);
		return "manager/manage/edit-product";
	}
	@RequestMapping("editsave")
	public String updateProduct(Product product,HttpSession ses) 
	{
		service.updateProduct(product);
		return "redirect:"+ses.getAttribute("url");
	}
	@RequestMapping("findall")
	public String findAll(HttpSession ses)
	{
		ses.setAttribute("brand", null);
		return "redirect:/manager/productlist?pn=1";
	}
}

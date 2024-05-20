package com.store.controllers.user;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.models.ProductCategory;
import com.store.repositories.CategoryRepository;
import com.store.util.Utility;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired private CategoryRepository crepo;
	@RequestMapping("home")
	public String userHome(Model model,HttpSession ses) 
	{
		model.addAttribute("username",ses.getAttribute("name"));
		return "user/home/home";
	}
	@RequestMapping("searchproducts")
	public String searchProducts(Model model,HttpSession ses,HttpServletRequest req)
	{
		Utility.setUrl(ses, req);
		List<ProductCategory> clist=crepo.findAll();
		model.addAttribute("clist",clist);
		return "user/search/search-products";
	}
}

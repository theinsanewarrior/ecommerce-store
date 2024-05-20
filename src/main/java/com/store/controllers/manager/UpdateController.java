package com.store.controllers.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("update")
public class UpdateController {
	@RequestMapping("/product")
	public String getProductList()
	{
		return "manager/manage/product-list?pn=1";
	}
	@RequestMapping("/category")
	public String getCatList()
	{	
		return "manager/category/category-list";
	}
}

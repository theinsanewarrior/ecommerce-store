package com.store.controllers.user;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.models.ProductTransaction;
import com.store.repositories.ProductRepository;
import com.store.repositories.TransactionRepository;

@Controller
@RequestMapping("transaction")
public class TransactionListController {
	@Autowired private TransactionRepository repo;
	@RequestMapping("list")
	public String userHome(Model model,HttpSession ses) 
	{
		List<ProductTransaction> list=repo.findByUid((String)ses.getAttribute("uid"));
		model.addAttribute("list",list);
		return "user/purchase-list/transaction-list";
	}
}

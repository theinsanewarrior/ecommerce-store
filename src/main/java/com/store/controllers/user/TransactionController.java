package com.store.controllers.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.models.ProductTransaction;
import com.store.repositories.ProductRepository;
import com.store.repositories.TransactionRepository;

@Controller
@RequestMapping("transaction")
public class TransactionController {
	@Autowired private TransactionRepository trepo;
	@Autowired private ProductRepository prepo;
	
	@RequestMapping("success")
	public String transact(HttpSession ses){
//		String uid = (String)ses.getAttribute("uid");
//		int pid = (int)ses.getAttribute("pid");
//		int price = (int)ses.getAttribute("tbp");
//		int quantity = (int)ses.getAttribute("quantity");
//		ProductTransaction pt = new ProductTransaction(uid, pid, quantity, price, new Date());
		ProductTransaction pt = new ProductTransaction("1111", 1112, 1, 18000, new Date());
		trepo.save(pt);
		prepo.updateCopies(pt.getQuantity(),	pt.getPid());
		return "user/home/home";
	}
}

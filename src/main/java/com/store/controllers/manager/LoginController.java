package com.store.controllers.manager;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("adminlogin")
public class LoginController {
	
	@RequestMapping("login")
	public String adminLogin(String uid,String pass,RedirectAttributes at,Model model,HttpSession ses) 
	{	
		if(uid.equals("admin") && pass.equals("admin"))
		{
			ses.setAttribute("name","Admin");
			return "redirect:/manager/home";
		}
		else
		{
			at.addAttribute("msg", "Wrong credentials");
			return "redirect:/productstore/adminlogin";
		}
	}
}

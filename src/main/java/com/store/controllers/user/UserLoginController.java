package com.store.controllers.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.store.models.User;
import com.store.services.ProductService;
import com.store.services.UserService;

@Controller
@RequestMapping("userlogin")
public class UserLoginController {
	@Autowired
	private UserService service;
	@Autowired ProductService productservice;
		
	@RequestMapping("register")
	public String getUserRegistration(Model model)
	{
		model.addAttribute("user",new User());
		return "user/login/user-registration";
	}
	@RequestMapping("registerme")
	public String userRegistration(User user,Model model)
	{
		User u=service.getUser(user.getUid());
		if(u!=null)
		{
			model.addAttribute("user",user);
			model.addAttribute("msg","This user id already exists.Choose other user id");
			return "user/login/user-registration";
		}
		service.registerUser(user);
		model.addAttribute("name", user.getName());
		
		return "user/login/register";
	}
	@RequestMapping("login")
	public String userLogin(String uid,String password,RedirectAttributes at,HttpSession session)
	{
		User dbuser=service.getUser(uid);
		if(dbuser!=null)
		{
			if(dbuser.getPassword().trim().equals(password.trim()))
			{
				session.setAttribute("uid",uid);
				session.setAttribute("password",password);
				session.setAttribute("name",dbuser.getName());
				return "redirect:/user/home";
			}
		}
		at.addAttribute("msg", "User id or password is incorrect");
		return "redirect:/productstore/userlogin";
	}
	@RequestMapping("logout")
	public String userLogout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/productstore";
	}
}

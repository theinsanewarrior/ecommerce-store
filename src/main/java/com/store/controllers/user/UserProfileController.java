package com.store.controllers.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.models.User;
import com.store.services.UserService;

@Controller
@RequestMapping("profile")
public class UserProfileController {
	@Autowired
	private UserService service;
	
	@RequestMapping("profile")
	public String getProfile(Model model,HttpSession ses) 
	{
		User user=service.getUser((String)ses.getAttribute("uid"));
		model.addAttribute("user",user);
		ses.setAttribute("user",user);
		return "user/profile/user-details";
	}
	@RequestMapping("editprofile")
	public String getEditProfile(Model model,HttpSession ses) 
	{
		User user=(User)ses.getAttribute("user");
		model.addAttribute("user",user);
		return "user/profile/edit-details";
	}
	@RequestMapping("updateprofile")
	public String updateProfile(User user,Model model)
	{
		System.out.println(user.getPassword());
		service.updateUser(user);
		model.addAttribute("msg","Your profile has been updated");
		return "user/profile/edit-details";
	}
	@RequestMapping("changepass")
	public String changePassword()
	{
		return "user/profile/change-password";
	}
	@RequestMapping("checkpass")
	public String checkPassword(String pass,HttpSession ses,Model model)
	{
		User user=(User)ses.getAttribute("user");	
		if(!user.getPassword().equals(pass))
		{
			model.addAttribute("msg", "Entered password is incorrect");
			return "user/profile/change-password";
		}
		return "user/profile/new-password";
	}
	@RequestMapping("updatepass")
	public String updatePassword(String pass,HttpSession ses,Model model)
	{
		if(pass.equals((String)ses.getAttribute("password")))
		{
			model.addAttribute("samep",1);
			model.addAttribute("msg", "This is your current password.Enter new password");
			return "user/profile/new-password";
		}
		model.addAttribute("samep",0);
		service.updatePassword(pass,(String)ses.getAttribute("uid"));
		User user=(User)ses.getAttribute("user");
		user.setPassword(pass);
		ses.setAttribute("password",pass);
		model.addAttribute("msg", "Password has been changed");
		return "user/profile/new-password";
	}
}

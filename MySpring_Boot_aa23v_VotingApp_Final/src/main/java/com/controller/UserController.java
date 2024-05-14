package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.User;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;

	@PostMapping("/createuser")
	public String createUser(@ModelAttribute User user, HttpSession session)
	{
		String voter = user.getVoter_Id();

		if(userServ.getUserByVoter_ID(voter) != null  )
		{
			session.setAttribute("fail", "Registration Failed, Voter Id already registered");

			return "redirect:/register";
		}
		else{

			userServ.addUser(user);
			session.setAttribute("msg", "Registration successful");
			return "redirect:/register";
		}

	}
	
	@GetMapping("/user")
	public String dashboard(Model m, Principal p)
	{
		String Voter_ID = p.getName(); //

		User user  = userServ.getUserByVoter_ID(Voter_ID);
		
		m.addAttribute("user",user);
		m.addAttribute("title","DASHBOARD");
		
		return "user/dashboard";
		
		
	}
	
		

}
